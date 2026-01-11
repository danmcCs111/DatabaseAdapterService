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
	public static ArrayList<ArrayList<Holder>> collectResults(String query) throws SQLException
	{
		ArrayList<ArrayList<Holder>> retHolders = new ArrayList<ArrayList<Holder>>();
		ArrayList<Holder> retHldrs = new ArrayList<Holder>();
		
		Connection conn = null;
		try {
			conn = getConnection();
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
	    		TableDefinition tdC = td.cloneTableDefinition();
	    		retHldrs = new ArrayList<Holder>();
	    		System.out.println(rs.getRow());
	    		for(String s : tdC.getTableColumnsKeySet())
	    		{
	    			Holder h = tdC.getHolder(s);
	    			retHldrs.add(h);
	    			System.out.println(h.getColumnName() + " " + h.callConversion(rs) + " " + h.getClassType().getName());
	    		}
	    		retHolders.add(retHldrs);
	    	}
	    	System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		return retHolders;
	}
	
	public static ArrayList<ArrayList<Holder>> callSelect(String query) 
	{
		Connection conn = null;
		ArrayList<ArrayList<Holder>> retHolders = null;
		try {
			conn = getConnection();
	    	retHolders = QueryExecutionService.collectResults(query);
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
		return retHolders;
	}
	
	public static void executeInsertUpdate(String query)
	{
		Connection conn = null;
		try {
			conn = getConnection();
			
			Statement stmt = conn.createStatement();
			System.out.println(query);
			con:
			for(String q : query.split(";"))
			{
				System.out.println(q);
				try {
					stmt.executeUpdate(q);
				}catch(SQLException e) {
					System.out.println("error executing: " + q);
					continue con;
				}
			}
			System.out.println("execute update");
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
	
	public static String getTableAndDatabase(String s)
	{
		return s.split("_", 2)[1];
	}
	
	private static Connection getConnection() throws SQLException
	{
		return (DriverAdapter.user != null)
				? DriverManager.getConnection(DriverAdapter.dbUrl, DriverAdapter.user, DriverAdapter.pass)
				: DriverManager.getConnection(DriverAdapter.dbUrl);
	}
	
}
