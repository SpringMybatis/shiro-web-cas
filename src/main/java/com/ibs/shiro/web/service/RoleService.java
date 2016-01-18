package com.ibs.shiro.web.service;

import java.util.List;

import com.ibs.shiro.web.model.Role;

public interface RoleService {

	
	/**
	 * 添加角色
	 * 
	 * @param role
	 * @throws Exception
	 */
	public void addRole(Role role) throws Exception;

    /**
     * 删除角色
     * 
     * @param roleId
     * @throws Exception
     */
    public void deleteRole(Integer roleId) throws Exception;

    /**
     * 添加角色-权限之间关系
     * @param roleId
     * @param permissionList
     * @throws Exception
     */
    public void addRelationPermissions(Integer roleId, List<Integer> permissionList) throws Exception;
    
    /**
     * 移除角色-权限之间关系
     * @param roleId
     * @param permissionList
     * @throws Exception
     */
    public void deleteRelationPermissions(Integer roleId, List<Integer> permissionList) throws Exception;

	
	
}
