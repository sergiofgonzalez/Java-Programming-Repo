package org.joolzminer.examples;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LowerCaseConverterInputStreamIntegrationTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LowerCaseConverterInputStreamIntegrationTest.class);
	
	private Path filePath = Paths.get("C:/Users/sergio.f.gonzalez/git/"
			+ "Java-Programming-Repo/java-programming-samples/"
			+ "patterns/006-decorator-java-io/src/main/java/org/"
			+ "joolzminer/examples/LowerCaseConverterInputStream.java");

	
	@Test
	public void testReadByte() {
		try (LowerCaseConverterInputStream reader = 
				new LowerCaseConverterInputStream(Files.newInputStream(filePath, StandardOpenOption.READ))) {
			int byteRead;
			while ((byteRead = reader.read()) != -1) {
				System.out.print((char)byteRead);
			}
		} catch (IOException e) {
			LOGGER.error("Error: ", e);
		}
	}
	
	@Test
	public void testReadByteBuffer() {
		try (LowerCaseConverterInputStream reader = 
				new LowerCaseConverterInputStream(Files.newInputStream(filePath, StandardOpenOption.READ))) {			
			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = reader.read(buffer)) != -1) {
				for (int i = 0; i < bytesRead; i++) {
					System.out.print((char)buffer[i]);
				}
			}
		} catch (IOException e) {
			LOGGER.error("Error: ", e);
		}
	}
	
	@Test
	public void testReadByteBufferOffset() {
		try (LowerCaseConverterInputStream reader = 
				new LowerCaseConverterInputStream(Files.newInputStream(filePath, StandardOpenOption.READ))) {			
			byte[] buffer = new byte[16*1024];
			int bytesRead;
			int offset = 0;
			while ((bytesRead = reader.read(buffer, offset, 100)) != -1) {
				offset += bytesRead;
			}
			
			for (int i = 0; i <= offset; i++) {
				System.out.print((char) buffer[i]);
			}
			
		} catch (IOException e) {
			LOGGER.error("Error: ", e);
		}
	}
	
	// With Buffering
	@Test
	public void testReadByteWithBuffering() {
		try (LowerCaseConverterInputStream reader = 
				new LowerCaseConverterInputStream(
						new BufferedInputStream(Files.newInputStream(filePath, StandardOpenOption.READ)))) {
			int byteRead;
			while ((byteRead = reader.read()) != -1) {
				System.out.print((char)byteRead);
			}
		} catch (IOException e) {
			LOGGER.error("Error: ", e);
		}
	}
	
	@Test
	public void testReadByteBufferWithBuffering() {
		try (LowerCaseConverterInputStream reader = 
				new LowerCaseConverterInputStream(
						new BufferedInputStream(Files.newInputStream(filePath, StandardOpenOption.READ)))) {			
			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = reader.read(buffer)) != -1) {
				for (int i = 0; i < bytesRead; i++) {
					System.out.print((char)buffer[i]);
				}
			}
		} catch (IOException e) {
			LOGGER.error("Error: ", e);
		}
	}
	
	@Test
	public void testReadByteBufferOffsetWithBuffering() {
		try (LowerCaseConverterInputStream reader = 
				new LowerCaseConverterInputStream(
						new BufferedInputStream(Files.newInputStream(filePath, StandardOpenOption.READ)))) {			
			byte[] buffer = new byte[16*1024];
			int bytesRead;
			int offset = 0;
			while ((bytesRead = reader.read(buffer, offset, 100)) != -1) {
				offset += bytesRead;
			}
			
			for (int i = 0; i <= offset; i++) {
				System.out.print((char) buffer[i]);
			}
			
		} catch (IOException e) {
			LOGGER.error("Error: ", e);
		}
	}	
}
