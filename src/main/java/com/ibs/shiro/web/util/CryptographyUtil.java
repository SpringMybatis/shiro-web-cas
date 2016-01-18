package com.ibs.shiro.web.util;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @author Administrator
 * shiro加、解密的工具
 */
public class CryptographyUtil {

	
	/**
	 * Base64加密
	 * 
	 * @param passwd
	 * @return
	 */
	public static String encodeBase64(String passwd){
		return Base64.encodeToString(passwd.getBytes());
	}
	
	
	/**
	 * Base64加密
	 * 
	 * @param passwd
	 * @return
	 */
	public static String decodeBase64(String passwd){
		return Base64.decodeToString(passwd.getBytes());
	}
	
	
	/**
	 * Md5加密
	 * 
	 * @param passwd
	 * @param salt
	 * @return
	 */
	public static String encodeMd5(String passwd,String salt){
		return new Md5Hash(passwd, salt).toString();
	}
	
	/**
	 * SHA1加密
	 * 
	 * @param passwd
	 * @param salt
	 * @return
	 */
	public static String encodeSHA1(String passwd,String salt){
		return new SimpleHash("SHA-1", passwd, salt).toString();
	}
	
	public static void main(String[] args) {
		String passwd = "19901223";
		String encodePs = encodeBase64(passwd);
		String decodePs = decodeBase64(encodePs);
		System.out.println(encodePs);
		System.out.println(decodePs);
		System.out.println(encodeMd5(passwd, "hello"));
		System.out.println(encodeSHA1(passwd, "hello"));
	}
	
}
