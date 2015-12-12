package shape;

import java.awt.Color;
import java.awt.image.BufferedImage;

import utility.Resource;

public class Shape {
	private BufferedImage shapeImage;
	private int[][] shapeArray;
	private Blocks[][] blocksInShape;
	private Color shapeColor;
	
	public Color getShapeColor() {
		return shapeColor;
	}

	public Shape(String directory, int[][] shapeArray, Color shapeColor) {
		shapeImage = Resource.getImage(directory);
		this.shapeArray = shapeArray;
		this.shapeColor = shapeColor;
		generateBlocksInShape();
	}

	public BufferedImage getShapeImage() {
		return shapeImage;
	}

	public int[][] getShapeArray() {
		return shapeArray;
	}
	
	public void generateBlocksInShape() {
		blocksInShape = new Blocks[shapeArray.length][shapeArray[0].length];
		for (int i = 0; i < blocksInShape.length; i++) {
			for (int j = 0; j < blocksInShape[0].length; j++) {
				if (shapeArray[i][j] == 1) {
					blocksInShape[i][j] = new Blocks(Blocks.FILLED_IN_SHAPE, shapeColor);
				} else {
					blocksInShape[i][j] = new Blocks(Blocks.BLANK, null);
				}
			}
		} 
	}

}
