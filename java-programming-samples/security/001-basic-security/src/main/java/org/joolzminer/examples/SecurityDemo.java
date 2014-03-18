package org.joolzminer.examples;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Run it with the Security Manager enabled  with the default security policy by using:
// -Djava.security.manager

public class SecurityDemo {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityDemo.class);
		
	public static void main(String[] args) {
		Path newFile = Paths.get("c:/temp/newFile.txt");
		try {
			if (Files.exists(newFile)) {
				Files.delete(newFile);
			} else {
				Files.write(newFile, Arrays.asList(new String[]{"hello", "world"}), Charset.forName("UTF-8"));			
			}
		} catch (IOException e) {
			LOGGER.error("IOException caught: ", e);
		} catch (SecurityException e) {
			LOGGER.error("Security exception: ", e);
		}			

	}
}
