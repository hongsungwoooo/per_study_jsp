<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>param 액션 태그</h3>
	<jsp:forward page="param_result.jsp">
		<jsp:param value="apple" name="userid"/>	
		<jsp:param value="자바학생" name="username"/>
	</jsp:forward>
</body>
</html>




















