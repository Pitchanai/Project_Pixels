package gameInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import shape.Shape;
import utility.NumberFormat;
import utility.RandomUtility;
import utility.Resource;
import utility.TimeFormat;

public class Play extends JPanel {
	private int score;
	private int time;
	
	private boolean noShapeLeft = true;
	private int[] shapeSelect = new int[4];
	
	private static ArrayList<Shape> allShape = new ArrayList<Shape>();
	
	private static int playerStatus;
	
	public Play() {
//		super();
		generateShape();
		this.setLayout(null);
		this.setPreferredSize(new Dimension(960, 540));
		setDoubleBuffered(true);
		
		if (noShapeLeft) {
			shapeSelect = RandomUtility.shape(allShape.size());
		}
		
		JPanel shape1 = new JPanel();
		shape1.setOpaque(false);
		shape1.setSize(150, 150);
		shape1.setLocation(650, 120);
		JPanel shape2 = new JPanel();
		shape2.setOpaque(false);
		shape2.setSize(150, 150);
		shape2.setLocation(800, 120);
		JPanel shape3 = new JPanel();
		shape3.setOpaque(false);
		shape3.setSize(150, 150);
		shape3.setLocation(650, 270);
		JPanel shape4 = new JPanel();
		shape4.setOpaque(false);
		shape4.setSize(150, 150);
		shape4.setLocation(800, 270);
		
		this.add(shape1);
		this.add(shape2);
		this.add(shape3);
		this.add(shape4);
		
		this.setVisible(true);
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		// TEMP
		int highScore = 36598;
		score = 1574;
		time = 368;
		// END TEMP
		
		// background Image
		g2d.drawImage(Resource.playBackground, null, 0, 0);
		
		// left zone
		g2d.setColor(Color.WHITE);
		g2d.setFont(Resource.Myriad_Pro);
		FontMetrics fontMetrics = g2d.getFontMetrics();
		g2d.drawString(NumberFormat.toString(highScore), 235 - fontMetrics.stringWidth(NumberFormat.toString(highScore)), 175);
		g2d.drawString(NumberFormat.toString(score), 235 - fontMetrics.stringWidth(NumberFormat.toString(score)), 296);
		g2d.drawString(TimeFormat.minutes(time), 158 - fontMetrics.stringWidth(TimeFormat.minutes(time)), 425);
		g2d.drawString(":", 161, 421);
		g2d.drawString(TimeFormat.seconds(time), 178, 425);
		
		// center zone
		
		// right zone
		g2d.drawImage(allShape.get(this.shapeSelect[0]).getShapeImage(), null, 650, 120);
		g2d.drawImage(allShape.get(this.shapeSelect[1]).getShapeImage(), null, 800, 120);
		g2d.drawImage(allShape.get(this.shapeSelect[2]).getShapeImage(), null, 650, 270);
		g2d.drawImage(allShape.get(this.shapeSelect[3]).getShapeImage(), null, 800, 270);
		
		
	}
	
	private static void generateShape() {
		// all shape data put it in here
		int[][] array = fillShapeArray(5, 1, "11111");
		allShape.add(new Shape("res/shape/shape01.png", array));
		
		array = fillShapeArray(3, 1, "111");
		allShape.add(new Shape("res/shape/shape02.png", array));
		
		array = fillShapeArray(3, 3, "111111111");
		allShape.add(new Shape("res/shape/shape03.png", array));
		
		array = fillShapeArray(3, 3, "111100100");
		allShape.add(new Shape("res/shape/shape04.png", array));
		
		 array = fillShapeArray(4, 2, "11101010");
		 allShape.add(new Shape("res/shape/shape05.png", array));
	}
	
	private static int[][] fillShapeArray(int y, int x, String data) {
		if ((x * y) != data.length()) {
			System.out.println("shape x = " + x + " y = " + y + "error : " + data);
			return null;
		} else {
			int[][] output = new int[y][x];
			int count = 0;
			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					output[i][j] = Integer.parseInt(data.substring(count, count+1));
				}
			}
			return output;
		}
	}
	

}
