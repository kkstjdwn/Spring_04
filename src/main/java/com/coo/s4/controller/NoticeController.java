package com.coo.s4.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.coo.s4.model.BoardVO;
import com.coo.s4.model.NoticeFilesVO;
import com.coo.s4.service.BoardNoticeService;
import com.coo.s4.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	//@Value("${not}")
	@Value("#{db['not']}")
	private String board;
	
	private int number = 0;
	
	@Inject
	public BoardNoticeService service;
	
	@ModelAttribute("board")
	public String getBoard() {
		return board;
	}
	
	
	@RequestMapping("noticeList")
	public ModelAndView boardList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", service.boardList(pager));
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
	@RequestMapping(value = "noticeWrite",method = RequestMethod.GET)
	public ModelAndView boardWrite()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardWrite");
		
		return mv;
	}
	
	@RequestMapping(value = "noticeWrite",method = RequestMethod.POST)
	public ModelAndView boardWrite(BoardVO noticeVO, HttpSession session,MultipartFile [] file) throws Exception{
		ModelAndView mv = new ModelAndView();
		session.getServletContext().getRealPath("resources/upload/notice");
				
			for (int i = 0; i < file.length; i++) {
				System.out.println(file[i].getOriginalFilename());
			}
		
		int result = service.boardInsert(noticeVO,session,file);
		
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
	public ModelAndView boardSelect(@ModelAttribute BoardVO noticeVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		//mv.addObject("vo", service.boardSelect(noticeVO));
		mv.setViewName("board/boardSelect");
		return mv;
		
	}
	
	
	
	@RequestMapping(value = "noticeUpdate",method = RequestMethod.GET)
	public ModelAndView boardUpdate(BoardVO noticeVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", service.boardSelect(noticeVO));
		mv.setViewName("board/boardUpdate");
		
		return mv;
	}
	
	@RequestMapping(value = "noticeUpdate",method = RequestMethod.POST)
	public ModelAndView boardUpdateResult(BoardVO noticeVO, HttpSession session, MultipartFile[] file)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = service.boardUpdate(noticeVO,session,file);
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
	public ModelAndView boardDelete(BoardVO noticeVO) throws Exception{
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
	
	
	@GetMapping("noticeAddFile")
	public ModelAndView noticeAddFile( )throws Exception{
		ModelAndView mv = new ModelAndView();
		number++;
		mv.addObject("num", number);
		mv.setViewName("common/files");
			
		
		return mv;
	}

	@PostMapping("noticeFileDelete")
	public ModelAndView noticeFileDelete(NoticeFilesVO vo) throws Exception{
		int result = service.fileDelete(vo);
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", result);
		mv.setViewName("common/common_ajax_result");
		return mv;
	}
	
	@GetMapping("fileDown")
	public ModelAndView fileDown(NoticeFilesVO filesVO) throws Exception{
		filesVO = service.fileSelect(filesVO);
		ModelAndView mv = new ModelAndView();
		mv.addObject("file", filesVO);
		mv.setViewName("fileDown");
		
		return mv;
	}
	
	@PostMapping("summerFile")
	public ModelAndView summerFile(MultipartFile file, HttpSession session) throws Exception{
		String fName = service.summerFile(file, session);
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", fName);
		mv.setViewName("common/common_ajax_result");
		return mv;
	}
	
	@PostMapping("summerFileDelete")
	public ModelAndView summerFileDelete(String file, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		String result = "실패!";
		boolean check = service.summerFileDelete(file, session);
		if (check) {
			result = "삭제";
		}
		mv.addObject("result", result);
		mv.setViewName("common/common_ajax_result");
		
		return mv;
	}
}
