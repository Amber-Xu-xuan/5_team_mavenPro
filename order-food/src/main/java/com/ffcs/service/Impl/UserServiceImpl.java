package com.ffcs.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffcs.bean.User;
import com.ffcs.dao.IUserDao;
import com.ffcs.service.IUserService;
import com.ffcs.util.Md5Password;
@Service
public class UserServiceImpl implements IUserService{
	@Autowired
    IUserDao iUserDao;
	@Override
	public void insert(User user) {
		String md5Pwd = Md5Password.getMd5Pwd(user.getPassword());
		user.setPassword(md5Pwd);
		//游客权限
		user.setRole("0");
		iUserDao.insert(user);
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
	public List<User> selectPage(int offset, int len) {
		return null;
	}

	@Override
	public int selectCount() {
		return 0;
	}

	@Override
	public User login(User user) {
		return iUserDao.login(user);
	}

}
