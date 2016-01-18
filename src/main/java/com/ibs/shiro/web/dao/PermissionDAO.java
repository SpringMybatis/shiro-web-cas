package com.ibs.shiro.web.dao;

import org.springframework.dao.DataAccessException;

import com.ibs.shiro.web.model.Permission;

public interface PermissionDAO {

	/**
	 * 添加权限信息
	 * 
	 * @param permission
	 * @throws DataAccessException
	 */
	public void insertPermission(Permission permission) throws DataAccessException;

	/**
	 * 删除权限
	 * 
	 * @param permissionId
	 * @throws DataAccessException
	 */
	public void deletePermission(Integer permissionId) throws DataAccessException;
	
}
