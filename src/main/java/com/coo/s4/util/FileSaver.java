package com.coo.s4.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;


public class FileSaver {

	// 1.Spring 에서 제공하는 FileCopyUtils 클래스의 copy메서드 사용
	public String save(String realPath, MultipartFile multipartFile) throws Exception {
		File file = new File(realPath);

		if (!file.exists()) {
			file.mkdirs();
		}
		
		Calendar ca =  Calendar.getInstance();
		Long name = ca.getTimeInMillis();
		
		int index = multipartFile.getOriginalFilename().lastIndexOf('.');
		String fileName = name + multipartFile.getOriginalFilename().substring(index);
		
		file = new File(realPath, fileName);
		FileCopyUtils.copy(multipartFile.getBytes(), file);
		
		return fileName;
	}
	
	
	//2.mutipartFile transferTo 메서드 사용
	public String save2(String realPath, MultipartFile multipartFile) throws Exception{

		File file = new File(realPath);
		if (!file.exists()) {
			file.mkdirs();
		}

		String fileName = UUID.randomUUID().toString()+multipartFile.getOriginalFilename();

		file = new File(realPath, fileName);
		multipartFile.transferTo(file);
		
		return fileName;
	}

	
	//3.Io Stream 사용
	public String save3(String realPath, MultipartFile multipartFile) throws Exception{
		File file = new File(realPath);
		if (!file.exists()) {
			file.mkdirs();
		}
		
		//저장할 파일명
		String fileName = UUID.randomUUID().toString(); //UniversialUniqueID
		fileName = fileName+"_"+multipartFile.getOriginalFilename();
		
		file = new File(realPath, fileName);
		
		FileOutputStream os = new FileOutputStream(file);
		os.write(multipartFile.getBytes());
		os.close();
		
		return fileName;
	}
}

