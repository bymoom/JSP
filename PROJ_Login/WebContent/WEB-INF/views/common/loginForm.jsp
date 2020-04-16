<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<title></title>
	
	<!-- Font Awesome Icons -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
	<!-- Theme style -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/dist/css/adminlte.min.css">
	<!-- Google Font: Source Sans Pro -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">

	<style>
		body {
			align-items : center;
			display : flex;
			flex-direction : column;
			justify-content : center;
			margin-top : 100px;
		}
	</style>
</head>

<body>
 
  <div class="wrapper">
	<%-- <form action="login" method="post">
		아이디 : <input type="text" name="id" value="${param.id}" /><br/>
		패스워드 : <input type="password" name="pwd" value="${param.pwd}" /><br/>
		<input type="submit" value="로그인" />
	</form> --%>
	
	<form action="login" method="post" class="form-horizontal" name="login">
     <div class="card-body">
       <div class="form-group row">
         <label for="inputEmail3" class="col-sm-4 col-form-label">ID</label>
         <div class="col-sm-6">
           <input type="text" name="id" class="form-control" id="inputEmail3" placeholder="ID">
         </div>
       </div>
       <div class="form-group row">
         <label for="inputPassword3" class="col-sm-4 col-form-label">PASSWORD</label>
         <div class="col-sm-6">
           <input type="password" name="pwd" class="form-control" id="inputPassword3" placeholder="PASSWORD">
         </div>
       </div>
       <div class="form-group row">
         <div class="offset-sm-2 col-sm-10">
           <div class="form-check">
             <input type="checkbox" class="form-check-input" id="exampleCheck2">
             <label class="form-check-label" for="exampleCheck2">Remember me</label>
           </div>
         </div>
       </div>
     </div>
     <!-- /.card-body -->
     <div class="card-footer">
       <button type="submit" class="btn btn-info">Log-In</button>
       <button type="reset" class="btn btn-default float-right">Cancel</button>
     </div>
     <!-- /.card-footer -->
   </form>
  </div> 
</body>

<!-- jQuery -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- SweetAlert2 -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/sweetalert2/sweetalert2.min.js"></script>
<!-- Toastr -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/toastr/toastr.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/dist/js/demo.js"></script>
	
<script>
	
	if("${msg}" != ""){
	    $(document).Toasts('create', {
	      title: '로그인 실패',
	      body: '${msg}'
	    })
	 }

</script>	
</html>