package utility;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Resource {
	public static final int SCREEN_WIDTH = 960;
	public static final int SCREEN_HEIGHT = 540;
	
	public static BufferedImage playBackground = getImage("res/playBackground.jpg");
	
	public Resource() {
		super();
	}
	
	private static BufferedImage getImage(String directory) {
		try {
			ClassLoader loader = Resource.class.getClassLoader();
			return ImageIO.read(loader.getResource(directory));
		} catch (Exception e) {
			return null;
		}
	}
	
//	static {
//		try {
//			ClassLoader loader = Resource.class.getClassLoader();
//			playBackground = ImageIO.read(loader.getResource("res/playBackground.jpg"));
//			System.out.println("Image load succeed.");
//		} catch (IOException e) {
//			playBackground = null;
//			System.out.println("Image load fail.");
//			
//		}
//	}

}
