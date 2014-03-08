package org.joolzminer.examples;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class JComboBoxTestRunner {
	
	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("JComboBox Test");
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String[] selections = {"green", "red", "orange", "dark blue"};
		JComboBox<String> comboBox = new JComboBox<>(selections);
		comboBox.setSelectedIndex(1);
		
		System.out.println(comboBox.getSelectedItem());
		frame.add(comboBox);
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
