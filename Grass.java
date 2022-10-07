import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;
import java.lang.Math;

class Grass extends PicPart {

		protected void paint(final BufferedImage bimg) {

			Random rnd = new Random();

			Graphics graphics = bimg.getGraphics();
			
				int baseheight = 50;
			for (int i=0; i < bimg.getWidth(); i++) {
				
				int y = bimg.getHeight();
				int alpha = 255;
				double rate = rnd.nextDouble()/5 + 0.1; 
				int red = rnd.nextInt(15)+6;
				int green = rnd.nextInt(35)+25;
				int blue = rnd.nextInt(8)+8;
				
				baseheight += -1+rnd.nextInt(3);

				for (int j=0; j < baseheight; j++) {
					graphics.setColor(new Color(red, green+rnd.nextInt(10)-rnd.nextInt(10), blue, alpha));
					graphics.fillRect(i, y, 1 , 1);
					y--;
				}

				while(alpha > 25) {	
					graphics.setColor(new Color(red, green+rnd.nextInt(10)-rnd.nextInt(10), blue, alpha));
					graphics.fillRect(i, y, 1 , 1);
					y--;

					while(rnd.nextDouble() > rate) {
						alpha -=1;
					}
				} 
			}
		}
}