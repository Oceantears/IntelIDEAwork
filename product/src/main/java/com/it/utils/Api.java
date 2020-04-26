/**
 *
 */
package com.it.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Laotian
 * @date 2020-03-14 12:31
 */
public class Api {
    public Map<String,Object> returnJson(int code,String msg){
        Map map=new HashMap();
        map.put("code",code);
        map.put("msg",msg);
        return map;
    }

    public Map<String,Object> returnJson(int code, String msg, List<Map> data){
        Map map=new HashMap();
        map.put("code",code);
        map.put("msg",msg);
        map.put("data",data);
        return map;
    }

    public Map<String,Object> returnJson(int code, String msg, Map data){
        Map map=new HashMap();
        map.put("code",code);
        map.put("msg",msg);
        map.put("data",data);
        return map;
    }
}