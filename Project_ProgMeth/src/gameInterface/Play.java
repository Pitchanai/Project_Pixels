package gameInterface;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

import shape.Blocks;
import shape.Shape;
import utility.NumberFormat;
import utility.RandomUtility;
import utility.Resource;
import utility.TimeFormat;

public class Play extends JPanel {
	private boolean firstTime = true;
	
	private int score = 1574;
	private int time;
	
	private boolean noShapeLeft = true;
	private int[] shapeSelect = new int[4];
	private boolean[] shapeUsed = new boolean[4];
	
	private ArrayList<Shape> allShape = new ArrayList<Shape>();
	
	private static int playerStatus;
	private static final int CLICKED_ITEM_1 = 0;
	private static final int CLICKED_ITEM_2 = 1;
	private static final int CLICKED_ITEM_3 = 2;
	private static final int CLICKED_ITEM_4 = 3;
	private static final int NOT_CLICKED = 5;
	
	private Blocks[][] field = new Blocks[10][10];
	private boolean mouseEntered = false;
	private int mouseX;
	private int mouseY;
	
	public Play() {
//		super();
		if (firstTime) {
			generateShape();
			generateField();
			firstTime = false;
			System.out.println("GAME OPENED.");
		}
		this.setLayout(null);
		this.setPreferredSize(new Dimension(960, 540));
		setDoubleBuffered(true);
		Arrays.fill(shapeUsed, false);
		
		playerStatus = NOT_CLICKED;
		
		if (noShapeLeft) {
			shapeSelect = RandomUtility.shape(allShape.size());
		}
		
		JPanel shape1 = new JPanel();
		shape1.setOpaque(false);
		shape1.setSize(150, 150);
		shape1.setLocation(650, 120);
		shape1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (playerStatus != CLICKED_ITEM_1)
					playerStatus = CLICKED_ITEM_1;
				else
					playerStatus = NOT_CLICKED;
			}			
		});
		JPanel shape2 = new JPanel();
		shape2.setOpaque(false);
		shape2.setSize(150, 150);
		shape2.setLocation(800, 120);
		shape2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (playerStatus != CLICKED_ITEM_2)
					playerStatus = CLICKED_ITEM_2;
				else
					playerStatus = NOT_CLICKED;
			}			
		});
		JPanel shape3 = new JPanel();
		shape3.setOpaque(false);
		shape3.setSize(150, 150);
		shape3.setLocation(650, 270);
		shape3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (playerStatus != CLICKED_ITEM_3)
					playerStatus = CLICKED_ITEM_3;
				else
					playerStatus = NOT_CLICKED;
			}			
		});
		JPanel shape4 = new JPanel();
		shape4.setOpaque(false);
		shape4.setSize(150, 150);
		shape4.setLocation(800, 270);
		shape4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (playerStatus != CLICKED_ITEM_2)
					playerStatus = CLICKED_ITEM_4;
				else
					playerStatus = NOT_CLICKED;
			}			
		});
		
		JPanel center = new JPanel();
		center.setOpaque(false);
		center.setSize(375, 375);
		center.setLocation(263, 83);
		center.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent e) {}
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				getCoordinate(e);
			}
			
			void getCoordinate(MouseEvent e) {
				if ((e.getX() % 38) <= 33 && (e.getY()) % 38 <= 33)
					mouseEntered = true;
				else 
					mouseEntered = false;
				mouseX = e.getX() / 38;
				mouseY = e.getY() / 38;
//				System.out.println("mouseEnter = " + mouseEntered + "\t(" + mouseX + "," + mouseY + ")");
		    }
			
		});
		center.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				mouseEntered = false;
			}
		});

		updateField();
		
		this.add(shape1);
		this.add(shape2);
		this.add(shape3);
		this.add(shape4);
		
		this.add(center);
		
		this.setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		// TEMP
		int highScore = 36598;
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
//		g2d.fillRect(263, 83, 28, 28);
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				g2d.setColor(field[i][j].getBlockColor());
//				if (i == mouseX && j == mouseY && mouseEntered)
//					g2d.setColor(Color.RED);
				g2d.fillRect((i * 38) + 263, (j * 38) + 83, 33, 33);
				}
		}
		
		// right zone
		g2d.drawImage(allShape.get(this.shapeSelect[0]).getShapeImage(), null, 650, 120);
		g2d.drawImage(allShape.get(this.shapeSelect[1]).getShapeImage(), null, 800, 120);
		g2d.drawImage(allShape.get(this.shapeSelect[2]).getShapeImage(), null, 650, 270);
		g2d.drawImage(allShape.get(this.shapeSelect[3]).getShapeImage(), null, 800, 270);
		if (playerStatus == CLICKED_ITEM_1) {
			g2d.drawRect(650, 120, 150, 150);
		} else if (playerStatus == CLICKED_ITEM_2) {
			g2d.drawRect(800, 120, 150, 150);
		} else if (playerStatus == CLICKED_ITEM_3) {
			g2d.drawRect(650, 270, 150, 150);
		} else if (playerStatus == CLICKED_ITEM_4) {
			g2d.drawRect(800, 270, 150, 150);
		}
		
	}
	
	private void generateShape() {
		// all shape data put it in here
		int[][] array = fillShapeArray(5, 1, "11111");
		allShape.add(new Shape("res/shape/shape01.png", array, Resource.orange));
		
		array = fillShapeArray(3, 1, "111");
		allShape.add(new Shape("res/shape/shape02.png", array, Resource.green));
		
		array = fillShapeArray(3, 3, "111111111");
		allShape.add(new Shape("res/shape/shape03.png", array, Resource.blue));
		
		array = fillShapeArray(3, 3, "111100100");
		allShape.add(new Shape("res/shape/shape04.png", array, Resource.purple));
		
		 array = fillShapeArray(4, 2, "11101010");
		 allShape.add(new Shape("res/shape/shape05.png", array, Resource.pink));
	}
	
	private void generateField() {
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
					field[i][j] = new Blocks(Blocks.BLANK, Color.LIGHT_GRAY);
			}
		}
	}
	
	public void updateField() {
		System.out.println("Update Field");
		
		if (playerStatus == NOT_CLICKED) {
			return;
		}
		else if (shapeUsed[playerStatus]) {
			return;
		}
		else if (playerStatus != NOT_CLICKED && !shapeUsed[playerStatus]) {
			for (int i = 0; i < field.length; i++) {
				for (int j = 0; j < field[0].length; j++) {
					field[i][j].undoCanFill();
				}
			}
			
			Shape shape = allShape.get(shapeSelect[playerStatus]);
			// TODO fill can place
			if (true) {
				int[][] shapeArray = shape.getShapeArray();
				for (int i = 0; i < shapeArray.length; i++) {
					for (int j = 0; j < shapeArray[0].length; j++) {
						if (shapeArray[i][j] == 1 && mouseEntered) {
							if ((shapeArray.length + mouseX) <= field.length && (shapeArray[0].length + mouseY) <= field[0].length) {
								System.out.println("CAN FILL");
								field[i + mouseX][j + mouseY].setCanFill();
							}
						}
					}
				}
			}
			
		}
	}
	
	private static int[][] fillShapeArray(int y, int x, String data) {
		if ((x * y) != data.length()) {
			System.out.println("shape x = " + x + " y = " + y + "error : " + data);
			return null;
		} else {
			int[][] output = new int[x][y];
			int count = 0;
			for (int j = 0; j < y; j++) {
				for (int i = 0; i < x; i++) {
					output[i][j] = Integer.parseInt(data.substring(count, count+1));
					count++;
				}
			}
			return output;
		}
	}
	

}
