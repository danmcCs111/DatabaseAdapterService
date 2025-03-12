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
		QUERY_TYPE = "Query";
	
	@Override
	public void handle(HttpExchange exchange) throws IOException 
	{
		Headers h = exchange.getRequestHeaders();
		InputStream is = exchange.getRequestBody();
		
		String result = readFromInputStreamToString(is);
		
		String response = "This is the response " + "\n";
		response += getRequestHeaderAsString(h);
		
		boolean isQuery = isQuery(h);
		if(isQuery)
		{
			ArrayList<Holder> holders = executeQuery(result);
			//TODO add to response in format maybe json
			System.out.println(HolderToXml.holdersToXml(holders));
		}
		
		exchange.sendResponseHeaders(200, response.length());
		OutputStream os = exchange.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}
	
	private static boolean isQuery(Headers h)
	{
		if(h.containsKey(REQUEST_TYPE_HEADER_KEY))
		{
			return h.get(REQUEST_TYPE_HEADER_KEY).contains(QUERY_TYPE);
		}
		else 
			return false;
	}
	
	private static ArrayList<Holder> executeQuery(String query)
	{
		return DriverAdapter.callSelect(query);
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
