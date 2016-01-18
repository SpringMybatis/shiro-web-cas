package com.ibs.shiro.web.dao.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ibs.shiro.web.dao.RoleDAO;
import com.ibs.shiro.web.model.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {

	private static final String ROLE = "com.bis.shiro.role.sqlMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	public void addRelationPermissions(Integer roleId,
			List<Integer> permissionList) throws DataAccessException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("roleId", roleId);
		if(!permissionList.isEmpty()){
			Iterator<Integer> iterator = permissionList.iterator();
			while(iterator.hasNext()){
				Integer perssionId = iterator.next();
				dataMap.put("perssionId", perssionId);
				sqlSession.insert(ROLE+"addRelationPermissions", dataMap);
			}
		}
	}

	public void addRole(Role role) throws DataAccessException {
		sqlSession.insert(ROLE+"addRole", role);
	}

	public void deleteRelationPermissions(Integer roleId,
			List<Integer> permissionList) throws DataAccessException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("roleId", roleId);
		if(!permissionList.isEmpty()){
			Iterator<Integer> iterator = permissionList.iterator();
			while(iterator.hasNext()){
				Integer perssionId = iterator.next();
				dataMap.put("perssionId", perssionId);
				sqlSession.delete(ROLE+"deleteRelationPermissions", dataMap);
			}
		}
	}

	public void deleteRole(Integer roleId) throws DataAccessException {
		sqlSession.delete(ROLE+"deleteRole", roleId);
	}

}
