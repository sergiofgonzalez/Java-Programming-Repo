package org.joolzminer.examples;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BinaryStreamCopyRunner {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(BinaryStreamCopyRunner.class);
	
	public void copyFiles(Path originPath, Path destinationPath) throws IOException {
		if (Files.notExists(originPath)) {
			throw new NoSuchFileException("origin file must exist");
		}
		if (Files.exists(destinationPath)) {
			throw new FileAlreadyExistsException("destination file must not exist");
		}
		
		byte[] readData = new byte[1024];
		try (	BufferedInputStream in = new BufferedInputStream(Files.newInputStream(originPath, StandardOpenOption.READ));
				BufferedOutputStream out = new BufferedOutputStream(Files.newOutputStream(destinationPath, StandardOpenOption.CREATE_NEW))) {
			int readBytes = in.read(readData);
			while (readBytes != -1) {
				out.write(readData, 0, readBytes);
				readBytes = in.read(readData);
			}
			
		} catch (IOException e) {
			LOGGER.error("error copying files: {} -> {}, {}", e);
			throw e;
		}
	}
	
	public static void main(String[] args) {
		BinaryStreamCopyRunner binaryStreamCopyRunner = new BinaryStreamCopyRunner();
		Path origin = Paths.get("C:/Users/sergio.f.gonzalez/git/Java-Programming-Repo/java-programming-samples/input-output/001-basic-io/src/test/resources/CAS Modeler Sketch.jpg");
		Path destination = Paths.get("C:/Users/sergio.f.gonzalez/git/Java-Programming-Repo/java-programming-samples/input-output/001-basic-io/src/test/resources/CAS Modeler Sketch.copy.jpg");
		
		try {
			binaryStreamCopyRunner.copyFiles(origin, destination);
		} catch (IOException e) {
			System.out.println("Could not perform copy: " + e);
		}
	}
}
