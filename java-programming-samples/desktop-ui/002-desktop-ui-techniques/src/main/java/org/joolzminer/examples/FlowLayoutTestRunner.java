package org.joolzminer.examples;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class FlowLayoutTestRunner {
	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("FlowLayout test");
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String text = "A JTextArea object represents a multiline area for displaying "
				+ "text. You can change the number of lines that can be displayed at "
				+ "a time.";

		JTextArea textArea1 = new JTextArea(text, 5, 10);
		textArea1.setPreferredSize(new Dimension(100, 100));

		JTextArea textArea2 = new JTextArea(text, 5, 10);
		textArea2.setPreferredSize(new Dimension(100, 100));

		JScrollPane scrollPane = new JScrollPane(textArea2,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		textArea1.setLineWrap(true);
		textArea2.setLineWrap(true);
		textArea1.setWrapStyleWord(true);
		textArea2.setWrapStyleWord(true);
		
		frame.add(textArea1);
		frame.add(scrollPane);
		
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
