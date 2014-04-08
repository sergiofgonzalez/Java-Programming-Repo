package org.joolzminer.examples;


import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/*
 * see http://docs.oracle.com/javase/tutorial/figures/uiswing/layout/find.png
 */
public class GroupLayoutTestRunner extends JFrame {
	private static final long serialVersionUID = 1L;

	public GroupLayoutTestRunner() {
		JLabel label = new JLabel("Find What:");
		JTextField textField = new JTextField();
		JCheckBox caseCheckBox = new JCheckBox("Match Case");
		JCheckBox wrapCheckBox = new JCheckBox("Wrap Around");
		JCheckBox wholeCheckBox = new JCheckBox("Whole Words");
		JCheckBox backCheckBox = new JCheckBox("Search Backwards");
		JButton findButton = new JButton("Find");
		JButton cancelButton = new JButton("Cancel");
		
		// remove redundant default border of check boxes
		caseCheckBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		wrapCheckBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		wholeCheckBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		backCheckBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		setLayout(groupLayout);
		groupLayout.setAutoCreateGaps(true);
		groupLayout.setAutoCreateContainerGaps(true);
		
		groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
				.addComponent(label)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textField)
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(caseCheckBox)
										.addComponent(wholeCheckBox))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(wrapCheckBox)
										.addComponent(backCheckBox))))
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(findButton)
						.addComponent(cancelButton))
		);
		
		groupLayout.linkSize(SwingConstants.HORIZONTAL, findButton, cancelButton);
		
		groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField)
						.addComponent(findButton))
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(caseCheckBox)
										.addComponent(wrapCheckBox))
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(wholeCheckBox)
										.addComponent(backCheckBox)))
						.addComponent(cancelButton))
		);
	}
	
	public static void constructGUI() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new GroupLayoutTestRunner();
		
		frame.setTitle("Find");
		frame.setResizable(false);
		frame.pack();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
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
