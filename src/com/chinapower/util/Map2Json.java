package com.chinapower.util;

import net.sf.json.JSONObject;


public class Map2Json {
	/*
	 * 将java对象转换为json字符串
	 * **/
	public String object2json(Object obj){
		 JSONObject json = JSONObject.fromObject(obj);//将java对象转换为json对象  
	     String str = json.toString();//将json对象转换为字符串  
	     return str; 
	}
}
