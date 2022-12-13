<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!doctype html>
<html>
<head>
	<meta charset="utf-8" />
	<title>My JSP Page</title>
	<!-- Twitter Bootstrap3 & jQuery -->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
	<script src="http://code.jquery.com/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<c:set var="prof_list" value="${requestScope.boardlist }" />
	<c:set var="totalCnt" value="${requestScope.totalCnt }" />
	
	<c:set var="nowPage" value="${requestScope.nowPage }"/>
	<c:set var="totalPage" value="${requestScope.totalPage }"/>
	<c:set var="startPage" value="${requestScope.startPage }"/>
	<c:set var="endPage" value="${requestScope.endPage }"/>
	
	
	<div class="container">
		<div class="page-header clearfix">
			<h1 class='pull-left'>교수목록</h1>

			<div style='margin-top: 30px' class="pull-right">
				<a href="../board/prof_add.jsp" class="btn btn-primary">교수추가</a>
			</div>
		</div>
		
		<div style='margin-top: 30px' class="pull-right">
			<a>교수 총 인원수 : ${totalCnt} 명 </a>
		</div>
		
		<!-- 조회결과를 출력하기 위한 표 시작 -->
		<table class="table">
			<thead>
				<tr>
					<th class="info text-center">교수번호</th>
					<th class="info text-center">이름</th>
					<th class="info text-center">아이디</th>
					<th class="info text-center">직급</th>
					<th class="info text-center">급여</th>
					<th class="info text-center">입사일</th>
				</tr>
			</thead>
			<tbody>
			<c:choose>
			<c:when test="${boardlist != null and fn:length(boardlist) > 0 }"><c:forEach var="board" items="${boardlist}">
				<tr>
					<td class="text-center">${board.profno }</td>
					<td class="text-center">
						<a href="${pageContext.request.contextPath }/board/prof_View.bo?boardnum=${board.name}"></a>
					</td>
					<td class="text-center">${board.userid }</td>
					<td class="text-center">${board.position }</td>
					<td class="text-center">${board.sal }</td>
					<td class="text-center">${board.hiredate }</td>		


					
				</tr>
					</c:forEach>
				</c:when>
					<c:otherwise>
					<tr style="height: 50px;">
						<td colspan="5" style="text-align: center;">등록된 게시물이 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
			</tbody>
		</table>
		<!--// 조회결과를 출력하기 위한 표 끝  -->

		<br>
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		<!-- 페이징 처리 -->
		<table style="border: 0px; width: 900px;">
			<tr align="center" valign="middle">
				<td>
				
				</td>
			</tr>
		</table>
	</div>
</body>
</html>



