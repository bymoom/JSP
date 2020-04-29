<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
	$('#addFileBtn').on('click', function(event){
		//alert("add File Click!");
		if($('input[name="uploadFile"]').length >= 5){
			alert("파일 추가는 5개까지만 가능합니다.");
			return;
		}
		
		var div = $('<div>').addClass("inputRow");
		var input = $('<input>').attr({"type":"file","name":"uploadFile"}).css("display","inline");
		div.append(input).append("<button style='border:0;outline:0;' class='badge bg-red' type='button'>X</button>");
		div.appendTo('.fileInput'); //<div class="card-footer fileInput">여기에 추가하겠다는 뜻</div>
	});
	
	$('div.fileInput').on('click', 'div.inputRow > button', function(event){
		$(this).parent('div.inputRow').remove();
	});
	
	$('.fileInput').on('change', 'input[type="file"]', function(event){
		if(this.files[0].size > 1024*1024*40){
			alert("파일 용량이 40MB를 초과하였습니다.");
			this.value="";
			$(this).focus();
			return false;
		}
	});
</script>