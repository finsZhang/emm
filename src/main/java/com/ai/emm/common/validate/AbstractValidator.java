package com.ai.emm.common.validate;


import com.ai.emm.common.util.ServiceUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangFengZhou
 * Date:  2015/11/20
 * Time: 15:59
 * Email:zhangfz3@asiainfo.com
 */
public abstract class AbstractValidator {
    protected ValidateInOut[]validateInOuts;
    protected AbstractValidator(ValidateInOut... validateInOuts) {
        this.validateInOuts = validateInOuts;
    }

    protected abstract String validate(Class<?> valueType,Object value,ValidateInOut validateInOut);

    public <T> String validate(T bean) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (validateInOuts == null || validateInOuts.length == 0) {
            return null;
        } else {
            Class<?> clz = bean.getClass();
            Method getMethod;
            String propertyName;
            String errorMessage;
            for (ValidateInOut validateInOut : validateInOuts) {
                propertyName = validateInOut.getPropertyName();
                getMethod = clz.getDeclaredMethod(ServiceUtil.getGetMethodNameFromFiledName(propertyName));
                Class<?>  valueType = validateInOut.getPropertyClz()==null?getMethod.getReturnType():validateInOut.getPropertyClz();
                errorMessage = validate(valueType, getMethod.invoke(bean), validateInOut);
                if(errorMessage !=null){
                    return errorMessage;
                }
            }
        }
        return null;
    }
}
