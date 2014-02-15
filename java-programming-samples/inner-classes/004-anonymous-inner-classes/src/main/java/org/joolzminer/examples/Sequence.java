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

	public Sequence() {
		items = new ArrayList<Object>();
	}
	
	public void add(Object x) {
		items.add(x);
	}
	
	public Selector selector() {
		return new Selector() {
			private int i = 0;
			
			@Override
			public void reset() {
				i = 0;
			}
			
			@Override
			public void next() {
				if (i < items.size()) {
					i++;
				}
			}
			
			@Override
			public boolean isEnd() {
				return i == items.size();
			}
			
			@Override
			public Object current() {
				return items.get(i);
			}
		};		
	}	
	
	public static void main(String[] args) {
		Sequence sequence = new Sequence();
		for (int i = 0; i < 10; i++) {
			sequence.add(i);
		}
		
		Selector sequenceSelector = sequence.selector();
		while (!sequenceSelector.isEnd()) {
			System.out.print(sequenceSelector.current() + " ");
			sequenceSelector.next();
		}
		
	}
}
