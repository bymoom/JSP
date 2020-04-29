package com.jsp.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.utils.GetUploadPath;

/**
 * 상세 정보에서 사진 띄우기 (사용자가 어떤 처리를 요청하는건 아니기 때문에 doGet) 
 *
 */
//@WebServlet("/member/picture/get")
public class GetPictureServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("picture");
		String savedPath = GetUploadPath.getUploadPath("member.picture.upload");
		
		String filePath = savedPath + fileName;
		
		sendFile(response, filePath);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	//사용자에게 사진 경로 보내야하기때문에 response 필요
	private void sendFile(HttpServletResponse response, String filePath) throws ServletException, IOException {

		//보낼 파일 설정 (파일읽기)
		File downloadFile = new File(filePath);
		FileInputStream inStream = new FileInputStream(downloadFile);
		
		//ContextPath에 파일 이름 보내기 용도
		ServletContext context = getServletContext();
		
		//파일 포맷으로 MIME를 결정한다.
		//브라우저에게 "파일이야!!!"라고 알려주기
		String mimeType = context.getMimeType(filePath);
		if(mimeType == null) {
			mimeType = "application/octet-stream";
		}
		System.out.println("MIME Type : " + mimeType);
		
		//response 수정
		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length()); //브라우저 헤더에 들어갈 파일명의 길이 알려주기
		
		//일반적인 HTTP 응답에서 Content-Disposition 헤더는 컨텐츠가 브라우저에 inline 되어야 하는 웹페이지 자체이거나 웹페이지의 일부인지,
		//아니면 attachment로써 다운로드 되거나 로컬에 저장될 용도록 쓰이는 것인지를 알려주는 헤더입니다.
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName()); //'%s'에 downloadFile.getName() 입력
		response.setHeader(headerKey, headerValue);
		
		//파일 내보내기
		OutputStream outStream = response.getOutputStream();
		byte[] buffer = new byte[4096];
		int bytesRead = -1;
		
		while ((bytesRead = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}
		
		if(inStream != null) inStream.close();
		if(outStream != null) outStream.close();
	}

}
