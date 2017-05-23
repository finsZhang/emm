package com.ai.emm.common.util;

import com.ai.emm.exception.ParameterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Hongten
 * @created 2014-5-20
 */
public class TxtReader {
    private static Logger logger = LoggerFactory.getLogger(TxtReader.class);
    /**
     * @return
     * @throws IOException
     */
    public  static <T> List<T> readTxt(File file, int startLine, Class<T> clz, Map<String,Txt2Bean> fieldCols) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ParameterException {
        T obj = null;
        List<T> list = new ArrayList<T>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GBK"));
        String[]lineData;
        try {
        String line;
        int i = 0;

        String fieldName;
        Txt2Bean txt2Bean;
        while ((line = reader.readLine()) != null) {
            if (i < startLine) {
                i++;
                continue;
            }
            i++;
            lineData = line.split(",");
            obj = clz.newInstance();
            for(Map.Entry<String,Txt2Bean> fieldCol:fieldCols.entrySet()){
                fieldName = fieldCol.getKey();
                txt2Bean = fieldCol.getValue();
                Method setMethod = clz.getMethod(ServiceUtil.getSetMethodNameFromFiledName(fieldName),txt2Bean.getParameterType());
                if(txt2Bean.getColNum()<lineData.length)
                    setMethod.invoke(obj,lineData[txt2Bean.getColNum()]);
            }
            list.add(obj);
        }
    } catch (Exception e){
            logger.error("文件格式或文件数据有误:"+e.getMessage());
        throw new ParameterException("文件格式或文件数据有误！");
    } finally {
        reader.close();
    }
        return list;
    }
}