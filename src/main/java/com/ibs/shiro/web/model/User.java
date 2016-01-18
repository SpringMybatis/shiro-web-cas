package com.ibs.shiro.web.model;

import java.io.Serializable;

/**
 * @author Administrator 
 * User实体对象
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 * 
	 */
	private Integer userId;

	/**
	 * 用户名
	 * 
	 */
	private String userName;

	/**
	 * 密码
	 * 
	 */
	private String passWord;

	/**
	 * 盐加密
	 * 
	 */
	private String md5Salt;

	/**
	 * 账户是否锁住
	 * 
	 */
	private Integer locked = 1;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getMd5Salt() {
		return md5Salt;
	}

	public void setMd5Salt(String md5Salt) {
		this.md5Salt = md5Salt;
	}

	public Integer getLocked() {
		return locked;
	}

	public void setLocked(Integer locked) {
		this.locked = locked;
	}

	@Override
	public String toString() {
		return "User [locked=" + locked + ", md5Salt=" + md5Salt
				+ ", passWord=" + passWord + ", userId=" + userId
				+ ", userName=" + userName + "]";
	}

}
