package com.koreait.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc2")
public class MyServlet2 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) 
			throws ServletException, IOException {

		// application 저장소 선언
		ServletContext application = arg0.getServletContext();
		
		PrintWriter out = arg1.getWriter();
		
		String value_ = arg0.getParameter("value");
		String op = arg0.getParameter("operator");
		
		System.out.println("value : " + value_);
		System.out.println("op : " + op);
		
		int value = 0;
		
		if( !value_.equals("") ) {
			value = Integer.parseInt(value_);
		}
		
		// 계산
		if( op.equals("=") ) {
			System.out.println(" = 조건 도착");
			int x = (int) application.getAttribute("value");
			int y = value;
			String operator = (String) application.getAttribute("op");
			
			int result = 0;
			
			if( operator.equals("+") ) {
				result = x + y;
			} else {	// '-'
				result = x - y;
			}
			
			out.println("결과 값 : " + result);
			
		} else {	// + or -, 값 저장
			System.out.println(" else 조건 도착");
			application.setAttribute("value", value);
			application.setAttribute("op", op);
		}
	}
}













