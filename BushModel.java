import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;
import java.lang.Math;

class BushModel extends PicPart {
	
		Random rnd = new Random();
	
		double position;
	
		public BushModel(double position) {
			this.position = position;
		}

		protected void paint(final BufferedImage bimg) {

			Graphics graphics = bimg.getGraphics();
			
			for(int i=0; i<20; i++) {
				drawBranch(graphics, 1.5*rnd.nextDouble()-1.5*rnd.nextDouble(), true, 
				position*bimg.getWidth()+rnd.nextInt(100), bimg.getHeight(), 0);
			}
		}
		
		void drawBranch(Graphics graphics, double angle, boolean activeTwist, double x, double y, int depth) {
			
			if(depth>20) return;
			
			double len = 8 + 10*rnd.nextDouble();
			
			graphics.setColor(new Color(0,8,0));
			
			if(activeTwist || rnd.nextInt(3) == 0) {
				graphics.drawLine((int)x, (int)y, (int)(x+len*Math.cos(angle-Math.PI/2)), (int)(y+len*Math.sin(angle-Math.PI/2)));
				drawBranch(graphics, angle, !activeTwist, x+len*Math.cos(angle-Math.PI/2), y+len*Math.sin(angle-Math.PI/2), depth+1);
			} 
			if(!activeTwist) {
				graphics.drawLine((int)x, (int)y, (int)(x+len*Math.cos(-Math.PI/2)), (int)(y+len*Math.sin(-Math.PI/2)));
				drawBranch(graphics, angle, !activeTwist, x+len*Math.cos(-Math.PI/2), y+len*Math.sin(-Math.PI/2), depth+1);
			}
			
			if(rnd.nextInt(5) != 0) {
				graphics.setColor(new Color(0,22+rnd.nextInt(5),0));
				graphics.fillRect((int)(x+len*Math.cos(angle-Math.PI/2)), (int)(y+len*Math.sin(angle-Math.PI/2)), 8, 8);
			} else {
				if(rnd.nextBoolean()) {
					graphics.setColor(new Color(240,150,150));
				} else {
					graphics.setColor(new Color(150,240,240));
				}
				graphics.fillRect((int)(x+len*Math.cos(angle-Math.PI/2)), (int)(y+len*Math.sin(angle-Math.PI/2)), 4, 4);
			}
		}

}
