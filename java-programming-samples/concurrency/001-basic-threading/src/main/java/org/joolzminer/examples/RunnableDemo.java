package org.joolzminer.examples;

public class RunnableDemo implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// swallow exception
			}
		}		
	}

	public static void main(String[] args) {
		RunnableDemo runnableDemo = new RunnableDemo();
		Thread thread = new Thread(runnableDemo);
		
		System.out.print("*** starting RunnableDemo Thread: ");
		thread.start();
		System.out.println("done");
	}	
}
