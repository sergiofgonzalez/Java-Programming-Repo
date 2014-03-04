package org.joolzminer.examples;

interface Printable {
	void print(String document);
	void wakeUpPrinter();
	void shutdownPrinter();
	void alertUser(String message);
}


class PrintableImpl implements Printable {

	@Override
	public void print(String document) {
		System.out.println("sending document to printer");
	}

	@Override
	public void wakeUpPrinter() {
		System.out.println("waking up printer from sleep");
	}

	@Override
	public void shutdownPrinter() {
		System.out.println("shutting down printer");
	}

	@Override
	public void alertUser(String message) {
		System.out.println("user i need your attention: " + message);
	}	
}

class GenericPrinter implements Printable {

	@Override
	public void print(String document) {
		System.out.println("printing document: " + document);
	}

	@Override
	public void wakeUpPrinter() {
		System.out.println("waking up printer from sleep");
	}

	@Override
	public void shutdownPrinter() {
		System.out.println("shutting down printer");
	}

	@Override
	public void alertUser(String message) {
		System.out.println("alert: " + message);
	}
}

class SimplePrinterImpl extends GenericPrinter {

	@Override
	public void print(String document) {
		System.out.println("Simple printing document: " + document);
	}
	
}

abstract class DefaultPrinter implements Printable {

	public abstract void print(String document);

	@Override
	public void wakeUpPrinter() {
		System.out.println("waking up printer from sleep");
	}

	@Override
	public void shutdownPrinter() {
		System.out.println("shutting down printer");
	}

	@Override
	public void alertUser(String message) {
		System.out.println("user i need your attention: " + message);
	}		
}

public class GenericClassTest {
	
	
	public static void main(String[] args) {
		Printable printer = new SimplePrinterImpl();
		printer.wakeUpPrinter();
		printer.alertUser("more paper needed");
		printer.print("Da Vinci's code");
		printer.shutdownPrinter();
		
		Printable tediousPrinter = new PrintableImpl();
		tediousPrinter.wakeUpPrinter();
		tediousPrinter.alertUser("more paper needed");
		tediousPrinter.print("Da Vinci's code");
		tediousPrinter.shutdownPrinter();
	}
}
