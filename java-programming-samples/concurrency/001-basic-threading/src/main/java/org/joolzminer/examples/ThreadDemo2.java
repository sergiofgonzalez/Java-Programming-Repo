package org.joolzminer.examples;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

class MyThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// swallow exception
			}
		}
	}	
}

public class ThreadDemo2 extends JFrame {
	private static final long serialVersionUID = 1L;

	public void constructGUI() {
		setDefaultLookAndFeelDecorated(true);
		setTitle("Swing Thread Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		JButton runButton = new JButton("run");
		runButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MyThread thread = new MyThread();
				thread.start();
			}
		});
		
		
		add(runButton);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				(new ThreadDemo2()).constructGUI();
			}
		});
	}
}
