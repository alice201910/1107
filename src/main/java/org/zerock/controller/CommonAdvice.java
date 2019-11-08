package org.zerock.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.log4j.Log4j;

@ControllerAdvice
@Log4j
public class CommonAdvice {

	@ExceptionHandler(Exception.class)
	public String except(Exception e, Model model) {

		log.warn(e.getMessage());
		model.addAttribute("exception", e);

		return "error_page";
	}
}
