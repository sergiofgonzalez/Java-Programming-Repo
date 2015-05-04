package org.joolzminer.examples.async.runner;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureRunner {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		
		// Timeout will expire
		Future<Double> future1 = executor.submit(new Callable<Double>() {

			@Override
			public Double call() throws Exception {
				return doSomeLengthyComputation();
			}});
		
		doSomeOtherStuff();
				
		try {
			Double result = future1.get(4, TimeUnit.SECONDS);
			System.out.println(result);
		} catch (ExecutionException e) {
			System.out.println("Computation threw Exception: " + e);
		} catch (InterruptedException e) {
			System.out.println("Current thread was interrupted while waiting: " + e);
		} catch (TimeoutException e) {
			System.out.println("Timeout expired before the Future completion: " + e);
		}
		printSeparator();
		
		// Timeout will not expire
		Future<Double> future2 = executor.submit(new Callable<Double>() {

			@Override
			public Double call() throws Exception {
				return doSomeLengthyComputation();
			}});
		
		doSomeOtherStuff();
		try {
			Double result = future2.get(10, TimeUnit.SECONDS);
			System.out.println(result);
		} catch (ExecutionException e) {
			System.out.println("Computation threw Exception: " + e);
		} catch (InterruptedException e) {
			System.out.println("Current thread was interrupted while waiting: " + e);
		} catch (TimeoutException e) {
			System.out.println("Timeout expired before the Future completion: " + e);
		}
		printSeparator();
	}
	
	public static double doSomeLengthyComputation() {
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			// swallow
		}
		
		return new Random().nextDouble();
	}
	
	
	public static void doSomeOtherStuff() {
		System.out.println("Doing some other stuff asynchronously with the submitted task");
	}
	
	public static void printSeparator() {
		System.out.println("=============================================================");
	}
}	
