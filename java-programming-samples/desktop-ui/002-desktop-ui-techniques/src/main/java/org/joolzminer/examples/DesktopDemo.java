package org.joolzminer.examples;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class DesktopDemo {
	
	private static void confirmExitApp() {
		int userOption = JOptionPane.showConfirmDialog(null, "Exit application?", "Exit application", JOptionPane.YES_NO_OPTION);
		if (userOption == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JMenu fileMenu = new JMenu("File");
		JMenu mailMenu = new JMenu("Email");
		JMenu browseMenu = new JMenu("Browser");
		
		JMenuItem openItem = new JMenuItem("Open");
		openItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					try {
						Desktop.getDesktop().open(fileChooser.getSelectedFile().getAbsoluteFile());
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(null, "Could not open file: " + ex, "Error opening file", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		fileMenu.add(openItem);
		
		JMenuItem editItem = new JMenuItem("Edit");
		editItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					try {
						Desktop.getDesktop().edit(fileChooser.getSelectedFile().getAbsoluteFile());
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(null, "Could not edit file: " + ex, "Error editing file", JOptionPane.ERROR_MESSAGE);					
					}
				}
			}
		});
		fileMenu.add(editItem);
		
		JMenuItem printItem = new JMenuItem("Print");
		printItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					try {
						Desktop.getDesktop().print(fileChooser.getSelectedFile().getAbsoluteFile());
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(null, "Could not print file: " + ex, "Error printing file", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		fileMenu.add(printItem);
		
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				confirmExitApp();
			}
		});
		fileMenu.add(exitItem);
		
		JMenuItem browseItem = new JMenuItem("Go to google.com");
		browseItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {					
					URI browseUri = new URI("http://google.com");
					Desktop.getDesktop().browse(browseUri);
				} catch (URISyntaxException | IOException e1) {
					JOptionPane.showMessageDialog(null, "Could not open URI: " + e1, "Error opening URI", JOptionPane.ERROR_MESSAGE);
				}			
			}
		});
		browseMenu.add(browseItem);
		
		JMenuItem mailMenuItem = new JMenuItem("Email me");
		mailMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {					
					URI mailUri = new URI("mailto:sergio.f.gonzalez@gmail.com");
					Desktop.getDesktop().browse(mailUri);
				} catch (URISyntaxException | IOException e1) {
					JOptionPane.showMessageDialog(null, "Could not open Email client: " + e1, "Error opening Email client", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mailMenu.add(mailMenuItem);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		menuBar.add(browseMenu);
		menuBar.add(mailMenu);
		
		JFrame frame = new JFrame();
		frame.setTitle("Desktop Demo");
		frame.setSize(300, 100);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				confirmExitApp();
			}
			
		});
		
		frame.setJMenuBar(menuBar);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		if (!Desktop.isDesktopSupported()) {
			System.out.println("Desktop class is unsupported on this platform");
			System.exit(1);
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				constructGUI();
			}
		});
	}
}
