/**
 * 
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Shiqi
 *
 */
public class myAppUI implements ActionListener {

	private Logger log = Logger.getLogger(myAppUI.class.getName());
	private JFrame frame = null;
	private JPanel mainPanel = null;
	private JButton startBtn = null;
	private JButton stopBtn = null;
	private MyCanvas canvas = null;
	
	//constructor
	public myAppUI(){
		log.info("App started");
		initGUI();
	}
	
	private void initGUI(){
		frame = new JFrame();
		frame.setSize(500,400);
		frame.setTitle("myAppUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		frame.setLayout(new BorderLayout());
		frame.add(getMainPanel(), BorderLayout.NORTH);
		canvas = new MyCanvas();
		frame.add(canvas, BorderLayout.CENTER);
	}
	
	//Build the top main panel
	private JPanel getMainPanel(){
		mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());
		mainPanel.setBackground(Color.CYAN);
		
		startBtn = new JButton("Start");
		startBtn.addActionListener(this);//subscribe to button events
		stopBtn = new JButton("Stop");
		stopBtn.addActionListener(this);//subscribe to button events
		
		mainPanel.add(startBtn);//add the start button
		mainPanel.add(stopBtn);//add the stop button
		
		
		
		return mainPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0){
		log.info("We reeived on ActionEvent " + arg0);
		if(arg0.getActionCommand().equalsIgnoreCase("Start"))
			System.out.println("Start was pressed");
		if(arg0.getActionCommand().equalsIgnoreCase("Stop"))
			System.out.println("Stop was pressed");
	}
	
	public static void main(String[] args){
		myAppUI myApp = new myAppUI();
		System.out.println("App ended!!");
	}
}
