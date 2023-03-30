package com.dao;
import java.sql.*;
import java.util.*;
import com.object.Order;
public class OrderDao {
	public static void deleteOrderOfSpecificUser(String userID)
	{
		String query="delete from orders where userID=?";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1, userID);
			pr.execute();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void deleteOrder(String orderId)
	{
		String query="delete from orders where OrderId=?";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1,orderId);
			pr.execute();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static Order getOrder(String orderID)
	{
		Order order=new Order();
		String query="select * from orders where orderID=?";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1, orderID);
			ResultSet rs=pr.executeQuery();
			while(rs.next())
			{
				order.setOrderID(rs.getString(1));
				order.setCustomerName(rs.getString(2));
				order.setContactNumber(rs.getString(3));
				order.setEmail(rs.getString(4));
				order.setPaymentMode(rs.getString(5));
				order.setItems(rs.getString(6));
				order.setTotal(rs.getString(7));
				order.setUserID(rs.getString(8));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return order;
	}
	public static void saveOrder(Order order)
	{
		String query="insert into orders(CustomerName,ContactNumber,Email,PaymentMode,Items,Total,userID) values(?,?,?,?,?,?,?);";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1,order.getCustomerName());
			pr.setString(2, order.getContactNumber());
			pr.setString(3,order.getEmail());
			pr.setString(4, order.getPaymentMode());
			pr.setString(5, order.getItems());
			pr.setString(6, order.getTotal());
			pr.setString(7, order.getUserID());
			pr.execute();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static List<Order> getOrderList()
	{
		List<Order> list=new ArrayList<>();
		String query="select * from orders;";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			ResultSet rs=pr.executeQuery();
			while(rs.next())
			{
				Order order=new Order();
				order.setOrderID(rs.getString(1));
				order.setCustomerName(rs.getString(2));
				order.setContactNumber(rs.getString(3));
				order.setEmail(rs.getString(4));
				order.setPaymentMode(rs.getString(5));
				order.setItems(rs.getString(6));
				order.setTotal(rs.getString(7));
				order.setUserID(rs.getString(8));
				list.add(order);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public static List<Order> getSpecificUserOrderList(String userID)
	{
		List<Order> list=new ArrayList<>();
		String query="select * from orders where userID=?;";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1, userID);
			ResultSet rs=pr.executeQuery();
			while(rs.next())
			{
				Order ord=new Order();
				ord.setOrderID(rs.getString(1));
				ord.setCustomerName(rs.getString(2));
				ord.setContactNumber(rs.getString(3));
				ord.setEmail(rs.getString(4));
				ord.setPaymentMode(rs.getString(5));
				ord.setItems(rs.getString(6));
				ord.setTotal(rs.getString(7));
				ord.setUserID(rs.getString(8));
				list.add(ord);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
}
