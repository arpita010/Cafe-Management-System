package com.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import com.dao.CategoryDao;
import com.dao.ProductDao;
import com.object.Product;
import java.io.*;
import java.util.List;

public class AddProductServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String name=request.getParameter("name");
		String category=request.getParameter("category");
		String price=request.getParameter("price");
		String description=request.getParameter("description");
		if(ProductDao.checkProductExistence(name, category))
		{
			session.setAttribute("message","Product already exist!!!");
		}
		else
		{
			Product product=new Product();
			product.setName(name);
			product.setCategory(category);
			product.setPrice(price);
			product.setDescription(description);
			product.setcID(CategoryDao.getCID(category));
			ProductDao.addProduct(product);
			session.setAttribute("message", "Product Added Successfully!!");
			
		}
		response.sendRedirect("manageProduct.jsp");
		return;
	}
}
