package com.ai.emm.common.validate.interceptor;



import com.ai.emm.common.util.PropertiesUtils;
import com.ai.emm.common.util.ServiceUtil;

import java.lang.reflect.Method;

/**
 * Created by fins on 2016/5/31.
 */
public class UsernamePasswordInterceptor implements ValidatorInterceptor{
    private String errorMsg;
    private final static String USERNAME = "userName";
    private final static String PASSWORD = "passWord";
    private final static String APPID = "appId";
    public UsernamePasswordInterceptor(String errorMsg){
            this.errorMsg = errorMsg;
    }

    public <T> String preHandle(T bean) throws Exception {
        Class<?> clz = bean.getClass();
        Method getMethod = clz.getDeclaredMethod(ServiceUtil.getGetMethodNameFromFiledName(APPID));
        Object obj = getMethod.invoke(bean);
        if(obj==null){
            return APPID+"为空异常!";
        }

        String username = PropertiesUtils.getContextProperty(obj.toString()+".username");
        String password = PropertiesUtils.getContextProperty(obj.toString()+".password");

        Method getUsernameMethod = clz.getDeclaredMethod(ServiceUtil.getGetMethodNameFromFiledName(USERNAME));
        Object usernameValue = getUsernameMethod.invoke(bean);
        if(usernameValue==null){
            return USERNAME+"为空异常!";
        }

        Method getPasswordMethod = clz.getDeclaredMethod(ServiceUtil.getGetMethodNameFromFiledName(PASSWORD));
        Object passwordValue = getPasswordMethod.invoke(bean);
        if(passwordValue==null){
            return PASSWORD+"为空异常!";
        }

        if(!usernameValue.toString().equals(username)||!passwordValue.toString().equals(password)){
            return errorMsg;
        }
        return "";
    }


    public <T> void postHandle(T bean) throws Exception {

    }
}
