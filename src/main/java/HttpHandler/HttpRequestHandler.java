package HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import DriverAdapter.DatabaseDriverConsole;
import DriverAdapter.DriverAdapter;
import DriverAdapter.QueryExecutionService;
import Holders.Holder;
import Holders.HolderToXml;

public class HttpRequestHandler implements HttpHandler 
{
	private static final String 
		REQUEST_TYPE_HEADER_KEY = "Get-request-type",
		QUERY_TYPE = "Query",
		UPDATE_TYPE = "Update",
		TABLE_METADATA_TYPE = "TableMetadata",
		INSERT_TYPE = "Insert";
	
	@Override
	public void handle(HttpExchange exchange) throws IOException 
	{
		Headers h = exchange.getRequestHeaders();
		InputStream is = exchange.getRequestBody();
		String result = readFromInputStreamToString(is);
		
		String response = "This is the response " + "\n";
		response += getRequestHeaderAsString(h);

		String responseXml = execute(h, result);
		
		exchange.sendResponseHeaders(200, response.length() + responseXml.length());
		OutputStream os = exchange.getResponseBody();
		os.write(response.getBytes());
		os.write(responseXml.getBytes());
		os.close();
	}
	
	private static String execute(Headers h, String result)
	{
		String responseXml = "";
		if(h.containsKey(REQUEST_TYPE_HEADER_KEY))
		{
			try {
				if(h.get(REQUEST_TYPE_HEADER_KEY).contains(QUERY_TYPE))
				{
					ArrayList<ArrayList<Holder>> holders = executeQuery(result);
					responseXml = HolderToXml.holdersToXml(holders);
					System.out.println(responseXml);
				}
				else if(h.get(REQUEST_TYPE_HEADER_KEY).contains(UPDATE_TYPE) || 
						h.get(REQUEST_TYPE_HEADER_KEY).contains(INSERT_TYPE))
				{
					executeUpdate(result);
				}
				else if(h.get(REQUEST_TYPE_HEADER_KEY).contains(TABLE_METADATA_TYPE))
				{
					ArrayList<Holder> holders = executeTableMetadata(result);
					responseXml = HolderToXml.holderToXml(holders);
					System.out.println(responseXml);
				}
			} catch(SQLException se) {
				se.printStackTrace();
				DriverAdapter.databaseDriverConsole.setError(se.getMessage());
			}
		}
		
		return responseXml;
	}
	
	public static ArrayList<ArrayList<Holder>> executeQuery(String query) throws SQLException
	{
		return QueryExecutionService.collectResults(query);
	}
	
	public static void execute(String query)
	{
		QueryExecutionService.execute(query);
	}
	
	public static void executeUpdate(String query)
	{
		QueryExecutionService.executeInsertUpdate(query);
	}
	
	public static ArrayList<Holder> executeTableMetadata(String query) throws SQLException
	{
		return QueryExecutionService.getTableDefinition(query);
	}
	
	private static String readFromInputStreamToString(InputStream is)
	{
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String result = br.lines().collect(Collectors.joining("\n"));
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			DriverAdapter.databaseDriverConsole.setError(e.getMessage());
		}
		return result;
	}
	
	private static String getRequestHeaderAsString(Headers h)
	{
		String retResponse = "";
		for(String key : h.keySet())
		{
			retResponse += "[KEY] " + key + " ---> ";
			List<String> headers = h.get(key);
			for(String s : headers)
				retResponse += "[VALUE] " + s + "\n";
		}
		return retResponse;
	}

}
