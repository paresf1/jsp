<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

	<table border="1">
	
	<c:forEach var = "j" begin = "1" end ="9" step ="1">
		<tr>
		<c:forEach var = "i" begin = "2" end ="9" step ="1">
			<td>	
				${i } * ${j } = ${i*j }<br>
			</td>
		</c:forEach>
		</tr>
	</c:forEach>
	
	</table>
</body>
</html>