package com.ai.emm.bean.resq;

/**
 * Created by Walter on 2017/1/4.
 */
public class CommonPostLogResq {

    /**
     * tradeSerial : 0000
     * operateStatus : 02
     * orgName : 2
     * orgCode : 1
     * username : 2
     * password  : 2
     */

    private String tradeSerial;
    private String operateStatus;
    private String orgName;
    private String orgCode;
    private String username;
    private String password;

    public String getTradeSerial() {
        return tradeSerial;
    }

    public void setTradeSerial(String tradeSerial) {
        this.tradeSerial = tradeSerial;
    }

    public String getOperateStatus() {
        return operateStatus;
    }

    public void setOperateStatus(String operateStatus) {
        this.operateStatus = operateStatus;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
