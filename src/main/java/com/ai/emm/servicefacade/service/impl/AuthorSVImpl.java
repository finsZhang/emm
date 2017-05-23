package com.ai.emm.servicefacade.service.impl;

import com.ai.emm.servicefacade.bean.AuthorDataResponse;
import com.ai.emm.servicefacade.service.AbstractRestClient;
import com.ai.emm.servicefacade.service.interfaces.IAuthorSV;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangFengZhou
 * Date:  2015/9/6
 * Time: 14:22
 * Email:zhangfengzhou@asiainfo.com
 */
@Service
public class AuthorSVImpl extends AbstractRestClient<AuthorDataResponse> implements IAuthorSV {
    @Value("${authorPath}")
    private String url;
    public AuthorDataResponse retrieveData(Map map) throws IOException {
        return retrieveData(url,map);
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
