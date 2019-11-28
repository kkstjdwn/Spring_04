package com.coo.s4.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.coo.s4.model.BoardVO;
import com.coo.s4.service.BoardNoticeService;
import com.coo.s4.util.Pager;

@RestController //@Controller
public class JsonController {
	
	@Inject
	private BoardNoticeService service;

	@GetMapping("/getJson1")
	public ModelAndView getJson1() throws Exception{
		// name = iu , age = 27
		String jmsg = "{ \"name\" : \"iu\", \"age\" : 27 }";
		System.out.println(jmsg);
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", jmsg);
		mv.setViewName("common/common_ajax_result");
		
		return mv;
	}
	
	@GetMapping("/getJson2")
	@ResponseBody //지금 보내는 Data는 view가 아니니 리스폰에 담아서 바로 보내줄거다
	public BoardVO getJson2(BoardVO boardVO) throws Exception{
		
		boardVO = service.boardSelect(boardVO);
		
		return boardVO;
	}
	
	@GetMapping("/getJson3")
	@ResponseBody
	public List<BoardVO> getJson3(Pager pager) throws Exception{
		
		List<BoardVO> list = service.boardList(pager);
		
		return list;
		
	}
}
