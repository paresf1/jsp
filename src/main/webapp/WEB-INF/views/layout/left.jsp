<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="" %>     --%>
<div>
	<ul class="nav nav-sidebar">
			<li class="active"><a href="${pageContext.request.contextPath }/main.jsp">Main <span class="sr-only">(current)</span></a></li>
			<li class="active"><a href="${pageContext.request.contextPath }/member/memberList">사용자</a></li>
			<li class="active"><a href="${pageContext.request.contextPath }/member/listAjaxPage">사용자(ajax)</a></li>
			<li class="active"><a href="${pageContext.request.contextPath }/JobsSelectAllController">jobs</a></li>
	</ul>
</div>
