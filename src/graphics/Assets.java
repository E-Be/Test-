package graphics;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage sword, shield, bow, lance, wand;
	
	private static final int width = 64, height = 64;
	
	public static void init() {
	
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Test Sprite Sheet.png"));
		
		sword = sheet.crop(0, 0, width, height);
		shield = sheet.crop(width, 0, width, height);
		bow = sheet.crop(2*width, 0, width, height);
		lance = sheet.crop(3*width, 0, width, height);
		wand = sheet.crop(0, height, width, height);
		
			
		}
		
		
	}
	
	
	


