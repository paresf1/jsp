<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script>
	$(document).ready(function() {
		$("#memberList tr").on("click", function() {
			// data-userid		
			var userid = $(this).data("userid")
			console.log("userid : " + userid)

			document.location = "/member/memberContent?userid=" + userid;
		})
	})
</script>

<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped">

				<tr>
					<th>사용자 아이디</th>
					<th>사용자 이름</th>
					<th>사용자 별명</th>
					<th>등록일시</th>
				</tr>

				<tbody id="memberList">
					<c:forEach items="${memberList }" var="member">
						<tr data-userid="${member.userid }">
							<%-- 							<input type="hidden" value = "${member.userid }"/> --%>
							<td>${member.userid }</td>
							<td>${member.usernm }</td>
							<td>${member.alias }</td>

							<%
								Date now = new Date();
							request.setAttribute("now", now);
							%>
							<td><fmt:formatDate value="${member.reg_dt }"
									pattern="YYYY-MM-dd" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>


		<a href="${cp }/member/memberRegist"
			class="btn btn-default pull-right">사용자 등록</a>
		<div class="text-center">
			<ul class="pagination">
				<c:forEach begin="1" end="${pages }" var="i">
					<c:choose>
						<c:when test="${i == page }">
							<li class="active"><span>${i }</span></li>
						</c:when>
						<c:otherwise>
							<!-- 							밑에 페이지 개수를 나타내는 li -->
							<li><a
								href="${pageContext.request.contextPath }/member/memberList?page=${i}">${i }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>

			</ul>
		</div>
	</div>
</div>

