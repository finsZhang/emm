package com.ai.emm.common.util;

/**
 * Created by fins on 2016/6/28.
 */
public class Txt2Bean {
    private String propertyName;
    private Integer colNum;
    private Class<?> parameterType;

    public Txt2Bean(Integer colNum, Class<?> parameterType) {
        this.colNum = colNum;
        this.parameterType = parameterType;
    }

    public Txt2Bean(String propertyName, Integer colNum, Class<?> parameterType) {
        this.propertyName = propertyName;
        this.colNum = colNum;
        this.parameterType = parameterType;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Integer getColNum() {
        return colNum;
    }

    public void setColNum(Integer colNum) {
        this.colNum = colNum;
    }

    public Class<?> getParameterType() {
        return parameterType;
    }

    public void setParameterType(Class<?> parameterType) {
        this.parameterType = parameterType;
    }
}
