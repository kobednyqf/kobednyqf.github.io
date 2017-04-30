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
		String username = req.getParameter("username");//用户名，这里接收表单
		String password = req.getParameter("password");//密码，接收表单
		if(username!=null)
		username = new String(username.getBytes("ISO-8859-1"),"UTF-8");//中文乱码处理
		if(password!=null)
		password = new String(password.getBytes("ISO-8859-1"),"UTF-8");//中文乱码处理
		 
		 DB db=new DB(); 
			String sql ="select * from user where username='"+username+"' and password='"+password+"'";
			String[] userStrs=db.getStr(sql);//根据用户名和密码获取用户信息
		if( userStrs!=null){
			User user = new User(userStrs[0],userStrs[1]);
		  req.getSession().setAttribute("user", user);
		  req.getRequestDispatcher("/index.jsp").forward(req, resp);  //请求重定向方式
		}
		else{
		req.getRequestDispatcher("/loginFail.jsp").forward(req, resp);
		}
	}

}
