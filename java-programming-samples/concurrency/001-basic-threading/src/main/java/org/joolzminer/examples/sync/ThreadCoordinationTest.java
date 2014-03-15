package org.joolzminer.examples.sync;

public class ThreadCoordinationTest {
	public static void main(String[] args) {
		DeliveryNoteHolder deliveryNoteHolder = new DeliveryNoteHolder();
		DispatcherThread dispatcherThread = new DispatcherThread(deliveryNoteHolder);
		DriverThread driverThread = new DriverThread(deliveryNoteHolder, "driver-001");
		
		dispatcherThread.start();
		driverThread.start();
		
		boolean done = false;
		while (!done) {
			done = (Thread.State.TERMINATED == dispatcherThread.getState()) &&
					(Thread.State.WAITING == driverThread.getState());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// Swallow Exception
			}
		}
		
		System.out.println("*** Work finished!!!");
		System.exit(0);
	}
}
