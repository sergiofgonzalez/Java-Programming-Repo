package org.joolzminer.examples.functional.impl;

import org.joolzminer.examples.functional.ProcessingObject;

public class HeaderTextProcessing extends ProcessingObject<String> {

	@Override
	protected String handleWork(String text) {
		return "From Raoul, Mario and Alan:\n\n" + text;
	}

}
