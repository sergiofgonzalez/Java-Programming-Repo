package org.joolzminer.examples;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class JTextFieldAndJPasswordFieldTestRunner {
	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("JTextField and JPasswordField Test");
		frame.setLayout(new GridLayout(2, 2));
		
		JLabel label1 = new JLabel("User Name:", SwingConstants.RIGHT);
		JLabel label2 = new JLabel("Password:", SwingConstants.RIGHT);
		JTextField userNameField = new JTextField(20);
		JPasswordField passwordField = new JPasswordField();
		
		frame.add(label1);
		frame.add(userNameField);
		frame.add(label2);
		frame.add(passwordField);
		frame.setSize(200, 70);
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
