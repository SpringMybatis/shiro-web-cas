package com.ibs.shiro.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ibs.shiro.web.model.User;

@Controller
@Scope(value="prototype")
@RequestMapping(value="/user")
public class LoginController {
	
	@RequestMapping(value="/login.do")
	public String login(User user,HttpServletRequest request,HttpServletResponse response){
		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(user.getUserName(),user.getPassWord());
		try{
			currentUser.login(token);
			return "home";
		}catch(Exception e){
			e.printStackTrace();
			
			return "login";
		}
	}
	
}
