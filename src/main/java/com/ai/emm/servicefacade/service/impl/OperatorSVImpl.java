package com.ai.emm.servicefacade.service.impl;

import com.ai.emm.servicefacade.bean.OperatorResponse;
import com.ai.emm.servicefacade.service.AbstractRestClient;
import com.ai.emm.servicefacade.service.interfaces.IOperatorSV;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangFengZhou
 * Date:  2015/9/6
 * Time: 17:33
 * Email:zhangfengzhou@asiainfo.com
 */
@Service
public class OperatorSVImpl extends AbstractRestClient<OperatorResponse> implements IOperatorSV {
    @Value("${operatorPath}")
    private String url;
    public OperatorResponse retrieveOperator(Map map) throws IOException {
        return retrieveData(url,map);
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
