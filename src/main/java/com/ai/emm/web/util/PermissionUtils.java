package com.ai.emm.web.util;

import com.ai.emm.common.util.ApplicationUtil;
import com.ai.emm.common.util.PropertiesUtils;
import com.ai.emm.servicefacade.bean.BaseResponse;
import com.ai.emm.servicefacade.service.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2017/1/9.
 */
public class PermissionUtils {
    private static Logger logger = LoggerFactory.getLogger(PermissionUtils.class);
    public static boolean validateJmjUser(String orgCode,String userName,String password) throws Exception{
        RestClient restClient = ApplicationUtil.getBean(RestClient.class);
        String validateJmjUser = PropertiesUtils.getContextProperty("validateJmjUser");
        BaseResponse baseResponse;
        try {
            Map map = new HashMap();
            map.put("operatorCode", userName);
            map.put("password", password);
            map.put("jmjOrgCode", orgCode);
            baseResponse = restClient.retrieveData(validateJmjUser, map, BaseResponse.class);
        } catch (IOException e) {
            logger.error("Webservice Server can't response correctly："+e.getMessage());
            throw new IOException("Webservice Server can't response correctly");
        }
        if (null != baseResponse && !"0".equals(baseResponse.getCode())) {
            throw new Exception("用户名或密码错误!");
        }
        return true;
    }
}
