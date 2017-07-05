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

	//�Զ�ע��UserService
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	//������Ӧ/login����
	@RequestMapping(value = "/login")
	public ModelAndView login(String loginname, String password, ModelAndView mv,
			HttpSession session) {
		//���ݵ�¼������������û����ж��û���¼
		System.out.println(loginname+" "+password);
		User user = userService.login(loginname, password);
		if(user != null) {
			//��¼�ɹ�����user�������õ�HttpSession��������Χ��
			session.setAttribute("user", user);
			//ת����main.jsp����
			mv.setViewName("main");
		} else {
			//��¼ʧ�ܣ�����ֱ����Ϣ��ʾ������ת����¼ҳ��
			mv.addObject("message", "��¼���������������������");
			mv.setViewName("index");
		}
		return mv;
	}
}
