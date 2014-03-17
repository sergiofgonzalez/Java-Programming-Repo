package org.joolzminer.examples;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

class CounterTask extends SwingWorker<Integer, Integer> {
	private static final int DELAY = 1000;
	private JTextArea textArea;
	
	public CounterTask(JTextArea textArea) {
		this.textArea = textArea;
	}

	@Override
	protected Integer doInBackground() throws Exception {
		int i = 0;
		int count = 10;
		while (!isCancelled() && i < count) {
			i++;
			publish(new Integer[] {i});
			setProgress(count * i / count);
			Thread.sleep(DELAY);
		}
		return count;
	}

	@Override
	protected void process(List<Integer> chunks) {
		for (int i : chunks) {
			textArea.append(i + "\n");
		}
	}

	@Override
	protected void done() {
		if (isCancelled()) {
			textArea.append("cancelled!");
		} else {
			textArea.append("done!!");
		}
	}	
}

public class SwingWorkerDemo {
	
	private static void constructGUI() {
		JTextArea textArea = new JTextArea(10, 20);
		final JProgressBar progressBar = new JProgressBar(0, 10);
		final CounterTask task = new CounterTask(textArea);
		task.addPropertyChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if ("progress".equals(evt.getPropertyName())) {
					progressBar.setValue((Integer)evt.getNewValue());
				}
			}
		});
		
		JButton startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				task.execute();
			}
		});
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				task.cancel(true);
			}
		});
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(startButton);
		buttonPanel.add(cancelButton);
		
		JPanel cp = new JPanel();
		LayoutManager layout = new BoxLayout(cp, BoxLayout.Y_AXIS);
		cp.setLayout(layout);
		cp.add(buttonPanel);
		cp.add(new JScrollPane(textArea));
		cp.add(progressBar);
		
		JFrame frame = new JFrame("SwingWorker Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(cp);
		frame.pack();
		frame.setLocationRelativeTo(null);
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
