package com.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import com.dao.BillDao;
import com.dao.OrderDao;
import com.object.Order;
public class ApproveOrderServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String orderId=request.getParameter("orderId");
		BillDao.saveBill(orderId);
		OrderDao.deleteOrder(orderId);
		session.setAttribute("message","Order Approved Successfully");
		response.sendRedirect("manageOrderAdmin.jsp");
		return;
	}
}
