package com.cn.hysec.md5;

import java.security.MessageDigest;

/**
 * md5密码加密
 * @author Still2Almost
 *
 */
public class MD5Util {
	public final static String 	MD5(String s) {
		
		try {
			char hexDigits[]=
				 { '0', '1', '2', '3', '4', '5', '6', 
						 '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
			byte[] btInput=s.getBytes();
			//使用MD5摘要的算法MessageDigest对象
			MessageDigest mDigest=MessageDigest.getInstance("MD5");
			//使用指定字节更新摘要
			mDigest.update(btInput);
			//获得密文
			byte[] md=mDigest.digest();
			//把密文转换成十六进制的字符形式
			int j=md.length;
			char str[]=new char[j*2];
			int k=0;
			for(int i=0;i<j;i++){
				byte byte0=md[i];
				str[k++]=hexDigits[byte0 >>> 4& 0xf];
				str[k++]=hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
}
