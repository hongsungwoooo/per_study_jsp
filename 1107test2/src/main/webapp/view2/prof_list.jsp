<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8" />
	<title>My JSP Page</title>
	<!-- Twitter Bootstrap3 & jQuery -->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" />
	<script src="http://code.jquery.com/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	
	<div class="container">
		<div class="page-header clearfix">
			<h1 class='pull-left'>교수목록</h1>

			<div style='margin-top: 30px' class="pull-right">
				<a href="" class="btn btn-primary">교수추가</a>
			</div>
		</div>
		
		<div style='margin-top: 30px' class="pull-right">
			<a>교수 총 인원수 : 명 </a>
		</div>
		
		<!-- 조회결과를 출력하기 위한 표 시작 -->
		<table class="table">
			<thead>
				<tr>
					<th class="info text-center">교수번호</th>
					<th class="info text-center">이름</th>
					<th class="info text-center">아이디</th>
					<th class="info text-center">직급</th>
					<th class="info text-center">급여</th>
					<th class="info text-center">입사일</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="text-center"></td>
					<td class="text-center">
						<a href=""></a>
					</td>
					<td class="text-center"></td>
					<td class="text-center"></td>
					<td class="text-center"></td>
					<td class="text-center"></td>
				</tr>
			</tbody>
		</table>
		<!--// 조회결과를 출력하기 위한 표 끝  -->
		
		<!-- 페이징 처리 -->
		<table style="border: 0px; width: 900px;">
			<tr align="center" valign="middle">
				<td>
				
				</td>
			</tr>
		</table>
	</div>
</body>
</html>



