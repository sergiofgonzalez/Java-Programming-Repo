package org.joolzminer.examples;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LowerCaseConverterInputStream extends FilterInputStream {

	protected LowerCaseConverterInputStream(InputStream in) {
		super(in);
	}

	@Override
	public int read() throws IOException {
		int c = super.read();
		if (c != -1) {
			c = Character.toLowerCase(c);
		}
		return c;
	}

	@Override
	public int read(byte[] buffer) throws IOException {
		int bytesRead = super.read(buffer);
		for (int i = 0; i < bytesRead; i++) {
			buffer[i] = (byte) Character.toLowerCase(buffer[i]);
		}
		return bytesRead;
	}

	@Override
	public int read(byte[] buffer, int off, int len) throws IOException {
		int bytesRead = super.read(buffer, off, len);
		for (int i = 0; i < bytesRead; i++) {
			buffer[off + i] = (byte) Character.toLowerCase(buffer[off + i]);
		}
		
		return bytesRead;
	}	
}
