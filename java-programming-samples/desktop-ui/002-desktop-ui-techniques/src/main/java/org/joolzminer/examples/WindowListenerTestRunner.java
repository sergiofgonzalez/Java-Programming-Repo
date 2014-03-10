package org.joolzminer.examples;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class WindowListenerTestRunner extends JFrame {

	private static final long serialVersionUID = 1L;

	public WindowListenerTestRunner(String title) {
		super(title);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowIconified(WindowEvent e) {
				setState(Frame.NORMAL);
			}			
		});
	}
	
	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		WindowListenerTestRunner frame = new WindowListenerTestRunner("WindowListener Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(100, 100);
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
