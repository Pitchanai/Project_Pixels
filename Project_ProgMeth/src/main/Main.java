package main;

import javax.swing.JFrame;

import gameInterface.Home;
import gameInterface.Play;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Pixel");
		Home testScreen = new Home();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(testScreen);
		frame.pack();
		frame.setVisible(true);
		testScreen.requestFocus();
		
		while (true) {
			testScreen.requestFocus();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			testScreen.repaint();
		}
	}

}
