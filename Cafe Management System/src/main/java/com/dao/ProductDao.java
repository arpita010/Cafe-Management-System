package com.dao;
import java.util.*;
import java.sql.*;
import com.object.Product;
public class ProductDao {
	public static void editProduct(String productID,String newName,String newPrice,String newDesc)
	{
		String query="update products set Name=?,Price=?,Description=? where PID=?;";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1,newName);
			pr.setString(2, newPrice);
			pr.setString(3, newDesc);
			pr.setString(4, productID);
			pr.execute();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void deleteProduct(String productId)
	{
		String query="delete from products where PID=?";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1,productId);
			pr.execute();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void addProduct(Product product)
	{
		String query="insert into products(Name,Category,Price,Description,cID) values(?,?,?,?,?);";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1, product.getName());
			pr.setString(2,product.getCategory());
			pr.setString(3,product.getPrice());
			pr.setString(4, product.getDescription());
			pr.setString(5, product.getcID());
			pr.execute();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static HashMap<String,String> getProductsOfSameCategory(String category)
	{
		HashMap<String,String> map=new HashMap<>();
		String query="select * from products where Category=?";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1, category);
			ResultSet rs=pr.executeQuery();
			while(rs.next())
			{
				Product product=new Product();
				product.setPID(rs.getString(1));
				product.setName(rs.getString(2));
				product.setCategory(rs.getString(3));
				product.setPrice(rs.getString(4));
				product.setDescription(rs.getString(5));
				product.setcID(rs.getString(6));
				map.put(product.getName(),product.getPrice());
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return map;
		
	}
	public static boolean checkProductExistence(String name,String category)
	{
		String query="select PID from products where Name=? and Category=?;";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1, name);
			pr.setString(2, category);
			ResultSet rs=pr.executeQuery();
			if(rs.next())
				return true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public static String getTotalProducts()
	{
		String total="";
		String query="select count(*) from products";
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
	public static List<Product> getAllProducts()
	{
		List<Product> list=new ArrayList<Product>();
		String query="select * from products";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			ResultSet rs=pr.executeQuery();
			while(rs.next())
			{
				Product product=new Product();
				product.setPID(rs.getString(1));
				product.setName(rs.getString(2));
				product.setCategory(rs.getString(3));
				product.setPrice(rs.getString(4));
				product.setDescription(rs.getString(5));
				product.setcID(rs.getString(6));
				list.add(product);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
}
