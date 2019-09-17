package com.ffcs.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
* @ClassName: DateUtil 
* @Description: TODO(生成日期时间工具) 
* @author 黄青才 
* @date 2019年8月29日 上午9:47:01 
*
 */
public class DateUtil {
   public static String getNowDate(String time){
	   Date t = new Date();
	   SimpleDateFormat df = new SimpleDateFormat(time);
	   return df.format(t);
   }
}
