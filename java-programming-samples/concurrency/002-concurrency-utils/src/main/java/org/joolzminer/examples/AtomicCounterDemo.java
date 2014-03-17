package org.joolzminer.examples;

import java.lang.Thread.State;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

interface Counter {
	int getCount();
	void increment();
	void decrement();
}

class NonThreadSafeCounter implements Counter {
	int userCount = 0;

	@Override
	public int getCount() {
		return userCount;
	}

	@Override
	public void increment() {
		userCount++;
	}
	
	@Override
	public void decrement() {
		userCount--;
	}	
}

class AtomicCounter implements Counter {
	private AtomicInteger userCount = new AtomicInteger(0);
	
	@Override
	public int getCount() {
		return userCount.get();
	}
	
	@Override
	public void increment() {
		userCount.getAndIncrement();
	}
	
	@Override
	public void decrement() {
		userCount.getAndDecrement();
	}
}



public class AtomicCounterDemo {

	private static final Logger LOGGER = LoggerFactory.getLogger(AtomicCounterDemo.class);
	
	private static NonThreadSafeCounter nonThreadSafeCounter = new NonThreadSafeCounter();
	private static AtomicCounter atomicCounter = new AtomicCounter();
	private static Counter counter;
	
	
	static class IncrementerThread extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 1000; i++) {
				counter.increment();			
				try {
					sleep(10);
				} catch (InterruptedException e) {
					// swallow exception
				}
			}
		}
	}
	
	static class DecrementerThread extends Thread {
		@Override
		public void run() {
			for (int i = 0; i < 1000; i++) {
				counter.decrement();			
				try {
					sleep(10);
				} catch (InterruptedException e) {
					// swallow exception
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {

		System.out.println("*** Testing non thread safe counter class:");
		counter = nonThreadSafeCounter;
		IncrementerThread incrementerThread = new IncrementerThread();
		DecrementerThread decrementerThread = new DecrementerThread();
		
		LOGGER.info("Initial value -> unsafe counter={}", counter.getCount());
		
		incrementerThread.start();
		decrementerThread.start();
		
		boolean done = false;
		while (!done) {
			LOGGER.info("unsafe counter={}", counter.getCount());
			Thread.sleep(1000);
			done = (State.TERMINATED == incrementerThread.getState()) && 
					(State.TERMINATED == decrementerThread.getState());
		}		
		
		LOGGER.info("Final value -> unsafe counter={}", counter.getCount());
		System.out.println("\n");
		
		System.out.println("*** Testing thread safe counter class:");
		counter = atomicCounter;
		incrementerThread = new IncrementerThread();
		decrementerThread = new DecrementerThread();
		
		LOGGER.info("Initial value -> safe counter={}", counter.getCount());
		
		incrementerThread.start();
		decrementerThread.start();
		
		done = false;
		while (!done) {
			LOGGER.info("safe counter={}", counter.getCount());
			Thread.sleep(1000);
			done = (State.TERMINATED == incrementerThread.getState()) && 
					(State.TERMINATED == decrementerThread.getState());
		}		
		
		LOGGER.info("Final value -> safe counter={}", counter.getCount());		
	}
}
