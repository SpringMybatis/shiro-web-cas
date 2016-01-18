package com.ibs.shiro.web.realm;

import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.ibs.shiro.web.model.User;
import com.ibs.shiro.web.service.UserService;

public class MyJdbcRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;
	
	/**
	 * 获取角色一级权限信息
	 * 
	 * (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo simpleAuthorizationInfo = null;
		// 获取用户名
		String userName = (String) principals.getPrimaryPrincipal();
		try {
			if(StringUtils.isNotBlank(userName)){
				simpleAuthorizationInfo = new SimpleAuthorizationInfo();
				// 获取用户对应的角色
				Set<String> roles = userService.findRoles(userName);
				simpleAuthorizationInfo.addRoles(roles);
				// 获取用户对应的权限
				Set<String> permissions = userService.findPermissions(userName);
				simpleAuthorizationInfo.addStringPermissions(permissions);
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		return simpleAuthorizationInfo;
	}
	
	/** 
	 * 获取登陆验证信息
	 * 
	 * (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		AuthenticationInfo authenticationInfo = null;
		// 获取用户名
		String userName = (String) token.getPrincipal();
		try {
			if(StringUtils.isNotBlank(userName)){
				// 获取用户
				User user = userService.findByuserName(userName);
				if(user == null) {
		            throw new UnknownAccountException();//没找到帐号
		        }
		        if(Boolean.TRUE.equals(user.getLocked()==0)) {
		            throw new LockedAccountException(); //帐号锁定
		        }
				// 对比凭证
				authenticationInfo = new SimpleAuthenticationInfo(user.getUserName(), user.getPassWord(), ByteSource.Util.bytes(user.getMd5Salt()), getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new AuthenticationException();
		}
		return authenticationInfo;
	}

	
	 @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    /**
     * 清除授权缓存
     * 
     */
    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    /**
     * 清除验证缓存
     * 
     */
    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    /**
     * 清除所有缓存
     * 
     */
    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
	
}
