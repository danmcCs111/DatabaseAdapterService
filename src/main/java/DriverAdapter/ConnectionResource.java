package DriverAdapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionResource 
{
	private Connection 
		conn = null;
	private boolean 
		isRunning = false;
	
	public ConnectionResource()
	{
		try {
			buildConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setRunningState(boolean running)
	{
		this.isRunning = running;
	}
	
	public boolean isRunning()
	{
		return this.isRunning;
	}
	
	public Connection getConnection()
	{
		return conn;
	}
	
	public void buildConnection() throws SQLException
	{
		Connection con = (DriverAdapter.user != null)
				? DriverManager.getConnection(DriverAdapter.dbUrl, DriverAdapter.user, DriverAdapter.pass)
				: DriverManager.getConnection(DriverAdapter.dbUrl);
		conn = con;
	}
}
