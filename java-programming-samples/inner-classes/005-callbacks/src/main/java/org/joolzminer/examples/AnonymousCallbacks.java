package org.joolzminer.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



interface Incrementable2 {
	void increment();
}

class Callee2 implements Incrementable2 {
	private static final Logger LOGGER = LoggerFactory.getLogger(Callee.class);
	
	private int i = 0;
	
	@Override
	public void increment() {
		i++;
		LOGGER.info("value of i incremented: i = {}", i);
	}
	

	public Incrementable2 getCallbackReference() {
		return new Incrementable2() {
			
			@Override
			public void increment() {
				Callee2.this.increment();
			}
		};
	}
}


class Caller2 {
	private Incrementable2 callbackReference;
	
	public Caller2(Incrementable2 incrementable2CallbackReference) {
		this.callbackReference = incrementable2CallbackReference;
	}
	
	public void doIncrementThroughCallbackReference() {
		callbackReference.increment();
	}
}

public class AnonymousCallbacks {
	public static void main(String[] args) {
		Callee2 callee2 = new Callee2();
		System.out.println("*** Incrementing callee2 directly");
		callee2.increment();
		
		Caller2 caller2 = new Caller2(callee2.getCallbackReference());
		System.out.println("*** Incrementing callee2 through callback");
		caller2.doIncrementThroughCallbackReference();
	}
}