package org.joolzminer.examples;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class OutputStreamWriterTestRunner {
	public static void main(String[] args) {
		System.out.println("*** Converting UTF-8 chinese characters to GB2312 chars in file:");
		char[] chars = new char[2];
		chars[0] = '\u4F60'; // 你
		chars[1] = '\u597D'; // 好
		Path path = Paths.get("c:\\temp\\myFile.txt");
		Charset chineseSimplifiedCharset = Charset.forName("GB2312");
		
		try (OutputStreamWriter writer = new OutputStreamWriter(
				Files.newOutputStream(path, 
						StandardOpenOption.CREATE), chineseSimplifiedCharset)) {
			writer.write(chars);
		} catch (IOException e) {
			System.out.println("Error writing file: " + e);
			System.exit(1);
		}		
		
		System.out.println("*** Writing UTF-8 chinese characters directly to file:");
		Charset utf8Charset = Charset.forName("UTF-16");
		Path path2 = Paths.get("c:\\temp\\myfile-utf16.txt");
		try (OutputStreamWriter writer = new OutputStreamWriter(
				Files.newOutputStream(path2, 
						StandardOpenOption.CREATE), utf8Charset)) {
			writer.write(chars);
		} catch (IOException e) {
			System.out.println("Error writing file: " + e);
			System.exit(1);
		}			
	}
}
