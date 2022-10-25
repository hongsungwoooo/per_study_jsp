<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
		Connection conn = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password = "jsp";
		
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
	
		String sql = "SELECT * FROM car";
		/*
			1	Benz	Black	10000000
			2	Benz	Black	20000000
			3	K7		White	70000000
			4	K7		White	70000000
		*/
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		
		while(rs.next()){
			out.println("차 번호 : " + rs.getString(1) + "<br>");
			out.println("브랜드 : " + rs.getString("BRAND") + "<br>");
			out.println("색상 : " + rs.getString(3) + "<br>");
			out.println("가격 : " + rs.getInt("PRICE") + "원<br>");
		}
		
		out.println("<br><hr>");
		String carnum = "3";
		//sql = "SELECT 	* FROM 	CAR WHERE 	CARNUM  =  '" + carnum + "'";
		sql = "SELECT color FROM 	CAR WHERE 	CARNUM  =  ? ";
		pstm = conn.prepareStatement(sql);
		
		pstm.setString(1, carnum);
		
		rs = pstm.executeQuery();
		
		if( rs.next() ){
			out.println("컬러 : " + rs.getString(1));
		}
		
		// close 반납
		rs.close();
		pstm.close();
		conn.close();
		
	
	%>
</body>
</html>














