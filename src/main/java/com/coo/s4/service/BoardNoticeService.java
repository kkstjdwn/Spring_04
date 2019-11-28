package com.coo.s4.service;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.coo.s4.dao.BoardNoticeDAO;
import com.coo.s4.dao.NoticeFilesDAO;
import com.coo.s4.model.BoardNoticeVO;
import com.coo.s4.model.BoardVO;
import com.coo.s4.model.NoticeFilesVO;
import com.coo.s4.util.FileSaver;
import com.coo.s4.util.Pager;

import oracle.net.aso.e;

@Service
public class BoardNoticeService implements BoardService {
	
	@Inject
	private BoardNoticeDAO noticeDAO;
	
	@Inject
	private FileSaver saver;
	
	@Inject
	private NoticeFilesDAO noticeFilesDAO;
	
//	@Value("${not }")
//	private String board;
	
		
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
		//boardVO= noticeDAO.boardSelect(boardVO);
		//BoardNoticeVO noticeVO = (BoardNoticeVO)boardVO;
		//List<NoticeFilesVO> list = noticeFilesDAO.fileList(boardVO);
		//noticeVO.setFiles(list);
		
		return noticeDAO.boardSelect(boardVO);
	}
	
	@Transactional
	@Override
	public int boardInsert(BoardVO boardVO,HttpSession session, MultipartFile[] file) throws Exception {
		String realPath = session.getServletContext().getRealPath("resources/upload/notice");
		NoticeFilesVO filesVO = new NoticeFilesVO();
		int result = noticeDAO.boardInsert(boardVO);
		filesVO.setNum(boardVO.getNum());
		
		
		for (MultipartFile multipartFile : file) {
			if (multipartFile.getSize() != 0) {				
				filesVO.setFname(saver.save(realPath, multipartFile));
				filesVO.setOname(multipartFile.getOriginalFilename());
				result = noticeFilesDAO.fileInsert(filesVO);
				if (result<1) {
					throw new SQLException();
				}
			}
		}
		
		
		
		return result;
	}
	
	@Transactional
	@Override
	public int boardUpdate(BoardVO boardVO,HttpSession session,MultipartFile[] file) throws Exception {
		// TODO Auto-generated method stub
		String realPath = session.getServletContext().getRealPath("resources/upload/notice");
		NoticeFilesVO filesVO = new NoticeFilesVO();
		filesVO.setNum(boardVO.getNum());
		for (MultipartFile multipartFile : file) {
			if (multipartFile.getSize() != 0) {			
			filesVO.setFname(saver.save(realPath, multipartFile));
			filesVO.setOname(multipartFile.getOriginalFilename());
			noticeFilesDAO.fileInsert(filesVO);
			}
		}
		return noticeDAO.boardUpdate(boardVO);
	}

	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.boardDelete(boardVO);
	}
	
	public int fileDelete(NoticeFilesVO vo) throws Exception{
		return noticeFilesDAO.fileDelete(vo);
	}
	
	
	public NoticeFilesVO fileSelect(NoticeFilesVO filesVO) throws Exception{
		return noticeFilesDAO.fileSelect(filesVO);
	}
	
	public String summerFile(MultipartFile file, HttpSession session) throws Exception{
		 return saver.save2(session.getServletContext().getRealPath("resources/upload/summer"), file);
		 
	}
	
	public boolean summerFileDelete(String file, HttpSession session) throws Exception{
		
		return saver.fileDelete(session.getServletContext().getRealPath("resources/upload/summer"), file);
	}
}
