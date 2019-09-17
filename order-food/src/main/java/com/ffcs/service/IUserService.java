package com.ffcs.service;

import com.ffcs.bean.User;
/**
 * 
* @ClassName: IUserService 
* @Description: TODO(该接口处理 用户登陆 登出 等功能) 
* @author 黄青才 
* @date 2019年8月27日 下午3:30:06 
*
 */
public interface IUserService extends BaseService<User>{
	/**
	 * 
	* @Title: login 
	* @Description: TODO(校验登陆) 
	* @param @param user
	* @param @return    设定文件 
	* @return User    返回类型 
	* @throws
	 */
     public User login(User user);
}
