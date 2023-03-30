package com.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import com.dao.UserDao;
import com.object.User;

import java.io.*;
public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		if(UserDao.validateLogin(email, password))
		{
			User user=UserDao.getUser(email, password);
			session.setAttribute("activeUser",user);
			response.sendRedirect("dashboard.jsp");
		}
		else
		{
			session.setAttribute("message","Invalid Login Credentials!Try again!!");
			response.sendRedirect("index.jsp");
		}
		return;
	}
}
