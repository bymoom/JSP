package com.jsp.action.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.action.Action;
import com.jsp.dto.BoardVO;
import com.jsp.request.RegistBoardRequest;
import com.jsp.service.BoardService;
import com.jsp.service.BoardServiceImpl;

public class BoardRegistAction implements Action {

	private BoardService boardService; // = BoardServiceImpl.getInstance();
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "board/regist_success";
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		
		BoardVO board = new RegistBoardRequest(title, content, writer).toBoardVO();
		
		try {
			boardService.write(board);
		} catch (SQLException e) {
			e.printStackTrace();
			url = "board/regist_fail";
		}
		
		return url;
	}

}
