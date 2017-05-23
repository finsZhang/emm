package com.ai.emm.servicefacade.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.httpclient.HttpHost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangFengZhou
 * Date:  2015/9/6
 * Time: 14:26
 * Email:zhangfengzhou@asiainfo.com
 */
public abstract class AbstractRestClient<T> {
    private final String PATH_PARAM_SEPARATOR = "?";
    private final String PARAM_NAME_VALUE_SEPARATOR="=";
    private final String PARAM_VALUE_LEFT_SEPARATOR="{";
    private final String PARAM_VALUE_RIGHT_SEPARATOR="}";
    private final String PARAM_SEPARATOR="&";
    private static Logger logger = LoggerFactory.getLogger(AbstractRestClient.class);

    private Class<T> a;
    @Autowired
    @Qualifier("objectMapper")
    private ObjectMapper objectMapper;
    public AbstractRestClient(){
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        a = (Class) params[0];

    }
    @Autowired
    @Qualifier("httpHost")
    private HttpHost httpHost;
    @Autowired
    private RestTemplate restTemplate;
    protected T retrieveData(String url,Map map) throws IOException {
        String string = restTemplate.getForObject(preProcessURL(url,map),String.class,map);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        T obj = null;
        try{
            obj = objectMapper.readValue(string,a);
        }catch (IOException e){
            logger.error("接口调用异常，调用URL:"+preProcessURL(url,map)+"，返回类型："+a+",报文:"+string+";异常:"+e.getMessage());
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
            return httpHost.toURI()+url+PATH_PARAM_SEPARATOR+sb.toString();
        }else{
            return httpHost.toURI()+url;
        }
    }
}
