package org.joolzminer.examples;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImageSearchTask implements Runnable {

	private static final Logger LOGGER = LoggerFactory.getLogger(ImageSearchTask.class);
	
	private Path searchDir;
	private Executor executor;
	private DefaultListModel<String> listModel;
	private AtomicInteger fileCounter;

	public ImageSearchTask(Path searchDir, Executor executor,
			DefaultListModel<String> listModel, AtomicInteger fileCounter) {
		this.searchDir = searchDir;
		this.executor = executor;
		this.listModel = listModel;
		this.fileCounter = fileCounter;
	}

	@Override
	public void run() {
		if (fileCounter.get() > ExecutorDemo.MAX_RESULTS) {
			return;
		}
		
		try (DirectoryStream<Path> children = Files.newDirectoryStream(searchDir)) {
			for (final Path child : children) {
				if (Files.isDirectory(child)) {
					executor.execute(new ImageSearchTask(child, executor, listModel, fileCounter));
				} else if (Files.isRegularFile(child)) {
					String name = child.getFileName().toString().toLowerCase();
					if (name.endsWith(".jpg")) {
						final int fileNumber = fileCounter.getAndIncrement();
						if (fileNumber > ExecutorDemo.MAX_RESULTS) {
							break;
						}
						SwingUtilities.invokeLater( new Runnable() {
							
							@Override
							public void run() {
								listModel.addElement(fileNumber + ": " + child);
							}
						});
					}
				}
			}
		} catch (IOException e) {
			LOGGER.error("Error crawling directory", e);			
		}		
	}
}
