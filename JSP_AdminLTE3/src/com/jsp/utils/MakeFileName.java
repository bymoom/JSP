package com.jsp.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.jsp.dto.AttachVO;

public class MakeFileName {
	
	public static String toUUIDFileName(String fileName, String delimiter) {
		//UUID : MathRandom과 같은 기능(시리얼 코드 체계)
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid + delimiter + fileName;
	}

	public static List<AttachVO> parseFileNameFromAttaches(List<AttachVO> attachList, String delimiter){
		List<AttachVO> renamedAttachList = new ArrayList<AttachVO>();
		
		for(AttachVO attach : attachList) {
			String fileName = attach.getFileName(); //DB상의 fileName
			fileName = parseFileNameFromUUID(fileName, delimiter); //uuid가 제거된 fileName
			
			attach.setFileName(fileName);
			
			renamedAttachList.add(attach);
		}
		return renamedAttachList;
	}
	
	public static String parseFileNameFromUUID(String fileName, String delimiter) {
		String[] uuidFileName = fileName.split(delimiter);
		return uuidFileName[uuidFileName.length - 1];
	}
}
