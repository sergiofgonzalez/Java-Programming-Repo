package org.joolzminer.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



interface Incrementable {
	void increment();
}

class Callee implements Incrementable {
	private static final Logger LOGGER = LoggerFactory.getLogger(Callee.class);
	
	private int i = 0;
	
	@Override
	public void increment() {
		i++;
		LOGGER.info("value of i incremented: i = {}", i);
	}
	
	private class Closure implements Incrementable {

		@Override
		public void increment() {
			Callee.this.increment();
		}		
	}

	public Incrementable getCallbackReference() {
		return new Closure();
	}
}


class Caller {
	private Incrementable callbackReference;
	
	public Caller(Incrementable incrementableCallbackReference) {
		this.callbackReference = incrementableCallbackReference;
	}
	
	public void doIncrementThroughCallbackReference() {
		callbackReference.increment();
	}
}

public class Callbacks {
	public static void main(String[] args) {
		Callee callee = new Callee();
		System.out.println("*** Incrementing callee directly");
		callee.increment();
		
		Caller caller = new Caller(callee.getCallbackReference());
		System.out.println("*** Incrementing callee through callback");
		caller.doIncrementThroughCallbackReference();
	}
}