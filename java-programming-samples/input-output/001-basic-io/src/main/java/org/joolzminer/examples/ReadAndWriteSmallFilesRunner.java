package org.joolzminer.examples;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ReadAndWriteSmallFilesRunner {
	public static void main(String[] args) {
		System.out.println("*** writing small text file:");
		Path textFile = Paths.get("C:/Users/sergio.f.gonzalez/git/Java-Programming-Repo/"
				+ "java-programming-samples/input-output/001-basic-io/src/test/"
				+ "resources/speech.txt");
		String[] lineStrings = { "Easy read and write", "with java.nio.file.Files" };
		List<String> lines = Arrays.asList(lineStrings);
		try {
			Files.write(textFile, lines, Charset.forName("UTF-8"));
		} catch (IOException e) {
			System.out.println("Exception writing small text file: " + e);
		}
		
		System.out.println("*** reading small text file:");
		List<String> linesRead = null;
		try {
			linesRead = Files.readAllLines(textFile, Charset.forName("UTF-8"));
		} catch (IOException e) {
			System.out.println("Exception reading small text file: " + e);
		}
		
		if (linesRead != null) {
			for (String line : linesRead) {
				System.out.println(line);
			}
		}
	}
}
