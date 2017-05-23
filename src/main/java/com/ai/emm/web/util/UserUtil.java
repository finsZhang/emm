package com.ai.emm.web.util;

import com.ai.emm.bean.resp.JmjUserResponse;
import com.ai.emm.common.util.ApplicationUtil;
import com.ai.emm.common.util.Constants;
import com.ai.emm.common.util.JsonUtil;
import com.ai.emm.common.util.PropertiesUtils;
import com.ai.emm.servicefacade.bean.*;
import com.ai.emm.servicefacade.service.RestClient;
import com.ai.emm.servicefacade.service.impl.AuthorSVImpl;
import com.ai.emm.servicefacade.service.interfaces.IAuthorSV;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangFengZhou
 * Date:  2016/1/19
 * Time: 11:34
 * Email:zhangfz3@asiainfo.com
 */
public class UserUtil {
    private  static Logger logger = LoggerFactory.getLogger(UserUtil.class);

    /**
     *      用户的Session标志
     */
    public static String USER = "_USER_INFO";

    /**
     *      已登录的用户
     */
    public static Map<String, User> loginUsers = new HashMap<String, User>();

    /**
     * 保存用户信息到Session
     * @param user
     */
    public static void saveUserToSession(HttpSession session, User user) {
        session.setAttribute(USER, user);
        loginUsers.put(user.getOperatorCode(), user);
    }

    /**
     * 获取当前登录的用户
     * @return
     */
    public static User getCurrentUser(HttpSession session) {
        Object sessionUser = session.getAttribute(USER);
        if (sessionUser == null) {
            return null;
        }
        User User = (User) sessionUser;
        return User;
    }

    /**
     * 从session中移除用户
     */
    public static void removeUserFromSession(HttpSession session) {
        session.removeAttribute(USER);
    }

    public static void retriveUserInfo(String loginName,HttpSession session) throws Exception {
            Map map = new HashMap();
            map.put("operatorCode",loginName);
            map.put("appType","ecard");
            map.put("secureDesc","123456");
           IAuthorSV authorSV = ApplicationUtil.getBean(AuthorSVImpl.class);

            AuthorDataResponse authorDataResponse;
            authorDataResponse = authorSV.retrieveData(map);
            logger.debug(authorDataResponse.toString());
            User user = authorDataResponse.getUser();
            List<Menu> menus = authorDataResponse.getMenuBeans();
            SysOrg org = authorDataResponse.getSysOrgBean();
            List<SysOperator2Org> operator2OrgBeans = authorDataResponse.getSysOperator2OrgBeans();
            session.setAttribute(Constants.SESSION_USER, JsonUtil.toJson(user));
            session.setAttribute(Constants.SESSION_USER_OBJ, user);
            session.setAttribute(Constants.SESSION_MENU, JsonUtil.toJson(menus));
            session.setAttribute(Constants.SESSION_ORG, JsonUtil.toJson(org));
            session.setAttribute(Constants.SESSION_ORG_OBJ, org);
            Set<String> stationSet = new HashSet<String>();
            if(operator2OrgBeans!=null&&operator2OrgBeans.size()>0){
                for(int i=0;i<operator2OrgBeans.size();i++){
                    SysOperator2Org object = operator2OrgBeans.get(i);
                    if(object!=null&&object.getOrgId()!=null&&object.getOrgId().equals(org.getOrgId()))
                        stationSet.add(object.getStationCode());
                }

                if(stationSet.contains(Constants.STATION_CODE_ADMIN)){
                    session.setAttribute(Constants.SESSION_OPERATOR_STATION, Constants.STATION_CODE_ADMIN);
                }else if(stationSet.contains(Constants.STATION_CODE_COMMON)){
                    session.setAttribute(Constants.SESSION_OPERATOR_STATION, Constants.STATION_CODE_COMMON);
                }else if(stationSet.contains(Constants.STATION_CODE_MANAGER)){
                    session.setAttribute(Constants.SESSION_OPERATOR_STATION, Constants.STATION_CODE_MANAGER);
                }

            }

        logger.debug("session save complete");

        RestClient restClient = ApplicationUtil.getBean(RestClient.class);
        Map<String,String> rootMap = new HashMap<String, String>();
        rootMap.put("orgCode", PropertiesUtils.getContextProperty("org.root.code"));
        OrgResponse result = restClient.retrieveData(PropertiesUtils.getContextProperty("retriveOrgIdPath"),rootMap,OrgResponse.class);
        SysOrg rootOrg = result.getSysOrgBean();
        session.setAttribute(Constants.SESSION_ROOT_ORG,rootOrg);

    }

    public static void saveJmjUser() {

        Map<String,String> params = new HashMap<String, String>();
        params.put("jmjOrgCode", PropertiesUtils.getContextProperty("jmj.qy.orgCode"));
        RestClient restClient = ApplicationUtil.getBean(RestClient.class);
        String getJmjAdminByOrgCodePath = PropertiesUtils.getContextProperty("getJmjAdminByOrgCodePath");


        JmjUserResponse jmjQyUserResponse = null;
        try {
            jmjQyUserResponse = restClient.retrieveData(getJmjAdminByOrgCodePath,params,JmjUserResponse.class);
        } catch (IOException e) {
            logger.error("IOException:"+e.getMessage());
        }
        if("0".equals(jmjQyUserResponse.getCode())) {
            WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
            ServletContext application = webApplicationContext.getServletContext();
            application.setAttribute(Constants.SESSION_QY_JMJUSER, jmjQyUserResponse);
        }

        params = new HashMap<String, String>();
        params.put("jmjOrgCode", PropertiesUtils.getContextProperty("jmj.xh.orgCode"));
        JmjUserResponse jmjXhUserResponse = null;
        try {
            jmjXhUserResponse = restClient.retrieveData(getJmjAdminByOrgCodePath,params,JmjUserResponse.class);
        } catch (IOException e) {
            logger.error("IOException:"+e.getMessage());
        }
        if("0".equals(jmjXhUserResponse.getCode())) {
            WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
            ServletContext application = webApplicationContext.getServletContext();
            application.setAttribute(Constants.SESSION_XH_JMJUSER, jmjXhUserResponse);
        }
    }

    public static JmjUserResponse getQyUser(){
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        ServletContext application = webApplicationContext.getServletContext();
        if(application.getAttribute(Constants.SESSION_QY_JMJUSER)==null){
            saveJmjUser();
        }
        return (JmjUserResponse)application.getAttribute(Constants.SESSION_QY_JMJUSER);
    }

    public static JmjUserResponse getXhUser(){
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        ServletContext application = webApplicationContext.getServletContext();
        if(application.getAttribute(Constants.SESSION_XH_JMJUSER)==null){
            saveJmjUser();
        }
        return (JmjUserResponse)application.getAttribute(Constants.SESSION_XH_JMJUSER);
    }
}
