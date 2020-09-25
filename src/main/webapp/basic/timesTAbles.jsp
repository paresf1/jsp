<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<table border = "1">
		
		<% for(int i = 2 ; i<10; i++){%>		
			<tr>	
			<% for(int j = 1; j<10; j++){ %>
				<td><%=i %>* <%=j %> = <%=i*j %></td>
		<%} %>
		</tr>
	<%} %>	
	</table>
<!-- 	writer.println("<table border = 1>"); -->
<!-- 					for( int i = 2 ; i<10 ; i++){ -->
<!-- 						writer.println("<tr>"); -->
<!-- 						for(int j = 1; j<10 ; j++) { -->
<!-- 							writer.println("<td>" + i +"*" + j+ "="+ i*j);  -->
								
<!-- 							writer.println("</td>"); -->
<!-- 						} -->
<!-- 						writer.println("</tr>"); -->
<!-- 					} -->

<!-- 				writer.println("</table>"); -->
	
</body>
</html>