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
* @Description: TODO(用户模块 处理登陆 注册 登出等功能) 
* @author 黄青才 
* @date 2019年8月27日 上午11:32:05 
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
	* @Description: TODO(登陆 ) 
	* @param @param goodList
	* @param @return    设定文件 
	* @return Map<String,Object>    返回类型 
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
			//客户端传来的 MD5 再加盐计算后 去匹配数据库中的密码
			String md5Pwd = Md5Password.getMd5Pwd(user.getPassword());
			user.setPassword(md5Pwd);
			User loginUser = iUserService.login(user);
			if(loginUser !=null){
				MySessionContext  ms = MySessionContext.getInstance();
				// 电话 作为key vaule 为 loginUser 保存于 session 中
				session.setAttribute(session.getId(), loginUser);
				//当前登陆账号 存于 session
				session.setAttribute("userName", user.getPhoneNumber());
				//根据当前sessionId 保存session
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
	* @Description: TODO(根据session 检查是否登陆过) 
	* @param @param user
	* @param @param request
	* @param @param response
	* @param @return    设定文件 
	* @return Map<String,Object>    返回类型 
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
					//根据当前sessionId 获取session
					HttpSession loginSession = ms.getSession(cooieId);
					//当前cookid 有session 但不一定是登陆session
					if(loginSession !=null){
						//登陆session
						User sessionUser = (User) loginSession.getAttribute(loginSession.getId());
						//已登陆过
						if(sessionUser!=null){
						  //成功
						  userMap.put("status", "0");
						  userMap.put("user", sessionUser);
						  return userMap;
						}else{
							//失败
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
	* @Description: TODO(登出  去除session) 
	* @param @param request
	* @param @param response
	* @param @return    设定文件 
	* @return Map<String,Object>    返回类型 
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
	* @Description: TODO(注册功能    密码双MD5加密) 
	* @param @param request
	* @param @param response
	* @param @param session
	* @param @return    设定文件 
	* @return Map<String,Object>    返回类型 
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
	* @Description: TODO(管理员登陆 入口) 
	* @param @param user
	* @param @param request
	* @param @param response
	* @param @return    设定文件 
	* @return Map<String,Object>    返回类型 
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
			//客户端传来的 MD5 再加盐计算后 去匹配数据库中的密码
			String md5Pwd = Md5Password.getMd5Pwd(user.getPassword());
			user.setPassword(md5Pwd);
			User loginUser = iUserService.login(user);
			// 1代表 管理员权限
			if(loginUser !=null && "1".equals(loginUser.getRole()) ){
				System.out.println("478485");
				MySessionContext  ms = MySessionContext.getInstance();
				// 电话 作为key vaule 为 loginUser 保存于 session 中
				session.setAttribute(session.getId(), loginUser);
				//当前登陆账号 存于 session
				session.setAttribute("userName", user.getPhoneNumber());
				//根据当前sessionId 保存session
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
