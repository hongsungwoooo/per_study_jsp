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
<%-- 	<c:set>이 사이에 들어가는 값이 value</c:set> --%>
	<c:set var="userid" scope="session">자바학생</c:set>
	<c:set var="userpw" scope="session">1234</c:set>
	
	회원아이디 ${userid }<br>
	회원비밀번호 ${userpw }<br>
	회원아이디 ${sessionScope.userid }<br>
	회원비밀번호 ${sessionScope.userpw }<br>
	
</body>
</html>















