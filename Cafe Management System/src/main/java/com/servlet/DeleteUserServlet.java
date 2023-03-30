package com.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.UserDao;
public class DeleteUserServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String userID=request.getParameter("userID");
		HttpSession session=request.getSession();
		UserDao.deleteUser(userID);
		session.setAttribute("message", "User Deleted Successfully!!!");
		response.sendRedirect("manageUser.jsp");
		return;
	}
}
