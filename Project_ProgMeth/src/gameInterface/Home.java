package gameInterface;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;

import javafx.scene.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Main;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import utility.Resource;

public class Home extends JPanel {

	private BufferedImage start, highScore, howToPlay;
	private Point startPoint, highScorePoint, howToPlayPoint;
	private BasicPlayer player1, player2;

	public Home() {
		this.setVisible(true);
		setPreferredSize(new Dimension(960, 540));
		
		//music player
		
		player1 = new BasicPlayer();
			try{
				player1.open(Resource.homesound);
				player1.play();
				player1.setGain(0.5);
			}catch (BasicPlayerException e) {
				e.printStackTrace();
			}
		
		//click sound player
			
		player2 = new BasicPlayer();
			try {
				player2.open(Resource.clicksound);
			} catch (BasicPlayerException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		
		//set Point
		start = Resource.start1;
		startPoint = new Point(Resource.SCREEN_WIDTH / 2 - (180 / 2), Resource.SCREEN_HEIGHT / 2 + 50);
		
		highScore = Resource.highscore1;
		highScorePoint = new Point(Resource.SCREEN_WIDTH / 2 - (105 * 2), Resource.SCREEN_HEIGHT / 2 + 50);
		
		howToPlay = Resource.howtoplay1;
		howToPlayPoint = new Point(Resource.SCREEN_WIDTH / 2 + (105), Resource.SCREEN_HEIGHT / 2 + 50);
		
		//Set Mouse at button
		addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (start != null && startPoint != null) {
					Point st = e.getPoint();
					Rectangle bounds = new Rectangle(startPoint, new Dimension(
							start.getWidth(), start.getHeight()));
					if (bounds.contains(st)) {
						pushStart();
						
						try {
							player2.play();
							player2.setGain(0.1);
							player1.stop();
							player1.open(Resource.playsound);
							player1.play();
							player1.setGain(0.4);
						} catch (BasicPlayerException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				if (howToPlay != null && howToPlayPoint != null) {
					Point ht = e.getPoint();
					Rectangle bounds = new Rectangle(howToPlayPoint, new Dimension(
							howToPlay.getWidth(), howToPlay.getHeight()));
					if (bounds.contains(ht)) {
						pushHowToPlay();
						
						try {
							player2.play();
							player2.setGain(0.1);
						} catch (BasicPlayerException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				if (highScore != null && highScorePoint != null) {
					Point hs = e.getPoint();
					Rectangle bounds = new Rectangle(highScorePoint, new Dimension(
							highScore.getWidth(), highScore.getHeight()));
					if (bounds.contains(hs)) {
						pushHighScore();
						
						try {
							player2.play();
							player2.setGain(0.1);
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
		g2d.drawImage(Resource.homeBackground, null, 0, 0);
		
		// button Image
		
		g2d.drawImage(start, null, Resource.SCREEN_WIDTH / 2 - (180 / 2), Resource.SCREEN_HEIGHT / 2 + 50);
		g2d.drawImage(Resource.highscore1, null, Resource.SCREEN_WIDTH / 2 - (105 * 2), Resource.SCREEN_HEIGHT / 2 + 50);
		g2d.drawImage(Resource.howtoplay1, null, Resource.SCREEN_WIDTH / 2 + (105), Resource.SCREEN_HEIGHT / 2 + 50);
	
		// logo Image
		g2d.drawImage(Resource.newlogo1, null, Resource.SCREEN_WIDTH / 2 - (636 / 2), 50);
		logo();
		
		
	}
	
	// anime for LOGO
	public void logo(){
		Graphics g = getGraphics();
		super.paintComponents(g);
		Graphics2D g2d = (Graphics2D) g;
		try {
			Thread.sleep(50);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		g2d.drawImage(Resource.newlogo2, null, Resource.SCREEN_WIDTH / 2 - (636 / 2), 50);
		try {
			Thread.sleep(50);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		g2d.drawImage(Resource.newlogo3, null, Resource.SCREEN_WIDTH / 2 - (636 / 2), 50);
		try {
			Thread.sleep(50);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		g2d.drawImage(Resource.newlogo4, null, Resource.SCREEN_WIDTH / 2 - (636 / 2), 50);
		try {
			Thread.sleep(50);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	// when click Start
	private void pushStart() {
		//Main.setHomeToPlay(true);
		
		Graphics g = getGraphics();
		super.paintComponents(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(Resource.start2, null, Resource.SCREEN_WIDTH / 2 - (180 / 2), Resource.SCREEN_HEIGHT / 2 + 50);
		try {
			Thread.sleep(50);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		g2d.drawImage(start, null, Resource.SCREEN_WIDTH / 2 - (180 / 2), Resource.SCREEN_HEIGHT / 2 + 50);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//if(Main.homeToPlay == true){
		Main.frame.getContentPane().removeAll();
		Main.frame.setContentPane(Main.play);
		Main.frame.revalidate();
		//}
		
		//Main.setHomeToPlay(false);

	}
	// when Click HighScore
	private void pushHighScore() {
		//Main.setHomeToHigh(true);
		
		Graphics g = getGraphics();
		super.paintComponents(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(Resource.highscore2, null, Resource.SCREEN_WIDTH / 2 - (105 * 2), Resource.SCREEN_HEIGHT / 2 + 50);
		try {
			Thread.sleep(50);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		g2d.drawImage(Resource.highscore1, null, Resource.SCREEN_WIDTH / 2 - (105 * 2), Resource.SCREEN_HEIGHT / 2 + 50);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//if(Main.homeToHigh == true){
		Main.frame.getContentPane().removeAll();
		Main.frame.setContentPane(Main.high);
		Main.frame.revalidate();
		//}
		
		//Main.setHomeToHigh(false);
	}
	// when Click How to Play
	private void pushHowToPlay() {
		//Main.setHomeToHow(true);
		
		Graphics g = getGraphics();
		super.paintComponents(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(Resource.howtoplay2, null, Resource.SCREEN_WIDTH / 2 + (105), Resource.SCREEN_HEIGHT / 2 + 50);
		try {
			Thread.sleep(50);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		g2d.drawImage(Resource.howtoplay1, null, Resource.SCREEN_WIDTH / 2 + (105), Resource.SCREEN_HEIGHT / 2 + 50);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//if(Main.homeToHow == true){
		Main.frame.getContentPane().removeAll();
		Main.frame.setContentPane(Main.how);
		Main.frame.revalidate();
		//}
		
		//Main.setHomeToHow(false);
	}
}
