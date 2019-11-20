package com.coo.s4.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.coo.s4.model.NoticeFilesVO;

@Repository
public class NoticeFilesDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "noticeFilesMapper.";
	
	public int fileInsert(NoticeFilesVO vo) throws Exception{
		return sqlSession.insert(NAMESPACE+"fileInsert", vo);
	}
	
	
	
}