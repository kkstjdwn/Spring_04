package com.coo.s4.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.coo.s4.model.NoticeFilesVO;

@Component
public class FileDown extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		NoticeFilesVO filesVO = (NoticeFilesVO)model.get("file");
		String board = (String)model.get("board");
		String realPath = request.getSession().getServletContext().getRealPath("resources/upload/"+board);
		File file = new File(realPath, filesVO.getFname());
		
		//한글처리
		response.setCharacterEncoding("UTF-8");

		//파일의크기
		response.setContentLength((int)file.length());
		
		//다운로드시 파일 이름 인코딩
		String fileName = URLEncoder.encode(filesVO.getOname(),"UTF-8");
		
		//header 설정
		response.setHeader("Content-disposition", "attachment;filename\""+fileName+"\"");
		response.setHeader("Content-transper-Encoding", "binary");
		
		//outputStream
		FileInputStream fis = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		FileCopyUtils.copy(fis, os);
		os.close();
		fis.close();
	}

}
