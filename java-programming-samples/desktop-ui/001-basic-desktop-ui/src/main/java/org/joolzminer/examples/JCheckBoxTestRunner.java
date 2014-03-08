package org.joolzminer.examples;

import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class JCheckBoxTestRunner {
	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("JCheckBox Test");
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JCheckBox ac = new JCheckBox("A/C");
		ac.setSelected(true);
		
		JCheckBox cdPlayer = new JCheckBox("CD Player");
		JCheckBox cruiseControl = new JCheckBox("Cruise Control");
		JCheckBox keylessEntry = new JCheckBox("Keyless Entry");
		JCheckBox antiTheft = new JCheckBox("Anti-Theft Alarm");
		JCheckBox centralLock = new JCheckBox("Central Lock");
		
		frame.add(new JLabel("Car Features"));
		frame.add(ac);
		frame.add(cdPlayer);
		frame.add(cruiseControl);
		frame.add(keylessEntry);
		frame.add(antiTheft);
		frame.add(centralLock);
		
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
