package com.ibs.shiro.web.model;

import java.io.Serializable;

/**
 * @author Administrator
 * 角色实体
 */
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 角色Id
	 * 
	 */
	private Integer roleId;

	/**
	 * 角色名称
	 * 
	 */
	private String roleName;

	/**
	 * 角色描述
	 */
	private String roleDesc;

	/**
	 * 是否可用
	 * 
	 */
	private Integer locked = 1;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public Integer getLocked() {
		return locked;
	}

	public void setLocked(Integer locked) {
		this.locked = locked;
	}

	@Override
	public String toString() {
		return "Role [locked=" + locked + ", roleDesc=" + roleDesc
				+ ", roleId=" + roleId + ", roleName=" + roleName + "]";
	}

}
