package org.joolzminer.examples.functional;

public interface Resizable extends Drawable {
	// API version 1
	int getWidth();
	int getHeight();
	void setWidth(int width);
	void setHeight(int height);
	void setAbsoluteSize(int width, int height);
	
	// API version 2
	
	// void setRelativeSize(int wFactor, int hFactor); <- this breaks client code!!
	
	// this will not make client code break
	default void setRelativeSize(int wFactor, int hFactor) {
		setAbsoluteSize(getWidth() / wFactor, getHeight() / hFactor);
	}
	
}
