/**
 * 
 */
package edu.neu.csye6200.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author Shiqi
 *
 */
public class ShiqiAPP implements ActionListener, ChangeListener {
	private static final int ANGLE_MIN = 0;
	private static final int ANGLE_MAX = 90;
	private static final int ANGLE_INIT = 45; // initial stem angle
	private static final int LENGTH_MIN = 100;
	private static final int LENGTH_MAX = 500;
	private static final int LENGTH_INIT = 350;// initial stem length
	final static int maxGap = 20;
	private Logger log = Logger.getLogger(ShiqiAPP.class.getName());
	private JFrame frame;
	private JPanel mainPanel = null;
	private JSlider angleSlider = null;
	private JSlider lengthSlider = null;
	JComboBox<String> forkNumList;
	JComboBox<String> generationNumList;
	private JButton startBtn = null;
	private JButton stopBtn = null;
	private MyCanvas canvas = new MyCanvas();
	private int forkNum = 2;
	private int angle = ANGLE_INIT;
	private int initialLength = LENGTH_INIT;
	private int generationNum = 5;
	// constructor
	public ShiqiAPP() {
		log.info("App started");
		initGUI();

	}

	private void initGUI() {
		frame = new JFrame();
		frame.setSize(1500, 900);
		frame.setTitle("ShiqiAPP");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());
		JLabel title = new JLabel("<html><font size=+5><b>SHIQI'S BIOLOGICAL GROWTH</b></font></html>", JLabel.CENTER);
		title.setPreferredSize(new Dimension(frame.getWidth(), frame.getHeight() / 8));
		frame.add(title, BorderLayout.NORTH);
		frame.add(getMainPanel(), BorderLayout.EAST);
		frame.add(canvas, BorderLayout.CENTER);
	}

	/**
	 * @return JPanel Build the top main panel
	 */
	private JPanel getMainPanel() {
		// initialize mainPanel
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

		// initialize two buttons
		startBtn = new JButton("Generate");
		startBtn.addActionListener(this);// subscribe to button events
		stopBtn = new JButton("Clear");
		stopBtn.addActionListener(this);// subscribe to button events

		// initialize the angleSilder section
		JLabel lb1 = new JLabel("<html><font size=+2><b>Choose an angle</b></font></html>");
		angleSlider = new JSlider(JSlider.HORIZONTAL, ANGLE_MIN, ANGLE_MAX, ANGLE_INIT);
		angleSlider.addChangeListener(this);
		angleSlider.setMajorTickSpacing(15);
		angleSlider.setMinorTickSpacing(5);
		angleSlider.setPaintTicks(true);
		angleSlider.setPaintLabels(true);

		// initialize the fork number list section
		JLabel lb2 = new JLabel("<html><font size=+2><b>Forks</b></font></html>");
		String[] forkNumStrings = { "2", "3", "4", "5", "6", "7", "8" };
		// Create the combo box, select item at index 0.
		// Indices start at 0, so 0 specifies "2".
		forkNumList = new JComboBox<String>(forkNumStrings);
		forkNumList.setSelectedIndex(1);// default selected fork number is 3
		forkNumList.addActionListener(this);

		// initialize the lengthSilder section
		JLabel lb3 = new JLabel("<html><font size=+2><b>Choose an initial lenght of the stem</b></font></html>");
		lengthSlider = new JSlider(JSlider.HORIZONTAL, LENGTH_MIN, LENGTH_MAX, LENGTH_INIT);
		lengthSlider.addChangeListener(this);
		lengthSlider.setMajorTickSpacing(50);
		lengthSlider.setMinorTickSpacing(25);
		lengthSlider.setPaintTicks(true);
		lengthSlider.setPaintLabels(true);

		// initialize the generation number list section
		JLabel lb4 = new JLabel("<html><font size=+2><b>Choose a number of generation</b></font></html>");
		String[] generationNumStrings = { "1", "2", "3", "4", "5", "6", "7" };
		generationNumList = new JComboBox<String>(generationNumStrings);
		generationNumList = new JComboBox<String>(generationNumStrings);
		generationNumList.setSelectedIndex(4);// default selected fork number is 5
		generationNumList.addActionListener(this);

		// set the layout
		mainPanel.add(lb1);
		mainPanel.add(angleSlider);
		mainPanel.add(lb2);
		mainPanel.add(forkNumList);
		mainPanel.add(lb3);
		mainPanel.add(lengthSlider);
		mainPanel.add(lb4);
		mainPanel.add(generationNumList);
		mainPanel.add(startBtn);
		mainPanel.add(stopBtn);

		return mainPanel;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		log.info("We reeived on ActionEvent " + arg0);
		if (arg0.getActionCommand().equalsIgnoreCase("Generate")) {
			BGRule rule = new BGRule(forkNum, angle, initialLength);
			BGGeneration test = new BGGeneration(rule, generationNum);
			System.out.println("Generate: " + "\nRule: " + "BGRule(fork: " + forkNum + ", angle: " + angle
					+ ", length: " + initialLength + ")"
					+"\nGenerations: " + generationNum);
			canvas.setTree(test.tree);
			canvas.repaint();
		} else if (arg0.getActionCommand().equalsIgnoreCase("Clear")) {
			// System.out.println("Clear was pressed");
			canvas.setTree(null);
			canvas.repaint();
		} else {
			JComboBox<String> source = (JComboBox<String>) arg0.getSource();
			if (source == forkNumList)
				forkNum = Integer.parseInt((String) source.getSelectedItem());
			if (source == generationNumList)
				generationNum = Integer.parseInt((String) source.getSelectedItem());
				//System.out.println("generationNum: " +generationNum);
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider) e.getSource();
		if (!source.getValueIsAdjusting()) {
			if (source == angleSlider)
				angle = (int) source.getValue();
			if (source == lengthSlider)
				initialLength = (int) source.getValue();
		}
	}

	public static void main(String[] args) {
		new ShiqiAPP();
	}

}
