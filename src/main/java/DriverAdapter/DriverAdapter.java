package DriverAdapter;

import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

import HttpHandler.HttpRequestHandler;

public class DriverAdapter 
{
	public static String 
		dbUrl = null,
		user = null,
		pass = null;
	public static String [] 
		databasePaths = null;
	public static int portNumber = -1;
	
	private static String 
		regexAlias = "[a-zA-Z]*.db";
	
	public static void main(String [] args)
	{
		if(args.length == 4)
		{
			dbUrl = args[0];
			user = args[1];
			pass = args[2];
			portNumber = Integer.parseInt(args[3]);
		}
		else if(args.length == 3)
		{
			dbUrl = args[0];
			portNumber = Integer.parseInt(args[1]);
			databasePaths = args[2].split(":");
		}
		else
		{
			System.out.println(
				"Enter options \n" +
				"[database url] (required) \n" +
				"[user] \n" +
				"[password] \n" +
				"[port number] (required)\n"
			);
			return;
		}
		
		listenHttp();
		System.out.println(System.getProperty("user.dir"));
		
		for(String db : databasePaths)
		{
			HttpRequestHandler.execute("ATTACH DATABASE '" + db + "' AS " + getDatabaseAlias(db) + ";");
		}
	}
	
	private static String getDatabaseAlias(String dbPath)
	{
		return StringUtility.getMatches(dbPath, regexAlias).get(0).replace(".db", "");
	}
	
	@SuppressWarnings("restriction")
	public static void listenHttp()
	{
		try {
			HttpServer server = HttpServer.create(new InetSocketAddress(portNumber), 0);
	        server.createContext("/", new HttpRequestHandler());
	        server.setExecutor(null); // Use the default executor
	        server.start();
	        System.out.println("Server is running on port " + portNumber);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
