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
		String data = "hello";
		// pageContext : 현재 페이지
		pageContext.setAttribute("data", data);
		pageContext.setAttribute("result", "pageResult");
	%>
	
	${data}<br>
	${10+20 }<br>
	${10 > 3 }<br>
	
	<%=request.getAttribute("result") %> 입니다<br>
	${result } 입니다.<br>
	${requestScope.result } 입니다.<br>
	
	${names[0] }<br>
	${names[1] }<br>
	
	${notice.id }<br>
	${notice.title }<br>
	
	
</body>
</html>










