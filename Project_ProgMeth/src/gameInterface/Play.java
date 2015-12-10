package gameInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JPanel;

import utility.Resource;

public class Play extends JComponent {
	
	private static BufferedImage image;
	
	public Play() {
		super();
		this.setPreferredSize(new Dimension(960, 540));
		setDoubleBuffered(true);
		image = Resource.playBackground;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setBackground(Color.BLACK);
		g2d.drawImage(image, null, 0, 0);
	}
	

}
