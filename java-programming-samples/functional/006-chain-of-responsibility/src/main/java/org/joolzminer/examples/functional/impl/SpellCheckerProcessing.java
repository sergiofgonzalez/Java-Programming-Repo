package org.joolzminer.examples.functional.impl;

import org.joolzminer.examples.functional.ProcessingObject;

public class SpellCheckerProcessing extends ProcessingObject<String>{

	@Override
	protected String handleWork(String text) {
		return text.replaceAll("dilemna", "dilemma");
	}

}
