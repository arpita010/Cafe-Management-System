package com.servlet;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;

import com.dao.ProductDao;
public class EditProductServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String operation=request.getParameter("operation");
		HttpSession session=request.getSession();
		if(operation.trim().equals("editProduct"))
		{
			String productID=request.getParameter("productID");
			String newName=request.getParameter("newName");
			String newPrice=request.getParameter("newPrice");
			String newDescription=request.getParameter("newDescription");
			ProductDao.editProduct(productID, newName, newPrice, newDescription);
			session.setAttribute("message", "Product edited successfully!");
		}
		else if(operation.trim().equals("deleteProduct"))
		{
			String productID=request.getParameter("productID");
			ProductDao.deleteProduct(productID);
			session.setAttribute("message", "Product deleted successfully!");
		}
		response.sendRedirect("manageProduct.jsp");
		return;
	}
}
