package com.chinapower.action;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import com.chinapower.org.action.BasicAction;

public class GetCityWether extends BasicAction {
	private static final long serialVersionUID = 1L;

	public void  getWether() throws Exception{
		String cityId = getCityId();
		String json = getCityConf(cityId);
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.close();
	}
	//获取城市天气信息
	public static String getCityConf(String citycode) throws Exception{
		HttpClient client = new HttpClient();
		GetMethod getCityConfMet = new GetMethod("http://www.weather.com.cn/data/cityinfo/" + citycode + ".html");
		client.executeMethod(getCityConfMet);
		String cityconfJson = getCityConfMet.getResponseBodyAsString();
		return cityconfJson;
	}
	//获取城市天气信息
//	public static String getCityConf(String citycode) throws Exception{
//		HttpClient client = new HttpClient();
//		GetMethod getCityConfMet = new GetMethod(
//				"http://www.weather.com.cn/data/cityinfo/" + citycode + ".html");
//		client.executeMethod(getCityConfMet);
//		String cityconfJson = getCityConfMet.getResponseBodyAsString();
//		return cityconfJson;
//	}
	
	//获取城市id
	public static String  getCityId() {
		HttpClient hc = new HttpClient();
		GetMethod getm = new GetMethod("http://61.4.185.48:81/g/");
		String s;
		try {
			hc.executeMethod(getm);
			s = getm.getResponseBodyAsString();
			String citycode = "";
			if (s != null && s != "") {
				String[] datasplit = s.split(";");
				if (datasplit.length > 0) {
					for (String cityconf : datasplit) {
						String cityconftemp = cityconf.trim();
						int have = cityconftemp.indexOf("var id");
						if (have >= 0) {
							String[] citycodeconf = cityconf.split("=");
							if (citycodeconf.length > 0) {
								citycode = citycodeconf[1];
							}
						}
					}
				}
			}
			System.out.println(citycode);
			return citycode;
		} catch (IOException e) {
		}
		return null;
	}
}
