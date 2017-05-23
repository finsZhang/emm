package com.ai.emm.bean.resp;

import com.ai.emm.servicefacade.bean.BaseResponse;

/**
 * Created by jiahh on 2017-01-06.
 */
public class JmjUserResponse extends BaseResponse {
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String orgName;
    private String orgCode;
    private String userName;
    private String password;
}
