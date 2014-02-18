package org.joolzminer.examples;

public class Point<T> {
	protected T x;
	protected T y;

	public Point(T x, T y) {
		this.x = x;
		this.y = y;
	}

	public T getX() {
		return x;
	}

	public void setX(T x) {
		this.x = x;
	}

	public T getY() {
		return y;
	}

	public void setY(T y) {
		this.y = y;
	}	
	
	public static void main(String[] args) {
		Point<Integer> point1 = new Point<>(4, 2);
		point1.setX(4);
				
		Point<Double> point2 = new Point<>(1.3, 2.6);
		point2.setX(109.91);
		
		Point<String> point3 = new Point<>("xCoord", "yCoord");
		point3.getX();		
	}
}
