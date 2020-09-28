<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	redirectView.jsp
	<% List<String> result = (List<String>) request.getAttribute("rangers"); %>
	<table>
		<tr>
			<th>이름</th>
		</tr>
		
		<% //for(int i =0; i<result.size() ; i++ ){
			
			for(String ranger : result){
			
			%>
		<tr>
			<td><%= ranger %></td>
		</tr>
		<%
		}
		%>
	</table>
	
</body>
</html>