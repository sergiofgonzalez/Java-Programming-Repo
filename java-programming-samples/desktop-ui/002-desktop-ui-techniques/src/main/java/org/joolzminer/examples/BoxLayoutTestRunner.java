package org.joolzminer.examples;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class BoxLayoutTestRunner {
	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("BoxLayout Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BoxLayout boxLayoutTopToBottom = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
		frame.setLayout(boxLayoutTopToBottom);
		frame.add(new JButton("Button 1"));
		frame.add(new JButton("Button 2"));
		frame.add(new JButton("Button 3"));
		
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
