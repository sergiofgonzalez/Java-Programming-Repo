package org.joolzminer.examples;

interface Printer {
	void print(String message);
}

class PrinterImpl implements Printer {

	@Override
	public void print(String message) {
		System.out.println(message);
	}	
}

class SecretPrinterImpl {
	public class Inner implements Printer {

		@Override
		public void print(String message) {
			System.out.println("Inner: " + message);
		}		
	}
	
	public Printer getPrinter() {
		return new Inner();
	}
}

class HiddenPrinterImpl {
	private class Inner implements Printer {

		@Override
		public void print(String message) {
			System.out.println("Hidden Inner: " + message);
		}		
	}
	
	public Printer getPrinter() {
		return new Inner();
	}
}


public class MemberInnerClassTest2 {

	public static void main(String[] args) {
		
		// Option 1:  No inner class implementation
		Printer printer = new PrinterImpl();
		printer.print("oh");
		
		// Downcast to actual class
		PrinterImpl printerImpl = (PrinterImpl) printer;
		printerImpl.print("d'oh");
		
		// Option 2: public inner class implementation
		Printer secretPrinter = (new SecretPrinterImpl()).getPrinter();
		secretPrinter.print("oh");
		
		// Downcasting to actual class is awkward but possible
		SecretPrinterImpl.Inner innerImpl = (SecretPrinterImpl.Inner) secretPrinter;
		innerImpl.print("oh");
		
		
		// Option 3: private inner class implementation
		Printer hiddenPrinter = (new HiddenPrinterImpl()).getPrinter();
		hiddenPrinter.print("oh");
		
		// Downcasting to actual class is not possible
		//HiddenPrinterImpl.Inner hiddenInnerImpl = (HiddenPrinterImpl.Inner) hiddenPrinter;
	}
}
