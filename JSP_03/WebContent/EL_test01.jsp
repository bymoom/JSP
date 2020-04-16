<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%
	//session.invalidate();

	String str = "5교시...배부르다...";
	pageContext.setAttribute("msg", str);
	request.setAttribute("msg", "그런다고 졸면 될까요?");
	session.setAttribute("msg", "괜찮아~ 그냥 자~");
	application.setAttribute("msg", "session 닥쳐");
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<ul>
		<li>스크립트릿 : <% out.println(pageContext.getAttribute("msg")); %></li>
		<li>표현식 : <%= pageContext.getAttribute("msg") %></li>
		<li>EL문 : ${sessionScope.msg}</li>
	</ul>
</body>
</html>