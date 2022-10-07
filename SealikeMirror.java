import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;
import java.lang.Math;

class SealikeMirror extends PicPart {

	final Random rnd = new Random();

	final double cutoff;
	
	public SealikeMirror(double cutoff) {
		this.cutoff = cutoff;
	}

	@Override
	protected void paint(final BufferedImage bimg) {
		
		int start = (int)(bimg.getHeight()*cutoff);
		
		for(int y = 0; y+start<bimg.getHeight(); y++) {
			for(int x=0; x<bimg.getWidth(); x++) {
				int color = bimg.getRGB(x, start-y-1);
				bimg.setRGB(x, start+y, color);
			}
		
		}	
		
	}

}
