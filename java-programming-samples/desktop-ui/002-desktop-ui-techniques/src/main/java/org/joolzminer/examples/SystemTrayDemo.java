package org.joolzminer.examples;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class SystemTrayDemo {
	private static void constructGUI() {
		if (!SystemTray.isSupported()) {
			System.out.println("SystemTray is not supported in this platform!");
			System.exit(1);
		}
		
		SystemTray tray = SystemTray.getSystemTray();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("target/classes/airplane.gif");
		
		PopupMenu menu = new PopupMenu();
		MenuItem messageItem = new MenuItem("Show Message");
		messageItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Hello, System Tray!");
			}
		});
		
		menu.add(messageItem);
		
		MenuItem closeItem = new MenuItem("Close");
		closeItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		menu.add(closeItem);
		
		TrayIcon icon = new TrayIcon(image, "SystemTray Demo", menu);
		icon.setImageAutoSize(true);
		
		try {
			tray.add(icon);
		} catch (AWTException e1) {
			System.out.println("Could not add icon to System's tray");
			System.exit(1);
		}
		
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
