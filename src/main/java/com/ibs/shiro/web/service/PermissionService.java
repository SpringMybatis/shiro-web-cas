package com.ibs.shiro.web.service;

import com.ibs.shiro.web.model.Permission;


public interface PermissionService {

	/**
	 * 添加权限信息
	 * 
	 * @param permission
	 * @throws Exception
	 */
	public void insertPermission(Permission permission) throws Exception;

	/**
	 * 删除权限
	 * 
	 * @param permissionId
	 * @throws Exception
	 */
	public void deletePermission(Integer permissionId) throws Exception;

}
