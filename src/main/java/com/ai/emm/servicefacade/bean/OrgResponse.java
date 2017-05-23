package com.ai.emm.servicefacade.bean;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangFengZhou
 * Date:  2015/9/23
 * Time: 14:35
 * Email:zhangfengzhou@asiainfo.com
 */
public class OrgResponse extends BaseResponse{
    private SysOrg sysOrgBean;

    public SysOrg getSysOrgBean() {
        return sysOrgBean;
    }

    public void setSysOrgBean(SysOrg sysOrgBean) {
        this.sysOrgBean = sysOrgBean;
    }
}
