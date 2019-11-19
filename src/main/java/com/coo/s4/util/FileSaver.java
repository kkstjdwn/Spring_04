package com.coo.s4.util;

import java.io.File;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileSaver {
	
	public String save(String realPath, MultipartFile multipartFile) throws Exception{
		File file = new File(realPath);
		if (!file.exists()) {
			file.mkdirs();
		}
		String fileName = UUID.randomUUID().toString()+multipartFile.getOriginalFilename();
		file = new File(realPath, fileName);
		multipartFile.transferTo(file);
		
		return fileName;
	}

}
