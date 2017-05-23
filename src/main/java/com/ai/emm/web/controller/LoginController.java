package com.ai.emm.web.controller;

import com.ai.emm.common.util.Constants;
import com.ai.emm.common.util.JsonUtil;
import com.ai.emm.common.util.PropertiesUtils;
import com.ai.emm.servicefacade.bean.*;
import com.ai.emm.servicefacade.service.RestClient;
import com.ai.emm.servicefacade.service.interfaces.IAuthorSV;
import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: chengzj
 * Date: 15-3-13
 * Time: 下午7:56
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/emm/")
public class LoginController {
    @Autowired
    private IAuthorSV authorSV;
    private Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Value("${appCode}")
    private String appCode;
    @Value("${emm.domain.name}")
    private String domain;
    @Value("${emm.cookie.domain}")
    private String cookieDomain;
    @Value("${retriveOrgIdPath}")
    private String retriveOrgIdPath;
    @Value("${org.root.code}")
    private String rootOrgCode;
    @Value("${passwordChange}")
    private String passwordChange;
    @Autowired
    private RestClient restClient;

    @RequestMapping("login.html")
    public String login(Model model, String errorCode, String errorMessage){
		model.addAttribute("errorCode",errorCode);
        model.addAttribute("errorMessage",errorMessage);
        return "login";
    }

    /**
     * 用户登录，此方法目前只支持普通登录，不支持手机验证码登录
     * TODO 1、前台需要对密码需要加密处理
     * TODO 2、将用户名及密码写入Cookie
     * @param accountName
     * @param passwd
     * @param model
     * @return
     */
    @RequestMapping("index.html")
    public String loginCheck(String accountName, String passwd, Model model, HttpServletRequest request){
        logger.debug("loginCheck");
        String errorCode= "0";
        String errorMessage = "";
      try {
              if(request.getSession().getAttribute(Constants.SESSION_USER_OBJ)!=null&&!(request.getSession().getAttribute(Constants.SESSION_USER_OBJ).equals("null"))){
                  return "index";
              }

                Map map = new HashMap();
                map.put("operatorCode",accountName);
                map.put("password",passwd);
                map.put("appType","system_encryMachine");
                map.put("secureDesc","123456");

                AuthorDataResponse authorDataResponse;
                try {
                     authorDataResponse = authorSV.retrieveData(map);
                }catch (IOException e){
                    errorCode = "-1";
                    errorMessage = "Webservice Server can't response correctly";
                    model.addAttribute("errorCode",errorCode);
                    model.addAttribute("errorMessage",errorMessage);
                    return "redirect:/emm/login.html";
                }
                if(!"0".equals(authorDataResponse.getCode())){
                    model.addAttribute("errorCode",2);
                    model.addAttribute("errorMessage","用户名或密码错误!");
                    return "redirect:/emm/login.html";
                }

                errorCode = authorDataResponse.getCode();
                errorMessage = authorDataResponse.getMessage();
                User user = authorDataResponse.getUser();
                List<Menu> menus = authorDataResponse.getMenuBeans();
                SysOrg org = authorDataResponse.getSysOrgBean();
                List<SysOperator2Org> operator2OrgBeans = authorDataResponse.getSysOperator2OrgBeans();

                request.getSession().setAttribute(Constants.SESSION_USER, JsonUtil.toJson(user));
                request.getSession().setAttribute(Constants.SESSION_USER_OBJ, user);
                request.getSession().setAttribute(Constants.SESSION_MENU, JsonUtil.toJson(menus));
                request.getSession().setAttribute(Constants.SESSION_ORG, JsonUtil.toJson(org));
                request.getSession().setAttribute(Constants.SESSION_ORG_OBJ, org);

                Set<String> stationSet = new HashSet<String>();
                if(operator2OrgBeans!=null&&operator2OrgBeans.size()>0){
	                for(int i=0;i<operator2OrgBeans.size();i++){
                        SysOperator2Org object = operator2OrgBeans.get(i);
                        if(object.getOrgId().equals(org.getOrgId()))
                            stationSet.add(object.getStationCode());
	                }

                    if(stationSet.contains(Constants.STATION_CODE_ADMIN)){
                        request.getSession().setAttribute(Constants.SESSION_OPERATOR_STATION, Constants.STATION_CODE_ADMIN);
                    }else if(stationSet.contains(Constants.STATION_CODE_COMMON)){
                        request.getSession().setAttribute(Constants.SESSION_OPERATOR_STATION, Constants.STATION_CODE_COMMON);
                    }else if(stationSet.contains(Constants.STATION_CODE_MANAGER)){
                        request.getSession().setAttribute(Constants.SESSION_OPERATOR_STATION, Constants.STATION_CODE_MANAGER);
                    }
                }
                String VERSION = DateFormatUtils.format(new Date(System.currentTimeMillis()), "yyyyMMddHHmmss");
                request.getSession().setAttribute("staticVersion",VERSION);
                request.getSession().setAttribute(Constants.LOGIN_TIME_OUT, "false");
                request.getSession().setAttribute(Constants.LOGINPARAM, "false");
                request.getSession().setAttribute(Constants.VIEWONLY, "false");

          Map<String,String> rootMap = new HashMap<String, String>();
          rootMap.put("orgCode", rootOrgCode);
          OrgResponse result = restClient.retrieveData(retriveOrgIdPath,rootMap,OrgResponse.class);
          SysOrg rootOrg = result.getSysOrgBean();
          request.getSession().setAttribute(Constants.SESSION_ROOT_ORG,rootOrg);

      } catch (Exception ex) {
        	errorCode = "-2";
            logger.error("LoginController->loginAjax error!" + ex.getMessage());
        }
        if("0".equals(errorCode)){
            return "index";
        }
        model.addAttribute("errorCode",errorCode);
        model.addAttribute("errorMessage",errorMessage);
        return "redirect:/emm/login.html";      //增加错误参数
    }

