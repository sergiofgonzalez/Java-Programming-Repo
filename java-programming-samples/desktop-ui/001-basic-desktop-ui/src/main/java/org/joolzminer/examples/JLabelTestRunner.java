package org.joolzminer.examples;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class JLabelTestRunner {
	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame();
		frame.setTitle("JLabel test");
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label1 = new JLabel("First Name");
		label1.setFont(new Font("Consolas", Font.ITALIC, 12));
		label1.setForeground(Color.GRAY);
		
		JLabel label2 = new JLabel();
		label2.setText("<html>"
						+ "Last Name<br><font face='consolas' color='red'>"
						+ "(mandatory)</font>"
						+ "</html>");
		
		JLabel label3 = new JLabel();
		label3.setText("<html>"
						+ "Last Name<br><font face='garamond' color='red'>"
						+ "(mandatory)</font>"
						+ "</html>");
		
		ImageIcon imageIcon = new ImageIcon("target/classes/triangle.jpg");
		JLabel label4 = new JLabel(imageIcon);
		JLabel label5 = new JLabel("Mixed", imageIcon, SwingConstants.RIGHT);
		
		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		frame.add(label4);
		frame.add(label5);
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
