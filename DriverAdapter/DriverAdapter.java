package DriverAdapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverAdapter 
{
	public static String 
		DB_URL = "jdbc:mysql://localhost/videodatabase",
		USER = "newuser",
		PASS = "free-12345+";
	
	public static void main(String [] args)
	{
		callSelect();
	}
	
	public static void callSelect() 
	{
		Connection conn = null;
		try {
	    	conn = DriverManager.getConnection(DB_URL, USER, PASS);
	    	TableDefinitions.collectTableDefinition(VideoSelect.getSelectQuery());
	    	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
