package gameInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JPanel;

import utility.Resource;
import utility.numberFormat;

public class Play extends JComponent {
	
	private static BufferedImage image;
	private int score;
	
	public Play() {
		super();
		this.setPreferredSize(new Dimension(960, 540));
		setDoubleBuffered(true);
		image = Resource.playBackground;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		// background Image
		g2d.drawImage(image, null, 0, 0);
		
		// left zone
		
		// TEMP
		score = 1574;
		g2d.setColor(Color.WHITE);
		g2d.setFont(Resource.Myriad_Pro);
		FontMetrics fontMetrics = g2d.getFontMetrics();
		// END TEMP
		g2d.drawString(numberFormat.toString(score), 235 - fontMetrics.stringWidth(numberFormat.toString(score)), 190);
	}
	

}
