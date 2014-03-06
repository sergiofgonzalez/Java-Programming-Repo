package org.joolzminer.examples;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileCompareRunner {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FileCompareRunner.class);
	
	public boolean compareFiles(Path path1, Path path2) throws NoSuchFileException {
		if (Files.notExists(path1)) {
			throw new NoSuchFileException(path1.toString());
		}
		
		if (Files.notExists(path2)) {
			throw new NoSuchFileException(path2.toString());
		}
		
		try {
			if (Files.size(path1) != Files.size(path2)) {
				return false;
			}
		} catch (IOException e) {
			LOGGER.error("error comparing files: {} {}; error={}", path1, path2, e); 
			System.exit(1);
		}
			
		boolean result = true;
		try (BufferedInputStream bufferedInputStream1 = new BufferedInputStream(Files.newInputStream(path1, StandardOpenOption.READ));
				BufferedInputStream bufferedInputStream2 = new BufferedInputStream(Files.newInputStream(path2, StandardOpenOption.READ));) {
			int i1, i2;
			do {
				i1 = bufferedInputStream1.read();
				i2 = bufferedInputStream2.read();
				if (i1 != i2) {
					result = false;
				}
			} while ((result == true) && (i1 != -1));
			result = true;
		} catch (IOException e) {
			LOGGER.error("error comparing files {} vs. {}; error={}", path1, path2, e);
			System.exit(1);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Path path1 = Paths.get("C:/Users/sergio.f.gonzalez/git/Java-Programming-Repo/java-programming-samples/input-output/001-basic-io/src/test/resources/CAS Modeler Sketch.jpg");
		Path path2 = Paths.get("C:/Users/sergio.f.gonzalez/git/Java-Programming-Repo/java-programming-samples/input-output/001-basic-io/src/test/resources/Copy of CAS Modeler Sketch.jpg");
		
		FileCompareRunner fileCompareRunner = new FileCompareRunner();
		try {
			if (fileCompareRunner.compareFiles(path1, path2)) {
				System.out.println("Files are identical");
			} else {
				System.out.println("Files are different");
			}			
		} catch (NoSuchFileException e) {
			System.out.println("files to compare must exist: " + e);
		}
	}
}
