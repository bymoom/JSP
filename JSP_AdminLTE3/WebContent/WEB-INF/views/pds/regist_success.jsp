<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
	alert("자료를 등록했습니다!");
	
	window.close();
	//3페이지를 보다가 등록한 경우 reload해도 1페이지로 안 돌아가므로 아예 url로 이동시키기
	window.opener.location.href="list.do?page=1&perPageNum=10";
</script>