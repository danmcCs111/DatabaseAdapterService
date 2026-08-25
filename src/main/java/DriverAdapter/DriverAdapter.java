package DriverAdapter;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.net.httpserver.HttpServer;

import Holders.Holder;
import HttpHandler.HttpRequestHandler;

public class DriverAdapter 
{
	public static String 
		dbUrl = null,
		user = null,
		pass = null;
	public static String [] 
		databasePaths = null;
	public static int 
		portNumber = -1;
	private static String 
		regexAlias = "[a-zA-Z]*.db";
	
	public static DatabaseDriverConsole 
		databaseDriverConsole;
	public static boolean
		isReadOnlyInMemory = false;
	
	public static void main(String [] args) throws IOException
	{
		if(args.length == 3)
		{
			dbUrl = args[0];
			portNumber = Integer.parseInt(args[1]);
			databasePaths = args[2].split(",");
		}
		else if(args.length == 4)
		{
			dbUrl = args[0];
			portNumber = Integer.parseInt(args[1]);
			databasePaths = args[2].split(",");
			isReadOnlyInMemory = Boolean.parseBoolean(args[3]);
			
		}
		else
		{
			System.out.println(
				"Enter options \n" +
				"[database url] (required) \n" +
				"[port number] (required)\n" + 
				"[database paths] (required)" +
				"<load as memory read-only> (optional default false)"
			);
			return;
		}
		
		listenHttp();
		
		if(!isReadOnlyInMemory)
		{
			for(String db : databasePaths)
			{
				File f = new File(db);
				String dbPath = f.getCanonicalPath();
				String alias = getDatabaseAlias(db);
				System.out.println(dbPath + " " + alias);
				
				HttpRequestHandler.execute("ATTACH DATABASE '" + dbPath + "' AS " + alias + ";");
			}
		}
		else
		{
			for(String db : databasePaths)
			{
				File f = new File(db);
				String dbPath = f.getCanonicalPath();
				String alias = getDatabaseAlias(db);
				System.out.println(dbPath + " " + alias);
				
				HttpRequestHandler.execute("ATTACH DATABASE '" + dbPath + " ' AS " + alias + ";");
				//copy to ram
				String sql = "SELECT name FROM " + alias + ".sqlite_master WHERE type='table';";
				try {
					ArrayList<ArrayList<Holder>> hldrs = HttpRequestHandler.executeQuery(sql);
					for(ArrayList<Holder> hlds : hldrs)
					{
						for(Holder h : hlds)
						{
							HttpRequestHandler.executeUpdate("CREATE TABLE " + h.getReturnValueString() +
									" AS SELECT * FROM " + alias + "." + h.getReturnValueString());
						}
					}
					HttpRequestHandler.executeUpdate("DETACH DATABASE " + alias);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				HttpRequestHandler.executeUpdate("restore from " + dbPath);
				
			}
			
		}
		
		
		databaseDriverConsole = new DatabaseDriverConsole();
		databaseDriverConsole.setStatus("Connected.");
	}
	
	private static String getDatabaseAlias(String dbPath)
	{
		return StringUtility.getMatches(dbPath, regexAlias).get(0).replace(".db", "");
	}
	
	public static void listenHttp()
	{
		try {
			HttpServer server = HttpServer.create(new InetSocketAddress(portNumber), 
					QueryExecutionService.NUMBER_OF_HTTP_CONNECTIONS);
	        server.createContext("/", new HttpRequestHandler());
	        server.setExecutor(null); // Use the default executor
	        server.start();
	        System.out.println("Server is running on port " + portNumber);
		} catch (IOException e) {
			e.printStackTrace();
			databaseDriverConsole.setError(e.getMessage());
			System.exit(0);
		}
	}
}
