package org.joolzminer.examples.webserver;

import java.io.IOException;
import java.io.InputStream;

public class Request {
	private InputStream in;
	private String uri;
	
	public Request(InputStream in) {
		this.in = in;
	}
	
	public void parse() {
		StringBuilder request = new StringBuilder(2048);
		byte[] buffer = new byte[2048];
		int i;
		try {
			i = in.read(buffer);
		} catch (IOException e) {
			System.out.println("Error reading request (stack trace follows): ");
			e.printStackTrace();
			i = -1;
		}
		
		for (int j = 0; j < i; j++) {
			request.append((char)buffer[j]);
		}
		System.out.println(request.toString());
		uri = parseUri(request.toString());		
	}
	
	private String parseUri(String request) {
		int i1, i2;
		i1 = request.indexOf(' ');
		if (i1 != -1) {
			i2 = request.indexOf(' ', i1 + 1);
			if (i2 > i1) {
				return request.substring(i1 + 1, i2);
			}
		}
		return null;
	}
	
	public String getUri() {
		return uri;
	}
}
