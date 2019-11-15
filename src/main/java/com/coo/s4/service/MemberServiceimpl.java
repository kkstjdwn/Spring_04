package com.coo.s4.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.coo.s4.dao.MemberDAOimpl;
import com.coo.s4.model.MemberVO;

@Service
public class MemberServiceimpl implements MemberService {

	@Inject
	private MemberDAOimpl dao;
	
	@Override
	public int memberInsert(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return dao.memberInsert(memberVO);
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
