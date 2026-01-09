package DriverAdapter;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.net.httpserver.HttpServer;

import Holders.Holder;
import HttpHandler.HttpRequestHandler;

public class DriverAdapter 
{
	public static String 
		dbUrl,
		user,
		pass;
	public static int portNumber;
	
	public static void main(String [] args)
	{
		if(args.length != 4)
		{
			System.out.println(
					"Enter options \n" +
					"database url \n" +
					"user \n" +
					"password \n" +
					"port number \n"
			);
			return;
		}
		dbUrl = args[0];
		user = args[1];
		pass = args[2];
		portNumber = Integer.parseInt(args[3]);
		
		listenHttp();
	}
	
	public static ArrayList<ArrayList<Holder>> callSelect(String query) 
	{
		Connection conn = null;
		ArrayList<ArrayList<Holder>> retHolders = null;
		try {
	    	conn = DriverManager.getConnection(dbUrl, user, pass);
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
			conn = DriverManager.getConnection(dbUrl, user, pass);
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
