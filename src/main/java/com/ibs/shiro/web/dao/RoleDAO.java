package com.ibs.shiro.web.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ibs.shiro.web.model.Role;

public interface RoleDAO {

	/**
	 * 添加角色
	 * 
	 * @param role
	 * @throws DataAccessException
	 */
	public void addRole(Role role) throws DataAccessException;

    /**
     * 删除角色
     * 
     * @param roleId
     * @throws DataAccessException
     */
    public void deleteRole(Integer roleId) throws DataAccessException;

    /**
     * 添加角色-权限之间关系
     * @param roleId
     * @param permissionList
     * @throws DataAccessException
     */
    public void addRelationPermissions(Integer roleId, List<Integer> permissionList) throws DataAccessException;
    
    /**
     * 移除角色-权限之间关系
     * @param roleId
     * @param permissionList
     * @throws DataAccessException
     */
    public void deleteRelationPermissions(Integer roleId, List<Integer> permissionList) throws DataAccessException;

	
}
