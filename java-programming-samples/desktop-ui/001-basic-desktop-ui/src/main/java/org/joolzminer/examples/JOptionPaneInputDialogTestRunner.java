package org.joolzminer.examples;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class JOptionPaneInputDialogTestRunner {
	public static void main(String[] args) {
		JDialog.setDefaultLookAndFeelDecorated(true);
		Object[] selectionValues = { "Pandas", "Dogs", "Horses" };
		String initialSelection = "Dogs";

		Object selection = JOptionPane.showInputDialog(null,
				"What are your favorite animals?", "Zoo Quiz",
				JOptionPane.QUESTION_MESSAGE, null, selectionValues,
				initialSelection);
		
		System.out.println(selection);
		
		String input = JOptionPane.showInputDialog(null, "Enter Your Name", "John Doe");
		System.out.println(input);
	}
}
