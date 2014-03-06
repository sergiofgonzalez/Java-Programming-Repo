package org.joolzminer.examples;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class ListDirContentsRunner extends SimpleFileVisitor<Path> {
	
	public static void listDirContents(Path path) {
		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {			
			for (Path directoryPath : directoryStream) {
				System.out.println(directoryPath);
				if (Files.isDirectory(directoryPath)) {
					listDirContents(directoryPath);
				}
			}
		} catch (IOException e) {
			System.out.println("Exception caught while listing directory: " 
					+ path + ":" + e);
		}		
	}
	
	
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			throws IOException {
		System.out.println(file);
		return super.visitFile(file, attrs);
	}



	public static void main(String[] args) {
		
		System.out.println("*** Listing contents of C:/Users/sergio.f.gonzalez");
		Path path = Paths.get("C:/Users/sergio.f.gonzalez");
		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {			
			for (Path directoryPath : directoryStream) {
				System.out.println(directoryPath);
			}
		} catch (IOException e) {
			System.out.println("Exception caught while listing directory: " 
					+ path + ":" + e);
		}
		
		System.out.println("*** Manually listing recursively contents of C:/temp");
		listDirContents(Paths.get("C:/temp"));
		
		System.out.println("*** Using JDK7 API to recursively list contents:");
		try {
			Files.walkFileTree(Paths.get("c:/temp"), new ListDirContentsRunner());
		} catch (IOException e) {
			System.out.println("Exception caught: " + e);
		}
	}
}
