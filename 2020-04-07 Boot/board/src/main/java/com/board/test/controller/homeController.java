package com.board.test.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.board.test.dto.boardDto;
import com.board.test.mapper.boardMapper;

@Controller
public class homeController {

	@Resource
	boardMapper boardmapper;

	@RequestMapping("/home")
	private String home() {
		return "index.html";
	}

	@RequestMapping("/list.do")
	private String list(Model model) {
		List<boardDto> dto = boardmapper.boardList();
		model.addAttribute("boardDto",dto);

		return "list";
	}

	@RequestMapping("/insert.do")
	private String insert() {

		return "insert";
	}

	@RequestMapping(value = "/insertRes.do", method = RequestMethod.POST)
	private String insertRes(boardDto dto) {
		int res = boardmapper.write(dto);
		if(res>0) {
			System.out.println("insert 성공");
			return "redirect:index.html";
		}else {
			System.out.println("insert 실패");
			return "nsert.do";
		}
		
	}
	@RequestMapping("/delete.do")
	private String delete(String id) {
		int res = boardmapper.delete(id);
		if(res>0) {
			System.out.println("삭제성공");
			return "redirect:index.html";
		}else {
			System.out.println("삭제실패");
			return "list.do";
		}
	}
	@RequestMapping("/update.do")
	private String update(String id, Model model) {
		boardDto dto = boardmapper.one(id);
		model.addAttribute("dto",dto);
			return "updateForm";
	}
	
	@RequestMapping("/updateRes.do")
	private String updateRes(boardDto dto) {
		int res = boardmapper.update(dto);
		if(res>0) {
			System.out.println("업데이트 성공");
			return "redirect:index.html";
		}else {
			System.out.println("업데이트 실패");
			return "update.do";
		}
	}
	
	
}
