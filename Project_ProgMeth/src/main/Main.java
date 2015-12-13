package main;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gameInterface.HighScore;
import gameInterface.Home;
import gameInterface.HowToPlay;
import gameInterface.Play;

public class Main extends JFrame{
	/*public static boolean homeToPlay = false;
	public static boolean playToHome = false;
	public static boolean homeToHigh = false;
	public static boolean highToHome = false;
	public static boolean homeToHow = false;
	public static boolean howToHome = false;*/
	public static JFrame frame;
	public static Home home = new Home();;
	public static HighScore high = new HighScore();
	public static HowToPlay how = new HowToPlay();
	public static Play play = new Play();
	public static void main(String[] args) {
		
		frame = new JFrame("Pixel");
		frame.setContentPane(home);
		frame.revalidate();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		home.requestFocus();
	
		
		while (frame.isVisible() && home.requestFocus(true)) {
			home.requestFocus();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			home.repaint();
		}
		
		while (frame.isVisible() && high.requestFocus(true)) {
			high.requestFocus();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			high.repaint();
		}
		
		while (frame.isVisible() && how.requestFocus(true)) {
			how.requestFocus();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			how.repaint();
		}
		
		while (frame.isVisible() && play.requestFocus(true)) {
			play.requestFocus();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			play.repaint();
		}
		
	}
	/*
	public static void setHomeToPlay(boolean homeToPlay) {
		Main.homeToPlay = homeToPlay;
	}
	public static void setPlayToHome(boolean playToHome) {
		Main.playToHome = playToHome;
	}
	public static void setHomeToHigh(boolean homeToHigh) {
		Main.homeToHigh = homeToHigh;
	}
	public static void setHighToHome(boolean highToHome) {
		Main.highToHome = highToHome;
	}
	public static void setHomeToHow(boolean homeToHow) {
		Main.homeToHow = homeToHow;
	}
	public static void setHowToHome(boolean howToHome) {
		Main.howToHome = howToHome;
	}*/

}
