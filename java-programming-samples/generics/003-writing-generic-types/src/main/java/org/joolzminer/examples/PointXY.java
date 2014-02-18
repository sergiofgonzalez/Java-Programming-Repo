package org.joolzminer.examples;

public class PointXY<T extends Number> {
	protected T x;
	protected T y;

	public PointXY(T x, T y) {
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
		PointXY<Integer> point1 = new PointXY<>(4, 2);
		point1.setX(4);
				
		PointXY<Double> point2 = new PointXY<>(1.3, 2.6);
		point2.setX(109.91);		
	}
}
