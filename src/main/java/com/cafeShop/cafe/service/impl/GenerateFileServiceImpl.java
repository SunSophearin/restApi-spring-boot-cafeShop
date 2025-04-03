package com.cafeShop.cafe.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.cafeShop.cafe.service.GenerateFileService;
@Service
public class GenerateFileServiceImpl implements GenerateFileService {

	@Override
	public String genarateFileToString(String originalFile) {
		
		int lastIndexOf = originalFile.lastIndexOf(".");
		LocalDateTime now= LocalDateTime.now();
		String format = now.format( DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		if(lastIndexOf==-1) {
			return format;
		}
		String fileExtension = originalFile.substring(lastIndexOf);
		return format+fileExtension;
	}

}
