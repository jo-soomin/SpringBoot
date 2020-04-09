package com.login.Security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.login.Security.dto.loginDto;
import com.login.Security.mapper.loginMapper;

@Controller
public class TestController {
	
	@Autowired
	loginMapper loginMapper;

	
	
	@RequestMapping("/")
	public String home(ModelAndView mav) {
		
		return "home";
	}
	
	@ResponseBody
	@RequestMapping("/test")
	public String test() {
		
		return "OK";
	}
	
	@ResponseBody
	@RequestMapping("/adminOnly")
	public String adminOnly() {
		
		return "adminOnly Page";
	}
	
	
	@RequestMapping("/login")
	public String loginForm(){

		return "login-form";
	}
	
	
	@RequestMapping("/signup")
	public String signupForm(){

		return "signup";
	}
	
	@RequestMapping("/signupRes")
	public String signupRes(String username, String password){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		loginDto dto = new loginDto();
		dto.setUsername(username);
		dto.setPassword(encoder.encode(password));
	
		
		int res = loginMapper.signup(dto);
		if(res>0) {
			System.out.println("성공");
			return "home";
		}else {
			System.out.println("실패");
			return "signup";
		}
		
	}
	

}
