import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;
import java.lang.Math;

class TreeModel extends PicPart {
	
		double position;
		double height = 0.4;
	
		public TreeModel(double position) {
			this.position = position;
		}

		protected void paint(final BufferedImage bimg) {

			Random rnd = new Random();

			Graphics graphics = bimg.getGraphics();
			graphics.setColor(new Color(2,5,0));
			graphics.fillRect((int)(bimg.getWidth()*position-10), (int)(bimg.getHeight()*(1-height)-10), 20, bimg.getHeight());
			
			
			graphics.setColor(new Color(2,5,0,80));

			List<Point> points = new ArrayList<>();
			
			for(int i=0; i<50; i++) {
				points.add(new Point(position, 1.1-height, -Math.PI/2));
			}
			
			while(points.size() < 50000) {
				Point point = points.remove(0);
				double angle1 = point.angle + rnd.nextDouble()-rnd.nextDouble();
				double angle2 = point.angle + rnd.nextDouble()-rnd.nextDouble();
				
				points.add(rnd.nextInt(points.size()), new Point(point.x+0.015*Math.cos(angle1), 
					point.y+0.015*Math.sin(angle1), angle1));
					
				points.add(rnd.nextInt(points.size()), new Point(point.x+0.015*Math.cos(angle2), 
					point.y+0.015*Math.sin(angle2), angle2));
			}
			
			points.forEach(point -> 
						graphics.fillRect((int)(bimg.getWidth()*point.x), 
						(int)(bimg.getHeight()*point.y), 4, 4)
					);
		}
		

	static class Point {
		double x;
		double y;
		double angle;
		
		public Point(double x, double y, double angle) {
			this.x = x;
			this.y = y; 
			this.angle = angle;
		}
		
	}
}
