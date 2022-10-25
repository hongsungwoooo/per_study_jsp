<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="object_ok.jsp" name="joinForm">
		<fieldset>
			<legend>개인정보</legend>
			<input type="text" name="username" />		
			<input type="text" name="userid" />
			<input type="button" value="확인" onclick="sendit();">
		</fieldset>
	</form>
</body>
<script>
	function sendit(){
		let joinForm = document.joinForm;
		let nameTag = joinForm.username;
		let idTag = joinForm.userid;
		
		if( nameTag.value == "" ){
			alert("이름을 입력하세요!");
			nameTag.focus();
			return false;
		}
		
		if( idTag.value == "" ){
			alert("아이디를 입력하세요!");
			idTag.focus();
			return false;
		}
		
		joinForm.submit();
	}
</script>
</html>




















