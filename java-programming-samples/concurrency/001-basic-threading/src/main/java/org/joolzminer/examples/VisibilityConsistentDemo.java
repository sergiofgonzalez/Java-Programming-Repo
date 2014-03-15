package org.joolzminer.examples;

public class VisibilityConsistentDemo {
	private static volatile boolean started = false;
		
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// swallow exception
				}
				
				System.out.println("*** About to change started value");
				started = true;
				System.out.println("*** started value has been changed");
			}
		});
		
		System.out.println("*** starting thread: ");
		t1.start();
		
		while (!started) {
			// wait until started
		}
		
		System.out.println("*** Wait 3 seconds and exit");
	}
}
