package org.joolzminer.examples;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class FileCounterTask implements Callable<Long> {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileCounterTask.class);
	
	private Path dir;
	long fileCount = 0L;
	
	public FileCounterTask(Path dir) {
		this.dir = dir;
	}
	
	private void doCount(Path parent) {
		if (Files.notExists(parent)) {
			return;
		}
		
		try (DirectoryStream<Path> children = Files.newDirectoryStream(parent)) {
			for (Path child : children) {
				if (Files.isDirectory(child)) {
					doCount(child);
				} else if (Files.isRegularFile(child)) {
					fileCount++;
				}
			}
		} catch (IOException e) {
			LOGGER.error("Error crawling directories:", e);
		}	
	}
	
	@Override
	public Long call() throws Exception {
		LOGGER.info("Starting the count: {}", dir);
		doCount(dir);
		LOGGER.info("Finished counting: {}", dir);
		return fileCount;
	}
}

public class FileCounter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FileCounter.class);
	
	public static void main(String[] args) {
		Path[] dirs = { 
				Paths.get("C:/dev-workspaces/functional-programming_workspace"), 
				Paths.get("C:/dev-workspaces/joolzminer_workspace") };
		
		ExecutorService executorService = Executors.newFixedThreadPool(dirs.length);
		
		@SuppressWarnings("unchecked")
		Future<Long>[] results = new Future[dirs.length];
		for (int i = 0; i < dirs.length; i++) {
			Path dir = dirs[i];
			FileCounterTask task = new FileCounterTask(dir);
			results[i] = executorService.submit(task);
		}
		
		
		for (int i = 0; i < dirs.length; i++) {
			long fileCount = 0L;
			try {
				fileCount = results[i].get();
			} catch (InterruptedException | ExecutionException e) {
				LOGGER.error("excuting application: ", e);
			}
			LOGGER.info("{} contains {} file(s)", dirs[i], fileCount);
		}
	}
}
