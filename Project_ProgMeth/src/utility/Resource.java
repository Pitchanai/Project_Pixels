package utility;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Resource {
	public static final int SCREEN_WIDTH = 960;
	public static final int SCREEN_HEIGHT = 540;
	
	public static BufferedImage playBackground;
	
	public Resource() {
		super();
	}
	static {
		try {
			ClassLoader loader = Resource.class.getClassLoader();
			playBackground = ImageIO.read(loader.getResource("res/playBackground.jpg"));
		} catch (IOException e) {
			playBackground = null;
			System.out.println("Image load fail.");
			
		}
	}

}
