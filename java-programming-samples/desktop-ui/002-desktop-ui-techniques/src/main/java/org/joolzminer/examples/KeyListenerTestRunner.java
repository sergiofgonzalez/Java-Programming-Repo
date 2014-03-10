package org.joolzminer.examples;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class KeyListenerTestRunner extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;

	public KeyListenerTestRunner(String title) {
		super(title);
		setLayout(new BorderLayout());
		JTextField textField = new JTextField(20);
		textField.addKeyListener(this);
		add(textField);		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		KeyListenerTestRunner frame = new KeyListenerTestRunner("KeyListener Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
