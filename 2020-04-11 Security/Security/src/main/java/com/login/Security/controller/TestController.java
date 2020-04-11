package com.login.Security.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.login.Security.dto.boardDto;
import com.login.Security.dto.loginDto;
import com.login.Security.mapper.boardMapper;
import com.login.Security.mapper.loginMapper;

@Controller
public class TestController {
	
	@Autowired
	loginMapper loginMapper;
	
	@Autowired
	boardMapper boardMapper;

	
	
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
	
	
	@RequestMapping("/mypage")
	public String mypage(Principal principal, Model model){
		String username = principal.getName();
		loginDto dto = loginMapper.selectOne(username);
		model.addAttribute("dto", dto);
		return "mypage";
	}
	
	@RequestMapping("/board")
	public String board(Principal principal, Model model) {
		String username = principal.getName();
		List<boardDto> dto = boardMapper.selectlist(username);
		model.addAttribute("dto", dto);
		
		return "board";
	}
	
	@RequestMapping("/write")
	public String write() {
		return "write";
	}
	@RequestMapping("/writeRes")
	public String writeRes(boardDto dto, Principal principal) {
		System.out.println(principal.getName());
		dto.setUsername(principal.getName());
		int res = boardMapper.write(dto);
		if(res>0) {
			System.out.println("성공");
			return "redirect:mypage";
		}else {
			System.out.println("실패");
			return "redirect:write";
		}
		
	}
	@RequestMapping("Wholeboard")
	public String Wholeboard(Model model) {
		
		List<boardDto> dto = boardMapper.selectAll();
		model.addAttribute("dto", dto);
		
		return "Wholeboard";
	}
	

}
