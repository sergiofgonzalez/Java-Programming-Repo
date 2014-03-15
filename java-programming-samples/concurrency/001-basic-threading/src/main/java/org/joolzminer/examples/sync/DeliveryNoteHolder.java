package org.joolzminer.examples.sync;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class DeliveryNoteHolder {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DeliveryNoteHolder.class);
	
	private String deliveryNote;
	private boolean available = false;
	
	public synchronized String get() {
		while (available == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				// swallow exception
			}
		}
		available = false;
		LOGGER.info("GET {}", deliveryNote);
		notifyAll();
		return deliveryNote;
	}
	
	public synchronized void put(String deliveryNote) {
		while (available == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				// swallow exception
			}
		}
		this.deliveryNote = deliveryNote;
		available = true;
		LOGGER.info("PUT {}", deliveryNote);
		notifyAll();
	}
}
