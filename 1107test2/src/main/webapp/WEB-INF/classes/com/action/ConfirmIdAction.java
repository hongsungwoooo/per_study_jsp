package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Action;
import com.dao.MemberDao;

public class ConfirmIdAction implements Action{

    @Override
    public String execute(HttpServletRequest request,HttpServletResponse response) throws Throwable {

        String id =request.getParameter("id");
        MemberDao manager = MemberDao.getInstance();
        int check=manager.confirmId(id);
        
        request.setAttribute("check", new Integer(check));
        request.setAttribute("id", id);
        
        return "/view2/confirmId.jsp";
    }
}