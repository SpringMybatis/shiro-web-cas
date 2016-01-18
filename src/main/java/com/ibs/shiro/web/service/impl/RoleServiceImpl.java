package com.ibs.shiro.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibs.shiro.web.dao.RoleDAO;
import com.ibs.shiro.web.model.Role;
import com.ibs.shiro.web.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDAO roleDAO;
	
	public void addRelationPermissions(Integer roleId,
			List<Integer> permissionList) throws Exception {
		this.roleDAO.addRelationPermissions(roleId, permissionList);
	}

	public void addRole(Role role) throws Exception {
		this.roleDAO.addRole(role);
	}

	public void deleteRelationPermissions(Integer roleId,
			List<Integer> permissionList) throws Exception {
		this.roleDAO.deleteRelationPermissions(roleId, permissionList);
	}

	public void deleteRole(Integer roleId) throws Exception {
		this.roleDAO.deleteRole(roleId);
	}

}
