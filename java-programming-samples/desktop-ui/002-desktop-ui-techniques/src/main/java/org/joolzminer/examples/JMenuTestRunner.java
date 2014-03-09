package org.joolzminer.examples;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

class MyMenuActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
	}
	
}

public class JMenuTestRunner {
	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("JMenu Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyMenuActionListener actionListener = new MyMenuActionListener();
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu editMenu = new JMenu("Edit");
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
		
		JMenuItem fileNewMenuItem = new JMenuItem("New");
		JMenuItem fileOpenMenuItem = new JMenuItem("Open");
		JMenuItem fileSaveMenuItem = new JMenuItem("Save");
		JMenuItem fileExitMenuItem = new JMenuItem("Exit");
		
		fileMenu.add(fileNewMenuItem);
		fileNewMenuItem.addActionListener(actionListener);
		
		fileMenu.add(fileOpenMenuItem);
		fileOpenMenuItem.addActionListener(actionListener);
		
		fileMenu.add(fileSaveMenuItem);
		fileSaveMenuItem.addActionListener(actionListener);
		
		fileMenu.add(fileExitMenuItem);
		fileExitMenuItem.addActionListener(actionListener);
		
		JMenuItem editCopyMenuItem = new JMenuItem("Copy");
		JMenuItem editPasteMenuItem = new  JMenuItem("Paste");
		
		editMenu.add(editCopyMenuItem);
		editCopyMenuItem.addActionListener(actionListener);
		editMenu.add(editPasteMenuItem);
		editPasteMenuItem.addActionListener(actionListener);
		
		JMenuItem helpAboutMenuItem = new JMenuItem("About");
		helpMenu.add(helpAboutMenuItem);
		helpAboutMenuItem.addActionListener(actionListener);
		
		frame.setJMenuBar(menuBar);
		frame.setSize(200, 100);
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
