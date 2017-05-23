package com.ai.emm.servicefacade.bean;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangFengZhou
 * Date:  2015/9/6
 * Time: 17:19
 * Email:zhangfengzhou@asiainfo.com
 */
public class OrgsResponse extends BaseResponse{
    private List<SysOrg> sysOrgBeans;

    public List<SysOrg> getSysOrgBeans() {
        return sysOrgBeans;
    }

    public void setSysOrgBeans(List<SysOrg> sysOrgBeans) {
        this.sysOrgBeans = sysOrgBeans;
    }
}
