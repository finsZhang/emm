package com.ai.emm.servicefacade.service.interfaces;


import com.ai.emm.servicefacade.bean.OperatorResponse;

import java.io.IOException;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangFengZhou
 * Date:  2015/9/6
 * Time: 17:32
 * Email:zhangfengzhou@asiainfo.com
 */
public interface IOperatorSV {
    public OperatorResponse retrieveOperator(Map map) throws IOException;
}
