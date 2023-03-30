package com.dao;
import java.sql.*;
import com.object.Order;
import com.object.Bill;
import java.util.*;
public class BillDao {
	public static void deleteBill(String billNumber)
	{
		String query="delete from bills where BillNumber=?";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1, billNumber);
			pr.execute();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void deleteBills(String userID)
	{
		String query="delete from bills where UserId=?";
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
	
	public static void saveBill(String orderId)
	{
		Order order=OrderDao.getOrder(orderId);
		String query="insert into bills(OrderID,CustomerName,ContactNumber,Email,PaymentMode,Items,Total,UserId) values(?,?,?,?,?,?,?,?);";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1,orderId);
			pr.setString(2, order.getCustomerName());
			pr.setString(3,order.getContactNumber());
			pr.setString(4, order.getEmail());
			pr.setString(5, order.getPaymentMode());
			pr.setString(6, order.getItems());
			pr.setString(7, order.getTotal());
			pr.setString(8, order.getUserID());
			pr.execute();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static List<Bill> specficUserBillList(String userID)
	{
		List<Bill> list=new ArrayList<>();
		String query="select * from bills where UserId=?";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1,userID);
			ResultSet rs=pr.executeQuery();
			while(rs.next())
			{
				Bill bill =new Bill();
				bill.setBillNumber(rs.getString(1));
				bill.setOrderID(rs.getString(2));
				bill.setCustomerName(rs.getString(3));
				bill.setContactNumber(rs.getString(4));
				bill.setEmail(rs.getString(5));
				bill.setPaymentMode(rs.getString(6));
				bill.setItems(rs.getString(7));
				bill.setTotal(rs.getString(8));
				bill.setUserID(rs.getString(9));
				list.add(bill);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}

		return list;
	}
	public static List<Bill> getAllBillList()
	{
		List<Bill> list=new ArrayList<>();
		String query="select * from bills";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			ResultSet rs=pr.executeQuery();
			while(rs.next())
			{
				Bill bill =new Bill();
				bill.setBillNumber(rs.getString(1));
				bill.setOrderID(rs.getString(2));
				bill.setCustomerName(rs.getString(3));
				bill.setContactNumber(rs.getString(4));
				bill.setEmail(rs.getString(5));
				bill.setPaymentMode(rs.getString(6));
				bill.setItems(rs.getString(7));
				bill.setTotal(rs.getString(8));
				bill.setUserID(rs.getString(9));
				list.add(bill);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public static String getTotalBills()
	{
		String total="";
		String query="select count(*) from bills";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			ResultSet rs=pr.executeQuery();
			while(rs.next())
			{
				total=rs.getString(1);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return total;
	}
	public static String countSpecificUserBills(String userID)
	{
		String total="";
		String query="select count(*) from bills where UserId=?";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1,userID);
			ResultSet rs=pr.executeQuery();
			while(rs.next())
			{
				total=rs.getString(1);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return total;
	}
	public static Bill getBill(String billNumber)
	{
		String query="select * from bills where BillNumber=?";
		Bill bill=new Bill();
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1, billNumber);
			ResultSet rs=pr.executeQuery();
			while(rs.next())
			{
				bill.setBillNumber(rs.getString(1));
				bill.setOrderID(rs.getString(2));
				bill.setCustomerName(rs.getString(3));
				bill.setContactNumber(rs.getString(4));
				bill.setEmail(rs.getString(5));
				bill.setPaymentMode(rs.getString(6));
				bill.setItems(rs.getString(7));
				bill.setTotal(rs.getString(8));
				bill.setUserID(rs.getString(9));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return bill;
	}
}
