package com.ai.emm.common.validate;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangFengZhou
 * Date:  2015/11/20
 * Time: 16:05
 * Email:zhangfz3@asiainfo.com
 */
public class ValidateInOut {
    private String propertyName;
    private Class<?> propertyClz;
    private String errorMessage;
    private Object[] validPropertyValues;

    public ValidateInOut(String propertyName, String errorMessage, Object... validPropertyValues) {
        this.propertyName = propertyName;
        this.errorMessage = errorMessage;
        this.validPropertyValues = validPropertyValues;
    }

    public ValidateInOut(String propertyName, Class<?>  propertyClz, String errorMessage,Object... validPropertyValues) {
        this.propertyName = propertyName;
        this.propertyClz = propertyClz;
        this.errorMessage = errorMessage;
        this.validPropertyValues = validPropertyValues;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object[] getValidPropertyValues() {
        return validPropertyValues;
    }

    public void setValidPropertyValues(Object[] validPropertyValues) {
        this.validPropertyValues = validPropertyValues;
    }

    public Class<?> getPropertyClz() {
        return propertyClz;
    }

    public void setPropertyClz(Class<?> propertyClz) {
        this.propertyClz = propertyClz;
    }
}
