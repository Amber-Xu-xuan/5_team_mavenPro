package com.ffcs.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 
* @ClassName: Md5Password 
* @Description: TODO(MD5 加密) 
* @author 黄青才 
* @date 2019年8月29日 下午4:38:16 
*
 */
public class Md5Password {
	//加密盐
	 private  final static  String  SALT="1bbn3hh";
	 /**
	  * 
	 * @Title: getMd5Pwd 
	 * @Description: TODO(加密) 
	 * @param @param pwd
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	  */
    public static String getMd5Pwd(String pwd){
    	String md5Hex = DigestUtils.md5Hex(pwd+SALT);
    	return md5Hex;
    }
}
