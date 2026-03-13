package DriverAdapter;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Holders.Holder;

public class QueryExecutionService 
{
	private static ArrayList<ConnectionResource> 
		connections = new ArrayList<ConnectionResource>();
	public static int
		RETRY_SLEEP = 10000,//10 seconds
		RETRY_COUNT = 12, //10 * 12 = 120 seconds, 2minutes
		NUMBER_OF_DATABASE_CONNECTIONS = 24,
		NUMBER_OF_HTTP_CONNECTIONS = 150;
	static {
		initConnectionPool();
	}
	
	public static ArrayList<ArrayList<Holder>> collectResults(String query) throws SQLException
	{
		ArrayList<ArrayList<Holder>> retHolders = new ArrayList<ArrayList<Holder>>();
		ArrayList<Holder> retHldrs = new ArrayList<Holder>();
		
		ConnectionResource conn = null;
		try {
			conn = getConnection(RETRY_COUNT);
	    	Statement stmt = conn.getConnection().createStatement();
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
	    	conn.setRunningState(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retHolders;
	}
	
	public static ArrayList<ArrayList<Holder>> callSelect(String query) 
	{
		ArrayList<ArrayList<Holder>> retHolders = null;
		try {
	    	retHolders = QueryExecutionService.collectResults(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retHolders;
	}
	
	public static void execute(String query)
	{
		ConnectionResource conn = null;
		try {
			conn = getConnection(RETRY_COUNT);
			
			Statement stmt = conn.getConnection().createStatement();
			System.out.println(query);
			con:
			for(String q : query.split(";"))
			{
				System.out.println(q);
				try {
					stmt.execute(q);
				}catch(SQLException e) {
					System.out.println("error executing: " + q);
					e.printStackTrace();
					continue con;
				}
			}
			System.out.println("execute update");
			conn.setRunningState(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void executeInsertUpdate(String query)
	{
		ConnectionResource conn = null;
		try {
			conn = getConnection(RETRY_COUNT);
			
			Statement stmt = conn.getConnection().createStatement();
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
			conn.setRunningState(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static String getTableAndDatabase(String s)
	{
		return s.split("_", 2)[1];
	}
	
	private static void initConnectionPool()
	{
		connections = new ArrayList<ConnectionResource>();
		for(int i = 0; i < NUMBER_OF_DATABASE_CONNECTIONS; i++)
		{
			connections.add(new ConnectionResource());
		}
	}
	
	private static ConnectionResource getConnection(int retryCount) throws SQLException
	{
		for(int i = 0; i < NUMBER_OF_DATABASE_CONNECTIONS; i++)
		{
			ConnectionResource cr = connections.get(i);
			if(!cr.isRunning())
			{
				cr.setRunningState(true);
				return cr;
			}
		}
		return getConnection(--retryCount);
	}
	
}
