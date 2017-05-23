package com.ai.emm.bean.resp;

/**
 * Created by Walter on 2017/1/4.
 */
public class CommonPreLogResp {

    /**
     * resultCode : 0
     * errMsg : 成功
     * tradeSerial : 201623545432222
     */
    private String resultCode;
    private String errMsg;
    private String tradeSerial;

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

    public String getTradeSerial() {
        return tradeSerial;
    }

    public void setTradeSerial(String tradeSerial) {
        this.tradeSerial = tradeSerial;
    }
}
