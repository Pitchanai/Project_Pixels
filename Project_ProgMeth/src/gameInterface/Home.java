package gameInterface;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utility.Resource;

public class Home extends JPanel {

	private BufferedImage start, highScore, howToPlay;
	private Point startPoint, highScorePoint, howToPlayPoint;
	private boolean isStart, isHighScore, isHowToPlay;
	

	public Home() {
		this.setVisible(true);
		setPreferredSize(new Dimension(960, 540));

		start = Resource.start1;
		startPoint = new Point(Resource.SCREEN_WIDTH / 2 - (180 / 2), Resource.SCREEN_HEIGHT / 2 + 50);
		
		highScore = Resource.highscore1;
		highScorePoint = new Point(Resource.SCREEN_WIDTH / 2 - (105 * 2), Resource.SCREEN_HEIGHT / 2 + 50);
		
		howToPlay = Resource.howtoplay1;
		howToPlayPoint = new Point(Resource.SCREEN_WIDTH / 2 + (105), Resource.SCREEN_HEIGHT / 2 + 50);
		
		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (start != null && startPoint != null) {
					Point st = e.getPoint();
					Rectangle bounds = new Rectangle(startPoint, new Dimension(
							start.getWidth(), start.getHeight()));
					if (bounds.contains(st)) {
						pushStart();
						
					}
				}
				if (howToPlay != null && howToPlayPoint != null) {
					Point ht = e.getPoint();
					Rectangle bounds = new Rectangle(howToPlayPoint, new Dimension(
							howToPlay.getWidth(), howToPlay.getHeight()));
					if (bounds.contains(ht)) {
						pushHowToPlay();
						
					}
				}
				if (highScore != null && highScorePoint != null) {
					Point hs = e.getPoint();
					Rectangle bounds = new Rectangle(highScorePoint, new Dimension(
							highScore.getWidth(), highScore.getHeight()));
					if (bounds.contains(hs)) {
						pushHighScore();
						
					}
				}
			}

		});

	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2d = (Graphics2D) g;

		// background Image
		g2d.drawImage(Resource.homeBackground, null, 0, 0);

		// button Image
		
		g2d.drawImage(start, null, Resource.SCREEN_WIDTH / 2 - (180 / 2), Resource.SCREEN_HEIGHT / 2 + 50);
		g2d.drawImage(Resource.highscore1, null, Resource.SCREEN_WIDTH / 2 - (105 * 2), Resource.SCREEN_HEIGHT / 2 + 50);
		g2d.drawImage(Resource.howtoplay1, null, Resource.SCREEN_WIDTH / 2 + (105), Resource.SCREEN_HEIGHT / 2 + 50);
	}
	
	private void pushStart() {
		isStart = true;
		Graphics g = getGraphics();
		super.paintComponents(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(Resource.start2, null, Resource.SCREEN_WIDTH / 2 - (180 / 2), Resource.SCREEN_HEIGHT / 2 + 50 + 7);
		try {
			Thread.sleep(150);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		isStart = false;
	}
	
	private void pushHighScore() {
		isHighScore = true;
		Graphics g = getGraphics();
		super.paintComponents(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(Resource.highscore2, null, Resource.SCREEN_WIDTH / 2 - (105 * 2), Resource.SCREEN_HEIGHT / 2 + 50 + 7);
		try {
			Thread.sleep(150);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		isHighScore = false;
	}
	
	private void pushHowToPlay() {
		isHowToPlay = true;
		Graphics g = getGraphics();
		super.paintComponents(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(Resource.howtoplay2, null, Resource.SCREEN_WIDTH / 2 + (105), Resource.SCREEN_HEIGHT / 2 + 50 + 7);
		try {
			Thread.sleep(150);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		isHowToPlay = false;
	}
}
