package com.chinapower.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encode {
	public static String Md5(String plainText ) { 
		try { 
		MessageDigest md = MessageDigest.getInstance("MD5"); 
		md.update(plainText.getBytes()); 
		byte b[] = md.digest(); 

		int i; 

		StringBuffer buf = new StringBuffer(""); 
		for (int offset = 0; offset < b.length; offset++) { 
		i = b[offset]; 
		if(i<0) i+= 256; 
		if(i<16) 
		buf.append("0"); 
		buf.append(Integer.toHexString(i)); 
		} 

		System.out.println("result: " + buf.toString());//32λ���� 
		return buf.toString();
		//System.out.println("result: " + buf.toString().substring(8,24));//16λ���� 

		} catch (NoSuchAlgorithmException e) { 
		} 
		return null;
	} 
}
