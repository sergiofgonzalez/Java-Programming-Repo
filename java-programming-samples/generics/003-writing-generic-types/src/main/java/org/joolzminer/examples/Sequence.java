package org.joolzminer.examples;

import java.util.ArrayList;
import java.util.List;

interface Selector<T> {
	boolean isEnd();
	T current();
	void next();
	void reset();
}

public class Sequence<T> {
	private final List<T> items = new ArrayList<>();
	
	public void add(T item) {
		items.add(item);
	}
	
	public Selector<T> getSelector() {
		return new Selector<T>() {
			private int i = 0;
			
			@Override
			public boolean isEnd() {
				return i == items.size();
			}

			@Override
			public T current() {
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
		};
	}

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		Selector<T> selector = getSelector();
		while (!selector.isEnd()) {
			stringBuffer.append(selector.current());
			stringBuffer.append(" ");
			selector.next();
		}
		
		stringBuffer.deleteCharAt(stringBuffer.length() - 1);
		
		return stringBuffer.toString();
	}	
}
