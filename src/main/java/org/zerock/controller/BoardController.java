package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.BoardVO;
import org.zerock.dto.PageDTO;
import org.zerock.dto.PageMaker;
import org.zerock.service.BoardService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
public class BoardController {
	
	@Setter(onMethod_ = { @Autowired } )
	private BoardService service;

	@GetMapping("/register")
	public void registerGET() {
		
		log.info("get register...............");
		
	}
	
	@PostMapping("/register")
	public String registerPost(BoardVO vo) {
		
		log.info("post register...............");
		log.info(vo);
		
		boolean result = service.register(vo);
		
		log.info("result: " + result);
		log.info("====================================");
		
		return "redirect:/board/list";
		
	}
	
	@GetMapping("/list")
	public void list(PageDTO dto, Model model) {
		log.info("get list...............");

		model.addAttribute("list",service.getList(dto));
		
		int total = service.getListCount(dto);
		
		PageMaker pg = new PageMaker(dto, total);
		
		model.addAttribute("pg", pg);
	}
	
}
