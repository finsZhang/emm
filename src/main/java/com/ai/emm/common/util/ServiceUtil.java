package com.ai.emm.common.util;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: ZhangFengZhou
 * Date:  2015/8/21
 * Time: 15:37
 * Email:zhangfengzhou@asiainfo.com
 */
public class ServiceUtil {
    public static Map transerBeanToMap(Object o) throws InvocationTargetException, IllegalAccessException {
        Map map = new HashMap();
        Method[] methods = o.getClass().getDeclaredMethods();
        Set<String> set = getValueInterfaceNames(o);
        for(int i = 0; i < methods.length; i++) {
            if(Modifier.isPublic(methods[i].getModifiers()) &&set.contains(methods[i].getName())) {
                String name = methods[i].getName().substring(3).toLowerCase();
                Object value = methods[i].invoke(o);
                map.put(name,value);
            }
        }
        return map;
    }

    public static Set<String> getValueInterfaceNames(Object o){
        Set<String> set = new HashSet();
        Class<?>[] types = o.getClass().getInterfaces();
        for(int i = 0; i < types.length; i++) {
            String interfaceName = types[i].getName();
            if(interfaceName.endsWith("Value")){
                Method[] methods = types[i].getDeclaredMethods();
                for(int j = 0; j < methods.length; j++) {
                    if (Modifier.isPublic(methods[j].getModifiers()) &&
                            methods[j].getName().startsWith("get")) {
                        set.add(methods[j].getName());
                    }
                }
                break;
            }
        }
        return set;
    }

    public static String getFieldNameFromSetMethod(Method method){
        String setName = method.getName();
        return setName.substring(3,4).toLowerCase()+setName.substring(4);
    }

    public static String getGetMethodNameFromFiledName(String fieldName){
        return "get" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
    }

    public static String getSetMethodNameFromFiledName(String fieldName){
        return "set" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
    }

}