package org.joolzminer.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClientDemo {
	public static void main(String[] args) {

		System.out.println("*** Establishing connection to localhost:1234...");
		try (	Socket socket = new Socket("localhost", 1234);
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
			
			System.out.println("*** writing message: ");
			out.println("Hello from client!!");
			String inputLine = in.readLine();
			if (inputLine != null) {
				System.out.println("response received: " + inputLine);
			}
			
			
			out.println("OK, I'll disconnect now sending the 'bye' command!");
			inputLine = in.readLine();
			if (inputLine != null) {
				System.out.println("response received: " + inputLine);
			}
			
			out.println("bye");
			inputLine = in.readLine();
			if (inputLine != null) {
				System.out.println("response received: " + inputLine);
			}
			
		} catch (IOException e) {
			System.out.println("Exception caught in client (is server running?): " + e);
		}
		
		System.out.println("*** client finished!");
	}
}
