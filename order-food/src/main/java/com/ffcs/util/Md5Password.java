package com.ffcs.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 
* @ClassName: Md5Password 
* @Description: TODO(MD5 ����) 
* @author ����� 
* @date 2019��8��29�� ����4:38:16 
*
 */
public class Md5Password {
	//������
	 private  final static  String  SALT="1bbn3hh";
	 /**
	  * 
	 * @Title: getMd5Pwd 
	 * @Description: TODO(����) 
	 * @param @param pwd
	 * @param @return    �趨�ļ� 
	 * @return String    �������� 
	 * @throws
	  */
    public static String getMd5Pwd(String pwd){
    	String md5Hex = DigestUtils.md5Hex(pwd+SALT);
    	return md5Hex;
    }
}
