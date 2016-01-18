package com.ibs.shiro.web.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ibs.shiro.web.dao.PermissionDAO;
import com.ibs.shiro.web.model.Permission;

@Repository
public class PermissionDAOImpl implements PermissionDAO {

	private static final String PERMISSION = "com.bis.shiro.perssion.sqlMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	public void deletePermission(Integer permissionId)
			throws DataAccessException {
		this.sqlSession.delete(PERMISSION+"deletePermission",permissionId);
	}

	public void insertPermission(Permission permission)
			throws DataAccessException {
		this.sqlSession.insert(PERMISSION+"insertPermission", permission);
	}

}
