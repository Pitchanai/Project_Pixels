package shape;

import java.awt.image.BufferedImage;

import utility.Resource;

public class Shape {
	private BufferedImage shapeImage;
	private int[][] shapeArray;
	
	public Shape(String directory, int[][] shapeArray) {
		shapeImage = Resource.getImage(directory);
		this.shapeArray = shapeArray;
	}

	public BufferedImage getShapeImage() {
		return shapeImage;
	}

	public int[][] getShapeArray() {
		return shapeArray;
	}

}
