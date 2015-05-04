package org.joolzminer.examples.functional.client;

import java.util.List;

import org.joolzminer.examples.functional.Resizable;

public class Utils {
	public static void paint(List<Resizable> shapes) {
		shapes.forEach(shape -> {
			shape.setAbsoluteSize(42, 42);
			shape.draw();
		});
	}
}
