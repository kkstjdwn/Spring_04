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
	public void memberLogin() {
		
	}
	
	@PostMapping("memberLogin")
	public ModelAndView memberLogin(MemberVO memberVO,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		String result = memberVO.getId();
		memberVO = service.memberLogin(memberVO);
		
		if (memberVO == null) {
			mv.addObject("msg", "로그인 실패");
			mv.addObject("path", "memberLogin");
			mv.addObject("result", result);
			mv.setViewName("common/common_result");
		}else {
			session.setAttribute("member", memberVO);
			mv.setViewName("index");
		}
		
		return mv;
	}
	
	
	@GetMapping("memberIdCheck")
	public ModelAndView memberIdCheck(MemberVO memberVO) throws Exception{
	
		ModelAndView mv = new ModelAndView();
		String result = memberVO.getId();
		memberVO = service.memberIdCheck(memberVO);
		String msg = " 사용중인 ID가 있습니다.";
		if (memberVO == null) {
			msg = " 사용 가능한 ID입니다";
		}
		mv.addObject("result", result);
		mv.addObject("vo", memberVO);
		mv.addObject("msg", msg);
		
		return mv;
	}
	
	
	@GetMapping("memberJoin")
	public void memberJoin() throws Exception{
		
	}
	
	@PostMapping("memberJoin")
	public ModelAndView memberJoin(MemberVO memberVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = service.memberInsert(memberVO);
		String msg = "회원 가입 실패";
		if (result > 0) {
			msg = "회원가입 성공";
		}
		String path = "/index";
		mv.addObject("msg", msg);
		mv.addObject("path", path);
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@GetMapping("memberMypage")
	public void memberMypage(){
		
	}
	
	@GetMapping("memberUpdate")
	public void memberUpdate(){
		
	}
	
	@PostMapping("memberUpdate")
	public ModelAndView membetUpdate(MemberVO memberVO,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = service.memberUpdate(memberVO);
		String msg = "수정 실패";
		if (result>0) {
			msg = "수정 성공";
			session.setAttribute("member", memberVO);
		}
		mv.addObject("msg", msg);
		mv.addObject("path", "memberMypage");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@GetMapping("memberDelete")
	public ModelAndView memberDelete(MemberVO memberVO,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = service.memberDelete(memberVO);
		String msg = "삭제 실패";
		if (result>0) {
			msg = "삭제 성공";
		}
		mv.addObject("msg", msg);
		mv.addObject("path", "/index");
		session.invalidate();
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@GetMapping("memberLogout")
	public ModelAndView memberLogout(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		session.invalidate();
		mv.setViewName("index");
		
		
		return mv;
	}
	
	
}
