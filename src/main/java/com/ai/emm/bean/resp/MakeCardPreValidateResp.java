package com.ai.emm.bean.resp;

import java.util.List;

/**
 * Created by Walter on 2016/12/29.
 */
public class MakeCardPreValidateResp {

    /**
     * resultCode : 0
     * errMsg : 成功
     * respDatas : [{"respData":"2F234323"},{"respData":"2F234323"}]
     * tradeSerial : 201623545432222
     */

    private String resultCode;
    private String errMsg;
    private String tradeSerial;
    private List<RespDatasBean> respDatas;

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

    public List<RespDatasBean> getRespDatas() {
        return respDatas;
    }

    public void setRespDatas(List<RespDatasBean> respDatas) {
        this.respDatas = respDatas;
    }

    public static class RespDatasBean {
        /**
         * respData : 2F234323
         */

        private String respData;

        public String getRespData() {
            return respData;
        }

        public void setRespData(String respData) {
            this.respData = respData;
        }
    }
}
