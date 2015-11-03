package com.ppfix.web.util;

import com.alibaba.fastjson.JSON;


/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2015/10/28-17:43
 */
public class JsonUtils {

    public static String toJson(Object map){
        if(map!=null){
            return JSON.toJSONString(map);
        }else
            return null;
    }
}
