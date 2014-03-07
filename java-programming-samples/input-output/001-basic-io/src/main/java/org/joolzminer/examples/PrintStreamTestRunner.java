package org.joolzminer.examples;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class PrintStreamTestRunner {
	public static void main(String[] args) {
		Path logFile = Paths.get("C:\\temp\\debug.txt");
		try (	OutputStream outputStream = Files.newOutputStream(logFile, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
				PrintStream printStream = new PrintStream(outputStream, true);) {
			System.setOut(printStream);
			System.out.println("This will be sent to file");
		} catch (IOException e) {
			System.out.println("Error redirecting System.out to file: " + e);
		}
	}
}
