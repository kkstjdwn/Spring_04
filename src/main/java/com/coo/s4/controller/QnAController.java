package com.coo.s4.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.coo.s4.service.BoardQnaService;
import com.coo.s4.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnAController {
	@Inject
	private BoardQnaService service;
	
	@RequestMapping("qnaList")
	private ModelAndView boardList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", service.boardList(pager));
		mv.setViewName("board/boardList");
		
		return mv;
	}
}
