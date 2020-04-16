<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	Date today = new Date();
	String todayStr = new SimpleDateFormat("yyyy-MM-dd").format(today);
	out.println(todayStr);
%>

<fmt:formatDate value="<%= today %>" pattern="yyyy-MM-dd" />

<%--
var="today"할 경우 contextPath에 value값을 올리겠다는 의미라서 출력하려면 ${today}를 따로 작성해야한다
<fmt:formatDate value="<%= today %>" pattern="yyyy-MM-dd" var="today"/>
${today} --%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

</body>
</html>