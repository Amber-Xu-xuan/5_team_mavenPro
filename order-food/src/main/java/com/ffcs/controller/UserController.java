package com.ffcs.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffcs.bean.User;
import com.ffcs.service.IUserService;
import com.ffcs.util.Md5Password;
import com.ffcs.util.MySessionContext;

/**
 * 
* @ClassName: UserController 
* @Description: TODO(�û�ģ�� �����½ ע�� �ǳ��ȹ���) 
* @author ����� 
* @date 2019��8��27�� ����11:32:05 
*
 */
@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	IUserService iUserService;
	/**
	 * 
	* @Title: login 
	* @Description: TODO(��½ ) 
	* @param @param goodList
	* @param @return    �趨�ļ� 
	* @return Map<String,Object>    �������� 
	* @throws
	 */
	@ResponseBody
	@RequestMapping("login")
     public Map<String,Object> login(@RequestBody User user,HttpServletRequest request,HttpServletResponse response){
		final Logger logger = LoggerFactory.getLogger(UserController.class);
		logger.info("<<<<<<<<<<<<<<<<<<<start>>>>>>>>>>>>>>>>>>>>");
		Long startTime =System.currentTimeMillis();
		
		Map<String, Object> userMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();	
		try{
			//�ͻ��˴����� MD5 �ټ��μ���� ȥƥ�����ݿ��е�����
			String md5Pwd = Md5Password.getMd5Pwd(user.getPassword());
			user.setPassword(md5Pwd);
			User loginUser = iUserService.login(user);
			if(loginUser !=null){
				MySessionContext  ms = MySessionContext.getInstance();
				// �绰 ��Ϊkey vaule Ϊ loginUser ������ session ��
				session.setAttribute(session.getId(), loginUser);
				//��ǰ��½�˺� ���� session
				session.setAttribute("userName", user.getPhoneNumber());
				//���ݵ�ǰsessionId ����session
				ms.AddSession(session);
				Cookie cookie = new Cookie("sessionId",session.getId());
				cookie.setPath("/");
				response.addCookie(cookie);
				userMap.put("status", "0");
				userMap.put("user", loginUser);
			}else{
				userMap.put("status", "1");
			}
		}catch (Exception e){
			logger.error("error:[{}ms]",e);
			userMap.put("status", "1");
		}
		Long stoptTime =System.currentTimeMillis();
		logger.debug("costTime:[{}ms]",stoptTime-startTime);
		logger.info("<<<<<<<<<<<<<<<<<<<stop>>>>>>>>>>>>>>>>>>>>");
		return userMap;
     }
	/**
	 * 
	* @Title: checkLogin 
	* @Description: TODO(����session ����Ƿ��½��) 
	* @param @param user
	* @param @param request
	* @param @param response
	* @param @return    �趨�ļ� 
	* @return Map<String,Object>    �������� 
	* @throws
	 */
	@ResponseBody
	@RequestMapping("checkLogin")
     public Map<String,Object> checkLogin(HttpServletRequest request,HttpServletResponse response){
		final Logger logger = LoggerFactory.getLogger(UserController.class);
		logger.info("<<<<<<<<<<<<<<<<<<<start>>>>>>>>>>>>>>>>>>>>");
		Map<String, Object> userMap=null;
		Long startTime =System.currentTimeMillis();
		try{
			 userMap = new HashMap<String, Object>();
			Cookie[] cookies = request.getCookies();
			
			for(Cookie cookie : cookies){
				if(cookie !=null && "sessionId".equals(cookie.getName())){
					String cooieId = cookie.getValue(); 
					MySessionContext  ms = MySessionContext.getInstance();
					//���ݵ�ǰsessionId ��ȡsession
					HttpSession loginSession = ms.getSession(cooieId);
					//��ǰcookid ��session ����һ���ǵ�½session
					if(loginSession !=null){
						//��½session
						User sessionUser = (User) loginSession.getAttribute(loginSession.getId());
						//�ѵ�½��
						if(sessionUser!=null){
						  //�ɹ�
						  userMap.put("status", "0");
						  userMap.put("user", sessionUser);
						  return userMap;
						}else{
							//ʧ��
						  userMap.put("status", "1");
						}
				  }
				}else{
					      userMap.put("status", "1");
				}
			 }
			
		}catch (Exception e) {
			logger.error("error:[{}ms]",e);
			userMap.put("status", "1");
		}
		Long stoptTime =System.currentTimeMillis();
		logger.debug("costTime:[{}ms]",stoptTime-startTime);
		logger.info("<<<<<<<<<<<<<<<<<<<stop>>>>>>>>>>>>>>>>>>>>");
		return userMap;
     }
	/**
	 * 
	* @Title: logout 
	* @Description: TODO(�ǳ�  ȥ��session) 
	* @param @param request
	* @param @param response
	* @param @return    �趨�ļ� 
	* @return Map<String,Object>    �������� 
	* @throws
	 */
	@ResponseBody
	@RequestMapping("logout")
     public Map<String,Object> logout(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		final Logger logger = LoggerFactory.getLogger(UserController.class);
		logger.info("<<<<<<<<<<<<<<<<<<<start>>>>>>>>>>>>>>>>>>>>");
		Long startTime =System.currentTimeMillis();
		
		Map<String, Object> userMap = new HashMap<String, Object>();
		try{
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie : cookies){
				if("sessionId".equals(cookie.getName())){
					cookie.setPath("/");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
			  userMap.put("status", "0");
			  userMap.put("user", "");
		}catch (Exception e) {
			 userMap.put("status", "1");
			 logger.error("error:[{}ms]",e);
		}
		Long stoptTime =System.currentTimeMillis();
		logger.debug("costTime:[{}ms]",stoptTime-startTime);
		logger.info("<<<<<<<<<<<<<<<<<<<stop>>>>>>>>>>>>>>>>>>>>");
		return userMap;
     }
	/**
	 * 
	* @Title: register 
	* @Description: TODO(ע�Ṧ��    ����˫MD5����) 
	* @param @param request
	* @param @param response
	* @param @param session
	* @param @return    �趨�ļ� 
	* @return Map<String,Object>    �������� 
	* @throws
	 */
	@ResponseBody
	@RequestMapping("register")
     public Map<String,Object> register(@RequestBody User user){
		final Logger logger = LoggerFactory.getLogger(UserController.class);
		logger.info("<<<<<<<<<<<<<<<<<<<start>>>>>>>>>>>>>>>>>>>>");
		Long startTime =System.currentTimeMillis();
		
		Map<String, Object> registerMap = new HashMap<String, Object>();
		try{
			iUserService.insert(user);
			registerMap.put("status", "0");
		}catch (Exception e) {
			logger.error("error:[{}ms]",e);
			registerMap.put("status", "1");
		}
		Long stoptTime =System.currentTimeMillis();
		logger.debug("costTime:[{}ms]",stoptTime-startTime);
		logger.info("<<<<<<<<<<<<<<<<<<<stop>>>>>>>>>>>>>>>>>>>>");
		return registerMap;
     }
	/**
	 * 
	* @Title: aminLogin 
	* @Description: TODO(����Ա��½ ���) 
	* @param @param user
	* @param @param request
	* @param @param response
	* @param @return    �趨�ļ� 
	* @return Map<String,Object>    �������� 
	* @throws
	 */
	@ResponseBody
	@RequestMapping("adminLogin")
     public Map<String,Object> aminLogin(@RequestBody User user,HttpServletRequest request,HttpServletResponse response){
		final Logger logger = LoggerFactory.getLogger(UserController.class);
		logger.info("<<<<<<<<<<<<<<<<<<<start>>>>>>>>>>>>>>>>>>>>");
		Long startTime =System.currentTimeMillis();
		Map<String, Object> userMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();	
		try{
			//�ͻ��˴����� MD5 �ټ��μ���� ȥƥ�����ݿ��е�����
			String md5Pwd = Md5Password.getMd5Pwd(user.getPassword());
			user.setPassword(md5Pwd);
			User loginUser = iUserService.login(user);
			// 1���� ����ԱȨ��
			if(loginUser !=null && "1".equals(loginUser.getRole()) ){
				System.out.println("478485");
				MySessionContext  ms = MySessionContext.getInstance();
				// �绰 ��Ϊkey vaule Ϊ loginUser ������ session ��
				session.setAttribute(session.getId(), loginUser);
				//��ǰ��½�˺� ���� session
				session.setAttribute("userName", user.getPhoneNumber());
				//���ݵ�ǰsessionId ����session
				ms.AddSession(session);
				Cookie cookie = new Cookie("sessionId",session.getId());
				cookie.setPath("/");
				response.addCookie(cookie);
				userMap.put("status", "0");
				userMap.put("user", loginUser);
			}else{
				userMap.put("status", "1");
			}
		}catch (Exception e){
			logger.error("error:[{}ms]",e);
			userMap.put("status", "1");
		}
		Long stoptTime =System.currentTimeMillis();
		logger.debug("costTime:[{}ms]",stoptTime-startTime);
		logger.info("<<<<<<<<<<<<<<<<<<<stop>>>>>>>>>>>>>>>>>>>>");
		return userMap;
     }
	
}
