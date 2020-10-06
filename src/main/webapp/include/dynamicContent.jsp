<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<%
			request.getRequestDispatcher("/include/header.jsp")
			.include(request, response);
		%>
	</h1>
	dynamicCOntent.jsp
	
	값이 header jsp에서도 적용이 된다.
	param : <%= request.getParameter("param") %>
</body>
</html>