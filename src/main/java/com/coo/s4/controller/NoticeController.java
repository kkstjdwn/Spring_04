package com.coo.s4.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.coo.s4.model.BoardNoticeVO;
import com.coo.s4.model.BoardVO;
import com.coo.s4.service.BoardNoticeService;
import com.coo.s4.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	private String board = "notice";
	
	@Inject
	public BoardNoticeService service;
	
	@RequestMapping("noticeList")
	public ModelAndView boardList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", service.boardList(pager));
		mv.addObject("pager", pager);
		mv.addObject("board", board);
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
	@RequestMapping(value = "noticeWrite",method = RequestMethod.GET)
	public ModelAndView boardWrite()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", board);
		mv.setViewName("board/boardWrite");
		
		return mv;
	}
	
	@RequestMapping(value = "noticeWrite",method = RequestMethod.POST)
	public ModelAndView boardWrite(BoardNoticeVO noticeVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = service.boardInsert(noticeVO);
		
		String msg = "공지 작성 실패";
		if (result>0) {
			msg = "공지 작성 성공";
		}
		String path = "noticeList";
		
		mv.addObject("msg", msg);
		mv.addObject("path", path);
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@RequestMapping("noticeSelect")
	public ModelAndView boardSelect(BoardNoticeVO noticeVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", service.boardSelect(noticeVO));
		mv.addObject("board", board);
		mv.setViewName("board/boardSelect");
		return mv;
		
	}
	
	@RequestMapping(value = "noticeUpdate",method = RequestMethod.GET)
	public ModelAndView boardUpdate(BoardNoticeVO noticeVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", service.boardSelect(noticeVO));
		mv.addObject("board", board);
		mv.setViewName("board/boardUpdate");
		
		return mv;
	}
	
	@RequestMapping(value = "noticeUpdate",method = RequestMethod.POST)
	public ModelAndView boardUpdateResult(BoardNoticeVO noticeVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = service.boardUpdate(noticeVO);
		String msg = "수정 실패";
		if (result>0) {
			msg = "수정 성공";
		}
		String path = "noticeList";
		mv.addObject("msg", msg);
		mv.addObject("path", path);
		mv.setViewName("common/common_result");
		
		return mv;
		
	}
	
	
	@RequestMapping(value = "noticeDelete")
	public ModelAndView boardDelete(BoardNoticeVO noticeVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = service.boardDelete(service.boardSelect(noticeVO));
		String msg = "삭제 실패";
		if (result>0) {
			msg = "삭제 성공";
		}
		String path = "noticeList";
		mv.addObject("msg", msg);
		mv.addObject("path", path);
		mv.setViewName("common/common_result");
		
		
		return mv;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
