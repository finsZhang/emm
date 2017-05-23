package com.ai.emm.common.validate.interceptor;

/**
 * Created by fins on 2016/5/31.
 */
public interface ValidatorInterceptor {
    <T> String preHandle(T bean)
            throws Exception;
    <T> void postHandle(T bean)
            throws Exception;
}
