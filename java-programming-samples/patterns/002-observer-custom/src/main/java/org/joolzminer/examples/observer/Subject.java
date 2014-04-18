package org.joolzminer.examples.observer;

/**
 * The <b>Subject</b> interface in the <b>Observer</b> design pattern.<br/>
 * The <b>Observer</b> pattern defines a one-to-many dependency between objects
 * so that when one object changes state, all of its dependents are
 * notified and updated automatically.<br/><br/>
 * 
 * In this pattern the <b>Subject</b> object holds a state that is
 * interesting to a set of dependent objects known as <b>Observers</b>.
 * <b>Observers</b> subscribe that they want to be notified of the subject state
 * changes.<br/>
 * 
 * The interface defines operations to register and remove dependent <b>Observers</b>,
 * and also an operation to notify the Observers that the <b>Subject</b>'s state has 
 * changed.
 * 
 * @author sergio.f.gonzalez
 *
 */
public interface Subject {
	/**
	 * Adds an Observer to the set of dependent Observers of this Subject's state.
	 * @param o the Observer instance to be registered.
	 */
	void registerObserver(Observer o);
	
	/**
	 * Removes an existing Observer from the set of dependent Observers of this 
	 * Subject's state.
	 * @param o the Observer instance to be removed.
	 */
	void removeObserver(Observer o);
	
	/**
	 * Notifies all registered Observers that the Subject's state has changed.
	 */
	void notifyObservers();
}
