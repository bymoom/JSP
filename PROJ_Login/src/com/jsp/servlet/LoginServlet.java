package com.jsp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.dto.MemberVO;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/common/loginForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/WEB-INF/views/common/loginForm.jsp";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberService service = MemberServiceImpl.getInstance();
		String msg = "Id나 패스워드가 잘못되었습니다.";
		
		MemberVO getVo = service.memData(id);
		if(getVo != null && getVo.getPwd().equals(pwd)) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", getVo);
			url = "/WEB-INF/views/common/login_success.jsp";
			msg = "";
		}
		request.setAttribute("msg", msg);
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
