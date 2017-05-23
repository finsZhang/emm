package com.ai.emm.common.util;

import java.security.MessageDigest;

/**
 * Created by Walter on 2017/1/6.
 */
public class MD5Util {
    public final static String MD5(String s) {
        try {
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(s.getBytes());
            StringBuffer buffer = new StringBuffer();
            // 把没一个byte 做一个与运算 0xff;
            for (byte b : result) {
                // 与运算
                int number = b & 0xff;// 加盐
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    buffer.append("0");
                }
                buffer.append(str);
            }

            // 标准的md5加密后的结果
            return buffer.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
//        "e10adc3949ba59abbe56e057f20f883e"
        System.out.print(MD5Util.MD5("123456"));
    }
}
