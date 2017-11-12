/**
 * 
 */
package edu.neu.csye6200.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * @author Shiqi
 *
 */
public class MyCanvas extends JPanel {

	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		Dimension size = getSize();
		
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, size.width, size.height);
		
		g2d.setColor(Color.black);
		BGGeneration test = new BGGeneration(3, 100, 5, 0);
		for(BGStem stem : test.tree){
			g2d.drawLine((int)stem.xstart + 450, (int)stem.ystart + 400, (int)stem.xend +450, (int)stem.yend + 400);
			System.out.println(stem.toString());
		}
		
		
	}

}
