package org.joolzminer.examples;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class JFrameTestRunner {
	
	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame();
		frame.setTitle("My First Swing Application");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// add a JLabel that says Welcome
		JLabel label = new JLabel("Welcome!");
		frame.add(label);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				constructGUI();
			}
		});
	}
}
