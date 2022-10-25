package com.koreait.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/eltest")
public class ElTest extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) 
			throws ServletException, IOException {
		
		arg0.setAttribute("result", "짝수");
		
		String[] names = {"abc","def"};
		arg0.setAttribute("names", names);
		
		Map<String, Object> notice
			= new HashMap<>();
		notice.put("id", 1);
		notice.put("title", "el study");
		arg0.setAttribute("notice", notice);
		
		
		RequestDispatcher dispatcher
			= arg0.getRequestDispatcher("/el/el_test.jsp");
		dispatcher.forward(arg0, arg1);
	}
}














