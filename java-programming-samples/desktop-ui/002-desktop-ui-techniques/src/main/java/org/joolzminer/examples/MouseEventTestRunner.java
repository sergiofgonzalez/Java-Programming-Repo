package org.joolzminer.examples;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

class MouseClickListener extends MouseAdapter {

	@Override
	public void mouseClicked(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			System.out.print("The mouse left button was clicked ");			
		} else if (SwingUtilities.isRightMouseButton(e)) {
			System.out.print("The mouse right button was clicked ");
		} else if (SwingUtilities.isMiddleMouseButton(e)) {
			System.out.print("The mouse middle button was clicked ");
		}
		
		System.out.print(e.getClickCount() + " time(s) ");
		System.out.println("at (" + e.getX() + ", " + e.getY() + ")");
	}	
}

public class MouseEventTestRunner {
	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Mouse Listener Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addMouseListener(new MouseClickListener());
		frame.setSize(200, 200);
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
