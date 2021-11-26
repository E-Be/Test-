package graphics;

import java.awt.Font;
import java.io.InputStream;




public class AssetsFonts {
	
	public static Font pieces24;
	public static Font typeWriter24;
	
	public static void init() {
		
		InputStream is = AssetsFonts.class.getResourceAsStream("/fonts/pieces_of_eight/Pieces of Eight.ttf");
		pieces24 = FontLoader.loadFont(is, 24);
		InputStream is2 = AssetsFonts.class.getResourceAsStream("/fonts/jmh_typewriter/JMH Typewriter.ttf");
		typeWriter24 = FontLoader.loadFont(is2, 24);
		
		}
	
	

}
