package org.zerock.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
	
	@GetMapping("/read")
	public void read(@ModelAttribute("dto") PageDTO dto, Model model) {	// @ModelAttribute 는 자동으로 모델 추가
		// 목록가기 누르면 다시 돌아가기위해서 그 전 데이터들이 필요하므로 @ModelAttribute("dto") 써줌
		
		model.addAttribute("board", service.findByBno(dto.getBno()));
		
		log.info("read get.................");
		
		
	}
	
	@PostMapping("/register")
	public String registerPost(@ModelAttribute("vo") @Valid BoardVO vo, BindingResult bind, RedirectAttributes rttr) {
		
		log.info("post register...............");
		log.info(vo);
		
		if(bind.hasErrors()) {
			log.info("error exiests");
			return "/board/register";
		}
		
		boolean result = service.register(vo);
		
		log.info("result: " + result);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
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
