package utility;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Resource {
	public static final int SCREEN_WIDTH = 960;
	public static final int SCREEN_HEIGHT = 540;
	
	// image
	public static BufferedImage playBackground = getImage("res/play/playBackground.jpg");
	public static BufferedImage homeBackground;
	public static BufferedImage highscoreBackground;
	public static BufferedImage howToPlayBackground;
	
	// font
	public static Font TH_Sarabun_New = new Font(registerFont("res/font/THSarabunNew.ttf", "TH Sarabun New"), Font.PLAIN, 70);
	public static Font Myriad_Pro = new Font(registerFont("res/font/MyriadPro-Regular.ttf", "Myriad Pro"), Font.PLAIN, 60);
	
	
	// color
	
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
	
	private static String registerFont(String directory, String fontName) {
		try {
			ClassLoader loader = Resource.class.getClassLoader();
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(loader.getResource(directory).getPath())));
			return fontName;
		} catch (IOException | FontFormatException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
