package org.joolzminer.examples;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class SwingTimerDemo extends JFrame {

	private static final long serialVersionUID = 1L;

	private String[] questions = {
		"What is the largest mammal?",
		"Who is the current Japanese prime minister?",
		"Who invented the Internet?",
		"What is the smallest country in the world?",
		"What is the biggest city in America?",
		"Finished. Please remain seated."
	};
	
	private JLabel questionLabel = new JLabel("Click Start to begin the quiz");
	private JTextField answer = new JTextField();
	private JButton startButton = new JButton("Start");
	private JComboBox<String> answerBox = new JComboBox<>();
	private int counter = 0;
	private Timer timer = new Timer(10000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Toolkit.getDefaultToolkit().beep();
			if (counter > 0) {
				answerBox.addItem(answer.getText());
				answer.setText("");
			}
			String nextQuestion = getNextQuestion();
			questionLabel.setText(nextQuestion);
			if (counter == questions.length) {
				timer.stop();
			}
		}
	});

	public SwingTimerDemo(String title) {
		super(title);
		init();
	}
	
	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(questionLabel, BorderLayout.WEST);
		questionLabel.setPreferredSize(new Dimension(300, 15));
		answer.setPreferredSize(new Dimension(100, 15));
		add(answer, BorderLayout.CENTER);
		add(startButton, BorderLayout.EAST);
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((JButton)e.getSource()).setEnabled(false);
				timer.start();
			}
		});
		add(answerBox, BorderLayout.SOUTH);
		startButton.setFocusable(true);
		pack();
		setVisible(true);
	}
	
	private String getNextQuestion() {
		return questions[counter++];
	}
	
	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new TimerDemo("Swing Timer Demo");
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
