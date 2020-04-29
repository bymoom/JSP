<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
	alert("삭제에 성공했습니다.");
	window.close();
	opener.parent.searchList_go(${pageMaker.cri.page}, "<%= request.getContextPath() %>/pds/list.do"); <!--긴 주소줄 없애기 용으로 searchList_go 호출 -->
</script>

<!-- 주소줄에 길게 나타나는것들 없애기 용도 -->
<%-- <form id="jobForm">
	<input type='hidden' name="page" value="${pageMaker.cri.page}" />
	<input type='hidden' name="perPageNum" value="${pageMaker.cri.perPageNum}"/>
	<input type='hidden' name="searchType" value="${pageMaker.cri.searchType }" />
	<input type='hidden' name="keyword" value="${pageMaker.cri.keyword }" />
</form> --%>