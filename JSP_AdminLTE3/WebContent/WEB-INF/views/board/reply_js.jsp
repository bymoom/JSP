<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!-- 
	***자바스크립트 이벤트(예:아이콘 겉모양은 같은데 내용만 다른걸 만들때,최근본상품또는메뉴)***
	1. 템플릿 만들기(화면 만들기)
	2. 
 -->
<!-- 핸들바 사용하려면 JQUERY 필요(header에 있음) -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.6/handlebars.js"></script>

<!-- {{prettifyDate regdate}} : 메서드에 파라미터 보내기 -->
<!-- data-toggle="modal" data-target="#modifyModal" : modal로 modifyModal(화면)띄울게 -->
<script type="text/x-handlebars-template" id="reply-list-template">
{{#each .}}
<div class="replyLi" data-rno={{rno}}>
	<i class="fas fa-comments bg-yellow"></i>
 	<div class="timeline-item" >
  		<span class="time">
    		<i class="fa fa-clock"></i>{{prettifyDate regdate}}
	 		<a class="btn btn-primary btn-xs" id="modifyReplyBtn"
	    		data-replyer={{replyer}} data-toggle="modal" data-target="#modifyModal">Modify</a>
  		</span>
	
  		<h3 class="timeline-header"><strong style="display:none;">{{rno}}</strong>{{replyer}}</h3>
  		<div class="timeline-body">{{replytext}} </div>
	</div>
</div>
{{/each}}
</script>

<!-- 핸들바 컴파일을 거쳐야함 -->
<script>

	//Handlebars에 메서드 만들기
	Handlebars.registerHelper("prettifyDate", function(timeValue){
		//timeValue : getTime() = 밀리세컨드(예 : 1587608750000)
		var dateObj = new Date(timeValue);
		
		var year = dateObj.getFullYear();
		var month = dateObj.getMonth() + 1; //월은 0부터 시작해서 +1
		var date = dateObj.getDate();
		
		return year + "/" + month + "/" + date;
	});
	
	/* var jsonData = [
	{
		"rno" : 0,
		"bno" : 345,
		"replytext" : "방가방가",
		"replyer" : "mimi",
		"regdate" : 1587456848000,
		"updatedate" : 1587456848000
	},
	{
		"rno" : 1,
		"bno" : 345,
		"replytext" : "방가방가",
		"replyer" : "mimi",
		"regdate" : 1587456976000,
		"updatedate" : 1587456976000
	}
	];
	
	var templateObject = $('#reply-list-template'); //#reply-list-template : 스크립트 아이디(스크립트 객체화)
	var template = Handlebars.compile(templateObject.html()); //JSON 데이터를 컴파일
	var html = template(jsonData);
	console.log(html);
	$('#repliesDiv').after(html); //#repliesDiv 태그 다음에 html 붙이기
	*/

	var replyPage = 1;
	/* var realEndPage = 1; */
	
	//detail 화면 열면 처음에 무조건 떠야 하니까 function호출(안부르면 페이지번호를 눌러야만 댓글뜬다)
	getPage("<%= request.getContextPath() %>/replies/list.do?bno=${board.bno}&page=1");
	
	//글번호에 따라 적용시킬거라 function으로 만들어서 호출해서 쓴다
	//클래스 메서도 : 새(bird) 클래스 -> 새가 날 수 있도록 하는 메서드 (한번만 써야해도 만든다)
	//자바스크립트 function : (같은 행위를) 반복적으로 사용할때 사용
	var printData = function(replyArr, target, templateObject){
		var template = Handlebars.compile(templateObject.html());
		var html = template(replyArr);
		$('.replyLi').remove(); //after를 쓰면 계속 이어 붙여지기 때문에 remove
		target.after(html);
	}
	
	//reply list
	//#reply-list-template : 스크립트 아이디(스크립트 객체화)
	function getPage(pageInfo){
		$.getJSON(pageInfo, function(data){
			printData(data.replyList,$('#repliesDiv'),$('#reply-list-template'));
			printPaging (data.pageMaker, $('.pagination')); // .pagination : detailBoard.jsp에 있는 ul 태그
			/* if(data.pageMaker.realEndPage > 0){
				realEndPage = data.pageMaker.realEndPage;
			} */
		});
	}
	
	
	//reply pagination
	var printPaging = function(pageMaker, target){
		var str = "";
		
		if(pageMaker.prev){
			str += "<li class='page-item'><a class='page-link' href='" + (pageMaker.startPage-1) + "'><i class='fas fa-angle-left'/></a></li>";
		}
		
		for(var i = pageMaker.startPage; i <= pageMaker.endPage; i++){
			var strClass = pageMaker.cri.page == i ? 'active' : ''; //현재페이지에 해당하는 페이지 번호인 경우 해당 번호에 색 입히기
			str += "<li class='page-item " + strClass + "'><a class='page-link' href='" + i + "'>" + i + "</a></li>";
		}
		
		if(pageMaker.next){
			str += "<li class='page-item'><a class='page-link' href='" + (pageMaker.endPage+1) + "'><i class='fas fa-angle-right'/></a></li>";
		}
		
		target.html(str);
	}
	
	$('.pagination').on('click', 'li a', function(event){
		//alert("reply page click");
		event.preventDefault(); //a태그가 갖고 있는 기본 이벤트(사이트 이동) 막기
		replyPage=$(this).attr("href");
		getPage("<%= request.getContextPath() %>/replies/list.do?bno=${board.bno}&page=" + replyPage); //현재 url은 board이기때쿤에 상대주소 아니고 절대주소 씀
	});
	
	$('#replyAddBtn').on('click', function(e){
		//alert("add reply btn");
		var replyer = $('#newReplyWriter').val();
		var replytext = $('#newReplyText').val();
		
		if(replytext==""){
			alert('댓글 내용은 필수입니다.');
			$('#newReplyText').focus().css("border-color", "red").attr("placeholder", "내용은 필수입니다.");
			return;
		}
	
		//댓글 데이터를 JSON으로 만들기
		var data = {
				"bno" : "${board.bno}",
				"replyer" : replyer,
				"replytext" : replytext
		}
		
		//RESTful 방식 : 화면을 넘기는게 아니라 JSON 데이터를 넘겨 처리 하는 방식
		$.ajax({
			url : "<%= request.getContextPath() %>/replies/regist.do",
			type : "post",
			data : JSON.stringify(data),
			contentType : "application/json", //보내는 data 형식 지정
			dataType : "text", //받는 data 형식 지정
			success : function(data){
				var result = data.split(',');
				if(result[0] == "SUCCESS"){
					alert("댓글이 등록되었습니다.");
					getPage("<%= request.getContextPath() %>/replies/list.do?bno=${board.bno}&page=" + result[1]);
					$('#newReplyText').val("");
				}else{
					alert("댓글 등록이 취소되었습니다.");
				}
			}
		});
	});
	
	//reply modify 권한 체크
	$('div.timeline').on('click', '#modifyReplyBtn', function(event){
		//로그인 사용자 확인
		var replyer = $(event.target).attr("data-replyer");
		if(replyer!="${loginUser.id}"){
			alert("수정 권한이 없습니다.");
			$(this).attr("data-toggle","");
		}
	});
	
	//수정창에 data 표시
	$('div.timeline').on('click', '.replyLi', function(event){
		var reply = $(this);
		$('#replytext').val(reply.find('.timeline-body').text());
		$('.modal-title').html(reply.attr('data-rno'));
	});
	
	$('#replyModBtn').on('click', function(event){
		//값 가져오기
		var rno = $('.modal-title').text();
		var replytext = $('#replytext').val();
		
		//받은 데이터를 JSON으로...
		var sendData = {
			rno : rno,
			replytext : replytext
		}
		
		$.ajax({ //필터의 내용도 ajax 데이터로 와서 logincheck.jsp는 실행안되고 success 안의 if문만 실행됨
			url : "<%= request.getContextPath() %>/replies/modify.do",
			type : "post",
			data : JSON.stringify(sendData),
			success : function(result){
				if(result == "SUCCESS"){
					alert("수정되었습니다.");
					getPage("<%= request.getContextPath() %>/replies/list.do?bno=${board.bno}&page=" + replyPage);
				}else{
					alert("수정에 실패했습니다.");
				}
			},
			complete : function(){ //성공하든 안하든 한번은 꼭 실행한다
				$('#modifyModal').modal('hide');
			}
		});
	});
	
	$('#replyDelBtn').on('click', function(event){
		//alert("delete action btn");
		var rno = $('.modal-title').text();
		
		//${board.bno} : 값이 문자인 경우 ""을 안 붙이면 변수로 인식해서 에러. int인 경우는 string이 아니기때문에 상관없음
		var sendData = {
				bno : "${board.bno}",
				rno : rno,
				page : replyPage
		};
		
		$.ajax({
			url : "<%= request.getContextPath() %>/replies/remove.do",
			type : "post",
			data : JSON.stringify(sendData),
			success : function(data){
				var result = data.split(',');
				if(result[0] == "SUCCESS"){
					alert("삭제되었습니다.");
					getPage("<%= request.getContextPath() %>/replies/list.do?bno=${board.bno}&page=" + result[1]);
				}
			},
			error : function(error){
				alert("삭제에 실패했습니다.");
			},
			complete : function(){
				$('#modifyModal').modal('hide');
			}
		});
		
	});
	
</script>