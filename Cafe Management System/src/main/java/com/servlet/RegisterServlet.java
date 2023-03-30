package com.servlet;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.UserDao;
import com.object.User;

import java.io.*;
public class RegisterServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String contactNumber=request.getParameter("contactNumber");
		String password=request.getParameter("password");
		String userType=request.getParameter("userType");
		String adminCard="";
		HttpSession session=request.getSession();
		if(UserDao.checkUserExistence(email))
		{
			session.setAttribute("message", "User already exist! Try with another email!!!");
		}else {
		User newUser=new User();
		newUser.setName(name);
		newUser.setContactNumber(contactNumber);
		newUser.setEmail(email);
		newUser.setPassword(password);
		newUser.setUserType(userType);
		UserDao.registerUser(newUser);
		if(userType.equals("admin")) {
			adminCard=request.getParameter("adminCard");
			String userID=UserDao.getUserID(email);
			newUser.setUserID(userID);
			newUser.setAdminCard(adminCard);
			UserDao.registerAdmin(newUser);	
		}
		session.setAttribute("message", "You have registered succesfully..");
		}
		response.sendRedirect("index.jsp");
	}
}
