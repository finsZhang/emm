package com.ai.emm.servicefacade.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangFengZhou
 * Date:  2015/9/6
 * Time: 11:47
 * Email:zhangfengzhou@asiainfo.com
 */

 @JsonIgnoreProperties(ignoreUnknown = true)
 public class User implements Serializable{
    private String operatorId;
    private String operatorCode;
    private String operatorPsw;
    private String operatorName;

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getOperatorPsw() {
        return operatorPsw;
    }

    public void setOperatorPsw(String operatorPsw) {
        this.operatorPsw = operatorPsw;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
}
