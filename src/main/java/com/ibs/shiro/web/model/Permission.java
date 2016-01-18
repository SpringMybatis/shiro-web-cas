package com.ibs.shiro.web.model;

import java.io.Serializable;

/**
 * @author Administrator
 * 权限实体
 */
public class Permission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 权限ID
	 * 
	 */
	private Integer permissionId;

	/**
	 * 权限ID
	 */
	private String permissionName;

	/**
	 * 权限描述
	 * 
	 */
	private String permissionDesc;

	/**
	 * 是否可用
	 */
	private Integer locked = 1;

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getPermissionDesc() {
		return permissionDesc;
	}

	public void setPermissionDesc(String permissionDesc) {
		this.permissionDesc = permissionDesc;
	}

	public Integer getLocked() {
		return locked;
	}

	public void setLocked(Integer locked) {
		this.locked = locked;
	}

	@Override
	public String toString() {
		return "Permission [locked=" + locked + ", permissionDesc="
				+ permissionDesc + ", permissionId=" + permissionId
				+ ", permissionName=" + permissionName + "]";
	}

}
