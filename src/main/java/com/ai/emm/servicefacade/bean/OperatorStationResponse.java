package com.ai.emm.servicefacade.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangFengZhou
 * Date:  2015/10/30
 * Time: 16:22
 * Email:zhangfz3@asiainfo.com
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OperatorStationResponse  extends BaseResponse{
    private List<SysOperator2Org> sysOperator2OrgBeans;

    public List<SysOperator2Org> getSysOperator2OrgBeans() {
        return sysOperator2OrgBeans;
    }

    public void setSysOperator2OrgBeans(List<SysOperator2Org> sysOperator2OrgBeans) {
        this.sysOperator2OrgBeans = sysOperator2OrgBeans;
    }
}
