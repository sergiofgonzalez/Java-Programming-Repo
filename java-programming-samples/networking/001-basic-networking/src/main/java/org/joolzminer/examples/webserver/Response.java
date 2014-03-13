package org.joolzminer.examples.webserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Response {
	private static final int BUFFER_SIZE = 1024;
	
	private Request request;
	private OutputStream out;
	
	public Response(OutputStream out) {
		this.out = out;
	}

	public void setRequest(Request request) {
		this.request = request;
	}
	
	public void sendStaticResource() throws IOException {
		byte[] bytes = new byte[BUFFER_SIZE];
		Path path = Paths.get(System.getProperty("user.dir"), "webroot", request.getUri());
		if (Files.exists(path)) {
			try (InputStream in = Files.newInputStream(path)) {
				int bytesRead;
				while ((bytesRead = in.read(bytes, 0, BUFFER_SIZE)) != -1) {
					out.write(bytes, 0, bytesRead);
				} 
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			String errorMessage = "HTTP/1.1 404 File Not Found\r\n"
					+ "Content-Type: text/html\r\n"
					+ "Content-Length: 23\r\n"
					+ "<h1>File Not Found</h1>";
			
			out.write(errorMessage.getBytes());
		}
	}
}
