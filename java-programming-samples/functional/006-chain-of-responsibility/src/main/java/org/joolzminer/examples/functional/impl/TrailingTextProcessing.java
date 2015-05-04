package org.joolzminer.examples.functional.impl;

import org.joolzminer.examples.functional.ProcessingObject;

public class TrailingTextProcessing extends ProcessingObject<String>{

	@Override
	protected String handleWork(String text) {
		return text + "\n\nKind regards,\nRaoul, Mario and Alan";
	}

}
