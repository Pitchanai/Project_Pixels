package gameInterface;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.Main;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import utility.Resource;

public class HighScore extends JPanel{
	private Point backPoint;
	private BufferedImage back;
	private BasicPlayer player;
	
	public HighScore() {
		this.setVisible(true);
		setPreferredSize(new Dimension(960, 540));
		
		//button sound player
		player = new BasicPlayer();
			try{
				player.open(Resource.clicksound);
			}catch (BasicPlayerException e) {
				e.printStackTrace();
			}
		
		//set Point
		back = Resource.backhome1;
		backPoint = new Point(30, Resource.SCREEN_HEIGHT - 120);
		
		
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (back != null && backPoint != null) {
					Point b = e.getPoint();
					Rectangle bounds = new Rectangle(backPoint, new Dimension(
							back.getWidth(), back.getHeight()));
					if (bounds.contains(b)) {
						pushBack();
						
						try {
							player.play();
							player.setGain(0.1);
						} catch (BasicPlayerException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2d = (Graphics2D) g;

		// background Image
		g2d.drawImage(Resource.highscoreBackground, null, 0, 0);
		
		// backhome Button
		g2d.drawImage(Resource.backhome1, null, 30, Resource.SCREEN_HEIGHT - 120);
	}
	
	private void pushBack() {
		//Main.setHighToHome(true);
		
		Graphics g = getGraphics();
		super.paintComponents(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(Resource.backhome2, null, 30, Resource.SCREEN_HEIGHT - 120);
		try {
			Thread.sleep(50);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		g2d.drawImage(Resource.backhome1, null, 30, Resource.SCREEN_HEIGHT - 120);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//if(Main.highToHome == true){
		Main.frame.getContentPane().removeAll();
		Main.frame.setContentPane(Main.home);
		Main.frame.revalidate();
		//}
		
		//Main.setHighToHome(false);
	}
}
