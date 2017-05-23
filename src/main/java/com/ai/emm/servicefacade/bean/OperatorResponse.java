package com.ai.emm.servicefacade.bean;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangFengZhou
 * Date:  2015/9/6
 * Time: 17:31
 * Email:zhangfengzhou@asiainfo.com
 */
public class OperatorResponse extends BaseResponse{
    private List<User> sysOperatorBeans;

    public List<User> getSysOperatorBeans() {
        return sysOperatorBeans;
    }

    public void setSysOperatorBeans(List<User> sysOperatorBeans) {
        this.sysOperatorBeans = sysOperatorBeans;
    }
}
