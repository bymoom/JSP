package com.jsp.action.pds;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.jsp.action.Action;
import com.jsp.dto.AttachVO;
import com.jsp.dto.PdsVO;
import com.jsp.service.PdsService;
import com.jsp.utils.GetUploadPath;
import com.jsp.utils.MakeFileName;

public class RegistPdsAction implements Action {

	private PdsService pdsService;
	public void setPdsService(PdsService pdsService) {
		this.pdsService = pdsService;
	}
	
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "pds/regist_success";
		
		try {
			PdsVO pds = fileUpload(request);
			
			pdsService.regist(pds);
			
		} catch (Exception e) {
			e.printStackTrace();
			url = "pds/regist_fail";
		}
		return url;
	}
	
	//업로드 파일 환경 설정
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; //3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; //40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; //50MB

	private PdsVO fileUpload(HttpServletRequest request) throws Exception {
		
		PdsVO pds = new PdsVO();
		List<AttachVO> attachList = new ArrayList<>();
		
		//업로드를 위한 upload 환경 설정(하드디스크에 저장할 준비해주는 DiskFileItemFactory = sqlFactory와 같은 용도 -> connection할 준비해주는...)
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		
		//임시 저장 위치 설정
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		
		//실제 저장할 수 있도록 도와주는 용도(session과 같음)
		ServletFileUpload upload = new ServletFileUpload(factory);
		//업로드 파일 크기 적용
		upload.setFileSizeMax(MAX_FILE_SIZE);
		//업로드 request 크기 적용
		upload.setSizeMax(MAX_REQUEST_SIZE);
		
		//파일을 실제로 저장할 경로 설정
		String uploadPath = GetUploadPath.getUploadPath("pds.upload");
		
		File file = new File(uploadPath);
		if(!file.mkdirs()) {
			System.out.println(uploadPath + "가 이미 존재하거나 실패하였습니다.");
		}
		
		
		//request로부터 받은 파일을 추출
		//어떤 파일인지 알려줄 용도
		try {
			List<FileItem> formItems = upload.parseRequest(request);

			String title = null;
			String content = null;
			String writer = null;
			int pno = -1; //pno값이 잘못 들어오는 것을 방지하기 위해 -1로 처리
			
			if(formItems != null && formItems.size() > 0) {
				for(FileItem item : formItems) {
					if(!item.isFormField()) { //formItem이 파일인 경우 local과 attach 테이블에 저장

						//필드네임이 uploadFile이 아닌 경우 거르기(summernote의 files를 제외함)
						if(!item.getFieldName().equals("uploadFile")) continue;
						
						System.out.println("item.getFieldName() : " + item.getFieldName());
						System.out.println("item : " + item);
						
						String fileName = new File(item.getName()).getName();
						fileName = MakeFileName.toUUIDFileName(fileName, "$$");
						
						String filePath = uploadPath + File.separator + fileName;
						File storeFile = new File(filePath);

						//local HDD에 저장
						try {
							item.write(storeFile);
						} catch (Exception e) {
							e.printStackTrace();
							throw e;
						}
						
						AttachVO attach = new AttachVO();
						attach.setFileName(fileName);
						attach.setUploadPath(uploadPath);
						attach.setFileType(fileName.substring(fileName.lastIndexOf(".") + 1));
						
						attachList.add(attach);
						
					}else { //파일이 아닌 경우
						
						switch(item.getFieldName()) {
						case "writer" :
							writer = item.getString("utf-8");
							break;
						
						case "title" :
							title = item.getString("utf-8");
							break;
						
						case "content" :
							content = item.getString("utf-8");
							break;
						}
					}
				}
			}

			pds.setAttachList(attachList);
			pds.setWriter(writer);
			pds.setTitle(title);
			pds.setContent(content);
		
		} catch (FileUploadException e) {
			e.printStackTrace();
			throw e;
		}
		return pds;
	}
}
