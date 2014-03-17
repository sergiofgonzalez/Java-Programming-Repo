package org.joolzminer.examples;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class ExecutorDemo extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	public static final int MAX_RESULTS = 300;
	private JButton searchButton = new JButton("Search");
	private DefaultListModel<String> listModel;
	private JList<String> imageList;
	private Executor executor = Executors.newFixedThreadPool(10);
	private AtomicInteger fileCounter = new AtomicInteger(1);
	
	public ExecutorDemo(String title) {
		super(title);
		init();
	}
	
	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(searchButton, BorderLayout.NORTH);
		listModel = new DefaultListModel<>();
		imageList = new JList<>(listModel);
		add(new JScrollPane(imageList), BorderLayout.CENTER);
		pack();
		setSize(800, 650);
		searchButton.addActionListener(this);
		setVisible(true);

		// center frame on screen
		setLocationRelativeTo(null);
	}
	
	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new ExecutorDemo("Executor Demo : Image Searcher");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		searchButton.setEnabled(false);
		Iterable<Path> roots = FileSystems.getDefault().getRootDirectories();
		for (Path root : roots) {
			executor.execute(new ImageSearchTask(root, executor, listModel, fileCounter));
		}		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				constructGUI();
			}
		});
		
		System.out.println("Finished!!");
		
		
	}
}
