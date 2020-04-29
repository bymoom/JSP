<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
	alert("글을 수정했습니다.");
	location.href="detail.do?bno=${param.bno}&where=modify";
	window.opener.location.reload(true);
</script>