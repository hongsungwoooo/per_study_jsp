package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
//��û �Ķ���ͷ� ��ɾ �����ϴ� ����� ���� �������̽�
public interface Action {
    public String execute(HttpServletRequest request,HttpServletResponse response)throws Throwable;
}