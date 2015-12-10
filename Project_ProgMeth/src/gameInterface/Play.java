package gameInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import utility.Resource;

public class Play extends JPanel {
	
	private static BufferedImage Image;
	
	public Play() {
		this.setPreferredSize(new Dimension(960, 540));
		this.setDoubleBuffered(true);
	}
	
	protected void painComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.clearRect(0, 0, this.getWidth(), this.getHeight());
		g.drawImage(Resource.playBackground, 0, 0, null);
		
		try {
			ClassLoader loader = Play.class.getClassLoader();
			Image = Resource.playBackground;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Picture file not found!", "Error", JOptionPane.ERROR_MESSAGE);
			Image = null;
		}
	}
	

}
