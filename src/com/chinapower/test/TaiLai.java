package com.chinapower.test;

import java.io.File;
import java.net.URL;

public class TaiLai extends Thread {
//	public int count =0;
//	public void run(){
//		HttpClient hc = new HttpClient();
////		GetMethod gm = new GetMethod("http://221.209.44.122/Position_goLDZC.action?zwlb.id=5");
//		GetMethod gm = new GetMethod("http://www.tailai.gov.cn");
//		try {
//			int c=0;
//			for(int i=0;i<300;i++){
//				int s =  hc.executeMethod(gm);
//				System.out.println(s+":"+(c++));
//			}
//		} catch (Exception e) {
//		} 
//	}
	public static void main(String[] args) {
//		for(int j=0;j<5000;j++){
//			Thread t = new TaiLai();
//			t.start();
//		}
		TaiLai t = new TaiLai();
		t.getUrl();
	}
	public void getUrl(){
//		URL xmlpath = this.getClass().getClassLoader().getResource("source.txt");
//		System.out.println(xmlpath);
		File file = new File ("source.txt");
		System.out.println(file.getAbsolutePath());
	}
}
