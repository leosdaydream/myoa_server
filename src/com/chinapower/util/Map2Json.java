package com.chinapower.util;

import net.sf.json.JSONObject;


public class Map2Json {
	/*
	 * ��java����ת��Ϊjson�ַ���
	 * **/
	public String object2json(Object obj){
		 JSONObject json = JSONObject.fromObject(obj);//��java����ת��Ϊjson����  
	     String str = json.toString();//��json����ת��Ϊ�ַ���  
	     return str; 
	}
}
