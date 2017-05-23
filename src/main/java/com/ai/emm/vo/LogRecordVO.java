package com.ai.emm.vo;

import java.util.Date;

/**
 * Created by lenovo on 2017/1/6.
 */
public class LogRecordVO {
    private long id;
    private String tradeSerial;
    private String chipSerial;
    private String cardSerial;
    private String cardNo;
    private String idNo;
    private String cardName;
    private String daughterType;
    private Date operateDate;
    private String psamNo;
    private String orgName;
    private String orgCode;
    private String businessType;
    private String cardType;
    private String cardStatus;
    private String operateStatus;
    private Date updateDate;


    //Query condtion
    public  String getOrgCodes() {
        return orgCodes;
    }public void   setOrgCodes(String orgCodes) {
        this.orgCodes = orgCodes;
    }public String getOrgNames() {
        return orgNames;
    }public void   setOrgNames(String orgNames) {
        this.orgNames = orgNames;
    }private String orgCodes;
    private String orgNames;
    public  String getStartOperateDate() {
        return startOperateDate;
    }public void   setStartOperateDate(String startOperateDate) {
        this.startOperateDate = startOperateDate;
    }public String getEndOperateDate() {
        return endOperateDate;
    }public void   setEndOperateDate(String endOperateDate) {
        this.endOperateDate = endOperateDate;
    }private String startOperateDate;
    private String endOperateDate;

    public Date getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTradeSerial() {
        return tradeSerial;
    }

    public void setTradeSerial(String tradeSerial) {
        this.tradeSerial = tradeSerial;
    }

    public String getChipSerial() {
        return chipSerial;
    }

    public void setChipSerial(String chipSerial) {
        this.chipSerial = chipSerial;
    }

    public String getCardSerial() {
        return cardSerial;
    }

    public void setCardSerial(String cardSerial) {
        this.cardSerial = cardSerial;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getDaughterType() {
        return daughterType;
    }

    public void setDaughterType(String daughterType) {
        this.daughterType = daughterType;
    }

    public String getPsamNo() {
        return psamNo;
    }

    public void setPsamNo(String psamNo) {
        this.psamNo = psamNo;
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

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getOperateStatus() {
        return operateStatus;
    }

    public void setOperateStatus(String operateStatus) {
        this.operateStatus = operateStatus;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
