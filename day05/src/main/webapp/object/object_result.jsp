<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=request.getParameter("username") %> 님 어서오세요. <br>
	당신의 아이디는 <%=request.getParameter("userid") %> 입니다.<br>
</body>
</html>





