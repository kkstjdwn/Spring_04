package com.coo.s4;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.coo.s4.dao.MemberDAOimpl;
import com.coo.s4.model.MemberVO;

public class MemberDAO_test extends TestAbstractCase{

	@Inject
	private MemberDAOimpl dao;
	@Test
	public void test() throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setId("p");	
		assertEquals(1, dao.memberDelete(memberVO));
	}

}
