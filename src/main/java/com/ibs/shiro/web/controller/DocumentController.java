package com.ibs.shiro.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ibs.shiro.web.model.User;

@Controller
@Scope(value="prototype")
@RequestMapping(value="/docs")
public class DocumentController {
	
	@RequestMapping(value="/read.do")
	public String login(User user,HttpServletRequest request,HttpServletResponse response){
		
		return "docs";
	}
	
}
