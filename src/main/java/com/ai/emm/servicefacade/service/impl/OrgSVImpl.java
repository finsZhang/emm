package com.ai.emm.servicefacade.service.impl;

import com.ai.emm.servicefacade.bean.OrgsResponse;
import com.ai.emm.servicefacade.service.AbstractRestClient;
import com.ai.emm.servicefacade.service.interfaces.IOrgSV;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangFengZhou
 * Date:  2015/9/6
 * Time: 17:21
 * Email:zhangfengzhou@asiainfo.com
 */
@Service
public class OrgSVImpl extends AbstractRestClient<OrgsResponse> implements IOrgSV {
    @Value("${orgPath}")
    private String url;
    public OrgsResponse retrieveOrg(Map map) throws IOException {
        return retrieveData(url,map);
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
