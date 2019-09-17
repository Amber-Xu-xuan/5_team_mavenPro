package com.ffcs.util;

import java.util.HashMap;

import javax.servlet.http.HttpSession;
/**
 * 
* @ClassName: MySessionContext 
* @Description: TODO(��� session �ڴ˵�ʵ����  ��Ϊ���̹߳���) 
* @author ����� 
* @date 2019��9��1�� ����12:06:24 
*
 */
public class MySessionContext {
	private static MySessionContext instance;    
    @SuppressWarnings("rawtypes")
	private HashMap mymap;    
    @SuppressWarnings("rawtypes")
	private MySessionContext()    
    {    
        mymap = new HashMap();    
    }    
    public static MySessionContext getInstance()    
    {    
        if(instance==null)    
        {    
            instance = new MySessionContext();    
        }    
        return instance;    
    }    
    @SuppressWarnings("unchecked")
	public synchronized void AddSession(HttpSession session){    
        if(session!=null)    
        {    
            mymap.put(session.getId(), session);    
        }    
    }    
    public synchronized void DelSession(HttpSession session){    
        if(session!=null)    
        {    
            mymap.remove(session.getId());    
        }    
   }
    public synchronized HttpSession getSession(String session_id)    
    {    
        if(session_id==null)return null;    
        return (HttpSession)mymap.get(session_id);    
    }
}