package org.joolzminer.examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyAndMoveFilesRunner {
	public static void main(String[] args) {
		
		System.out.println("*** Copying/Replacing File:");
		Path source = Paths.get("C:/Users/sergio.f.gonzalez/git/Java-Programming-Repo/"
				+ "java-programming-samples/input-output/001-basic-io/src/test/"
				+ "resources/CAS Modeler Sketch.jpg");
		Path target = Paths.get(source.getParent().toString(), "Copy of CAS Modeler Sketch.jpg");
		
		try {
			System.out.println("source=" + source);
			System.out.println("target=" + target);
			Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			System.out.println("Exception caught while copying the file: " + e);
		}
		
		System.out.println("*** Moving File:");
		source = target;
		target = Paths.get(source.getParent().toString(), "moved.jpg");
		try {
			System.out.println("source=" + source);
			System.out.println("target=" + target);
			Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			System.out.println("Exception caught while moving the file: " + e);
		}		
	}
}
