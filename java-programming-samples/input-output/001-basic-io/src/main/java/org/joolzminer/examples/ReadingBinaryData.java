package org.joolzminer.examples;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ReadingBinaryData {
	public static void main(String[] args) {
		
		System.out.println("*** read():");
		
		Path thisFile = Paths.get("C:/Users/sergio.f.gonzalez/git/"
				+ "Java-Programming-Repo/java-programming-samples/input-output/"
				+ "001-basic-io/src/main/java/org/joolzminer/examples/"
				+ "ReadingBinaryData.java");
		
		try (BufferedInputStream bufferedInputStream = new BufferedInputStream(
				Files.newInputStream(thisFile, StandardOpenOption.READ))) {
			int i = bufferedInputStream.read();
			while (i != -1) {
				byte b = (byte) i;
				System.out.println(b + ", ");
				i = bufferedInputStream.read();
			}
		} catch (IOException e) {
			System.out.println("Error reading binary file: " + e);
		}
		
		System.out.println("*** read(byte[]):");
		byte[] fileContents = new byte[16];
		try (BufferedInputStream bufferedInputStream = new BufferedInputStream(
				Files.newInputStream(thisFile, StandardOpenOption.READ))) {
			int readBytes = bufferedInputStream.read(fileContents);
			while (readBytes != -1) {				
				for (int i = 0; i < readBytes; i++) {
					System.out.print((byte)fileContents[i] + ", ");
				}
				System.out.println();
				readBytes = bufferedInputStream.read(fileContents);
			}
		} catch (IOException e) {
			System.out.println("Error reading binary file: " + e);
		}
		
		System.out.println("*** read(byte[], int, int");
		byte[] wholeFileContents = new byte[10 * 1024];
		int totalSize = 0;
		try (BufferedInputStream bufferedInputStream = new BufferedInputStream(
				Files.newInputStream(thisFile, StandardOpenOption.READ))) {
			int numBlocks = 0;
			int readBytes = bufferedInputStream.read(wholeFileContents, numBlocks, 16);
			totalSize = readBytes; 
			while (readBytes != -1) {				
				numBlocks++;
				readBytes = bufferedInputStream.read(wholeFileContents, numBlocks * 16, 16);
				totalSize += readBytes;
			}
		} catch (IOException e) {
			System.out.println("Error reading binary file: " + e);
		}
		
		for (int i = 0; i < totalSize; i++) {
			System.out.print((byte)wholeFileContents[i] + ", ");
			if (i % 15 == 0) {
				System.out.println();
			}
		}
	}
}
