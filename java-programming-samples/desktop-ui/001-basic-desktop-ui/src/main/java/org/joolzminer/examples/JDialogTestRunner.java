package org.joolzminer.examples;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class AddressDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	JLabel label1 = new JLabel("Address");
	JLabel label2 = new JLabel("City");
	JLabel label3 = new JLabel("State");
	JLabel label4 = new JLabel("Zip Code");
	JTextField addressField = new JTextField();
	JTextField cityField = new JTextField();
	JTextField stateField = new JTextField();
	JTextField zipCodeField = new JTextField();
	String[] address = new String[4];
	
	public AddressDialog(Frame owner, boolean modal) {
		super(owner, modal);
		init();
	}
	
	private void init() {
		setTitle("Address Dialog");
		setLayout(new GridLayout(4, 2));
		add(label1);
		add(addressField);
		add(label2);
		add(cityField);
		add(label3);
		add(stateField);
		add(label4);
		add(zipCodeField);
	}
	
	public String[] getAddress() {
		address[0] = addressField.getText();
		address[1] = cityField.getText();
		address[2] = stateField.getText();
		address[3] = zipCodeField.getText();
		
		return address;
	}
}

public class JDialogTestRunner extends JFrame {

	private static final long serialVersionUID = 1L;

	AddressDialog dialog = new AddressDialog(this, false);
	
	public JDialogTestRunner() {
		super();
		init();
	}
	
	public JDialogTestRunner(String title) {
		super(title);
		init();
	}
	
	private void init() {
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton button = new JButton("Show Dialog");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				displayDialog();
			}
		});
		add(button);
	}
	
	private void displayDialog() {
		dialog.setSize(250, 120);
		dialog.setVisible(true);
	}
	
	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		JDialogTestRunner frame = new JDialogTestRunner();
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
