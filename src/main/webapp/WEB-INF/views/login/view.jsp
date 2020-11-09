<%@page import="javax.swing.text.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
<!--     <link rel="icon" href="../../favicon.ico"> -->

    <title>Signin Template for Bootstrap</title>

	
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath }/css/signin.css" rel="stylesheet">
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type = "text/javascript" src="${pageContext.request.contextPath }/js/js.cookie-2.2.1.min.js"></script>
  </head>

  <body>
  
				
	<script>
<%-- 	<% Cookie[] cookies= request.getCookies();%>		 --%>
		function getCookieValue(cookieName){
			cookies = document.cookie.split("; ")//이름, 벨류로 나뉘어짐
			names = "";
			values = ""; 
			for(i = 0 ; i < cookies.length; i++){
				names = cookies[i].split("=");// 이름과 벨류 두개로만 나뉘어짐
				if(names[0]==(cookieName)){
					values = names[1];
					}
			}
			return values
				
		}

		function setCookie(cookiName, cookieValue, expires){

			
			var today = new Date();
			today.setDate(today.getDate() + expires );
			
			document.cookie = cookiName + "=" + cookieValue + "; path =/; expires=" + today.toGMTString();

			console.log(document.cookie); 
						
		}

		//해당쿠키의 expires속성을 과거날짜로 변경
		function deleteCookie(cookieName){
			setCookie(cookieName, "", -1);			
		}

		$(function(){
			// sign in 버튼이 클릭 되었을 떄 이벤트 핸들러
			
			// 수업시간에 한거
			$('button[type=button]').on('click', function(){

				if($('input[type=checkbox]').prop('checked')== true){
					Cookies.set('REMEMBER', 'Y')
					var value = $('#inputEmail').val()
					Cookies.set('USERNAME', value)
											
				}else{
					Cookies.remove('REMEMBER')
					Cookies.remove('USERNAME')
				}
				
				$("form").submit();

		})
		
		
			//remember me cookie 확인
			if(Cookies.get("REMEMBER")=="Y"){
// 				$('input[name=check]').attr('checked',true)
				$('input[type=checkbox]').attr('checked',true)
				
				
// 				$('input[name=check]').prop('checked',true)
// 				$('input[name=check]').prop('checked',false)
// 				$('#inputEmail').attr('value', getCookieValue('USERNAME'))
				$('#inputEmail').val(Cookies.get("USERNAME"))
				
			}
		})
		
	</script>
	
	msg :${msg }<br>
	msg_s : ${msg_s }<br>
	<c:remove var="msg_s" scope="session"/>
	msg_ra : ${msg_ra }
	msg_ra_attr : ${msg_ra_attr }
	
    <div class="container">

      <form class="form-signin" action="${pageContext.request.contextPath }/login/process" method="post">
        <h2 class="form-signin-heading"><spring:message code="login.signin"/></h2>
        <label for="inputEmail" class="sr-only"><spring:message code="login.userid"/></label>
        <input type="email" id="inputEmail" name = "userid" class="form-control" placeholder="Email address" required autofocus value = "brown">
        <label for="inputPassword" class="sr-only"><spring:message code="login.password"/></label>
        <input type="password" id="inputPassword" name="pass" class="form-control" placeholder="Password" required value = "brownPass">
        <div class="checkbox">
          <label>
            <input name = "check" type="checkbox" value="remember-me"  > <spring:message code="login.rememberme"/>
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="button">Sign in</button>
        
      </form>
    </div>
  </body>
</html>
