<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<%@ include file = "/WEB-INF/views/layout/commonLib.jsp" %>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>	
$(document).ready(function(){
	$("#zipcodeBtn").on('click', function(){
		new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
	            console.log(data);

	            $("#addr1").val(data.roadAddress)
	            $("#zipcode").val(data.zonecode)
	            
	        }
	    }).open();
	})
	$("#regBtn").on("click", function(){	
		//client side - vaildidation
		//client side - vaildidation
		//검증을 두단계 거치는게 안전함, 악의적으로 script 가능
	
		// vaildiation 생략 가능
		$("#frm").submit()
	})
	
// 	initData()	
})

function initData(){
	$("#userid").val("lss");
	$("#usernm").val("이승석");
	$("#alias").val("승석");
	$("#pass").val("pass");
	$("#addr1").val("대전 중구 중앙로 76");
	$("#addr2").val("흰둥이집");
	$("#zipcode").val("34904");
	
}
</script>


</head>
<style>
	img{
		width : 200px;
		height : 180px;
	}
</style>

<body>
	<%@ include file = "/WEB-INF/views/layout/header.jsp" %>
	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file = "/WEB-INF/views/layout/left.jsp" %>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<form id="frm" class="form-horizontal" role="form"
						action="${cp }/member/memberRegist" method="Post"
						enctype=  "multipart/form-data">
					
					<div class="form-group">
						<label for="filename" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
							<input type ="file" name = "realFilename2">
						</div>
					</div>
					
					<div class="form-group">
<!-- 						라벨은 시각장애인을 위해 읽도록 하는 것 -->
						<label for="userId" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userid" name="userid"
							 placeholder="사용자 아이디" value = "${param.userid }">
<!-- 							오류일떄 나타나는것 place holder -->
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="usernm" name="usernm"
							 placeholder="사용자 이름" value = "${param.usernm }" >
						</div>
					</div>


					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">별명</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="alias" name="alias"
							 placeholder="별명" value = "${param.alias }">
						</div>
					</div>
					
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="pass" name="pass"
							 placeholder="사용자 비밀번호" value = "${param.pass }">
						</div>
					</div>
					
					<div class="form-group">
						<label for="addr1" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="addr1" name="addr1"
							 placeholder="사용자 주소" readonly="readonly" value = "${param.addr1 }">
							 <button id="zipcodeBtn" type = "button" class="btn btn-default" >우편번호 찾기</button>
						</div>
					</div>
					
					<div class="form-group">
						<label for="addr2" class="col-sm-2 control-label">상세 주소</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="addr2" name="addr2"
							 placeholder="사용자 상세주소" value = "${param.addr2 }">
						</div>
					</div>
					
					<div class="form-group">
						<label for="zipcode" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="zipcode" name="zipcode"
							 placeholder="사용자 우편번호" readonly="readonly"  value = "${param.zipcode }">
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button id="regBtn" type="button" class="btn btn-default">사용자 등록</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
