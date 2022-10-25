<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원가입 폼</h3>
	<form action="join" method="post" id="joinForm">
		아이디 		: <input type="text" name="userid" id="userid"/><br>
		비밀번호 		: <input type="password" name="userpw" id="userpw"/><br>
		이름 		: <input type="text" name="username" id="username"/><br>
		휴대폰 번호 	: <input type="text" name="userphone" id="userphone"/><br>
		<br>
		<input type="button" value="회원가입" onclick="sendit()">	
	</form>
</body>
<script>
	function sendit(){
		let frm = document.getElementById("joinForm");
		
		// id값으로 접근 
		let idTag = document.getElementById("userid");
		let pwTag = document.getElementById("userpw");
		
		// name속성으로 접근
		let nameTag = frm.username;
		let phoneTag = frm.userphone;
		
		if( idTag.value == "" ){
			alert("아이디를 입력해주세요!");
			idTag.focus();
			return false;
		}
		
		if( pwTag.value == "" ){
			alert("비밀번호를 입력해주세요!");
			pwTag.focus();
			return false;
		}
		
		if( pwTag.value.length < 8 ){
			alert("비밀번호는 8자리 이상으로 입력하세요!");
			pwTag.focus();
			return false;
		}
		
		if( nameTag.value == "" ){
			alert("이름을 입력하세요!");
			nameTag.focus();
			return false;
		}
		
		if( phoneTag.value == "" ){
			alert("휴대폰 번호를 입력하세요!");
			phoneTag.focus();
			return false;
		}
		
		frm.submit();
	}
</script>
</html>














