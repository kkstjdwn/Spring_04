package com.coo.s4.dao;

import java.util.List;

import com.coo.s4.model.BoardVO;
import com.coo.s4.util.Pager;

public interface BoardDAO {
	
	//List
	public List<BoardVO> boardList(Pager pager) throws Exception;
	//SelectOne
	public BoardVO boardSelect(BoardVO boardVO) throws Exception;
	//insert
	public int boardInsert(BoardVO boardVO) throws Exception;
	//update
	public int boardUpdate(BoardVO boardVO) throws Exception;
	//delete
	public int boardDelete(BoardVO boardVO) throws Exception;
	//count
	public int boardCount(Pager pager) throws Exception;

}
