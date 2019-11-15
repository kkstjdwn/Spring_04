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
	public int memberJoin(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return dao.memberJoin(memberVO);
	}

	@Override
	public MemberVO memberLogin(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return dao.memberLogin(memberVO);
	}

	@Override
	public int MemberUpdate(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int MemberDelete(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int MemberPointUpdate(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVO memberIdCheck(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return dao.memberIdCheck(memberVO);
	}
	
	

}
