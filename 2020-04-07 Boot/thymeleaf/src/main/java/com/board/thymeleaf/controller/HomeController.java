package com.board.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.board.thymeleaf.dto.thymeleafDto;

@Controller
public class HomeController {
	  @GetMapping("/test")
	    public String getUser(Model model) {
		  System.out.println("넘어오기하나");
		  thymeleafDto dto = new thymeleafDto("kkaok", "테스트", "web");
		  model.addAttribute("user",dto);
	        return "test";
	    }

}
