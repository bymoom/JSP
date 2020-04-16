<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%-- forward하면서 request 파라미터를 같이 보내는 방법 --%>

<jsp:forward page="/action_forward/target.jsp">
	<jsp:param value='<%= URLEncoder.encode("홍길동", "utf-8") %>' name="name"/>
	<jsp:param value="12" name="age"/>
</jsp:forward>
