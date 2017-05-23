package com.ai.emm.bean.resq;

import java.util.List;

/**
 * Created by Walter on 2016/12/29.
 */
public class MakeCardPreValidateResq {


    /**
     * busType : 03
     * cardKind : 01
     * cardName : 李裕建
     * cardNo : 61040204002238725
     * cardSerial : 0103581210
     * cardSubType : 0
     * chipSerial : 0D7880700200908650FFFFFF28
     * idNo : 371327198206085415
     * operateStatus : 01
     * orgCode : 435885557
     * orgName : 旬邑
     * password : 12345678
     * psamNo : 61040020150828009848
     * username : jmj_admin
     * resqDatas : [{"resqData":"B0116666666666666666001600107120009013DEFF188EDFFF6FEC2100E7"},{"resqData":"B0116666666666666666001600107120009013DEFF188EDFFF6FEC2100E7"}]
     */

    private String busType;
    private String cardKind;
    private String cardName;
    private String cardNo;
    private String cardSerial;
    private String cardSubType;
    private String chipSerial;
    private String idNo;
    private String operateStatus;
    private String orgCode;
    private String orgName;
    private String password;
    private String psamNo;
    private String username;
    private List<ResqDatasBean> resqDatas;

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public String getCardKind() {
        return cardKind;
    }

    public void setCardKind(String cardKind) {
        this.cardKind = cardKind;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardSerial() {
        return cardSerial;
    }

    public void setCardSerial(String cardSerial) {
        this.cardSerial = cardSerial;
    }

    public String getCardSubType() {
        return cardSubType;
    }

    public void setCardSubType(String cardSubType) {
        this.cardSubType = cardSubType;
    }

    public String getChipSerial() {
        return chipSerial;
    }

    public void setChipSerial(String chipSerial) {
        this.chipSerial = chipSerial;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getOperateStatus() {
        return operateStatus;
    }

    public void setOperateStatus(String operateStatus) {
        this.operateStatus = operateStatus;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPsamNo() {
        return psamNo;
    }

    public void setPsamNo(String psamNo) {
        this.psamNo = psamNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<ResqDatasBean> getResqDatas() {
        return resqDatas;
    }

    public void setResqDatas(List<ResqDatasBean> resqDatas) {
        this.resqDatas = resqDatas;
    }

    public static class ResqDatasBean {
        /**
         * resqData : B0116666666666666666001600107120009013DEFF188EDFFF6FEC2100E7
         */

        private String resqData;

        public String getResqData() {
            return resqData;
        }

        public void setResqData(String resqData) {
            this.resqData = resqData;
        }
    }
}
