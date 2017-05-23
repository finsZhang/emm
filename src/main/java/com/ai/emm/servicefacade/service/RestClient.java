package com.ai.emm.servicefacade.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.httpclient.HttpHost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangFengZhou
 * Date:  2015/9/17
 * Time: 18:28
 * Email:zhangfengzhou@asiainfo.com
 */
@Service
public class RestClient {
    private final String PATH_PARAM_SEPARATOR = "?";
    private final String PARAM_NAME_VALUE_SEPARATOR="=";
    private final String PARAM_VALUE_LEFT_SEPARATOR="{";
    private final String PARAM_VALUE_RIGHT_SEPARATOR="}";
    private final String PARAM_SEPARATOR="&";

    private Logger logger = LoggerFactory.getLogger(RestClient.class);

    @Autowired
    @Qualifier("objectMapper")
    private ObjectMapper objectMapper;

    @Autowired
    @Qualifier("httpHost")
    private HttpHost httpHost;
    @Autowired
    private RestTemplate restTemplate;
    private HttpHost httpHostVal;
    public <T> T retrieveData(String url,Map map,Class<T> clazz,HttpHost...httpHosts) throws IOException {
        if(httpHosts!=null&&httpHosts.length>0){
            httpHostVal = httpHosts[0];
        }else{
            httpHostVal = httpHost;
        }
        logger.debug(" logger retrieveData start 1"+preProcessURL(url,map)+":"+map);

        String string = restTemplate.getForObject(preProcessURL(url,map),String.class,map);
        logger.debug(" logger retrieveData start 2"+string);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        T obj = null;
        try{
            obj = objectMapper.readValue(string,clazz);
        }catch (IOException e){
            logger.error("接口调用异常，调用URL:"+preProcessURL(url,map)+"，返回类型："+clazz+",报文:"+string+";异常:"+e.getMessage());
            throw e;
        }
        return obj;
    }
    private String preProcessURL(String url,Map map){
        StringBuffer sb = new StringBuffer();
        Set<Map.Entry> set =  map.entrySet();
        Iterator<Map.Entry> entrys = set.iterator();
        Map.Entry entry;
        int i=0;
        while(entrys.hasNext()){
            entry = entrys.next();
            if(i++>0){
                sb.append(PARAM_SEPARATOR);
            }
            sb.append(entry.getKey()+PARAM_NAME_VALUE_SEPARATOR+PARAM_VALUE_LEFT_SEPARATOR+entry.getKey()+PARAM_VALUE_RIGHT_SEPARATOR);
        }
        if(sb.length()>0){
            return httpHostVal.toURI()+url+PATH_PARAM_SEPARATOR+sb.toString();
        }else{
            return httpHostVal.toURI()+url;
        }
    }
}
