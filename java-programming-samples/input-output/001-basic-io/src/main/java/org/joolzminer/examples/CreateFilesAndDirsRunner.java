package org.joolzminer.examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateFilesAndDirsRunner {
	public static void main(String[] args) {
		System.out.println("*** creating a file when parent dir does not exist:");
		Path newFile = Paths.get("/home/newFile.txt");
		try {
			Files.createFile(newFile);
		} catch (IOException e) {
			System.out.println("exception: " + e);
		}
		
		System.out.println("*** deleting a file:");
		Path newFile2 = Paths.get("/temp/newFile.txt");
		try {
			Files.deleteIfExists(newFile2);
		} catch (IOException e) {
			System.out.println("exception: " + e);
		}
		
		System.out.println("*** deleting a file when file does not exists:");
		try {
			Files.delete(newFile2);
		} catch (IOException e) {
			System.out.println("exception: " + e);
		}
		
		System.out.println("*** creating a file when parent dir exists:");		
		try {
			Files.createFile(newFile2);
		} catch (IOException e) {
			System.out.println("exception: " + e);
		}
		
		System.out.println("*** creating a file when file already exists:");
		try {
			Files.createFile(newFile2);
		} catch (IOException e) {
			System.out.println("exception: " + e);
		}
		
		
		System.out.println("*** creating a directory:");
		Path newDir = Paths.get("C:\\home");
		try {
			Files.createDirectory(newDir);
		} catch (IOException e) {
			System.out.println("exception: " + e);
		}
		
		System.out.println("*** Removing a non-empty directory:");
		Path newFile3 = Paths.get("C:\\home", "newFile.txt");
		try {
			Files.createFile(newFile3);
			Files.delete(newDir);
		} catch (IOException e) {
			System.out.println("exception: " + e);
		}
		
		System.out.println("*** cleaning up all the mess:");
		try {
			Files.delete(newFile3);
			Files.delete(newDir);
			Files.delete(newFile2);
		} catch (IOException e) {
			System.out.println("exception: could not clean up environment: " + e);
			System.exit(1);
		}
	}
}
