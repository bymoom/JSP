package com.jsp.action.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.dto.BoardVO;
import com.jsp.request.ModifyBoardRequest;
import com.jsp.service.BoardService;
import com.jsp.service.BoardServiceImpl;

public class BoardModifyAction implements Action {

	private BoardService boardService; // = BoardServiceImpl.getInstance();
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "board/modify_success";
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		
		BoardVO board = new ModifyBoardRequest(bno, title, content, writer).toBoardVO();
		
		try {
			boardService.modify(board);
		} catch (SQLException e) {
			e.printStackTrace();
			url = "board/modify_fail";
		}
		
		return url;
	}

}
