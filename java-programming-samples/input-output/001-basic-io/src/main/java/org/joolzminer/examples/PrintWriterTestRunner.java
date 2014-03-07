package org.joolzminer.examples;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class PrintWriterTestRunner {
	public static void main(String[] args) {
		Path path = Paths.get("c:\\temp\\printWriterOutput.txt");
		Charset usAsciiCharset = Charset.forName("US-ASCII");
		try (	BufferedWriter bufferedWriter = Files
					.newBufferedWriter(path,usAsciiCharset, StandardOpenOption.CREATE);
				PrintWriter printWriter = new PrintWriter(bufferedWriter);) {
			printWriter.println("PrintWriter is so easy to use");
			printWriter.print(1234);
		} catch (IOException e) {
			System.out.println("Error writing to file: " + e);
		}
	}
}
