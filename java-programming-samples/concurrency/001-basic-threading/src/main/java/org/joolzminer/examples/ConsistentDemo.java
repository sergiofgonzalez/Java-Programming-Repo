package org.joolzminer.examples;

public class ConsistentDemo {
	private static boolean started = false;
	
	public synchronized static void setStarted() {
		started = true;
	}
	
	public synchronized static boolean isStarted() {
		return started;
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// swallow exception
				}
				
				System.out.println("*** About to to call setStarted()");
				setStarted();
				System.out.println("*** setStarted() has been called!");
			}
		});
		
		System.out.println("*** starting thread: ");
		t1.start();
		
		while (!isStarted()) {
			// wait until started
		}
		
		System.out.println("*** Wait 3 seconds and exit");
	}
}