    private boolean setCookie(HttpServletResponse response, HttpServletRequest request, String accountName, String password){
        // 3、种我们自己的cookie
        /*String remYes = "true";
        int remYesTime = 30;
        try {
            int maxAge = 0;//设置超时时间
            if (StringUtils.equals(remYes, "true")) {
                maxAge = remYesTime;
                CookieUtil.setCookie(response, cookieDomain, UserHolder.COOKIE_KEY_OUT_TIME, "true", maxAge);
                String _erp_descd = CookieUtil.getCookie(request, UserHolder.COOKIE_KEY_USERNAME);//从Cookie中获取erp信息（编码后的）
                String _pwd_descd = CookieUtil.getCookie(request, UserHolder.COOKIE_KEY_PWD);

            } else {
                CookieUtil.removeCookie(request, response, cookieDomain, UserHolder.COOKIE_KEY_OUT_TIME);
            }
            String k = DESUtil.encrypt(accountName);
            String v = DESUtil.encrypt(password);
            CookieUtil.setCookie(response, cookieDomain, UserHolder.COOKIE_KEY_USERNAME, k, maxAge);
            CookieUtil.setCookie(response, cookieDomain, UserHolder.COOKIE_KEY_PWD, v, maxAge);
        } catch (Exception e) {
            logger.error("设置Cookie失败，请重新输入！", e);
            return false;
        }*/
        return true;
    }

    /**
     * 退出
     *
     * @return
     */
    @RequestMapping("logout.html")
    public String loginOut(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
//    	try {
//	        User user = (User)request.getSession().getAttribute(Constants.SESSION_USER_OBJ);
////			//记录操作日志
////            publicUserSV.saveLog("退出");
////			//保存注销日志
//			request.getSession().setAttribute(Constants.SESSION_USER_OBJ, null);
//    	} catch (Exception ex) {
//    		logger.error("PublicUserController->loginOut error!" + ex.getMessage());
//        }
        request.getSession().invalidate();
        String isSSOLogout = PropertiesUtils.getContextProperty("isSSOLogout");
        if("true".equals(isSSOLogout)) {
            response.sendRedirect(PropertiesUtils.getContextProperty("casServerLogoutUrl")
                    + "?service=" + PropertiesUtils.getContextProperty("serverName") + "/"+PropertiesUtils.getContextProperty("service.projectName"));
            return null;
        }else{
            return "login";
        }

    }
    
    @RequestMapping("getMenus.ajax")
    @ResponseBody
    public Map getMenus(HttpServletResponse response,
            HttpServletRequest request){
    	String menus = (String) request.getSession().getAttribute(Constants.SESSION_MENU);
		Map map = new HashMap();
	    map.put("menus",menus);
        if(menus != null && map.size()>0){
            return map;
        }
        return null;
    }

    @RequestMapping("getRootOrg.ajax")
    @ResponseBody
    public SysOrg getRootOrg(HttpServletRequest request) throws IOException {
        SysOrg rootOrg = (SysOrg) request.getSession().getAttribute(Constants.SESSION_ROOT_ORG);
        return rootOrg;
    }
  
    /**
     * 
     * 功能说明：显示用户协议
     * TODO 
     * @return
     */
    @RequestMapping("treaty.html")
    public String showTreaty(){
    	return "treaty";
    }

    /**
     * 退出
     *
     * @return
     */
    @RequestMapping("ModifyPassword.html")
    public String ModifyPassword(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        return "/logMgr/ModifyPassword";
    }
    @RequestMapping("PasswordChange.ajax")
    @ResponseBody
    public BaseResponse PasswordChange(String passwordOld,String passwordNew,HttpServletRequest request) throws IOException {
        // 先获取当前登陆用户
        User user = (User) request.getSession().getAttribute(Constants.SESSION_USER_OBJ);
        Map<String,String> rootMap = new HashMap<String, String>();
        rootMap.put("operatorCode",user.getOperatorCode());
          //rootMap.put("password","12345678");
          //rootMap.put("newPassword","1");
          rootMap.put("password",passwordOld.toString());
          rootMap.put("newPassword",passwordNew.toString());
        BaseResponse result = null;
        try {
            result = restClient.retrieveData(passwordChange,rootMap,BaseResponse.class);
        } catch (IOException e) {
            result.setMessage(e.getMessage());
        }
        return result;
    }
}
