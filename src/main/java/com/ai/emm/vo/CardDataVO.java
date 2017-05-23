package com.ai.emm.vo;

import java.util.Date;

/**
 * Created by lenovo on 2017/1/5.
 */
public class CardDataVO {
    //卡数据
    private long id;
    private String orgName;
    private String orgCode;
    private String cityCode;
    private String cardSerial;
    private String cardNo;
    private String chipSerial;
    private String masterType;
    private String daughterType;
    private String name;
    private String sex;
    private String idNo;
    private String phoneNo;
    private String address;
    private String status;
    //导入记录数据
    private long recordId;
    private String zipFileName;
    private String txtFileName;
    private String batchNum;
    private String receiveAddr;
    private String creatorName;
    private String creatorCode;
    private Date createTime;
    //查询条件部分

    public String getStartOperateDate() {
        return startOperateDate;
    }

    public void setStartOperateDate(String startOperateDate) {
        this.startOperateDate = startOperateDate;
    }

    public String getEndOperateDate() {
        return endOperateDate;
    }

    public void setEndOperateDate(String endOperateDate) {
        this.endOperateDate = endOperateDate;
    }

    private String startOperateDate;
    private String endOperateDate;

    public CardDataVO() {
    }

    public CardDataVO(long id, String orgName, String orgCode, String cityCode, String cardSerial, String cardNo, String chipSerial, String masterType, String daughterType, String name, String sex, String idNo, String phoneNo, String address, String status, long recordId, String zipFileName, String txtFileName, String batchNum, String receiveAddr, String creatorName, String creatorCode, Date createTime) {
        this.id = id;
        this.orgName = orgName;
        this.orgCode = orgCode;
        this.cityCode = cityCode;
        this.cardSerial = cardSerial;
        this.cardNo = cardNo;
        this.chipSerial = chipSerial;
        this.masterType = masterType;
        this.daughterType = daughterType;
        this.name = name;
        this.sex = sex;
        this.idNo = idNo;
        this.phoneNo = phoneNo;
        this.address = address;
        this.status = status;
        this.recordId = recordId;
        this.zipFileName = zipFileName;
        this.txtFileName = txtFileName;
        this.batchNum = batchNum;
        this.receiveAddr = receiveAddr;
        this.creatorName = creatorName;
        this.creatorCode = creatorCode;
        this.createTime = createTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
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

    public String getChipSerial() {
        return chipSerial;
    }

    public void setChipSerial(String chipSerial) {
        this.chipSerial = chipSerial;
    }

    public String getMasterType() {
        return masterType;
    }

    public void setMasterType(String masterType) {
        this.masterType = masterType;
    }

    public String getDaughterType() {
        return daughterType;
    }

    public void setDaughterType(String daughterType) {
        this.daughterType = daughterType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getRecordId() {
        return recordId;
    }

    public void setRecordId(long recordId) {
        this.recordId = recordId;
    }

    public String getZipFileName() {
        return zipFileName;
    }

    public void setZipFileName(String zipFileName) {
        this.zipFileName = zipFileName;
    }

    public String getTxtFileName() {
        return txtFileName;
    }

    public void setTxtFileName(String txtFileName) {
        this.txtFileName = txtFileName;
    }

    public String getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(String batchNum) {
        this.batchNum = batchNum;
    }

    public String getReceiveAddr() {
        return receiveAddr;
    }

    public void setReceiveAddr(String receiveAddr) {
        this.receiveAddr = receiveAddr;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getCreatorCode() {
        return creatorCode;
    }

    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
