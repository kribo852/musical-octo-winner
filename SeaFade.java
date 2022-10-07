import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;
import java.lang.Math;

class SeaFade extends PicPart {

	final Random rnd = new Random();

	final double cutoff;
	
	public SeaFade(double cutoff) {
		this.cutoff = cutoff;
	}

	@Override
	protected void paint(final BufferedImage bimg) {
		
		Graphics graphics = bimg.getGraphics();
		
		int start = (int)(bimg.getHeight()*cutoff);
		
		for(int y = 0; y+start<bimg.getHeight(); y++) {
			for(int x=0; x<bimg.getWidth(); x++) {
				
				graphics.setColor(new Color(10, 20, 15, (int)Math.min(255, Math.hypot(x-bimg.getWidth()/2.25, y)/3.75)));
				graphics.fillRect(x, y+start, 1, 1);
			}
		}	
	}
}

