package com.ffcs.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * 
* @ClassName: LoginSessionListener 
* @Description: TODO(������һ�仰��������������) 
* @author ����� 
* @date 2019��8��27�� ����4:56:17 
*
 */
public class LoginSessionListener implements HttpSessionListener{
	//������һ������������session��  
	public static Map userMap = new HashMap();
	//MySessionContext��ʵ��session�Ķ�ȡ��ɾ������  ����ģʽ  
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
