package org.joolzminer.examples;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class StopThreadDemo extends JFrame {
	private static final long serialVersionUID = 1L;

	private JLabel counterLabel = new JLabel("Counter");
	private JButton startButton = new JButton("Start");
	private JButton stopButton = new JButton("Stop");
	boolean stopped = false;
	CounterThread counterThread = null;
	int count = 1;
	
	
	class CounterThread extends Thread {

		@Override
		public void run() {
			while (!stopped) {
				try {
					sleep(100);
				} catch (InterruptedException e) {
					// Swallow exception
				}
				if (count == 1000) {
					count = 1;
				}
				counterLabel.setText(Integer.toString(count++));
			}
		}		
	}
	
	public StopThreadDemo(String title) {
		super(title);
		init();
	}
	
	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		add(counterLabel);
		add(startButton);
		add(stopButton);
				
		stopButton.setEnabled(false);
		
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				startButton.setEnabled(false);
				stopButton.setEnabled(true);
				startThread();
			}
		});
		
		stopButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				startButton.setEnabled(true);
				stopButton.setEnabled(false);
				stopThread();
			}
		});
		

		pack();
		setVisible(true);

	}
	
	public synchronized void startThread() {
		stopped = false;
		counterThread = new CounterThread();
		counterThread.start();
	}
	
	public synchronized void stopThread() {
		stopped = true;
	}
	
	
	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new StopThreadDemo("Stop Threads Demo");
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
