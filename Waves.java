import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;
import java.lang.Math;

class Waves extends PicPart {

	final Random rnd = new Random();

	final double cutoff;
	
	final int iterations=25;
	
	public Waves(double cutoff) {
		this.cutoff = cutoff;
	}

	@Override
	protected void paint(final BufferedImage bimg) {
		
		int length = 25;
		
		Graphics graphics = bimg.getGraphics();
		
		int startheight = (int)(bimg.getHeight()*cutoff)-1;
		
		for(int y=startheight; y<bimg.getHeight(); y++) {
			for(int i = 0; i<iterations; i++) {
			
				int middlex = rnd.nextInt(bimg.getWidth());
			
				for(double startx = -length; startx<length; startx++) {
					if(middlex+startx< 0 || middlex+startx>=bimg.getWidth()) {
						continue;
					}
					int height = (int)(10*Math.exp(-0.05*Math.abs(startx)));
					graphics.setColor(new Color(bimg.getRGB( (int)(middlex+startx), y)).darker());
					graphics.drawLine((int)(middlex+startx), y, (int)(middlex+startx), y-height);
				}
			
			}		
		}
	}
	
	
}

