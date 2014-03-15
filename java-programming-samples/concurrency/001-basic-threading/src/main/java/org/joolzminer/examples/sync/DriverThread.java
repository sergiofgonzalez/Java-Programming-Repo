package org.joolzminer.examples.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverThread extends Thread {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DriverThread.class);
	
	private DeliveryNoteHolder deliveryNoteHolder;
	private String driverName;
	
	public DriverThread(DeliveryNoteHolder deliveryNoteHolder, String driverName) {
		this.deliveryNoteHolder = deliveryNoteHolder;
		this.driverName = driverName;
	}

	@Override
	public void run() {
		LOGGER.info("Driver {} begins working", driverName);
		while (true) {
			LOGGER.info("Driver {} is ready to get a delivery note", driverName);
			String deliveryNote = deliveryNoteHolder.get();
			LOGGER.info("Driver {} got delivery note {}", driverName, deliveryNote);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// Swallow exception
			}
		}		
	}	
}
