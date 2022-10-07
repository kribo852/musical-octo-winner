import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;
import java.lang.Math;


class FractalMain {

	public static void main(String[] args) {
	
		FrameGenerator frameGenerator = new FrameGenerator();
		frameGenerator.setDimensions(1024, 1024);

		frameGenerator.addPart(new Fractal());

		frameGenerator.savePic("Mosaic");
	}
	
	static class Fractal extends PicPart {
		
		@Override
		protected void paint(final BufferedImage bimg) {
		
			Graphics graphics = bimg.getGraphics();
		
			Color init = new Color(150, 100, 25);
		
			recurse(0,0, 1024, 1024,init, graphics);
		}
		
		public void recurse(int sx, int sy, int ex, int ey, Color parentcolor, Graphics g) {
			Color current = new Color(mutateColComponent(parentcolor.getRed()), mutateColComponent(parentcolor.getGreen()), mutateColComponent(parentcolor.getBlue()));
			if(ex - sx == 1) {
				g.setColor(current);
				g.fillRect(sx, sy, ex, ey);
			}
			else {
				recurse(sx, sy, (ex+sx)/2, (ey+sy)/2,current, g);
				recurse((ex+sx)/2, sy, ex, (ey+sy)/2,current, g);
				recurse(sx, (ey+sy)/2, (ex+sx)/2, ey,current, g);
				recurse((ex+sx)/2, (ey+sy)/2, ex, ey,current, g);
			}
		}
		
	}
	
	static int mutateColComponent(int color) {
		return Math.min(Math.max(color+new Random().nextInt(21)-10, 0), 255);
	}

}
