package HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import DriverAdapter.DriverAdapter;
import Holders.Holder;
import Holders.HolderToXml;

public class HttpRequestHandler implements HttpHandler 
{
	private static final String 
		REQUEST_TYPE_HEADER_KEY = "Get-request-type",
		QUERY_TYPE = "Query",
		UPDATE_TYPE = "Update";
	
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
			if(h.get(REQUEST_TYPE_HEADER_KEY).contains(QUERY_TYPE))
			{
				ArrayList<ArrayList<Holder>> holders = executeQuery(result);
				responseXml = HolderToXml.holdersToXml(holders);
				System.out.println(responseXml);
			}
			else if(h.get(REQUEST_TYPE_HEADER_KEY).contains(UPDATE_TYPE))
			{
				executeUpdate(result);
			}
		}
		
		return responseXml;
	}
	
	private static ArrayList<ArrayList<Holder>> executeQuery(String query)
	{
		return DriverAdapter.callSelect(query);
	}
	
	private static void executeUpdate(String query)
	{
		DriverAdapter.executeInsertUpdate(query);
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
