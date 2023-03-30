package com.servlet;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.OrderDao;
import com.object.Order;
import com.object.User;

import java.io.*;
public class OrderServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		User activeUser=(User)session.getAttribute("activeUser");
		PrintWriter out=response.getWriter();
		String customerName=request.getParameter("name");
		String items=request.getParameter("allProducts");
		String email=request.getParameter("email");
		String contactNumber=request.getParameter("contactNumber");
		String paymentMode=request.getParameter("paymentMode");
		String total=request.getParameter("totalBillAmount");
		String userId=activeUser.getUserID();
		Order order=new Order();
		order.setCustomerName(customerName);
		order.setContactNumber(contactNumber);
		order.setEmail(email);
		order.setPaymentMode(paymentMode);
		order.setItems(items);
		order.setTotal(total);
		order.setUserID(userId);
		OrderDao.saveOrder(order);
		session.setAttribute("message","Order Placed successfully !!! Wait for admin approval.");
		response.sendRedirect("manageOrder.jsp");
		return;
	}
}
