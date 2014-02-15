package org.joolzminer.examples;


import java.util.ArrayList;
import java.util.List;

interface Selector {
	boolean isEnd();
	Object current();
	void next();
	void reset();
}

public class Sequence {
	private List<Object> items;

	public Sequence(int initialSize) {
		items = new ArrayList<Object>(initialSize);
	}
	
	public void add(Object x) {
		items.add(x);
	}
	
	private class SequenceSelector implements Selector {
		private int i = 0;
		
		@Override
		public boolean isEnd() {
			return i == items.size();
		}

		@Override
		public Object current() {
			return items.get(i);
		}

		@Override
		public void next() {
			if (i < items.size()) {
				i++;
			}
		}

		@Override
		public void reset() {
			i = 0;
		}		
	}
	
	public Selector selector() {
		return new SequenceSelector();
	}
	
	public static void main(String[] args) {
		Sequence sequence = new Sequence(10);
		for (int i = 0; i < 10; i++) {
			sequence.add(i);
		}
		
		Selector selector = sequence.selector();
		
		while (!selector.isEnd()) {
			System.out.print(selector.current() + " ");
			selector.next();
		}
	}
}
