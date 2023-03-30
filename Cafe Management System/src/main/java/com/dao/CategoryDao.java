package com.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.object.Category;
public class CategoryDao {
	public static void editCategory(String newName,String oldName)
	{
		String query="update category set Name=? where Name=?;";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1, newName);
			pr.setString(2,oldName);
			pr.execute();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void deleteCategory(String catID)
	{
		String query="delete from category where CategoryID=?";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1, catID);
			pr.execute();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void addCategory(String name)
	{
		//check existence of category;
		String query="insert into category(Name) values(?);";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1, name);
			pr.execute();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static boolean checkCategoryExistence(String name)
	{
		String query="select * from category where Name='"+name+"'";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			ResultSet rs=pr.executeQuery();
			if(rs.next())
				return true;//category already exist;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public static String getCID(String name)
	{
		String cID="";
		String query="select CategoryID from category where Name=?;";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1, name);
			ResultSet rs=pr.executeQuery();
			while(rs.next())
			{
				cID=rs.getString(1);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return cID;
	}
	public static String getTotalCategories()
	{
		String total="";
		String query="select count(*) from category";
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
	public static List<Category> getAllCategories()
	{
		List<Category> list=new ArrayList<>();
		String query="select * from category";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			ResultSet rs=pr.executeQuery();
			while(rs.next())
			{
				Category cat=new Category();
				cat.setcID(rs.getString(1));
				cat.setcName(rs.getString(2));
				list.add(cat);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public static List<String> getAllCategoriesName()
	{
		List<String> list=new ArrayList<>();
		String query="select * from category";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			ResultSet rs=pr.executeQuery();
			while(rs.next())
			{
				Category cat=new Category();
				cat.setcID(rs.getString(1));
				cat.setcName(rs.getString(2));
				list.add(cat.getcName());
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
		
	}
}
