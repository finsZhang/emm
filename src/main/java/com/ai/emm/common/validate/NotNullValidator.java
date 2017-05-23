package com.ai.emm.common.validate;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangFengZhou
 * Date:  2015/11/20
 * Time: 16:10
 * Email:zhangfz3@asiainfo.com
 */
public class NotNullValidator extends AbstractValidator {
    public NotNullValidator(ValidateInOut... validateInOuts) {
        super(validateInOuts);
    }

    @Override
    protected   String validate(Class<?> valueType,Object value,ValidateInOut validateInOut){
        boolean isValid = true;
        if(valueType == String.class){
            isValid = (value != null&&!"".equals(((String)value).trim()));
        }else{
            isValid = value != null;
        }
        if(isValid){
            return null;
        }else{
            return validateInOut.getErrorMessage();
        }
    }
}
