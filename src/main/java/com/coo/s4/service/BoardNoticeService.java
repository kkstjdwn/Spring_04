package com.coo.s4.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.coo.s4.dao.BoardNoticeDAO;
import com.coo.s4.dao.NoticeFilesDAO;
import com.coo.s4.model.BoardVO;
import com.coo.s4.model.NoticeFilesVO;
import com.coo.s4.util.FileSaver;
import com.coo.s4.util.Pager;

@Service
public class BoardNoticeService implements BoardService {
	
	@Inject
	private BoardNoticeDAO noticeDAO;
	
	@Inject
	private FileSaver saver;
	
	@Inject
	private NoticeFilesDAO noticeFilesDAO;
	
		
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
		return noticeDAO.boardSelect(boardVO);
	}

	@Override
	public int boardInsert(BoardVO boardVO,HttpSession session, MultipartFile[] file) throws Exception {
		String realPath = session.getServletContext().getRealPath("resources/upload/notice");
		System.out.println(realPath);
		
		int num = noticeDAO.getNum();
		
		NoticeFilesVO filesVO = new NoticeFilesVO();
		filesVO.setNum(num);
		boardVO.setNum(num);
		
		int result = noticeDAO.boardInsert(boardVO);
		
		System.out.println(boardVO.getNum());
		
//		for (MultipartFile multipartFile : file) {
//			
//			filesVO.setFname(saver.save(realPath, multipartFile));
//			filesVO.setOname(multipartFile.getOriginalFilename());			
//		}
		
		
		
		return result;
	}

	@Override
	public int boardUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.boardUpdate(boardVO);
	}

	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.boardDelete(boardVO);
	}

}
