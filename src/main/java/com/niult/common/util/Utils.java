package com.niult.common.util;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author Niu Liangtao
 * @create 2018/01/28 17:48
 */
@Slf4j
public class Utils {

    /**
     * 一天的毫秒数
     */
    private static final long MILLIS_PER_DAY = 86400000L;
    /* **************************************************************************************/

    /**
     * 判断Map是否为空
     *
     * @param para the map to check, may be null
     * @return true if empty or null
     */
    public static boolean isEmpty(String para) {
        return (para == null || para.isEmpty());
    }

    /**
     * 判断Map是否为空
     *
     * @param para the map to check, may be null
     * @return true if empty or null
     */
    public static boolean isEmpty(Map para) {
        return (para == null || para.isEmpty());
    }

    /**
     * 判断Map是否为空
     *
     * @param para the map to check, may be null
     * @return true if empty or null
     */
    public static boolean isEmpty(List para) {
        return (para == null || para.isEmpty());
    }

    /**
     * 判断para是否为空
     *
     * @param para the map to check, may be null
     * @return true if empty or null
     */
    public static boolean isEmpty(Object para) {

        if(para == null) {
            return true;
        }
        if(para instanceof String) {
            String para2 = (String) para;
            return para2.isEmpty();

        }else if(para instanceof List) {
            List<?> para2 = (List<?>) para;
            return para2.isEmpty();

        }else if(para instanceof Map) {
            Map<?, ?> para2 = (Map<?, ?>) para;
            return para2.isEmpty();

        }else if(para instanceof Collection) {
            Collection d = (Collection) para;
            return d.isEmpty();

        }else {
            return false;
        }
    }

    /**
     * 判断para是否为空
     *
     * @param para the map to check, may be null
     * @return true if empty or null
     */
    public static boolean isNotEmpty(Object para) {
        return ! isEmpty(para);
    }

    /**
     * 判断Map是否为非空
     *
     * @param para the map to check, may be null
     * @return true if non-null and non-empty
     */
    public static boolean isNotEmpty(String para) {
        return ! isEmpty(para);
    }

    /**
     * 判断Map是否为非空
     *
     * @param para the map to check, may be null
     * @return true if non-null and non-empty
     */
    public static boolean isNotEmpty(Map para) {
        return ! isEmpty(para);
    }

    /**
     * 判断Map是否为非空
     *
     * @param para the map to check, may be null
     * @return true if non-null and non-empty
     */
    public static boolean isNotEmpty(List para) {
        return ! isEmpty(para);
    }

    /* **************************************************************************************/

    /**
     * sigmod函数
     *
     * @param param 参数
     * @return sigmod
     */
    public static double sigmod(double param) {
        return 1.0 / (1.0 + Math.pow(Math.E, - param));
    }

    /**
     * 是否在有效时间内的时间
     *
     * @param time 发生时间
     * @param days 有效时间
     * @return 是否在有效时间内的时间
     */
    public static boolean timeStatus(String time, int days) {
        Date now = new Date();
        Date date = new Date(Long.valueOf(time));

        return now.getTime() - date.getTime() <= (MILLIS_PER_DAY * days);
    }

    /**
     * Long的字符串解析
     *
     * @param record       字符串
     * @param defaultValue 默认值
     * @return Long型的数值
     */
    public static Long parseLong(Object record, Long defaultValue) {
        try {
            if(isNull(record)) {
                return defaultValue;
            }

            return Long.valueOf(record.toString());
        }catch(Exception e) {
            //TODO
            // log.error("[parseParam error:{}]", e);
        }
        return defaultValue;
    }

    /**
     * Int的字符串解析
     *
     * @param record       字符串
     * @param defaultValue 默认值
     * @return Int型的数值
     */
    public static int parseInt(Object record, int defaultValue) {
        try {
            if(isNull(record)) {
                return defaultValue;
            }

            int p = Integer.parseInt(record.toString());
            if(p <= 0 || p > 100000) {
                return defaultValue;
            }
            return p;
        }catch(Exception e) {
            //TODO
            //log.error("[parseParam error:{}]", e);
        }
        return defaultValue;
    }

    public static boolean isNull(Object param) {
        if((param == null || isEmpty(param.toString())
                || "null".equals(param.toString().trim().toLowerCase())
                || param.toString().length() == 0
                || "\\N".equals(param.toString()))) {
            return true;
        }else {
            return false;
        }
    }

    public static boolean isNormalUser(String userId) {
        return ! (isNull(userId) || "-1".equals(userId));
    }

    public static long timePartition(String time, int hours) {
        Date now = new Date();
        Date date = new Date(Long.valueOf(time));
        Long diff = now.getTime() - date.getTime();
        return Math.round(diff / (7200000 * hours) + 0.5);

    }

}


