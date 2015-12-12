package utility;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import shape.Shape;

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
	public static Color blue = new Color(0x809bcd);
	public static Color pink = new Color(0xf6cac9);
	public static Color silverGrey = new Color(0xc0b7af);
	public static Color green = new Color(0xb6ba99);
	public static Color purple = new Color(0xb2677a);
	public static Color yellow = new Color(0xddbf5e);
	public static Color creme = new Color(0xceb799);
	public static Color opalBlue = new Color(0xc3ddd6);
	public static Color arcticGreen = new Color(0x648589);
	public static Color orange = new Color(0xeb9587);
	
	
	public Resource() {
		super();
	}
	
	public static BufferedImage getImage(String directory) {
		try {
			ClassLoader loader = Resource.class.getClassLoader();
			return ImageIO.read(loader.getResource(directory));
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String registerFont(String directory, String fontName) {
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
