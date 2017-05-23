package com.ai.emm.common.validate;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangFengZhou
 * Date:  2015/11/20
 * Time: 17:36
 * Email:zhangfz3@asiainfo.com
 */
public class InValidator extends AbstractValidator {

    public InValidator(ValidateInOut... validateInOuts) {
        super(validateInOuts);
    }

    @Override
    public String validate(Class<?> valueType, Object value, ValidateInOut validateInOut) {
        Object[] validValues = validateInOut.getValidPropertyValues();
        if(Arrays.asList(validValues).contains(value)){
            return null;
        }else{
            return validateInOut.getErrorMessage();
        }
    }
}
