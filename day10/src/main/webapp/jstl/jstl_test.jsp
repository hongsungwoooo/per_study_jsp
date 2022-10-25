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
	<h2>JSTL TEST(변수)</h2>
	<!-- 
		변수선언, scope : 어느 범위까지 사용하는지, page : pageContext
		jstl로 만들어진 값은 setAttribute로 값을 넣기 때문에
		el로 값을 가져올 수 있다.
	 -->
	<c:set var="userid" value="student" scope="page" />
	회원아이디 <c:out value="${userid }" /><br>
	회원아이디 ${userid }<br>
</body>
</html>



















