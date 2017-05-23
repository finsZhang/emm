package com.ai.emm.vo;

import java.util.Date;

/**
 * Created by lenovo on 2017/1/6.
 */
public class LogReportVO {

    private String startOperateDate;
    private String endOperateDate;
    private String orgName;
    private String orgCode;
    private String businessType;
    private String operateCount;
    private String timePeriod;

    public String getOrgNames() {
        return orgNames;
    }

    public void setOrgNames(String orgNames) {
        this.orgNames = orgNames;
    }

    public String getOrgCodes() {
        return orgCodes;
    }

    public void setOrgCodes(String orgCodes) {
        this.orgCodes = orgCodes;
    }

    private String orgNames;
    private String orgCodes;


    public String getOperateCount() {
        return operateCount;
    }

    public void setOperateCount(String operateCount) {
        this.operateCount = operateCount;
    }




    public String getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }




    public String getStartOperateDate() {
        return startOperateDate;
    }

    public void setStartOperateDate(String  startOperateDate) {
        this.startOperateDate = startOperateDate;
    }

    public String getEndOperateDate() {
        return endOperateDate;
    }

    public void setEndOperateDate(String endOperateDate) {
        this.endOperateDate = endOperateDate;
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

}
