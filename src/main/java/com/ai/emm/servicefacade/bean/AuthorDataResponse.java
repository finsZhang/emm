package com.ai.emm.servicefacade.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangFengZhou
 * Date:  2015/9/6
 * Time: 14:13
 * Email:zhangfengzhou@asiainfo.com
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorDataResponse extends BaseResponse{
    private List<Menu> menuBeans;
    private User user;
    private  SysOrg sysOrgBean;
    private List<SysOperator2Org> sysOperator2OrgBeans;

    public List<Menu> getMenuBeans() {
        return menuBeans;
    }

    public void setMenuBeans(List<Menu> menuBeans) {
        this.menuBeans = menuBeans;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SysOrg getSysOrgBean() {
        return sysOrgBean;
    }

    public void setSysOrgBean(SysOrg sysOrgBean) {
        this.sysOrgBean = sysOrgBean;
    }

    public List<SysOperator2Org> getSysOperator2OrgBeans() {
        return sysOperator2OrgBeans;
    }

    public void setSysOperator2OrgBeans(List<SysOperator2Org> sysOperator2OrgBeans) {
        this.sysOperator2OrgBeans = sysOperator2OrgBeans;
    }
}
