package com.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.Action;
import com.dao.MemberDao;
import com.domain.Member;

public class ModifyProAction implements Action{

    @Override
    public String execute(HttpServletRequest request,HttpServletResponse response) throws Throwable {

        //1.�α��� ���� ����
        HttpSession session =request.getSession();
        if(session.getAttribute("memId")==null)
            return"/view/loginForm.jsp";
        
        //2.���ڵ�ó��
        request.setCharacterEncoding("utf-8");
        
        //3.�ڹٺ��� �����ϰ� �ڹٺ� ���۵� �����͸� ����
        Member member =new Member();
        member.setId((String)session.getAttribute("memId"));
        member.setName(request.getParameter("name"));
        member.setPasswd(request.getParameter("passwd"));
        member.setJumin1(request.getParameter("jumin1"));
        member.setJumin2(request.getParameter("jumin2"));
        member.setEmail(request.getParameter("email"));
        member.setBlog(request.getParameter("blog"));  
        member.setReg_date(new Timestamp(System.currentTimeMillis()));
        
        //4.MemberDao�� updateMember �޼ҵ忡 �ڹٺ� ����
        MemberDao manager = MemberDao.getInstance();
        manager.updateMember(member);
        
        return "/view2/modifyPro.jsp";
    }
}
