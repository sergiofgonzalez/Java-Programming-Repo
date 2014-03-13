package org.joolzminer.examples;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class MultipleThreadsDemo extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel countUpLabel = new JLabel("Count up");
	private JLabel countDownLabel = new JLabel("Cound down");
	
	class CountUpThread extends Thread {

		@Override
		public void run() {
			int count = 0;
			while (true) {
				try {
					sleep(100);
				} catch (InterruptedException e) {
					// Swallow exception
				}
				if (count == 1000) {
					count = 0;
				}
				countUpLabel.setText(Integer.toString(count++));
			}
		}		
	}
	
	class CountDownThread extends Thread {

		@Override
		public void run() {
			int count = 1000;
			while (true) {
				try {
					sleep(100);
				} catch (InterruptedException e) {
					// Swallow exception
				}
				if (count == 0) {
					count = 1000;
				}
				countDownLabel.setText(Integer.toString(count--));
			}
		}		
	}
	
	public MultipleThreadsDemo(String title) {
		super(title);
		init();
	}
	
	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		add(countUpLabel);
		add(countDownLabel);
		
		pack();
		setVisible(true);
		
		(new CountDownThread()).start();
		(new CountUpThread()).start();
	}
	
	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new MultipleThreadsDemo("Multiple Threads Demo");
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
