<%@page import="java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<%
	Scanner scan = new Scanner(System.in);
	int i = Integer.parseInt(scan.nextLine()); //브라우저랑 jsp가 주고받는 값이 String이라 integer로 변환
	String val;
	
	for(;i <= 9; i++){
		for(int j = 1; j <= 9; j++){
			val = i + " * " + j + " = " + i*j;
			out.println(val + "<br/>");
		}
		out.println("<br/>");
	}
%>
</body>
</html>