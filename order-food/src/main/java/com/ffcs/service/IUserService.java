package com.ffcs.service;

import com.ffcs.bean.User;
/**
 * 
* @ClassName: IUserService 
* @Description: TODO(�ýӿڴ��� �û���½ �ǳ� �ȹ���) 
* @author ����� 
* @date 2019��8��27�� ����3:30:06 
*
 */
public interface IUserService extends BaseService<User>{
	/**
	 * 
	* @Title: login 
	* @Description: TODO(У���½) 
	* @param @param user
	* @param @return    �趨�ļ� 
	* @return User    �������� 
	* @throws
	 */
     public User login(User user);
}
