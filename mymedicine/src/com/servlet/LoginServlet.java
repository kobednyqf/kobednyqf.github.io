package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.DB;
import com.model.User;
 
 

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String username = req.getParameter("username");//�û�����������ձ�
		String password = req.getParameter("password");//���룬���ձ�
		if(username!=null)
		username = new String(username.getBytes("ISO-8859-1"),"UTF-8");//�������봦��
		if(password!=null)
		password = new String(password.getBytes("ISO-8859-1"),"UTF-8");//�������봦��
		 
		 DB db=new DB(); 
			String sql ="select * from user where username='"+username+"' and password='"+password+"'";
			String[] userStrs=db.getStr(sql);//�����û����������ȡ�û���Ϣ
		if( userStrs!=null){
			User user = new User(userStrs[0],userStrs[1]);
		  req.getSession().setAttribute("user", user);
		  req.getRequestDispatcher("/index.jsp").forward(req, resp);  //�����ض���ʽ
		}
		else{
		req.getRequestDispatcher("/loginFail.jsp").forward(req, resp);
		}
	}

}
