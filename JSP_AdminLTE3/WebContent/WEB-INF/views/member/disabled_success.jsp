<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
	alert("${param.id}님의 사용을 정지했습니다.");
	location.href="detail.do?id=${param.id}";
</script>