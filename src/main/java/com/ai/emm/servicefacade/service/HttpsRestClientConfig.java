package com.ai.emm.servicefacade.service;

import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.ssl.SSLContexts;

import javax.net.ssl.SSLContext;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Created by IntelliJ IDEA.
 * User: zhangfz3
 * Date:  2016/9/3
 * Time: 13:12
 * Email:zhangfz3@asiainfo.com
 */
public class HttpsRestClientConfig{
    public static SSLConnectionSocketFactory create()throws Exception {
        SSLContext sslcontext = SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy() {
            public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                return true;
            }
        }).build();
        return new SSLConnectionSocketFactory(sslcontext, null, null,NoopHostnameVerifier.INSTANCE);
    }

    public static Registry<ConnectionSocketFactory> build(SSLConnectionSocketFactory sslConnectionSocketFactory)throws Exception {
       Registry<ConnectionSocketFactory>  socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
               .register("http", PlainConnectionSocketFactory.INSTANCE)
               .register("https",sslConnectionSocketFactory).build();
        return socketFactoryRegistry;
    }
}