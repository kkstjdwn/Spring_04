package com.coo.s4.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


import com.coo.s4.model.BoardVO;
import com.coo.s4.model.QnaFilesVO;

@Repository
public class QnaFilesDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "qnaFilesMapper.";
	
	public int fileInsert(QnaFilesVO filesVO) throws Exception{
		return sqlSession.insert(NAMESPACE+"fileInsert",filesVO);
	}
	
	public List<QnaFilesVO> fileList(BoardVO vo) throws Exception{
		return sqlSession.selectList(NAMESPACE+"fileList",vo);
		
	}
	
	public int fileDelete(QnaFilesVO filesVO) throws Exception{
		return sqlSession.delete(NAMESPACE+"fileDelete",filesVO);
	}
	
	public QnaFilesVO fileSelect(QnaFilesVO filesVO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"fileSelect",filesVO);
	}

}
