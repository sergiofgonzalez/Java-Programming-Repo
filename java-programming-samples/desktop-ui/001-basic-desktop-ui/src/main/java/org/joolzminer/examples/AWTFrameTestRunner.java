package org.joolzminer.examples;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class AWTFrameTestRunner extends Frame {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		AWTFrameTestRunner frame = new AWTFrameTestRunner();
		frame.setTitle("My AWT Frame");
		frame.setSize(300, 100);
		frame.setLayout(new FlowLayout());
		
		// adding components
		Label label = new Label("Name");
		frame.add(label);
		
		TextField textField = new TextField();
		frame.add(textField);
		
		Button button = new Button("Register");
		frame.add(button);
		
		Checkbox checkbox = new Checkbox();
		frame.add(checkbox);
		
		frame.setVisible(true);
	}
}
