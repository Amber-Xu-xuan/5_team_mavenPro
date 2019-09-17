package com.ffcs.dao.Impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import com.ffcs.bean.User;
import com.ffcs.dao.IUserDao;
/**
 * 
* @ClassName: UserDaoImpl 
* @Description: TODO(���� �û���ع��� �����½) 
* @author ����� 
* @date 2019��8��27�� ����3:45:16 
*
 */
@Component
public class UserDaoImpl extends SqlSessionDaoSupport implements IUserDao{

	@Override
	public void insert(User t) {
		
		 getSqlSession().insert("user.insertUser",t);
		 getSqlSession().insert("user.insertLimit",t);
	}

	@Override
	public void update(User t) {
		
	}

	@Override
	public void delete(String id) {
		
	}

	@Override
	public User selectOne(Integer id) {
		return null;
	}

	@Override
	public List<User> selectAll() {
		return null;
	}

	@Override
	public List<User> selectPage(int page, int rows) {
		return null;
	}

	@Override
	public int selectCount() {
		return 0;
	}
  
	@Override
	public User login(User user) {
		User loginUser = getSqlSession().selectOne("user.login",user);
		return loginUser;
	}

	

}
