package com.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class TestServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println();
		HttpSession session=request.getSession();
		session.setAttribute("field",request.getParameter("field"));
		RequestDispatcher rd=request.getRequestDispatcher("manageOrder.jsp");
		rd.include(request, response);
	}
}
