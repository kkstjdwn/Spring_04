package com.coo.s4.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.coo.s4.model.BoardQnaVO;
import com.coo.s4.service.BoardQnaService;
import com.coo.s4.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnAController {
	
	private String board = "qna";
	
	@Inject
	private BoardQnaService service;
	
	private int number=0;
	
	@RequestMapping("qnaList")
	public ModelAndView boardList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", service.boardList(pager));
		mv.addObject("board", board);
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
	@RequestMapping(value = "qnaWrite",method = RequestMethod.GET)
	public ModelAndView boardInsert() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", board);
		mv.setViewName("board/boardWrite");
		
		return mv;
	}
	
	@RequestMapping(value = "qnaWrite",method = RequestMethod.POST)
	public ModelAndView boardInsert(BoardQnaVO qnAVO,HttpSession session,MultipartFile [] file) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = service.boardInsert(qnAVO,session,file);
		String msg = "질문 작성 실패";
		if (result>0) {
			msg = "질문 작성 성공";
		}
		String path = "qnaList";
		mv.addObject("msg", msg);
		mv.addObject("path", path);
		mv.addObject("page", board);
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	
	@RequestMapping("qnaSelect")
	public ModelAndView boardSelect(BoardQnaVO qnaVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("vo", service.boardSelect(qnaVO));
		mv.addObject("board", board);
		mv.setViewName("board/boardSelect");
		
		return mv;
	}
	
	@RequestMapping(value = "qnaUpdate",method = RequestMethod.GET)
	public ModelAndView boardUpdate(BoardQnaVO qnaVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", board);
		mv.addObject("vo", service.boardSelect(qnaVO));
		mv.setViewName("board/boardUpdate");
		
		return mv;
	}
	
	@RequestMapping(value = "qnaUpdate",method = RequestMethod.POST)
	public ModelAndView boardUpdateResult(BoardQnaVO qnaVO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		int result = service.boardUpdate(qnaVO);
		String msg = "수정 실패";
		if (result>0) {
			msg = "수정 성공";
		}
		String path = "qnaList";
		mv.addObject("msg", msg);
		mv.addObject("path", path);
		mv.addObject("board", board);
		mv.setViewName("common/common_result");
		
		return mv;
		
		
	}
	
	
	@RequestMapping("qnaDelete")
	public ModelAndView boardDelete(BoardQnaVO qnaVO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		int result = service.boardDelete(service.boardSelect(qnaVO));
		String msg = "삭제 실패";
		if (result>0) {
			msg = "삭제 성공";
		}
		String path = "qnaList";
		mv.addObject("msg", msg);	
		mv.addObject("path", path);
		mv.setViewName("common/common_result");
		return mv;
	}
	
	@RequestMapping(value = "qnaReply",method = RequestMethod.GET)
	public ModelAndView boardReply(BoardQnaVO qnaVO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", service.boardSelect(qnaVO));
		mv.addObject("board", board);
		mv.setViewName("board/boardReply");
		
		return mv;
	}
	
	@RequestMapping(value = "qnaReply",method = RequestMethod.POST)
	public ModelAndView boardReplyResult(BoardQnaVO qnaVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = service.boardReply(qnaVO);
		String msg = "작성 실패";
		if (result>0) {
			msg = "작성 성공";
		}
		String path = "qnaList";
		mv.addObject("msg", msg);
		mv.addObject("path", path);
		mv.setViewName("common/common_result");
		
		return mv;
		
	}
	
	@GetMapping("qnaAddFile")
	public ModelAndView noticeAddFile( )throws Exception{
		ModelAndView mv = new ModelAndView();
		number++;
		mv.addObject("num", number);
		mv.setViewName("common/files");
			
		
		return mv;
	}
	
	@GetMapping("qnaReset")
	public void noticeReset( )throws Exception{
		number = 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
