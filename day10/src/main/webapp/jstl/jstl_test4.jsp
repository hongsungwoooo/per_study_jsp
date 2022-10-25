<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:choose>
		<%-- param.userid가 empty일때 --%>
		<c:when test="${empty param.userid }">
			<form>
				아이디 <input type="text" name="userid"><br>
				비밀번호 <input type="text" name="userpw"><br>
				<input type="submit"><br>
			</form>
		</c:when>
		<%-- param.userid가 empty 아닌경우 일때 --%>
		<c:otherwise>
			<c:set var="userid" value="${param.userid }" />
			<c:set var="userpw" value="${param.userpw }" />
			<c:choose>
				<c:when test="${userid == 'admin' }">관리자</c:when>	
				<c:when test="${userid == 'java' }">자바학생</c:when>
				<c:otherwise>비회원</c:otherwise>	
			</c:choose>
		</c:otherwise>
	</c:choose>
	
	
	<!-- 
		요청 : http://localhost:8081/jstl/jstl_test4.jsp?userid=&userpw=	
			조건 1. userid값이 없을때 -> 아이디/비밀번호 입력 화면
			조건 2. userid값이 있을때
				조건 2-1. userid값이 admin 이면, 	'관리자' 출력
				조건 2-2. userid값이 java 이면, 	'자바학생' 출력
				조건 2-3. userid값이 그 외 값이면, 	'비회원' 출력 
	-->
</body>
</html>













