<%@page import="kr.or.ddit.jobs.model.JobsVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<% List<JobsVo> jobsList = (List<JobsVo>) request.getAttribute("JobsVo"); %>
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

<title>Jsp</title>

<!-- <script src="/js/jquery/jquery-1.12.4.js"></script> -->
<%@ include file="/layout/commonLib.jsp" %>
</head>

<body>
<%@ include file = "/layout/header.jsp" %>
	

<div class="container-fluid">
	<div class="row">
			
		<div class="col-sm-3 col-md-2 sidebar">
		<%@ include file = "/layout/left.jsp" %>
		</div>
		
		
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="blog-header">
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
				</div>

			<div class="row">
				<div class="col-sm-8 blog-main">
					<div class="blog-post">
						
					</div>
				</div>
	<!-- /.blog-main -->
			</div>	
		</div>
	</div>
</div>
</body>
</html>
