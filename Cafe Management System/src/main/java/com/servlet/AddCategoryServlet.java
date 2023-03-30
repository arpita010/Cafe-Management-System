package com.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import com.dao.CategoryDao;
import java.io.*;
public class AddCategoryServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String cName=request.getParameter("name");
		HttpSession session=request.getSession();
		boolean existence=CategoryDao.checkCategoryExistence(cName);
		if(existence)
		{
			session.setAttribute("message","Category Already Exist!!");
		}else {
		CategoryDao.addCategory(cName);
		session.setAttribute("message", "Category added successfully!");
		}
		response.sendRedirect("manageCategory.jsp");
		return;
	}
}
