package com.ffcs.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 
* @ClassName: OrderIdUtil 
* @Description: TODO(订单id 生成工具) 
* @author 黄青才 
* @date 2019年8月29日 上午9:39:44 
*
 */
public class OrderIdUtil {
	
    /**
     * 
    * @Title: getOrderId 
    * @Description: TODO(生成订单唯一 id) 
    * @param @param lock
    * @param @return    设定文件 
    * @return String    返回类型 
    * @throws
     */
	public static String getOrderId() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String newDate=sdf.format(new Date());
		String result="";
		Random random=new Random();
		for(int i=0;i<3;i++){
			result+=random.nextInt(10);
		}
		return newDate+result;

    }
}
