package DriverAdapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Holders.Holder;

public class TableDefinitions 
{
	private static final String SHOW_COLUMNS_PREFIX_QUERY = "SHOW COLUMNS FROM";
	private static final String [][] DATABASE_AND_TABLES = new String [][] {
			{"VideoDatabase", "Video"}
	};
	private static final ArrayList<TableDefinition> tableDefinitions = new ArrayList<TableDefinition>();
	
	
	public static void createTableDefinitions()
	{
		for(String [] databaseAndTable : DATABASE_AND_TABLES)
		{
			try {
				TableDefinition td = collectTableDefinition(SHOW_COLUMNS_PREFIX_QUERY + " " + 
						databaseAndTable[0] + "." + 
						databaseAndTable[1]);
				tableDefinitions.add(td);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static TableDefinition collectTableDefinition(String query) throws SQLException
	{
		TableDefinition td = new TableDefinition();
		Connection conn = null;
		try {
	    	conn = DriverManager.getConnection(DriverAdapter.DB_URL, DriverAdapter.USER, DriverAdapter.PASS);
	    	Statement stmt = conn.createStatement();
	    	ResultSet rs = stmt.executeQuery(query);
	    	ResultSetMetaData rsmd = rs.getMetaData();
	    	
	    	for(int i = 0; i < rsmd.getColumnCount(); i++)
	    	{
	    		td.addColumnAndType(rsmd.getColumnLabel(i+1), rsmd.getColumnClassName(i+1));
	    	}
	    	while(rs.next())
	    	{
	    		System.out.println(rs.getRow());
	    		for(String s : td.getTableColumnsKeySet())
	    		{
	    			Holder h = td.getHolder(s);
	    			System.out.println(h.getColumnName() + " " + h.callConversion(rs));
	    		}
	    		System.out.println();
	    	}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		finally {
			conn.close();
		}
		return td;
	}
}
