package com.ffcs.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
* @ClassName: DateUtil 
* @Description: TODO(��������ʱ�乤��) 
* @author ����� 
* @date 2019��8��29�� ����9:47:01 
*
 */
public class DateUtil {
   public static String getNowDate(String time){
	   Date t = new Date();
	   SimpleDateFormat df = new SimpleDateFormat(time);
	   return df.format(t);
   }
}
