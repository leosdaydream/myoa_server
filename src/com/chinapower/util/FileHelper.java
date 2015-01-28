package com.chinapower.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;

/**
 * @author Administrator
 * */
public class FileHelper {
		public static String getFileContent(String path)throws Exception{
			File file = new File(path);
	        StringBuilder sb = new StringBuilder();
	        String s ="";
	        BufferedReader br = new BufferedReader(new FileReader(file));
	        while( (s = br.readLine()) != null) {
	        sb.append(s + "\n");
	        }
	        br.close();
	        String str = sb.toString();
	        return str;
		}
		/**
		 * 重新数据文件
		 * */
		public static void writeToFileContent(String file,String content) throws Exception{
			BufferedWriter out = null;     
	            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));     
	            out.write(content);     
	            if(out != null){  
	            out.close();     
	        }     
	                
		}
}
