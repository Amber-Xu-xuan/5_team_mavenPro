package com.ffcs.dao;

import com.ffcs.bean.User;

public interface IUserDao extends BaseDao<User>{
	/**
	 * 
	* @Title: login 
	* @Description: TODO(登陆) 
	* @param @param user
	* @param @return    设定文件 
	* @return User    返回类型 
	* @throws
	 */
     public User login(User user);
}
