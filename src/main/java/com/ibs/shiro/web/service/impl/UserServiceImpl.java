package com.ibs.shiro.web.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibs.shiro.web.dao.UserDAO;
import com.ibs.shiro.web.model.User;
import com.ibs.shiro.web.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	public void addRelationRoles(Integer userId, List<Integer> roleList)
			throws Exception {
		this.userDAO.addRelationRoles(userId, roleList);
	}

	public void addUser(User user) throws Exception {
		this.addUser(user);
	}

	public void changePassword(Integer userId, String newPassword)
			throws Exception {
		this.userDAO.changePassword(userId, newPassword);
	}

	public void deleteRelationRoles(Integer userId, List<Integer> roleList)
			throws Exception {
		this.userDAO.deleteRelationRoles(userId, roleList);
	}

	public User findByuserName(String userName) throws Exception {
		return this.userDAO.findByuserName(userName);
	}

	public Set<String> findPermissions(String userName) throws Exception {
		return this.userDAO.findPermissions(userName);
	}

	public Set<String> findRoles(String userName) throws Exception {
		return this.userDAO.findRoles(userName);
	}

}
