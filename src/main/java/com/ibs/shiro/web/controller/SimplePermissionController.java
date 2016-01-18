package com.ibs.shiro.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope(value="prototype")
@RequestMapping(value="/sperm")
public class SimplePermissionController {

	@RequestMapping(value="/simple.do")
	public String login(HttpServletRequest request,HttpServletResponse response){
		
		return "simple";
	}
	
}
