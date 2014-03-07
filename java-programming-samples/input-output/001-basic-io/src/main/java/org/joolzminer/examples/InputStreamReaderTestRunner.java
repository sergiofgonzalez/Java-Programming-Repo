package org.joolzminer.examples;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class InputStreamReaderTestRunner {
	public static void main(String[] args) {
		System.out.println("*** writing Chinese characters into file:");
		char[] chars = new char[2];
		chars[0] = '\u4F60'; // 你
		chars[1] = '\u597D'; // 好
		Path textFile = Paths.get("c:\\temp\\myFile.txt");
		Charset chineseSimplifiedCharset = Charset.forName("GB2312");
		
		try (OutputStreamWriter writer = new OutputStreamWriter(
				Files.newOutputStream(textFile, 
						StandardOpenOption.CREATE), chineseSimplifiedCharset)) {
			writer.write(chars);
		} catch (IOException e) {
			System.out.println("Error writing file: " + e);
			System.exit(1);
		}			
	
		System.out.println("*** Reading file:");
		try (	InputStream inputStream = Files.newInputStream(textFile, StandardOpenOption.READ);
				InputStreamReader reader = new InputStreamReader(inputStream, chineseSimplifiedCharset);) {
			char[] readChars = new char[2];
			reader.read(readChars);
			System.out.println(readChars[0]);
			System.out.println(readChars[1]);
		} catch (IOException e) {
			System.out.println("Error reading file: " + e);
			System.exit(1);
		}
	}
}
