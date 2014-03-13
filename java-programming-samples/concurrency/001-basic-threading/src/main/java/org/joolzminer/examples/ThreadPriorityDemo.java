package org.joolzminer.examples;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ThreadPriorityDemo extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel labelPriority10 = new JLabel("Priority 10:");
	private JTextField textFieldPriority10 = new JTextField();
	
	private JLabel labelPriority1 = new JLabel("Priority 1:");
	private JTextField textFieldPriority1 = new JTextField();
	
	class CounterThread extends Thread {
		
		private JTextField textField;
		
		public CounterThread(JTextField textField) {
			this.textField = textField;
		}
		
		@Override
		public void run() {
			int count = 0;
			while (true) {
				try {
					sleep(100);
				} catch (InterruptedException e) {
					// Swallow exception
				}
				if (count == 500000) {
					count = 0;
				}
				textField.setText(Integer.toString(count++));
			}
		}		
	}
	
	public ThreadPriorityDemo(String title) {
		super(title);
		init();
	}
	
	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(2, 2));
		add(labelPriority1);
		add(textFieldPriority1);
		add(labelPriority10);
		add(textFieldPriority10);
		
		pack();
		setVisible(true);
		
		CounterThread threadPriority1 = new CounterThread(textFieldPriority1);
		threadPriority1.setPriority(1);
		
		CounterThread threadPriority10 = new CounterThread(textFieldPriority10);
		threadPriority10.setPriority(10);
		
		threadPriority1.start();
		threadPriority10.start();
	}
	
	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new ThreadPriorityDemo("Thread Priority Demo");
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
