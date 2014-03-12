package org.joolzminer.examples;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ReadWebResourceUsingURLConnectionDemo {
	public static void main(String[] args) {		
		try {
			URL url = new URL("http://google.com");
			URLConnection urlConnection = url.openConnection();
			Map<String, List<String>> headers = urlConnection.getHeaderFields();
			
			System.out.println("*** response headers: ");
			for (Entry<String, List<String>> header : headers.entrySet()) {
				System.out.println(header.getKey() + "=" + header.getValue());
			}
			System.out.println();
			
			System.out.println("*** response body:");			
			InputStream inputStream = urlConnection.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String line = bufferedReader.readLine();
			while (line != null) {
				System.out.println(line);
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
			
		} catch (IOException e) {
			System.out.println("Error reading web resource: " + e);
			System.exit(1);
		}
	}
}
