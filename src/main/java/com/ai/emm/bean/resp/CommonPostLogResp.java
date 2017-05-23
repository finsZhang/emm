package com.ai.emm.bean.resp;

/**
 * Created by Walter on 2017/1/4.
 */
public class CommonPostLogResp {

    /**
     * resultCode : 0
     * errMsg : 成功
     */
    private String resultCode;
    private String errMsg;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

}
