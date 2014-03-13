package org.joolzminer.examples;

public class ThreadDemo extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// swallow exception
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.print("*** starting ThreadDemo Thread: ");
		(new ThreadDemo()).start();
		System.out.println("done");
	}
}
