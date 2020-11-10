<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<script>
	$(document).ready(function(){
// 		var userid = "${userid }"

		//client side에서는 서버사이드 변수나 값을 사용 가능
		memberContentajaxHTML("${param.userid}")
// 		memberContentajaxHTML(userid)
			
		$("#update").on("click", function(){
			// data-userid		
			console.log("userid : " + userid)	
			document.location = "/member/memberUpdate?userid=" + userid;		
		})
		
		$("#profileDownBtn").on("click", function(){
			document.location = "/profileDownload?userid=${memberVo.userid}";
		})
		
	})
	
	
	function memberContentajaxHTML(a){
		$.ajax({url : "/member/ContentAjaxHTML",
			method : "get",
			data : {userid : a},
			//data : "userid="+userid,
			success : function(data){
				$("#Content").html(data)
				
			}
		})
	}

	function memberAjax(userid){
		$.ajax({url : "/member/memberAjax",

		})
	}
</script>

</head>
<style>
	img{
		width : 200px;
		height : 180px;
	}
</style>

		<div class="row">

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"
				id = "Content">
			
				
			</div>
		</div>
</html>
