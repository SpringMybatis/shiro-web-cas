package com.ibs.shiro.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibs.shiro.web.dao.PermissionDAO;
import com.ibs.shiro.web.model.Permission;
import com.ibs.shiro.web.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionDAO permissionDAO;
	
	public void deletePermission(Integer permissionId) throws Exception {
		this.permissionDAO.deletePermission(permissionId);
	}

	public void insertPermission(Permission permission) throws Exception {
		this.insertPermission(permission);
	}

}
