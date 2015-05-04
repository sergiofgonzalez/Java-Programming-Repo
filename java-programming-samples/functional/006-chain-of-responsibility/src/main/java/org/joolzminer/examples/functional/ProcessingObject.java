package org.joolzminer.examples.functional;

public abstract class ProcessingObject<T> {
	protected ProcessingObject<T> successor;
	
	public void setSuccessor(ProcessingObject<T> successor) {
		this.successor = successor;
	}
	
	public T handle(T input) {
		T t = handleWork(input);
		if (successor != null) {
			return successor.handle(t);
		} else {
			return t;
		}
	}
	
	abstract protected T handleWork(T input);
}
