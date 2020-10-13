<%@page import="kr.or.ddit.jobs.model.JobsVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% List<JobsVo> jobsList = (List<JobsVo>) request.getAttribute("JobsVo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
				<% for(int i = 0 ; i<jobsList.size() ; i++){
						jobsList.get(i);
						
				%>
		<tr>
			<td>
				<%=jobsList.get(i).getJob_id()%>
				<%=jobsList.get(i).getJob_title()%>
				
			</td>
		</tr>
			
					<% 						
				}%>
			


	</table>

</body>
</html>