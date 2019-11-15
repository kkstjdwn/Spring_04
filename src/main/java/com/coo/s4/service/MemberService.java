package com.coo.s4.service;

import com.coo.s4.model.MemberVO;

public interface MemberService {
	
	//join
		public int memberInsert(MemberVO memberVO)throws Exception;
		
		//login
		public MemberVO memberLogin(MemberVO memberVO) throws Exception;
		
		//update
		public int memberUpdate(MemberVO memberVO) throws Exception;
		
		//delete
		public int memberDelete(MemberVO memberVO) throws Exception;
		
		//중복확인 IdCheck
		public MemberVO memberIdCheck(MemberVO memberVO) throws Exception;
		
		//pointUPdate
		public int memberPointUpdate(MemberVO memberVO) throws Exception;


}
