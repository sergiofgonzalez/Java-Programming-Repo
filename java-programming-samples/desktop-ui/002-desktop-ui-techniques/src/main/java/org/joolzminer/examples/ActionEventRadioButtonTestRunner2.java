package org.joolzminer.examples;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class ActionEventRadioButtonTestRunner2 extends JFrame {

	private static final long serialVersionUID = 1L;

	class RadioClickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			setTitle(command);
		}

	}

	public ActionEventRadioButtonTestRunner2(String title) {
		super(title);
		init();
	}

	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		JRadioButton radioButton1 = new JRadioButton("Red");
		JRadioButton radioButton2 = new JRadioButton("Green");
		JRadioButton radioButton3 = new JRadioButton("Blue");

		RadioClickListener listener = new RadioClickListener();
		radioButton1.addActionListener(listener);
		radioButton2.addActionListener(listener);
		radioButton3.addActionListener(listener);

		ButtonGroup colorButtonGroup = new ButtonGroup();
		colorButtonGroup.add(radioButton1);
		colorButtonGroup.add(radioButton2);
		colorButtonGroup.add(radioButton3);
		radioButton1.setSelected(true);

		add(new JLabel("Color:"));
		add(radioButton1);
		add(radioButton2);
		add(radioButton3);

	}

	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		ActionEventRadioButtonTestRunner2 frame = 
			new ActionEventRadioButtonTestRunner2("ActionListener Test: Radio buttons");
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
