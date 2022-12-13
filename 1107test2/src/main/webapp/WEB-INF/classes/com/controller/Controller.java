package com.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
           
public class Controller extends HttpServlet {
      
    private Map commandMap = new HashMap();//��ɾ�� ��ɾ� ó�� Ŭ������ ������ ����

    //��ɾ�� ó��Ŭ������ ���εǾ� �ִ� properties ������ �о Map��ü�� commandMap�� ����
    //��ɾ�� ó��Ŭ������ ���εǾ� �ִ� properties ������ Command.properties����
    public void init(ServletConfig config) throws ServletException {
        String configFile = config.getInitParameter("configFile");
        Properties prop = new Properties();
        FileInputStream fis = null;
        try {
            String configFilePath = config.getServletContext().getRealPath(
                      configFile);
            fis = new FileInputStream(configFilePath);
            prop.load(fis);
        } catch (IOException e) {
            throw new ServletException(e);
        } finally {
            if (fis != null)
                try {
                    fis.close();
                } catch (IOException ex) {
                }
        }
        Iterator keyIter = prop.keySet().iterator();
        while (keyIter.hasNext()) {
            String command = (String) keyIter.next();
            String handlerClassName = prop.getProperty(command);
            try {
                Class handlerClass = Class.forName(handlerClassName);
                Object handlerInstance = handlerClass.newInstance();
                commandMap.put(command, handlerInstance);
            } catch (ClassNotFoundException e) {
                throw new ServletException(e);
            } catch (InstantiationException e) {
                throw new ServletException(e);
            } catch (IllegalAccessException e) {
                throw new ServletException(e);
            }
        }
    }

    public void doGet(//get����� ���� �޼ҵ�
        HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        requestPro(request, response);
    }

    protected void doPost(//post����� ���� �޼ҵ�
        HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        requestPro(request, response);
    }

    //�ÿ����� ��û�� �м��ؼ� �ش� �۾��� ó��
    private void requestPro(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        String view = null;
        Action com=null;
        
        try {
            String command = request.getRequestURI();
            if (command.indexOf(request.getContextPath()) == 0) {
               command = command.substring(request.getContextPath().length());
            }
            com = (Action)commandMap.get(command); 
            view = com.execute(request, response);
        } catch(Throwable e) {
            throw new ServletException(e);
        }   
        RequestDispatcher dispatcher =request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
}