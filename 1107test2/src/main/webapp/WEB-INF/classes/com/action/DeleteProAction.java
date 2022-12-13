package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.Action;
import com.dao.MemberDao;

public class DeleteProAction implements Action{

    @Override
    public String execute(HttpServletRequest request,HttpServletResponse response) throws Throwable {
        
        request.setCharacterEncoding("utf-8");
        
        //1. �α��� ���� üũ
        HttpSession session =request.getSession();
        if(session.getAttribute("memId")==null)
            return"/view2/loginForm.jsp";
        
        //2. session���� id�� �����ذ� ���۹��� ��й�ȣ��
        
        String id =(String)session.getAttribute("memId");
        String passwd = request.getParameter("passwd");
                
        //     memberDao�� userCheck �� ����
        MemberDao manager = MemberDao.getInstance();
        int check = manager.userCheck(id, passwd);
        
        //3. check 1�� ��� deleteMember �޼ҵ忡 id ����
        if(check== 1){
            manager.deleteMember(id);
            session.invalidate();
        }           
        
        //4. check�� request�� ����
        request.setAttribute("check", check);
        
        return "/view2/deletePro.jsp";
    }
}