package com.coo.s4.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.coo.s4.model.BoardVO;
import com.coo.s4.service.BoardNoticeService;
import com.coo.s4.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Inject
	public BoardNoticeService service;
	
	@RequestMapping("noticeList")
	public ModelAndView boardList(Pager pager)throws Exception{
		List<BoardVO> ar = service.boardList(pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.setViewName("board/boardList");
		
		return mv;
	}
}
