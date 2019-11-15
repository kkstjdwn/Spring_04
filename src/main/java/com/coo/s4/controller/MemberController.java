package com.coo.s4.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.coo.s4.model.MemberVO;
import com.coo.s4.service.MemberServiceimpl;

@Controller
@RequestMapping("member/**")
public class MemberController {
	@Inject
	private MemberServiceimpl service;
	
	@GetMapping("memberLogin")
	public void memberLogin()throws Exception{
		
	}
	
	@PostMapping("memberLogin")
	public ModelAndView memberLogin(MemberVO memberVO,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		memberVO = service.memberLogin(memberVO);
		if (memberVO == null ) {
			String msg = "로그인 실패";
			String path = "memberLogin";
			mv.addObject("msg", msg);
			mv.addObject("path", path);
			mv.setViewName("common/common_result");
		}else {
			session.setAttribute("member", memberVO);
			mv.setViewName("/index");
		}
		return mv;
	}
	
	
	
	
	@GetMapping("memberJoin")
	public void memberJoin() throws Exception{
		
	}
	
	@PostMapping("memberJoin")
	public ModelAndView memberJoin(MemberVO memberVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = service.memberJoin(memberVO);
		String msg = "회원가입 실패";
		if (result>0) {
			msg = "회원가입 성공";
		}
		String path = "index";
		mv.addObject("msg", msg);
		mv.addObject("path", path);
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@GetMapping("memberIdCheck")
	public ModelAndView memberIdCheck(MemberVO memberVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberVO checkVO = service.memberIdCheck(memberVO);
		int result = 0;	
		String msg = "중복된 ID가 있습니다!";
		if (checkVO == null && memberVO.getId()!="") {
			msg = "사용 가능 한 ID 입니다.";
			result = 1;
			
			
		}else if (memberVO.getId()=="") {
			msg="ID를 입력하세요";
			result = 0;
		}
		mv.addObject("result",result);
		mv.addObject("vo", memberVO);
		mv.addObject("msg", msg);
		
		return mv;
	}
	
	@GetMapping("memberLogout")
	public ModelAndView memberLogout(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		session.invalidate();
		mv.setViewName("/index");
		
		return mv;
		
	}
	

}
