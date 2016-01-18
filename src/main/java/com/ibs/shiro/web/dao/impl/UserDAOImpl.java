package com.ibs.shiro.web.dao.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ibs.shiro.web.dao.UserDAO;
import com.ibs.shiro.web.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final String USER = "com.bis.shiro.user.sqlMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	public void addRelationRoles(Integer userId, List<Integer> roleList)
			throws DataAccessException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("userId", userId);
		if(!roleList.isEmpty()){
			Iterator<Integer> iterator = roleList.iterator();
			while(iterator.hasNext()){
				Integer roleId = iterator.next();
				dataMap.put("roleId", roleId);
				sqlSession.insert(USER+"addRelationRoles", dataMap);
			}
		}
	}

	public void addUser(User user) throws DataAccessException {
		this.sqlSession.insert(USER+"addUser", user);
	}

	public void changePassword(Integer userId, String newPassword) throws DataAccessException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("userId", userId);
		dataMap.put("newPassword", newPassword);
		this.sqlSession.update(USER+"changePassword", dataMap);
	}

	public void deleteRelationRoles(Integer userId, List<Integer> roleList)	throws DataAccessException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("userId", userId);
		if(!roleList.isEmpty()){
			Iterator<Integer> iterator = roleList.iterator();
			while(iterator.hasNext()){
				Integer roleId = iterator.next();
				dataMap.put("roleId", roleId);
				sqlSession.delete(USER+"deleteRelationRoles", dataMap);
			}
		}
	}

	public User findByuserName(String userName) throws DataAccessException {
		return this.sqlSession.selectOne(USER+"findByuserName", userName);
	}

	public Set<String> findPermissions(String userName) throws DataAccessException {
		List<String> list= this.sqlSession.selectList(USER+"findPermissions", userName);
		return new HashSet<String>(list);
	}

	public Set<String> findRoles(String userName) throws DataAccessException {
		List<String> list= this.sqlSession.selectList(USER+"findRoles", userName);
		return new HashSet<String>(list);
	}

}
