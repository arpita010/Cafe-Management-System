package com.servlet;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.CategoryDao;

import java.io.*;
public class EditCategoryServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String operation=request.getParameter("operation");
		if(operation.trim().equals("editCategory"))
		{
			String oldName=request.getParameter("oldCatName");
			String newName=request.getParameter("newName");
			CategoryDao.editCategory(newName, oldName);
			session.setAttribute("message", "Category edited successfully ! Thank You..");
			
		}
		else if(operation.trim().equals("deleteCategory"))
		{
			String catID=request.getParameter("catID");
			CategoryDao.deleteCategory(catID);
			session.setAttribute("message", "Category deleted successfully! ");
		}
		response.sendRedirect("manageCategory.jsp");
		return;
	}
	
	
}
