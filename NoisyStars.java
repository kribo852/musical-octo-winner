import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;
import java.lang.Math;

class NoisyStars extends PicPart {

		protected void paint(final BufferedImage bimg) {

			Random rnd = new Random();

			Graphics graphics = bimg.getGraphics();

			for (int i=0; i < bimg.getWidth()*bimg.getHeight()/250 ; i++) {
				int x = rnd.nextInt(bimg.getWidth());
				int y = rnd.nextInt(bimg.getHeight());
				
				int brightness = (int)getBrightness(new Color(bimg.getRGB(x, y))); 
				
				if(brightness < 200) {
					graphics.setColor(new Color(255, 255, 255, 200-brightness));
				
					int diff = rnd.nextInt(3);
				
					graphics.fillRect(x, y, 2+diff , 2+diff);		
				}
			}
		}
		
		double getBrightness(Color c) {
			return Math.pow(
			Math.pow(c.getRed(), 2)+
			Math.pow(c.getGreen(), 2)+
			Math.pow(c.getBlue(), 2)
			 , 0.5);
		} 
}
