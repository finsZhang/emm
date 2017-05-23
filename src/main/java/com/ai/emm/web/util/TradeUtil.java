package com.ai.emm.web.util;

import com.ai.emm.common.util.DateUtils;

/**
 * Created by lenovo on 2017/1/9.
 */
public class TradeUtil {
    public static String getTradeSerial(String cardSerial,String tradeType){
        return cardSerial+"_"+tradeType+"_"+ DateUtils.getTime().getTime();
    }
}
