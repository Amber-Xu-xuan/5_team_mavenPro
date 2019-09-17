package com.ffcs.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * 
* @ClassName: LoginSessionListener 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author 黄青才 
* @date 2019年8月27日 下午4:56:17 
*
 */
public class LoginSessionListener implements HttpSessionListener{
	//创建了一个对象来保存session的  
	public static Map userMap = new HashMap();
	//MySessionContext是实现session的读取和删除增加  单例模式  
    private   MySessionContext myc=MySessionContext.getInstance();  

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		myc.AddSession(event.getSession());  
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		 HttpSession session = event.getSession();  
	        myc.DelSession(session); 
	}

}
