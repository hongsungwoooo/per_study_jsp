<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/user/UserLoginok.us" method="post" >
		<p>
		 아이디<input type="text" name="userid">
		 </p>
		 <p>
		 패스워드<input type="text" name="userpw">
		 </p>
		 <p>
		 <input type="submit" value="로그인하기">
		 </p>
	</form>
</body>
</html>