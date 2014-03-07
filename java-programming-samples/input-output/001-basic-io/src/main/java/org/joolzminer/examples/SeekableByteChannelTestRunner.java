package org.joolzminer.examples;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SeekableByteChannelTestRunner {
	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(12);
		System.out.println("buffer.position=" + buffer.position());
		
		System.out.println("*** putting an int in the buffer:");
		buffer.putInt(10);
		System.out.println("buffer.position=" + buffer.position());
		
		System.out.println("*** putting a long in the buffer:");
		buffer.putLong(1234567890L);
		System.out.println("buffer.position=" + buffer.position());
		
		System.out.println("*** rewinding buffer and displaying contents:");
		buffer.rewind();
		System.out.println("buffer.position=" + buffer.position());
		System.out.println("buffer.getInt=" + buffer.getInt());
		System.out.println("buffer.getLong=" + buffer.getLong());
		System.out.println("buffer.position=" + buffer.position());
		
		System.out.println("*** rewinding again:");
		buffer.rewind();
		System.out.println("buffer.position=" + buffer.position());
		
		
		Path path = Paths.get("C:\\temp\\channel.bin");
		try (SeekableByteChannel byteChannel = Files.newByteChannel(path, 
														StandardOpenOption.CREATE, 
														StandardOpenOption.READ, 
														StandardOpenOption.WRITE)) {
			System.out.println("*** Writing on byte channel: ");
			System.out.println("byteChannel.position=" + byteChannel.position());
			byteChannel.write(buffer);
			System.out.println("byteChannel.position=" + byteChannel.position());
			
			System.out.println("*** Reading from byte channel: ");
			ByteBuffer readBuffer = ByteBuffer.allocate(40);
			byteChannel.position(0);
			byteChannel.read(readBuffer);
			readBuffer.rewind();
			System.out.println("readBuffer.getInt=" + readBuffer.getInt());
			System.out.println("readBuffer.getLong=" + readBuffer.getLong());
		} catch (IOException e) {
			System.out.println("Error reading/writing from byte channel: " + e);
		}
	}
}
