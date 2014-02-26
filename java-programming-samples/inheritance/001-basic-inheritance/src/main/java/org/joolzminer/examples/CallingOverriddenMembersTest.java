package org.joolzminer.examples;


class Tool {
	@Override
	public String toString() {
		return "Generic Tool";
	}
}

class Pencil extends Tool {
	@Override
	public String toString() {
		return "Pencil";
	}
	
	public void write() {		
		System.out.println(toString());
		System.out.println(super.toString());
	}
}

public final class CallingOverriddenMembersTest {
	public static void main(String[] args) {
		Pencil pencil = new Pencil();
		pencil.write();		
	}

}
