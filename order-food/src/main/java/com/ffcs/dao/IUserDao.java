package com.ffcs.dao;

import com.ffcs.bean.User;

public interface IUserDao extends BaseDao<User>{
	/**
	 * 
	* @Title: login 
	* @Description: TODO(��½) 
	* @param @param user
	* @param @return    �趨�ļ� 
	* @return User    �������� 
	* @throws
	 */
     public User login(User user);
}
