import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;
import java.lang.Math;

class Noise extends PicPart {

	final Random rnd = new Random();

	@Override
	protected void paint(final BufferedImage bimg) {
		for(int iter = 0; iter<5; iter++)
		for(int y = 0; y<bimg.getHeight()-1; y++) {
			for(int x=0; x<bimg.getWidth(); x++) {	
				if(new Random().nextBoolean()) {
					int rgb = bimg.getRGB(x, y);
					bimg.setRGB(x, y, bimg.getRGB(x, y+1));
					bimg.setRGB(x, y+1, rgb);
				}
			}
		}			
	}
	
	
}

