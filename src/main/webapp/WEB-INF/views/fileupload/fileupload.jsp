<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

	<!-- client form method : post 
		 		necType : multipart/form-data
		 server - servlet@MultipartConfig
		 	    - spring Frameworkd multipartResolver
	-->	
	<form action="${cp }/fileupload/upload" method="post" enctype="multipart/form-data">
	file : <input type="file" name = "file"><br>
	userid : <input type="text" name = "userid" value = "브라운">
	<input type="submit" value = "전송">
	</form>
</body>
</html>