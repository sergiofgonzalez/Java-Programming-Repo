package org.joolzminer.examples;

import java.awt.GridLayout;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SwingDemo {
	private static void constructGUI(String language, String country ) {
		Locale locale = null;
		if (language == null || country == null) {
			locale = Locale.getDefault();
		} else {
			locale = new Locale(language, country);
		}
				
		ResourceBundle resourceBundle = ResourceBundle.getBundle("swingdemo", locale);
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("I18n Swing Demo: " + locale);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(3, 2));
		
		frame.add(new JLabel(resourceBundle.getString("username")));
		frame.add(new JTextField());
		
		frame.add(new JLabel(resourceBundle.getString("password")));
		frame.add(new JPasswordField());
		
		frame.add(new JButton(resourceBundle.getString("login")));
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				constructGUI(null, null);
				constructGUI("fr", "CA");
				constructGUI("es", "ES");
			}
		});
	}
}
