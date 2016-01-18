package com.ibs.shiro.web.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.ibs.shiro.web.model.User;

public class PasswordHelper {

    private String algorithmName = "md5";
    
    private int hashIterations = 2;

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    public void encryptPassword(User user) {
    	String newPassword = new SimpleHash(
                algorithmName,
                user.getPassWord(),
                ByteSource.Util.bytes(user.getMd5Salt()),
                hashIterations).toHex();
    	System.out.println(newPassword);
    	user.setPassWord(newPassword);
    }
    
    public static void main(String[] args) {
		User u = new User();
		u.setPassWord("123");
		u.setMd5Salt("29a0f8a0bc0102f348fbd457c7d56ecb");
    	PasswordHelper ps = new PasswordHelper();
    	ps.encryptPassword(u);
	}
}
