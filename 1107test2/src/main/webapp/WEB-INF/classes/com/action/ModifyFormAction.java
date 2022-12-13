package com.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.Action;
import com.dao.MemberDao;
import com.domain.Member;

public class ModifyFormAction implements Action{

    @Override
    public String execute(HttpServletRequest request,HttpServletResponse response) throws Throwable {

        //1. �α��� ���� ����
        HttpSession session =request.getSession();
        if(session.getAttribute("memId")==null)
            return"/view/loginForm.jsp";

        //2.session�� ����� id ȣ��        
        String id = (String)session.getAttribute("memId");  
            
        //3.MemberDao�� getMember �޼��忡 id ����
        MemberDao manager = MemberDao.getInstance();
        Member member = manager.getMember(id);        
        
        //4.��ȯ����  Member�� request�� ����
        request.setAttribute("member", member);
        
        return "/view2/modifyForm.jsp";
    }
}