package com.jsp.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.MemberVO;
import com.jsp.request.MemberRegistRequest;
import com.jsp.service.MemberServiceImpl;
import com.jsp.utils.ViewResolver;

@WebServlet("/member/modify")
public class MemberModifyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//화면 결정
		String url = "member/modify";
		
		//파라미터 처리
		String id = request.getParameter("id");
		
		//서비스 요청 -> 결과
		//결과에 따른 화면 분할
		MemberVO member = null;
		try {
			member = MemberServiceImpl.getInstance().getMember(id);
			System.out.println(member.getName());
		} catch (SQLException e) {
			e.printStackTrace();
			url = "error/500_error";
		}
		
		request.setAttribute("member", member);
		
		ViewResolver.view(request, response, url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "member/modify_success";
		//String result = null;
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String picture = request.getParameter("picture");
		String[] phone = request.getParameterValues("phone");
		String authority = request.getParameter("authority");
		String name = request.getParameter("name");
		
		MemberRegistRequest memberReq = new MemberRegistRequest(id, pwd, authority, email, phone, picture, name);
		
		MemberVO member = memberReq.toMemberVO();
		
		try {
			MemberServiceImpl.getInstance().modify(member);
		} catch (SQLException e) {
			e.printStackTrace();
			url = "member/modify_fail";
			//업로드 파일 삭제하기
		}

		/*result = "SUCCESS";
		response.getWriter().print(result);*/
		ViewResolver.view(request, response, url);
	}

}
