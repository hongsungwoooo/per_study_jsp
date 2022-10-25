<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/insert">
		<input type="text" name="data1">
		<input type="text" name="data2">
		<input type="submit">
	</form>
	<!-- 
		/Calc 요청을 받아오는 servlet class(B.java) 생성
		덧셈에 대한 결과(result) 만들어서, c.jsp 결과 result 출력
	 -->
	 
	 <!-- 
		/insert 요청을 받아오는 servelt Insert class 생성
		각각 데이터 받아와서, db insert -> result "추가성공" or "추가실패"
		mybatis, test.xml 신규파일 생성
	 	그 결과, c.jsp 에서 result 출력
	  -->
	  
</body>
</html>













