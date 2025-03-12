package HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class HttpRequestHandler implements HttpHandler 
{
	@Override
	public void handle(HttpExchange exchange) throws IOException 
	{
		Headers h = exchange.getRequestHeaders();
		String response = "This is the response " + "\n";
		for(String key : h.keySet())
		{
			response += "[KEY] " + key + " ---> ";
			List<String> headers = h.get(key);
			for(String s : headers)
				response += "[VALUE] " + s + "\n";
		}
		exchange.sendResponseHeaders(200, response.length());
		OutputStream os = exchange.getResponseBody();
		os.write(response.getBytes());
		os.close();
	}

}
