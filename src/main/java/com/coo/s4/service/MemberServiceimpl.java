package com.coo.s4.service;

import java.io.File;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.coo.s4.dao.MemberDAOimpl;
import com.coo.s4.model.MemberVO;
import com.coo.s4.util.FileSaver;

@Service
public class MemberServiceimpl implements MemberService {

	@Inject
	private MemberDAOimpl dao;
	
	@Override
	public int memberInsert(MemberVO memberVO, HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		//server HDD에 파일 저장
		//1.파일을 저장할 실제 경로
		String realPath = session.getServletContext().getRealPath("resources/upload/member");
		
		FileSaver fs = new FileSaver();
	 	memberVO.setFileName(fs.save(realPath, memberVO.getFile()));
		
		return 0;//dao.memberInsert(memberVO);
	}

	@Override
	public MemberVO memberLogin(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return dao.memberLogin(memberVO);
	}

	@Override
	public int memberUpdate(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return dao.memberUpdate(memberVO);
	}

	@Override
	public int memberDelete(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return memberDelete(memberVO);
	}

	@Override
	public MemberVO memberIdCheck(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return dao.memberIdCheck(memberVO);
	}

	@Override
	public int memberPointUpdate(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
