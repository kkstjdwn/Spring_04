package com.coo.s4.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.coo.s4.model.MemberVO;

@Repository
public class MemberDAOimpl implements MemberDAO {
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "memberMapper.";

	@Override
	public MemberVO memberIdCheck(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"memberIdCheck",memberVO);
	}

	@Override
	public int memberJoin(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE+"memberJoin",memberVO);
	}

	@Override
	public MemberVO memberLogin(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"memberLogin",memberVO);
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

}
