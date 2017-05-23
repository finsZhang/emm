package com.ai.emm.common.validate;

import java.math.BigDecimal;

/**
 * Created by Walter on 2016/5/25.
 */
public class CompareValidator extends AbstractValidator {

    public CompareValidator(ValidateInOut... validateInOuts) {
        super(validateInOuts);
    }

    @Override
    public String validate(Class<?> valueType, Object value, ValidateInOut validateInOut) {
        Object[] validValues = validateInOut.getValidPropertyValues();
        Object minValue = validValues[0];
        Object maxValue = validValues.length==2?validValues[1]:null;
        if(value!=null&&valueType ==  String.class){
            String  valueString = (String)value;
            if (minValue !=null&&minValue instanceof String) {
                String minValueString = (String) minValue;
                int sub = valueString.compareTo(minValueString);
                if (sub <= 0) {
                    return validateInOut.getErrorMessage();
                } else {
                    return validateMaxValue(valueString, maxValue, validateInOut);
                }
            }else{
                return validateMaxValue(valueString,maxValue,validateInOut);
            }
        }else if(value!=null&&valueType == Number.class) {
            BigDecimal valueBigDecimal = new BigDecimal(String.valueOf(value));
            if (minValue != null && minValue instanceof Number) {
                BigDecimal minValueBigDecimal = new BigDecimal(String.valueOf(minValue));
                int sub = valueBigDecimal.compareTo(minValueBigDecimal);
                if (sub <= 0) {
                    return validateInOut.getErrorMessage();
                } else {
                    return validateMaxValue(valueBigDecimal,maxValue,validateInOut);
                }
            }else{
                return validateMaxValue(valueBigDecimal,maxValue,validateInOut);
            }
        }
        return null;
    }

    public String validateMaxValue(Object value,Object maxValue,ValidateInOut validateInOut) {
        if (maxValue !=null&&maxValue instanceof Number) {
            BigDecimal valueBigDecimal = (BigDecimal)value;
            BigDecimal maxValueBigDecimal = new BigDecimal(String.valueOf(maxValue));
            int sub = valueBigDecimal.compareTo(maxValueBigDecimal);
            if(sub>=0){
                return validateInOut.getErrorMessage();
            }
        }else if(maxValue !=null&&maxValue instanceof String) {
            String  valueString = (String)value;
            String  maxValueString = (String)maxValue;
            int sub = valueString.compareTo(maxValueString);
            if(sub>=0){
                return validateInOut.getErrorMessage();
            }
        }
        return null;
    }
}
