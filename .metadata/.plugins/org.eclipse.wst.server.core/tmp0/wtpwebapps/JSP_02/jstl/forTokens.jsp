<%@page import="java.util.StringTokenizer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String source = "010-1234-5678";
	StringTokenizer stn = new StringTokenizer(source, "-"); //"-" : 뭘로 자를건지 구분해주는 구분자
	
	while(stn.hasMoreTokens()){ //잘라달라고 할때마다 잘라줌(자를게 있는지 없는지 확인 true, false)
		out.println(stn.nextToken() + "<br/>");
	}
%>

<c:forTokens var="str" items="<%= source %>" delims="-" varStatus="status"> <%-- varStatus="status" : 반복 상태 --%>
	${status.count} : ${str} <br/> <%-- 반복한횟수:값 / 1:010 / 2:1234 / 3:5678 --%>
</c:forTokens>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

</body>
</html>