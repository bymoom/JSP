<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h3><%= request.getContextPath() %>/member/list</h3>
	<h3><c:url value="/member/list" /></h3> <%-- <c:url>이 ContextPath를 자동으로 넘김 --%>
</body>
</html>