package org.joolzminer.examples.observer;

/**
 * The <b>Observer</b> interface in the <b>Observer</b> design pattern.<br/>
 * The <b>Observer</b> pattern defines a one-to-many dependency between objects
 * so that when one object changes state, all of its dependents are
 * notified and updated automatically.<br/><br/>
 * 
 * In this pattern the <b>Subject</b> object holds a state that is
 * interesting to a set of dependent objects known as <b>Observers</b>.
 * <b>Observers</b> subscribe that they want to be notified of the subject state
 * changes.<br/>
 * 
 * The interface defines an operation to notify the Observer that <b>Subject</b>'s 
 * state has changed.
 * 
 * The interface has been specialized for this example.
 * 
 * @author sergio.f.gonzalez
 *
 */
public interface Observer {
	void update(float temperature, float humidity, float pressure);
}
