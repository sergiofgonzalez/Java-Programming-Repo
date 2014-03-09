package org.joolzminer.examples;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class JOptionPaneMessageDialogTestRunner {
	public static void main(String[] args) {
		JDialog.setDefaultLookAndFeelDecorated(true);

		JOptionPane.showMessageDialog(null, "Thank you for visiting our store",
				"Thank you", JOptionPane.INFORMATION_MESSAGE);

		JOptionPane.showMessageDialog(null, "You have not saved this document",
				"Warning", JOptionPane.WARNING_MESSAGE);

		JOptionPane.showMessageDialog(null, "First Name must have a value",
				"Error", JOptionPane.ERROR_MESSAGE);
	}
}
