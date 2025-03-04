package DriverAdapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Holders.Holder;

public class DriverAdapter 
{
	public static String 
		DB_URL = "jdbc:mysql://localhost/videodatabase",
		USER = "newuser",
		PASS = "free-12345+";
	
	
	public static void main(String [] args)
	{
		try {
			callSelect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void callSelect() throws SQLException
	{
		Connection conn = null;
		try {
	    	conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    	Statement stmt = conn.createStatement();
	    	ResultSet rs = stmt.executeQuery(VideoSelect.getSelectQuery());
			while (rs.next()) 
			{
	        	 for(Holder h : VideoSelect.getHolders())
	        	 {
	        		 Object o = h.callConversion(rs);
	        		 System.out.println(h.getColumnName() + "-> " + o);
	        	 }
			}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		finally {
			conn.close();
		}
	}
}
