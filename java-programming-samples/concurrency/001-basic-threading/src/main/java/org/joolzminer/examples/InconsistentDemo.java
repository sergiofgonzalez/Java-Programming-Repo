package org.joolzminer.examples;

public class InconsistentDemo {
	private static boolean started = false;
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// swallow exception
				}
				started = true;
				System.out.println("started has been set to true!");
			}
		});
		
		System.out.print("*** starting thread: ");
		t1.start();
		
		while (!started) {
			// wait until started
		}
		
		System.out.println("*** Wait 3 seconds and exit");
	}
}
