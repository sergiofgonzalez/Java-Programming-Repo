package org.joolzminer.examples;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

public class WriteWebResourceUsingURLConnectionDemo {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.google.com/#q=java");
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			PrintWriter out = new PrintWriter(connection.getOutputStream());
			out.println("firstName=John");
			out.println("lastName=Doe");
		} catch (IOException e) {
			System.out.println("Error writing web resource: " + e);
		}
	}
}
