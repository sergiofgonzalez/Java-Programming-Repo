package org.joolzminer.examples;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class MyFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public MyFrame() {
		super();
		init();
	}
	
	public MyFrame(String title) {
		super(title);
		init();
	}
	
	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("JFrame: Swing app scaffolding");

		
		setLayout(new GridLayout(3, 2));
		
		add(new JLabel("First Name:"));
		add(new JTextField());
		
		add(new JLabel("Last Name:"));
		add(new JTextField());
		
		add(new JButton("Register"));
		
		int frameWidth = 400;
		int frameHeight = 100;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		// Position on the top-right corner of the screen
		setBounds((int) screenSize.getWidth() - frameWidth, 0, frameWidth, frameHeight);
	}
}

public class SwingAppTestRunner {
	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		MyFrame frame = new MyFrame();
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
