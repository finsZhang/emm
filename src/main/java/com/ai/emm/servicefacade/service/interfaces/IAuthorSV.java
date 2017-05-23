package com.ai.emm.servicefacade.service.interfaces;

import com.ai.emm.servicefacade.bean.AuthorDataResponse;

import java.io.IOException;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangFengZhou
 * Date:  2015/9/6
 * Time: 14:18
 * Email:zhangfengzhou@asiainfo.com
 */
public interface IAuthorSV {
    public AuthorDataResponse retrieveData(Map map) throws IOException;
}
