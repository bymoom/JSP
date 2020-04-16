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

<%! Scanner scan = new Scanner(System.in); %>

<%!
	public int input(){
		System.out.println("정수를 입력!");
		int i = Integer.parseInt(scan.nextLine()); //브라우저랑 jsp가 주고받는 값이 String이라 integer로 변환
		return i;
	}
%>

<%
	int i = input();
	System.out.println(i);
	for(;i <= 9; i++){
%>

<%= i %>단 입니다.<br/>

<%
		for(int j = 1; j <= 9; j++){
%>

<%= i %> * <%= j %> = <%= i*j %><br/>

<%			
		}
%>
	<br/>
<%	
	}
%>
</body>
</html>