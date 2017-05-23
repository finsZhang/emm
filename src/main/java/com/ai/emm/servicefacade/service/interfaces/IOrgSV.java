package com.ai.emm.servicefacade.service.interfaces;


import com.ai.emm.servicefacade.bean.OrgsResponse;

import java.io.IOException;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangFengZhou
 * Date:  2015/9/6
 * Time: 17:17
 * Email:zhangfengzhou@asiainfo.com
 */
public interface IOrgSV {
    public OrgsResponse retrieveOrg(Map map) throws IOException;
}
