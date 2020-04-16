package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/login.html") -> web.xml에 등록함
public class LoginServlet extends HttpServlet {
	
	//주소를 입력한 경우 doGet메서드 실행(주소 = web.xml에  매핑한 url(= @WebServlet와 같은 기능) ex:'localhost/login.html')
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//브라우저에 띄우기
		/*response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();*/
		
		//out.println("doGet() execute!!");

		//Dispatcher : 총괄자
		request.getRequestDispatcher("/WEB-INF/views/loginForm.jsp").forward(request, response);
		
	}

	//submit 버튼 클릭하면 doPost 메서드 실행(처리해야하기때문)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//MemberVO member = memberService.getMember(id);
		
		request.getRequestDispatcher("login_success.jsp").forward(request, response);

		/*response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();*/
		
		//System.out.println("doPost() execute!!");
	}

}
