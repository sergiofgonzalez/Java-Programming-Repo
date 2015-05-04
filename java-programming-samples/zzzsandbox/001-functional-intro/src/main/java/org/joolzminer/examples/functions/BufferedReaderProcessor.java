package org.joolzminer.examples.functions;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderProcessor {
	String process(BufferedReader bufferedReader) throws IOException;
}
