<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<String> arList = new ArrayList<>();
		arList.add("Hello");
		arList.add("JSP");
		arList.add("EL");
		pageContext.setAttribute("list", arList);
		
	%>
	
	아이디 ${param.id }	<br>
	패스워드 ${param.pw }	<br>	
	
	${list }<br>

	${param.id >= 3 }<br>
	${param.id ge 3 }<br>
	--------------------------------<br>
	${empty param.id }<br>
	${not empty param.id }<br>
	--------------------------------<br>
	${empty param.id? '값이 비어 있습니다.' : param.id }<br>
	
	
</body>
</html>















