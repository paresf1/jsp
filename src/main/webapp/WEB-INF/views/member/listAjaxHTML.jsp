<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<c:forEach items="${memberList }" var="member">
	<tr data-userid="${member.userid }">
		<%-- 							<input type="hidden" value = "${member.userid }"/> --%>
		<td>${member.userid }</td>
		<td>${member.usernm }</td>
		<td>${member.alias }</td>
		<td><fmt:formatDate value="${member.reg_dt }"
				pattern="YYYY-MM-dd" /></td>
	</tr>
</c:forEach>

$SEPERATOR$

<c:forEach begin="1" end="${pages }" var="i">
	<c:choose>
		<c:when test="${i == pageVo.page }">
			<li class="active"><span>${i }</span></li>
		</c:when>
		<c:otherwise>
			<!-- 							밑에 페이지 개수를 나타내는 li -->
			<li>
<%-- 			<a href="${pageContext.request.contextPath }/member/memberList?page=${i}">${i }</a></li> --%>
				<a href="javascript:memberListAJaxHTML(${i });">${i }</a>
			</li>
		</c:otherwise>
	</c:choose>
</c:forEach>
