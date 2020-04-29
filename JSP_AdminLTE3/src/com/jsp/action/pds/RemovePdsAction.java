package com.jsp.action.pds;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.AttachVO;
import com.jsp.request.PageMaker;
import com.jsp.service.PdsService;
import com.jsp.utils.CreatePageMaker;

public class RemovePdsAction implements Action {

	private PdsService pdsService;
	public void setPdsService(PdsService pdsService) {
		this.pdsService = pdsService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "pds/remove_success";
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		
		
		
		try {
			List<AttachVO> attachList = pdsService.getPds(pno).getAttachList();
			String uploadPath = null;
			
			if(attachList != null) {
				for(AttachVO attach : attachList) {
					uploadPath = attach.getUploadPath() + File.separator + attach.getFileName();
					File file = new File(uploadPath);
					if(file.exists()){
						if(file.delete()) {
							pdsService.deleteAttach(attach.getAno());
							System.out.println("[RemovePdsAction] 파일을 삭제했습니다!!!");
						}else {
							System.out.println("[RemovePdsAction] 파일 삭제에 실패했습니다!!!");
						}
					}else {
						System.out.println("[RemovePdsAction] 파일이 없습니다!!!");
					}
				}
			}
			pdsService.remove(pno);

			PageMaker pageMaker = CreatePageMaker.make(request);
			request.setAttribute("pageMaker", pageMaker);
			
		} catch (Exception e) {
			e.printStackTrace();
			url = "pds/remove_fail";
		}
		
		return url;
	}

}
