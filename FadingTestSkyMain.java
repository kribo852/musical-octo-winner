import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;
import java.lang.Math;


class FadingTestSkyMain {

	public static void main(String[] args) {
	
		FrameGenerator frameGenerator = new FrameGenerator();
		frameGenerator.setDimensions(750, 750);

		frameGenerator.addPart(new MonochromeSky());
		frameGenerator.addPart(new Waves(0.7));

		frameGenerator.savePic("MTestSky");
	}
	
	static class MonochromeSky extends PicPart {
		
		@Override
		protected void paint(final BufferedImage bimg) {
		
			Graphics graphics = bimg.getGraphics();
			
			for(int h=0; h<bimg.getHeight(); h++) {
				int light = (int)(h*256/bimg.getHeight());
				Color c = new Color(light, light, light);
				graphics.setColor(c);
				graphics.drawLine(0, h, bimg.getWidth(), h);
			}
		}
	}

}
