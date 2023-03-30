package com.dao;
import com.object.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class UserDao {
	public static void updatePassword(String email,String newPassword)
	{
		String query="update users set Password=? where Email=?";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1, newPassword);
			pr.setString(2, email);
			pr.execute();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void editProfile(String userID,String newName,String newContactNumber,String newPassword)
	{
		String query="update users set Name=?,ContactNumber=?,Password=? where UserID=?";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1,newName);
			pr.setString(2,newContactNumber);
			pr.setString(3, newPassword);
			pr.setString(4, userID);
			pr.execute();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void deleteUser(String userID)
	{
		String query="delete from users where UserID=?";
		Connection con=DBConnection.getConnection();
		try
		{
			BillDao.deleteBills(userID);
			OrderDao.deleteOrderOfSpecificUser(userID);
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1,userID);
			pr.execute();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void registerUser(User user)
	{
		String query="insert into Users(Name,ContactNumber,Email,Password,userType) "
				+ "values(?,?,?,?,?);";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1, user.getName());
			pr.setString(2, user.getContactNumber());
			pr.setString(3, user.getEmail());
			pr.setString(4,user.getPassword());
			pr.setString(5, user.getUserType());
			pr.execute();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void registerAdmin(User user)
	{
		String query="insert into admin(userID,CardNumber) values(?,?);";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1,user.getUserID());
			pr.setString(2, user.getAdminCard());
			pr.execute();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static boolean checkUserExistence(String email)
	{
		String query="select UserID from Users where Email=?";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1,email);
			ResultSet rs=pr.executeQuery();
			if(rs.next())
				return true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public static boolean validateLogin(String email,String password)
	{
		String query="select UserId from users where Email=? and Password=?;";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1,email);
			pr.setString(2, password);
			ResultSet rs=pr.executeQuery();
			if(rs.next())
				return true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public static User getUser(String email,String password)
	{
		User user=new User();
		String query="select * from users where Email=? and Password=?";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1,email );
			pr.setString(2, password);
			ResultSet rs=pr.executeQuery();
			while(rs.next())
			{
				user.setUserID(rs.getString(1));
				user.setName(rs.getString(2));
				user.setContactNumber(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setUserType(rs.getString(6));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return user;
	}
	public static List<User> getAllUsers()
	{
		List<User> list=new ArrayList<>();
		String query="select * from Users where userType='normal'";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			ResultSet rs=pr.executeQuery();
			while(rs.next())
			{
				User user=new User();
				user.setUserID(rs.getString(1));
				user.setName(rs.getString(2));
				user.setContactNumber(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setPassword(rs.getString(5));
				list.add(user);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public static String getUserID(String email)
	{
		String userId="";
		String query="select UserID from users where Email=?";
		Connection con=DBConnection.getConnection();
		try
		{
			PreparedStatement pr=con.prepareStatement(query);
			pr.setString(1, email);
			ResultSet rs=pr.executeQuery();
			while(rs.next())
			{
				userId=rs.getString(1);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return userId;
	}
}
