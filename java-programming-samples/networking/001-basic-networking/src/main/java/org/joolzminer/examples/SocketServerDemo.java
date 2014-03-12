package org.joolzminer.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerDemo {
	public static void main(String[] args) {
		System.out.println("*** Setting up Server on port 1234: ");
		System.out.println("*** waiting for input...");
		try (	ServerSocket serverSocket = new ServerSocket(1234);
				Socket clientSocket = serverSocket.accept();
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); ) {
			
			boolean done = false;
			while (!done) {
				String inputLine = in.readLine();			
				while (inputLine != null) {
					System.out.println("input received: " + inputLine);
					out.println("hi, client, your message '" + inputLine + "' was received.");
					if (inputLine.equals("bye")) {
						done = true;
						break;
					}
					inputLine = in.readLine();
				}				
			}
			
		} catch (IOException e) {
			System.out.println("Error in server: " + e);
		}
		
		System.out.println("*** Server finished!!");
	}
}
