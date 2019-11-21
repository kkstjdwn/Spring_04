package com.coo.s4.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.coo.s4.model.BoardVO;
import com.coo.s4.model.NoticeFilesVO;

@Repository
public class NoticeFilesDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "noticeFilesMapper.";
	
	public int fileInsert(NoticeFilesVO vo) throws Exception{
		return sqlSession.insert(NAMESPACE+"fileInsert", vo);
	}
	
	public List<NoticeFilesVO> fileList(BoardVO vo) throws Exception{
		return sqlSession.selectList(NAMESPACE+"fileList",vo);
	}
	
	public int fileDelete(NoticeFilesVO vo) throws Exception{
		return sqlSession.delete(NAMESPACE+"fileDelete",vo);
	}
	
	
	public NoticeFilesVO fileSelect(NoticeFilesVO vo) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"fileSelect",vo);
	}
	
}
