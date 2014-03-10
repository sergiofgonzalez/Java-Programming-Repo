package org.joolzminer.examples;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class ActionEventRadioButtonTestRunner {

	static class RadioClickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			System.out.println("the radio '" + command + "' was selected");
		}
		
	}
	
	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("ActionListener Test: Radio Button");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		
		JRadioButton radioButton1 = new JRadioButton("Red");
		JRadioButton radioButton2 = new JRadioButton("Green");
		JRadioButton radioButton3 = new JRadioButton("Blue");

		RadioClickListener listener = new RadioClickListener();
		radioButton1.addActionListener(listener);
		radioButton2.addActionListener(listener);
		radioButton3.addActionListener(listener);
		
		ButtonGroup colorButtonGroup = new ButtonGroup();
		colorButtonGroup.add(radioButton1);
		colorButtonGroup.add(radioButton2);
		colorButtonGroup.add(radioButton3);
		radioButton1.setSelected(true);
		
		frame.add(new JLabel("Color:"));
		frame.add(radioButton1);
		frame.add(radioButton2);
		frame.add(radioButton3);	
		
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
