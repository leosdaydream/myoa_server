package com.chinapower.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collection;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import com.lowagie.text.List;

public class Test {
	public void writeToFileContent(String file, String content)
			throws Exception {
		BufferedWriter out = null;
		out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
				file, true)));
		out.write(content);
		if (out != null) {
			out.close();
		}

	}

	public String getFileContent() throws Exception {

		File file = new File(
				"E:\\Workspaces\\chinapower\\WebRoot\\data\\source.txt");
		StringBuilder sb = new StringBuilder();
		String s = "";
		BufferedReader br = new BufferedReader(new FileReader(file));
		while ((s = br.readLine()) != null) {
			sb.append(s + "\n");
		}
		br.close();
		String str = sb.toString();
		return str;
	}

	public String getCityId() {
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

	public String getCityConf(String citycode) throws Exception, IOException {
		HttpClient client = new HttpClient();
		GetMethod getCityConfMet = new GetMethod(
				"http://www.weather.com.cn/data/cityinfo/" + citycode + ".html");
		client.executeMethod(getCityConfMet);
		String cityconfJson = getCityConfMet.getResponseBodyAsString();
		return cityconfJson;
	}
	public WetherInfo jsonUtil(String jsonData){
		JSONObject jsonObject = new JSONObject().fromObject(jsonData);
		
		WetherInfo cc =  (WetherInfo) jsonObject.toBean(jsonObject,WetherInfo.class);
		return cc;
	}

	public static void main(String[] args) throws Exception {
		Test t = new Test();
		// System.out.println(t.getFileContent());
		// t.writeToFileContent("d:/text.txt", "sdfdsfd");
		String cifyconf = t.getCityConf(t.getCityId());
		WetherInfo cc =  t.jsonUtil(cifyconf);
		JSONObject ob = cc.getWeatherinfo();
		System.out.println(ob.getString("city"));
	}
	public void test(){
	}
}
