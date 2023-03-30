package com.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.UserDao;
public class ForgotPasswordServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String newPassword=request.getParameter("newPassword");
		HttpSession session=request.getSession();
		if(!UserDao.checkUserExistence(email))
		{
			session.setAttribute("message","We have not find any data related to you..Register yourself first!");
		}
		else {
		UserDao.updatePassword(email, newPassword);
		session.setAttribute("message", "Password updated succesfully..");
		}
		response.sendRedirect("index.jsp");
		return;
	}
}
