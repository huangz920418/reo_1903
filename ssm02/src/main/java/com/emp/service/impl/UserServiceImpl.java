package com.emp.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.emp.dao.UserDao;
import com.emp.entity.User;
import com.emp.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	//◊¢»ÎDao∂‘œÛ
	@Resource
	private UserDao userDao;

	@Override
	public User queryUser(String username) {
		User user = userDao.queryByUserName(username);
		return user;
	}

	@Override
	public Set<String> queryRoles(String username) {
		Set<String> roles = userDao.queryRoles(username);
		return roles;
	}

	@Override
	public Set<String> queryPermissions(String username) {
		Set<String> pers = userDao.queryPermissions(username);
		return pers;
	}

}
