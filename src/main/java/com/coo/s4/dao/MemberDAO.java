package com.coo.s4.dao;

import com.coo.s4.model.MemberVO;

public interface MemberDAO {
	
	//Join
	public int memberJoin(MemberVO memberVO) throws Exception;
	
	//login
	public MemberVO memberLogin(MemberVO memberVO) throws Exception;
	
	//update
	public int MemberUpdate(MemberVO memberVO) throws Exception;
	
	//delete
	public int MemberDelete(MemberVO memberVO) throws Exception;
	
	//point update 이미 default 값으로 0이 들어갔으니 update
	public int MemberPointUpdate(MemberVO memberVO) throws Exception;
	
	//id check
	public MemberVO memberIdCheck(MemberVO memberVO) throws Exception;

}
