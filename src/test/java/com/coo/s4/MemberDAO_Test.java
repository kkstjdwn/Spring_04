package com.coo.s4;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.coo.s4.dao.MemberDAOimpl;
import com.coo.s4.model.MemberVO;

public class MemberDAO_Test extends TestAbstractCase{
	
	@Inject
	private MemberDAOimpl daOimpl;
	@Test
	public void test() throws Exception{
		MemberVO vo = new MemberVO();
		vo.setBirth("1992-08-19");
		vo.setEmail("coo@coo.go");
		vo.setGender("M");
		vo.setId("coo");
		vo.setName("choo");
		vo.setPw("coo");
		
		System.out.println(daOimpl.memberIdCheck(vo));
		
		
	}

}
