<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.setCharacterEncoding("UTF-8"); %>
	
	<h1><%= request.getMethod() %></h1>
	userId 파라미터는 brown, sally 두개를 보내지만 getParameter 를 호출하면<br>
	첫번째 파라미터 값을 반환<br>
	request.getParameter("id") : <%= request.getParameter("id") %><br><br>
	
	String[]을 반환
	
	<% 
		String[] userIds = request.getParameterValues("id");
		for(String userId : userIds){
	%>
	
	<%= userId %>
	
	<% } %><br><br>
	
	parameterMap : Map<String, String[]>
	request.getParameterMap() :<br> <%= request.getParameterMap() %>
<% Enumeration<String> name = request.getParameterNames();%>
	
	이름 : <%=name %>



	
	요청에 존재하는 파라미터 이름 출력하기
	request.getParameterNames() : <%=  request.getParameterNames() %>
	
	
	
</body>
</html>














