<%@page import="javax.swing.text.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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

    <title>Signin Template for Bootstrap</title>

	
    <!-- Bootstrap core CSS -->
    <link href="<%= request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%= request.getContextPath() %>/css/signin.css" rel="stylesheet">
    
	
  </head>

  <body>
  
				
	<script>
<%-- 	<% Cookie[] cookies= request.getCookies();%>		 --%>
		

		
		function getCookieValue(name){
			cookies = document.cookie.split(";")//이름, 벨류로 나뉘어짐
			names = "";
			values = ""; 
			for(i = 0 ; i < cookies.length; i++){
				names = cookies[i].split("=");// 이름과 벨류 두개로만 나뉘어짐
				if(names[0]==(name)){
					values = names[1];
// 				cookies = document.cookie.split(";")
// 				values = cookies[i].split("=")
// 					document.write(names)
					}
				}
				return values	
		}
		
// 		getCookieValue(REMEMBERME	)
	</script>
	
<%-- 	<%= names %> --%>
<%-- 	<%= values %> --%>
	
	
    <div class="container">

      <form class="form-signin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> 		


  </body>
</html>
