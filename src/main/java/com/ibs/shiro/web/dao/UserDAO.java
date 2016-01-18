package com.ibs.shiro.web.dao;

import java.util.List;
import java.util.Set;

import org.springframework.dao.DataAccessException;

import com.ibs.shiro.web.model.User;

public interface UserDAO {

	
	/**
     * 添加用户
     * 
     * @param user
     * @throws DataAccessException
     */
    public void addUser(User user) throws DataAccessException;

    /**
     * 修改密码
     * 
     * @param userId
     * @param newPassword
     * @throws DataAccessException
     */
    public void changePassword(Integer userId, String newPassword) throws DataAccessException;

    /**
     * 添加用户-角色关系
     * 
     * @param userId
     * @param roleList
     * @throws DataAccessException
     */
    public void addRelationRoles(Integer userId, List<Integer> roleList) throws DataAccessException;

    /**
     * 删除用户-角色关系
     * 
     * @param userId
     * @param roleList
     * @throws DataAccessException
     */
    public void deleteRelationRoles(Integer userId, List<Integer> roleList) throws DataAccessException;

    /**
     * 根据用户名查找用户
     * 
     * @param userName
     * @return
     * @throws DataAccessException
     */
    public User findByuserName(String userName) throws DataAccessException;

    /**
     * 找到用户对应的角色
     * 
     * @param userName
     * @return
     * @throws DataAccessException
     */
    public Set<String> findRoles(String userName) throws DataAccessException;

    /**
     * 找到用户对应的权限
     * 
     * @param userName
     * @return
     * @throws DataAccessException
     */
    public Set<String> findPermissions(String userName) throws DataAccessException;
	
}
