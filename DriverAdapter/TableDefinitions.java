package DriverAdapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import Holders.Holder;

public class TableDefinitions 
{
	private static final String SHOW_COLUMNS_PREFIX_QUERY = "SHOW COLUMNS FROM";
	private static final String [][] DATABASE_AND_TABLES = new String [][] {
			{"VideoDatabase", "Video"}
	};
	private static final HashMap<String, ArrayList<TableDefinition>> tableDefinitions = new HashMap<String, ArrayList<TableDefinition>>();
	
	public static void createTableDefinitions()
	{
		for(String [] databaseAndTable : DATABASE_AND_TABLES)
		{
			try {
				ArrayList<TableDefinition> tds = collectTableDefinition(
						SHOW_COLUMNS_PREFIX_QUERY + " " + 
						databaseAndTable[0] + "." + 
						databaseAndTable[1]
				);
				tableDefinitions.put(databaseAndTable[0] + "_" + databaseAndTable[1], tds);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static ArrayList<TableDefinition> getTableDefinition(String def)
	{
		return tableDefinitions.get(def);
	}
	
	public static ArrayList<TableDefinition> collectTableDefinition(String query) throws SQLException
	{
		ArrayList<TableDefinition> tds = new ArrayList<TableDefinition>();
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
	    			System.out.println(h.getColumnName() + " " + h.callConversion(rs));
	    		}
	    	}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		finally {
			conn.close();
		}
		return tds;
	}
	
	public static String getTableAndDatabase(String s)
	{
		return s.split("_", 2)[1];
	}
	
}
