package com.servlet;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.BillDao;

import java.io.*;
public class DeleteBillServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String billNumber=request.getParameter("billNumber");
		BillDao.deleteBill(billNumber);
		HttpSession session=request.getSession();
		session.setAttribute("message","Bill deleted successfully!");
		response.sendRedirect("viewBill.jsp");
		return;
	}
}
