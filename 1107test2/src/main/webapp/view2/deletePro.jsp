<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib	prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원탈퇴</title>
</head>
<body>
<c:if test="${check == 1}">
회원정보가 삭제되었습니다.
<input type="button" value="확인" onclick="location.href='loginForm.do'">
</c:if>
<c:if test="${check != 1}">
	<script>
		alert("비밀번호가 맞지 않습니다.");
		history(-1);
	</script>
</c:if>
</body>
</html>