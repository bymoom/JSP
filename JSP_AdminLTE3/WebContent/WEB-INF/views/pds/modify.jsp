<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>수정페이지</title>

<body>
  <!-- Content Wrapper. Contains page content -->
  <div>
     <jsp:include page="content_header.jsp">
    	<jsp:param value="자료실" name="subject"/>
		<jsp:param value="수정" name="item"/>
		<jsp:param value="list.do" name="url"/>    	
    </jsp:include>

    <!-- Main content -->
    <section class="content container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card card-outline card-primary">
					<div class="card-header">
						<h3>자료 수정</h3>
					</div><!--end card-header  -->
					<div class="card-body">
						<form enctype="multipart/form-data" role="form" method="post" action="modify.do" name="modifyForm">
							
							<input type='hidden' name="pno" value="${pds.pno }" />
							<input type='hidden' name='page' value="${param.page}">
							<input type='hidden' name='perPageNum' value="${param.perPageNum}">
							<input type='hidden' name='searchType' value="${param.searchType}">
							<input type='hidden' name='keyword' value="${param.keyword}">
							
							<div class="form-group">
								<label for="writer">작성자</label> 
								<input type="text" id="writer" readonly
									name="writer" class="form-control" value="${pds.writer }">
							</div>
							<div class="form-group">
								<label for="title">제 목</label> 
								<input type="text" id="title" value="${pds.title }"
									name='title' class="form-control" placeholder="제목을 쓰세요">
							</div>
							<div class="form-group">
								<label for="content">내 용</label>
								<textarea id="content" name="content">${pds.content }</textarea>
							</div>
							
							<div class="form-group">								
								<div class="card card-outline card-success">
									<div class="card-header">
										<h3 style="display:inline;line-height:40px;">첨부파일 : </h3>
										&nbsp;&nbsp;<button class="btn btn-primary" 
										type="button" id="addFileBtn">Add File</button>
									</div>									
									<div class="card-footer fileInput">
										<ul class="mailbox-attachments d-flex align-items-stretch clearfix">
											
											<c:forEach items="${pds.attachList }" var="attach" >
											<li class="attach-item">																			
												<div class="mailbox-attachment-info">
													<a class="mailbox-attachment-name" attach-fileName="${attach.fileName }" attach-no="${attach.ano }" href="<%=request.getContextPath()%>/attach/getFile.do?pno=${pds.pno }&ano=${attach.ano }" name="attachedFile" >													
														<i class="fas fa-paperclip"></i>
														${attach.fileName }&nbsp;&nbsp;
														<button type="button" style="border:0;outline:0;" class="badge bg-red">X</button>																									
													</a>													
												</div>
											</li>	
											</c:forEach>
										</ul>
										<br/>														
									</div>
								</div>
							</div>
							
							<input type="hidden" name="pno" value="${pds.pno }" />
							
						</form>
					</div><!--end card-body  -->
					<div class="card-footer">
						<button type="button" class="btn btn-warning" id="modifyBtn">수 정</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn" id="cancelBtn">취 소</button>
					</div><!--end card-footer  -->
				</div><!-- end card -->				
			</div><!-- end col-md-12 -->
		</div><!-- end row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
	
<script>
$('#modifyBtn').on('click',function(e){
	var form=document.modifyForm;
	
	if($("input[name='title']").val()==""){
		alert(input.name+"은 필수입니다.");
		$("input[name='title']").focus();
		return;
	}
	
	var files = $('input[name="uploadFile"]');
	for(var file of files){
		console.log(file.name+" : "+file.value);
		if(file.value==""){
			alert("파일을 선택하세요.");
			file.focus();
			return false;
		}
	}	
	
	if(form.content.value.length>1000){
		alert("글자수가 1000자를 초과할 수 없습니다.");
		return;
	}
	
	form.submit();
	
});

$('#cancelBtn').on('click',function(e){
	history.go(-1);
});
</script>

<jsp:include page="modify_js.jsp"/>

<%@ include file="/WEB-INF/views/commons/summernote.jsp" %>

</body>






<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>자료수정</title>
<body>
  <!-- Content Wrapper. Contains page content -->
  <div>
    <jsp:include page="content_header.jsp">
    	<jsp:param value="자료실" name="subject"/>
		<jsp:param value="수정" name="item"/>
		<jsp:param value="list.do" name="url"/>    	
    </jsp:include>
    <!-- Main content -->
    <section class="content container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card card-outline card-info">
					<div class="card-header">
						<h4>글수정</h4>
					</div><!--end card-header  -->
					<div class="card-body">
						<form role="form" enctype="multipart/form-data" method="post" action="modify.do" name="modifyForm">
							<div class="form-group">
								<input type='hidden' name='pno' value ="${pds.pno}">
							</div>
							<div class="form-group">
								<label for="writer">작성자</label> 
								<input type="text" id="writer" readonly
									name="writer" class="form-control" value="${pds.writer}">
							</div>
							<div class="form-group">
								<label for="title">제 목</label> 
								<input type="text" id="title"
									name='title' class="form-control" value="${pds.title}">
							</div>
							<div class="form-group">
								<label for="content">내 용</label>
								<textarea class="form-control" name="content" id="content" rows="5">${pds.content}</textarea>
							</div>
							<div class="form-group">								
								<div class="card card-outline card-success">
									<div class="card-header">
										<h5 style="display:inline;line-height:40px;">첨부파일 : </h5>
										&nbsp;&nbsp;<button class="btn btn-xs btn-primary" 
										type="button" id="addFileBtn">Add File</button>
									</div>									
									<div class="card-footer fileInput">
										<c:forEach items="${pds.attachList}" var="attachList">
											<div class="inputRow">
												<input type="file" name="uploadFile" style="display:inline;" value="${attachList.fileName}">
												<button style='border:0;outline:0;' class='badge bg-red' type='button'>X</button>
											</div>
										</c:forEach>
									</div>
								</div>
							</div>
						</form>
					</div><!--end card-body  -->
					<div class="card-footer">
						<button type="button" class="btn btn-primary" id="modifyBtn" onclick="submitPdsModify();">완 료</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn" id="cancelBtn" onclick="CloseWindow();">취 소</button>
					</div><!--end card-footer  -->
				</div><!-- end card -->				
			</div><!-- end col-md-12 -->
		</div><!-- end row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

<%@ include file="/WEB-INF/views/commons/summernote.jsp" %>

<jsp:include page="attach_js.jsp" />

<script>
	
	function submitPdsModify(){
		var formObj = document.modifyForm;
		formObj.submit();
	};

	$('#cancelBtn').on('click', function(){
		history.go(-1);
	});
</script>

</body> --%>