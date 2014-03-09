package org.joolzminer.examples;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class JOptionPaneConfirmDialogTestRunner {
	public static void main(String[] args) {
		JDialog.setDefaultLookAndFeelDecorated(true);
		int response = JOptionPane.showConfirmDialog(null,
				"Do you want to continue?", "Confirm",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (response == JOptionPane.NO_OPTION) {
			System.out.println("No button was clicked");
		} else if (response == JOptionPane.YES_OPTION) {
			System.out.println("Yes button was clicked");
		} else if (response == JOptionPane.CLOSED_OPTION) {
			System.out.println("JOptionPane closed button was used");
		}
	}
}
