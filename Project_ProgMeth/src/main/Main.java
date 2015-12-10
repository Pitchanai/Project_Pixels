package main;

import javax.swing.JFrame;

import gameInterface.Play;

public class Main {
	public static void main(String[] args) {
		Play testScreen = new Play();
		JFrame f = new JFrame("Pixel");
		f.setResizable(false);
		f.add(testScreen);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}

}
