<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.koreait.vo.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%	
		// 객체배열,  
		User[] arrUser = {
			new User("java", "자바학생", 20),
			new User("dbms", "디학생", 30),
			new User("jsp", "웹학생", 40)
		};
		
		// request 객체, setAttribute
		request.setAttribute("users", arrUser);
		
		// forward 페이지 이동, attribute6.jsp
		pageContext.forward("attribute6.jsp");
	%>

</body>
</html>







