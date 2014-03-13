package org.joolzminer.examples.webserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
	
	private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
	
	private boolean shutdown = false;
	
	public static void main(String[] args) {
		HttpServer httpServer = new HttpServer();
		httpServer.await();
	}
	
	public void await() {
		System.out.println("*** Establishing HTTP Server on 127.0.0.1:8080.");
		try (ServerSocket serverSocket = new ServerSocket(8080, 1, InetAddress.getByName("127.0.0.1"));) {
			while (!shutdown) {
				System.out.println("*** Waiting for connections...");
				try (	Socket clientSocket = serverSocket.accept();
						InputStream in = clientSocket.getInputStream();
						OutputStream out = clientSocket.getOutputStream();) {
					
					System.out.println("*** Request received");
					
					Request request = new Request(in);
					request.parse();
					
					Response response = new Response(out);
					response.setRequest(request);
					response.sendStaticResource();
					
					clientSocket.close();
					
					shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
				} catch (IOException e) {
					e.printStackTrace();
					continue;
				}				
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
