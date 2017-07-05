package com.bbu.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.bbu.model.User;
import com.bbu.service.UserService;

@Controller
public class UserController {

	//自动注入UserService
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	//处理相应/login请求
	@RequestMapping(value = "/login")
	public ModelAndView login(String loginname, String password, ModelAndView mv,
			HttpSession session) {
		//根据登录名和密码查找用户，判断用户登录
		System.out.println(loginname+" "+password);
		User user = userService.login(loginname, password);
		if(user != null) {
			//登录成功，将user对象设置到HttpSession的作用域范围中
			session.setAttribute("user", user);
			//转发到main.jsp请求
			mv.setViewName("main");
		} else {
			//登录失败，设置直白信息提示，并跳转到登录页面
			mv.addObject("message", "登录名或密码错误，请重新输入");
			mv.setViewName("index");
		}
		return mv;
	}
}
