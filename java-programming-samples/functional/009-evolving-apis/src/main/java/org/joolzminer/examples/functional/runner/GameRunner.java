package org.joolzminer.examples.functional.runner;

import java.util.Arrays;
import java.util.List;

import org.joolzminer.examples.functional.Rectangle;
import org.joolzminer.examples.functional.Resizable;
import org.joolzminer.examples.functional.Square;
import org.joolzminer.examples.functional.client.Ellipse;
import org.joolzminer.examples.functional.client.Utils;


public class GameRunner {
	public static void main(String[] args) {
		List<Resizable> resizableShapes = Arrays.asList(new Square(), new Rectangle(), new Ellipse());
		Utils.paint(resizableShapes);
	}
}
