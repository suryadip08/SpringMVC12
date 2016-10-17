package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {

	@RequestMapping("/hello")
	public ModelAndView welcome_method(HttpServletRequest req, HttpServletResponse res){
		String username = req.getParameter("uname");
		String password = req.getParameter("pwd");
		String id = req.getParameter("id");
		
		System.out.println("username :"+username);
		System.out.println("id :" +id);
		
		if(password.equals("admin") && id.equals("10")){
			String message = "Hello " + username;
			return new ModelAndView("welcome","model",message);
		}
		
		else{
			return new ModelAndView("errorpage", "model", "Invalid credential");
		}
		
	}
}
