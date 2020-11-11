<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script>

	//ajax는 비동기이기 때문에 먼저 실행이 되므로 member을 눌러도 실행이 되지 않는다.
	//그러므로 안에 같이 넣어준다.
	//해당 html이 로딩이 완료 되었을 떄 실행되는 이벤트 핸들러 함수
	$(document).ready(function() {
		//ajax 요청을 통해 1페이지에 해당하는 사용자 정보를 json으로 받는다.

				//memberListAJax(1);
				memberListAJaxHTML(1);
				//$("#memberList tr").on("click",  function() { tr의 위치를 바꿔준것만으로 된다니 신기하다..
				// tr태그가 먼저 있는지 검사하고 그다음에 확인
				$("#memberList").on("click", "tr", function() {
					// data-userid		
					var userid = $(this).data("userid")
					console.log("userid : " + userid)

					document.location = "/member/ContentAjaxPage?userid=" + userid;
				})
	})
	
	function memberListAJax(p){
		$.ajax({url : "/member/listAjax",
			
			data : {page : p, pageSize : 5},
			//data : "page=1&pageSize=5"
			//data : JSON.stringfy({page : 1, pageSize : 5}),
			//			Controller에서 @RequestBody JSON <-->JAVA OBJECT
			
			method : "get",
			success : function(data){
				var i = 0;

				//memberList tbody 영역에 들어갈 html 문자열 생성
			var html ="";
			for(var i=0; i < data.memberList.length; i++){
				var member = data.memberList[i];
				
				html += "<tr data-userid= '"+ member.userid +"'>"
				html += "<td>" + member.userid +"</td>";	
				html += "<td>" + member.usernm +"</td>";
				html += "<td>" + member.useralias +"</td>";
				html += "<td>" + member.fmt_reg_dt +"</td>";
				html += "</tr>"
					
			}
			$("#memberList").html(html);
			//페이지 내비게이션 html 문자열이 동적으로 생성하기
			
			var pagehtml = "";
			
			for(var i=1; i < data.pages; i++){
				var result = data.pageVo.page;
				if(i == result){
//						pagehtml += "<li class='active'><span>"+i+"</span></li>"
					pagehtml += "<li class=\"active\"><span>"+i+"</span></li>"
					pagehtml += "<li class=\"active\"><span>"+i+"</span></li>"
				}else{
// 					pagehtml += "<li><a href=\"${pageContext.request.contextPath}/member/memberList?page="+i+"\">"+i+"</a></li>"
					// <a href = "javascript:memberListAjax(1);"/>
					pagehtml += "<li><a href=\"javascript:memberListAJax(" + i + ");\">" + i + "</a>"
				}
			}
			$("#pagelist").html(pagehtml);
		}
	});

	}

	function memberListAJaxHTML(p){
		$.ajax({url : "/member/listAjaxHTML",
			data : {page : p, pageSize : 5},
			//data : "page=1&pageSize=5"
			//data : JSON.stringfy({page : 1, pageSize : 5}),
			//			Controller에서 @RequestBody JSON <-->JAVA OBJECT
			
			method : "get",
			success : function(data){

			var html = data.split("$SEPERATOR$");	
			$("#memberList").html(html[0]);
			$("#pagelist").html(html[1]); 
		}
	});

	}
</script>

<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped">

				<tr>
					<th>사용자 아이디</th>
					<th>사용자 이름</th>
					<th>사용자 별명</th>
					<th>등록일시</th>
				</tr>

				<tbody id="memberList">
					
				</tbody>
			</table>
		</div>

.
		<a href="${cp }/member/memberRegist"
			class="btn btn-default pull-right">사용자 등록</a>
		<div class="text-center">
			<ul class="pagination" id = "pagelist">

			</ul>
		</div>
	</div>
</div>

