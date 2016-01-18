package com.ibs.shiro.web.service;

import java.util.List;
import java.util.Set;

import com.ibs.shiro.web.model.User;

public interface UserService {

	
    /**
     * 添加用户
     * 
     * @param user
     * @throws Exception
     */
    public void addUser(User user) throws Exception;

    /**
     * 修改密码
     * 
     * @param userId
     * @param newPassword
     * @throws Exception
     */
    public void changePassword(Integer userId, String newPassword) throws Exception;

    /**
     * 添加用户-角色关系
     * 
     * @param userId
     * @param roleList
     * @throws Exception
     */
    public void addRelationRoles(Integer userId, List<Integer> roleList) throws Exception;

    /**
     * 删除用户-角色关系
     * 
     * @param userId
     * @param roleList
     * @throws Exception
     */
    public void deleteRelationRoles(Integer userId, List<Integer> roleList) throws Exception;

    /**
     * 根据用户名查找用户
     * 
     * @param userName
     * @return
     * @throws Exception
     */
    public User findByuserName(String userName) throws Exception;

    /**
     * 找到用户对应的角色
     * 
     * @param userName
     * @return
     * @throws Exception
     */
    public Set<String> findRoles(String userName) throws Exception;

    /**
     * 找到用户对应的权限
     * 
     * @param userName
     * @return
     * @throws Exception
     */
    public Set<String> findPermissions(String userName) throws Exception;
    
}
