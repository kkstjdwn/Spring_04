package com.coo.s4.service;

import java.util.List;

import javax.inject.Inject;


import org.springframework.stereotype.Service;

import com.coo.s4.dao.BoardNoticeDAO;
import com.coo.s4.model.BoardVO;
import com.coo.s4.util.Pager;

@Service
public class BoardNoticeService implements BoardService {
	
	@Inject
	private BoardNoticeDAO noticeDAO;
		
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		pager.rowMake();
		pager.makePager(noticeDAO.boardCount(pager));
		return noticeDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int boardInsert(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
