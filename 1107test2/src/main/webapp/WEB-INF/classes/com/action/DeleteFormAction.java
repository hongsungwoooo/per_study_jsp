package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.Action;

public class DeleteFormAction implements Action{

    @Override
    public String execute(HttpServletRequest request,HttpServletResponse response) throws Throwable {

        HttpSession session = request.getSession();
        if(session.getAttribute("memId") == null)
            return "/view2/loginForm.jsp";
            
        return "/view2/deleteForm.jsp";
    }
}