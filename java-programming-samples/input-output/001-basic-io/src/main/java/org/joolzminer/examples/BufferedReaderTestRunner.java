package org.joolzminer.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BufferedReaderTestRunner {
	public static void main(String[] args) {
		Path thisFile = Paths.get("C:/Users/sergio.f.gonzalez/git/"
								+ "Java-Programming-Repo/java-programming-samples/"
								+ "input-output/001-basic-io/src/main/java/org/"
								+ "joolzminer/examples/BufferedReaderTestRunner.java");
		
		try (BufferedReader bufferedReader = Files
					.newBufferedReader(thisFile, Charset.forName("UTF-8"));) {
			String line = bufferedReader.readLine();
			while (line != null) {
				System.out.println(line);
				line = bufferedReader.readLine();				
			}
		} catch (IOException e) {
			System.out.println("Error reading file: " + e);
		}
	}
}
