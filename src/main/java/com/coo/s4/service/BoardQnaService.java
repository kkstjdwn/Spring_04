package com.coo.s4.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.coo.s4.dao.BoardQnaDAO;
import com.coo.s4.dao.QnaFilesDAO;
import com.coo.s4.model.BoardQnaVO;
import com.coo.s4.model.BoardVO;
import com.coo.s4.model.QnaFilesVO;
import com.coo.s4.util.FileSaver;
import com.coo.s4.util.Pager;

@Service
public class BoardQnaService implements BoardService {
	
	@Inject
	private BoardQnaDAO qnaDAO;
	@Inject
	private QnaFilesDAO fileDAO;
	@Inject
	private FileSaver saver;

	
	@Override
	public List<BoardVO> boardList(Pager pager) throws Exception {
		pager.rowMake();
		pager.makePager(qnaDAO.boardCount(pager));
		return qnaDAO.boardList(pager);
	}

	@Override
	public BoardVO boardSelect(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
//		boardVO = qnaDAO.boardSelect(boardVO);
//		BoardQnaVO qnaVO = (BoardQnaVO)boardVO;
//		qnaVO.setFiles(fileDAO.fileList(boardVO));
		return qnaDAO.boardSelect(boardVO);
	}

	@Override
	public int boardInsert(BoardVO boardVO,HttpSession session,MultipartFile[] file) throws Exception {
		QnaFilesVO filesVO = new QnaFilesVO();
		int result =  qnaDAO.boardInsert(boardVO);
		filesVO.setNum(boardVO.getNum());
		for (MultipartFile multipartFile : file) {
			if (multipartFile.getSize() != 0) {
				
			filesVO.setFname(saver.save(session.getServletContext().getRealPath("resources/upload/qna"), multipartFile));
			filesVO.setOname(multipartFile.getOriginalFilename());
			result = fileDAO.fileInsert(filesVO);
			}
		}
		
		return result;
	}

	@Override
	public int boardUpdate(BoardVO boardVO,HttpSession session,MultipartFile[] file) throws Exception {
		// TODO Auto-generated method stub
		String realPath = session.getServletContext().getRealPath("resources/upload/qna");
		QnaFilesVO filesVO = new QnaFilesVO();
		filesVO.setNum(boardVO.getNum());
		for (MultipartFile multipartFile : file) {
			if (multipartFile.getSize() != 0) {
				filesVO.setFname(saver.save(realPath, multipartFile));
				filesVO.setOname(multipartFile.getOriginalFilename());
				fileDAO.fileInsert(filesVO);
			}
		}
		return qnaDAO.boardUpdate(boardVO);
	}

	@Override
	public int boardDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.boardDelete(boardVO);
	}
	
	public int boardReply(BoardQnaVO qnaVO) throws Exception{
		
		
		qnaDAO.boardReplyUpdate((BoardQnaVO)qnaDAO.boardSelect(qnaVO));
		qnaVO.setStep(qnaVO.getStep()+1);
		qnaVO.setDepth(qnaVO.getDepth()+1);

//		첫번째 방법
//		BoardQnaVO child = new BoardQnaVO();
//		child.setTitle(qnaVO.getTitle());
//		child.setContents(qnaVO.getContents());
//		child.setWriter(qnaVO.getWriter());
//		child.setRef(qnaVO.getRef());
//		child.setStep(qnaVO.getStep()+1);
//		child.setDepth(qnaVO.getDepth()+1);
//		
		return qnaDAO.boardReply(qnaVO); 
	}
	
	public int fileDelete(QnaFilesVO filesVO) throws Exception{
		return fileDAO.fileDelete(filesVO);
	}
	
	public QnaFilesVO fileSelect(QnaFilesVO filesVO) throws Exception{
		return fileDAO.fileSelect(filesVO);
	}
}
