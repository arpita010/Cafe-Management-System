package com.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.UserDao;
public class EditProfileServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String userID=request.getParameter("userID");
		String newName=request.getParameter("newName");
		String newContactNumber=request.getParameter("newContactNumber");
		String newPassword=request.getParameter("newPassword");
		UserDao.editProfile(userID, newName, newContactNumber, newPassword);
		HttpSession session=request.getSession();
		session.setAttribute("message", "Profile updated successfully!Please login again.");
		session.removeAttribute("activeUser");
		response.sendRedirect("index.jsp");
		return;
	}
}
