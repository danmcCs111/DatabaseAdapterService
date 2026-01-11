package DriverAdapter;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.net.httpserver.HttpServer;

import HttpHandler.HttpRequestHandler;

public class DriverAdapter 
{
	public static String 
		dbUrl = null,
		user = null,
		pass = null;
	public static int portNumber = -1;
	
	public static void main(String [] args)
	{
		if(args.length == 4)
		{
			dbUrl = args[0];
			user = args[1];
			pass = args[2];
			portNumber = Integer.parseInt(args[3]);
		}
		else if(args.length == 1)
		{
			dbUrl = args[0];
			portNumber = Integer.parseInt(args[1]);
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
	}
	
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
