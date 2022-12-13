package com.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Action;
import com.dao.MemberDao;
import com.domain.Member;

public class InputProAction implements Action{

    @Override
    public String execute(HttpServletRequest request,HttpServletResponse response) throws Throwable {
        
        //1.���ڵ�ó��
        request.setCharacterEncoding("utf-8");
        
        //2.request���� ���۵� �����͸� ����        
        //3.�ڹٺ� ������ ����        
        Member member =new Member();
        member.setId(request.getParameter("id"));
        member.setName(request.getParameter("name"));
        member.setPasswd(request.getParameter("passwd"));
        member.setJumin1(request.getParameter("jumin1"));
        member.setJumin2(request.getParameter("jumin2"));
        member.setEmail(request.getParameter("email"));
        member.setBlog(request.getParameter("blog"));       
        member.setReg_date(new Timestamp(System.currentTimeMillis()));
        
        //4.MemberDao�� insertMember �޼ҵ� ȣ��
        MemberDao manager = MemberDao.getInstance();
        manager.insertMember(member);
        
        return "/view2/inputPro.jsp";
    }
}