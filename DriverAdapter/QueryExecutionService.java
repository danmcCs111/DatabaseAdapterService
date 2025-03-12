package DriverAdapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Holders.Holder;

public class QueryExecutionService 
{
	public static ArrayList<Holder> collectResults(String query) throws SQLException
	{
		ArrayList<Holder> retHolders = new ArrayList<Holder>();
		Connection conn = null;
		try {
	    	conn = DriverManager.getConnection(DriverAdapter.DB_URL, DriverAdapter.USER, DriverAdapter.PASS);
	    	Statement stmt = conn.createStatement();
	    	ResultSet rs = stmt.executeQuery(query);
	    	ResultSetMetaData rsmd = rs.getMetaData();
	    	
	    	TableDefinition td = new TableDefinition();
	    	for(int i = 0; i < rsmd.getColumnCount(); i++)
	    	{
	    		td.addColumnMetadata(rsmd.getColumnLabel(i+1), rsmd.getColumnClassName(i+1));
	    	}
	    	
	    	while(rs.next())
	    	{
	    		System.out.println(rs.getRow());
	    		for(String s : td.getTableColumnsKeySet())
	    		{
	    			Holder h = td.getHolder(s);
	    			System.out.println(h.getColumnName() + " " + h.callConversion(rs) + " " + h.getClassType().toString());
	    		}
	    	}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		finally {
			conn.close();
		}
		return retHolders;
	}
	
	public static String getTableAndDatabase(String s)
	{
		return s.split("_", 2)[1];
	}
	
}
