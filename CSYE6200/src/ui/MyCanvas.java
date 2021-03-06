/**
 * 
 */
package ui;

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
		
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, size.width, size.height);
		
		g2d.setColor(Color.GREEN);
		g2d.drawString("Hello World 2D", 10, 20);
		
		g2d.setColor(Color.RED);
		g2d.drawLine(0, 0, size.width, size.height);
		
		int boxSize = 10;
		int maxRows = size.height / (boxSize + 2);
		for(int j = 0; j < maxRows; j++){
			for(int i = 0; i <= 20; i++){
				Color col = new Color(50 + i * 10, 255 - j * 10, 50);
				g2d.setColor(col);
				g2d.fillRect(i*20, j*20, boxSize, boxSize);
			}
		}
	}

}
