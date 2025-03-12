package DriverAdapter;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.net.httpserver.HttpServer;

import Holders.Holder;
import HttpHandler.HttpRequestHandler;

public class DriverAdapter 
{
	public static String 
		DB_URL = "jdbc:mysql://localhost/videodatabase",
		USER = "newuser",
		PASS = "free-12345+";
	private static int 
		PORT_NUMBER = 8000;
	
	public static void main(String [] args)
	{
		callSelect(VideoSelect.SELECT_SQL);
		listenHttp();
	}
	
	public static ArrayList<ArrayList<Holder>>  callSelect(String query) 
	{
		Connection conn = null;
		ArrayList<ArrayList<Holder>> retHolders = null;
		try {
	    	conn = DriverManager.getConnection(DB_URL, USER, PASS);
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
	
	public static void listenHttp()
	{
		{
			try {
				 HttpServer server = HttpServer.create(new InetSocketAddress(PORT_NUMBER), 0);
		        server.createContext("/", new HttpRequestHandler());
		        server.setExecutor(null); // Use the default executor
		        server.start();
		        System.out.println("Server is running on port " + PORT_NUMBER);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
