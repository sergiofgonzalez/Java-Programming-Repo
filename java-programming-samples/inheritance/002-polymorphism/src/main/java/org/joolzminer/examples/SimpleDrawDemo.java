package org.joolzminer.examples;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

interface Shape {
	void draw(Graphics g);
}

class Rectangle implements Shape {
	private int x1, y1, x2, y2;
	
	public Rectangle(int x1, int y1, int x2, int y2) {
		this.x1 = x1 < x2 ? x1 : x2;
		this.y1 = y1 < y2 ? y1 : y2;
		this.x2 = x1 < x2 ? x2 : x1;
		this.y2 = y1 < y2 ? y2 : y1;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fill3DRect(x1, y1, x2 - x1, y2 - y1, true);
	}
}

class Line implements Shape {
	private int x1, y1, x2, y2;
	
	public Line(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.drawLine(x1, y1, x2, y2);		
	}	
}

class Oval implements Shape {
	private int x1, y1, x2, y2;
	
	public Oval(int x1, int y1, int x2, int y2) {
		this.x1 = x1 < x2 ? x1 : x2;
		this.y1 = y1 < y2 ? y1 : y2;
		this.x2 = x1 < x2 ? x2 : x1;
		this.y2 = y1 < y2 ? y2 : y1;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(x1, y1, x2 - x1, y2 - y1);
	}
	
	
}

public class SimpleDrawDemo extends JFrame implements ActionListener, MouseListener {
	private int x1, y1, x2, y2;
	private List<Shape> shapes = new ArrayList<>();
	String shapeType = "Rectangle";
	
	public SimpleDrawDemo() {
		setTitle("SimpleDraw Demo (Polymorphism in Action)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ButtonGroup colorButtonGroup = new ButtonGroup();
		JRadioButton lineButton = new JRadioButton("Line");
		JRadioButton rectangleButton = new JRadioButton("Rectangle");
		JRadioButton ovalButton = new JRadioButton("Oval");
		colorButtonGroup.add(lineButton);
		colorButtonGroup.add(rectangleButton);
		colorButtonGroup.add(ovalButton);
		
		lineButton.addActionListener(this);
		rectangleButton.addActionListener(this);
		ovalButton.addActionListener(this);
		
		rectangleButton.setSelected(true);
		
		JPanel radioPanel = new JPanel(new FlowLayout());
		radioPanel.add(lineButton);
		radioPanel.add(rectangleButton);
		radioPanel.add(ovalButton);
		
		add(radioPanel);
		
		addMouseListener(this);
	}

	@Override
	public void paint(Graphics g) {
		paintComponents(g);
		for (Shape shape : shapes) {
			shape.draw(g);
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		shapeType = e.getActionCommand().toString();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
		Shape shape = null;
		
		switch (shapeType) {
			case "Rectangle" :
				if (x1 != x2 && y1 != y2) {
					shape = new Rectangle(x1, y1, x2, y2);
				}
				break;
				
			case "Oval" :
				if (x1 != x2 && y1 != y2) {
					shape = new Oval(x1, y1, x2, y2);
				}
				break;
			
			case "Line" :
				if (x1 != x2 && y1 != y2) {
					shape = new Line(x1, y1, x2, y2);
				}
				break;		
			
			default:
				throw new UnsupportedOperationException("Unknown shapeType:" + e);
		}
		
		if (shape != null) {
			shapes.add(shape);
			repaint();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
	
	private static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		SimpleDrawDemo frame = new SimpleDrawDemo();
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
