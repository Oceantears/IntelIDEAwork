/**
 * <一句话功能简述>
 * <p>
 * Layui工具类
 *
 * @author sunmeng
 * @create 2020/3/18   17:12
 */
package com.it.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


//code=1 success 2 fail 3 warning
public class Layui extends HashMap<String,Object> {
	public Layui returnJson(int code,String msg){
		Layui layui=new Layui();
		layui.put("code",code);
		layui.put("msg",msg);
		return layui;
	}
	public Layui returnJson(int code, String msg, Map data){
		Layui layui=new Layui();
		layui.put("code",code);
		layui.put("msg",msg);
		layui.put("data",data);
		return layui;
	}
	public Layui returnJson(int code, String msg, List<?> data){
		Layui layui=new Layui();
		layui.put("code",code);
		layui.put("msg",msg);
		layui.put("data",data);
		return layui;
	}
}
