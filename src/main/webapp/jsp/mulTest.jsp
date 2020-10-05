<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action ="<%= request.getContextPath()%>/mulCalculation" method = "post">
	<input type = "text" value = "3" name = "start"><br>
	<input type = "text" value = "8" name = "end"><br>
	
	<input type = "submit"><br>
	</form>
</body>
</html>