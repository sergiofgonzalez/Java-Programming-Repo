package org.joolzminer.examples;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ActionListenerAnonymousTestRunner extends JFrame {
	private static final long serialVersionUID = 1L;

	private String selectedFile;
	
	public ActionListenerAnonymousTestRunner(String title) {
		super(title);		
	}
	
	public void init() {
		JButton button = new JButton("Select File");
		add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int returnVal = fileChooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					selectedFile = fileChooser.getSelectedFile().getName();
					System.out.println("Selected File=" + selectedFile);
				}
			}
		});
	}
	
	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		ActionListenerAnonymousTestRunner frame = new ActionListenerAnonymousTestRunner("ActionListener Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.init();
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
