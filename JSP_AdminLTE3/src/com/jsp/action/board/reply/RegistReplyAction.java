package com.jsp.action.board.reply;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsp.action.Action;
import com.jsp.request.PageMaker;
import com.jsp.request.RegistReplyRequest;
import com.jsp.request.SearchCriteria;
import com.jsp.service.ReplyService;

public class RegistReplyAction implements Action {

	private ReplyService replyService;
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = null;
		
		//jackson 패키지에 있는 클래스
		ObjectMapper mapper = new ObjectMapper();

		//ObjectMapper로 브라우저에서 보낸 값을 받아 RegistReplyRequest로 보내기
		RegistReplyRequest replyReq = mapper.readValue(request.getReader(), RegistReplyRequest.class);
		
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		try {
			replyService.registReply(replyReq.toReplyVO());
			
			//댓글 출력 순서를 바꾸기 위해 댓글 리스트 꺼내기
			SearchCriteria cri = new SearchCriteria();
			Map<String, Object> dataMap = replyService.getReplyList(replyReq.getBno(), cri);
			PageMaker pageMaker = (PageMaker) dataMap.get("pageMaker");
			int realEndPage = pageMaker.getRealEndPage();

			out.print("SUCCESS," + realEndPage);
			
		} catch (SQLException e) {
			e.printStackTrace();
			out.print("FAIL,1");
		}finally {
			if(out != null) out.close();
		}

		return url;
	}

}
