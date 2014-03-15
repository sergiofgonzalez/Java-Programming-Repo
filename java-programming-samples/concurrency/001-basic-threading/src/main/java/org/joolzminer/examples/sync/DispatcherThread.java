package org.joolzminer.examples.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DispatcherThread extends Thread {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DispatcherThread.class);
	
	private DeliveryNoteHolder deliveryNoteHolder;
	
	String[] deliveryNotes = { 	"XY23. 1234 Arnie Rd.",
								"XY24. 3330 Quebec St.",
								"XY25. 909 Swenson Ave.",
								"XY26. 4830 Davidson Blvd.",
								"XY27. 9900 Old York Dr." };
	
	
	public DispatcherThread(DeliveryNoteHolder deliveryNoteHolder) {
		this.deliveryNoteHolder = deliveryNoteHolder;
	}


	@Override
	public void run() {
		LOGGER.info("Dispatcher begins to work");
		for (String deliveryNote : deliveryNotes) {
			LOGGER.info("About to put delivery note: {}", deliveryNote);
			deliveryNoteHolder.put(deliveryNote);
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// Swallow exception
			}
		}
		LOGGER.info("Dispatcher has finished working!!!");
	}	
}
