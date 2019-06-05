package com.example.demo.utils;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * created by zhangtao on 2019/5/23
 */
public class ReservationUtil {
    /**
     * 保留两位小数
     * @param str 传入的字符串数值
     * @return String
     */
    public static  String getMathUtil(String str){
        if(str==null||"".equals(str)){
            return str;
        }else{
            double  math = Double.parseDouble(str);
            BigDecimal bigDecimal = new BigDecimal(math);
            return bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).toString();
        }
    }

    /**
     * 四舍五入取整
     * @param str
     * return String
     */
    public static String getMathInteger(String str){
        if(str==null||"".equals(str)){
            return str;
        }else{
            BigDecimal bigDecimal = new BigDecimal(str);
            return bigDecimal.setScale(0,BigDecimal.ROUND_HALF_UP).toString();
        }
    }



    /**
     * 正则替换
     */
    public static  String StringFilter(String str){
        String regEx = "\t\n\r";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();

    }
}
