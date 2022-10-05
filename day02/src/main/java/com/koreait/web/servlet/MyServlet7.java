package com.koreait.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class MyServlet7 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) 
			throws ServletException, IOException {
		
		String xStr = arg0.getParameter("x");
		String yStr = arg0.getParameter("y");
		String op= arg0.getParameter("operator");
		
		
		int x = 0;
		int y = 0;
		
		if( !xStr.equals("")) {
			x= Integer.parseInt(xStr);
		}
		if( !yStr.equals("")) {
			y= Integer.parseInt(yStr);
		}
		
		
		
		int result = 0;
		
//		switch(op) {
//		case "덧셈" : result = x + y; break;
//		case "뺄셈" : result = x - y; break;
//		case "곱셈" : result = x * y; break;
//		}
//      switch문도 가능

		if(op.equals("덧셈")){
			result = x + y;
		} else if(op.equals("뺄셈")) {
			result = x - y;
		} else if(op.equals("곱샘")) {
			result = x * y;
		}
		
		
		arg1.getWriter().println("결과는 : "+ result);
		
	}
	
	
}
