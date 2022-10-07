import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;
import java.lang.Math;

class Background extends PicPart {

	final Random rnd = new Random();

	final int bgr = 0, bgg = 15, bgb = 75; 

	@Override
	protected void paint(final BufferedImage bimg) {

		ArrayList<ColorComponent> spread = new ArrayList<>();
		
		spread.add(new ColorComponent(bimg.getWidth()/3, 5*bimg.getHeight()/8, new Color(255, 150, 0)));		

		iteratePhase(spread, bimg);
	}


	public void iteratePhase(ArrayList<ColorComponent> spread, BufferedImage bimg) {
		Graphics graphics = bimg.getGraphics();


		while(!spread.isEmpty()) {
			ColorComponent comp = spread.remove(0);

			if(bimg.getRGB(comp.x, comp.y) == 0) {
				graphics.setColor(comp.color);
				graphics.fillRect(comp.x, comp.y, 1, 1);
				for (int i = -1; i<2; i++) {
					for (int j = -1; j<2; j++) {
						if(comp.x+i>=0 && comp.x+i<bimg.getWidth() && 
							comp.y+j>=0 && comp.y+j<bimg.getHeight()) {

							if(bimg.getRGB(comp.x+i, comp.y+j) == 0) {
								if(spread.size() > 0) {
								spread.add(rnd.nextInt(spread.size()), new ColorComponent(comp.x+i, comp.y+j, 
									mutateColor(comp.color)));
								} else {
								spread.add(new ColorComponent(comp.x+i, comp.y+j, 
									mutateColor(comp.color)));	
								}
							}

						}
					}	
				}
			}
		}
	}

	Color mutateColor(Color color) {
		
		Color tempcolor = new Color(mutateColComponent(color.getRed()), 
			mutateColComponent(color.getGreen()),
				mutateColComponent(color.getBlue()));

		double oldRefDist = distanceToReference(color); 

		if(oldRefDist > 25) {
			while(distanceToReference(tempcolor) > oldRefDist) {
				tempcolor = new Color(mutateColComponent(color.getRed()), 
			mutateColComponent(color.getGreen()),
				mutateColComponent(color.getBlue()));
			}
			return tempcolor;
		}

		while(distanceToReference(tempcolor) > 25) {
			tempcolor = new Color(mutateColComponent(color.getRed()), 
			mutateColComponent(color.getGreen()),
				mutateColComponent(color.getBlue()));
		}
		return tempcolor;
	}

	double distanceToReference(Color color) {
		return Math.pow(
			Math.pow(color.getRed()-bgr, 2) +
			Math.pow(color.getGreen()-bgg, 2) +
			Math.pow(color.getBlue()-bgb, 2),
			0.5
		);
	}


	int mutateColComponent(int color) {
		return Math.min(Math.max(color+rnd.nextInt(3)-1, 0), 255);
	}

	static class ColorComponent {
		public int x;
		public int y;
		public Color color;

		public ColorComponent(int x, int y, Color c) {
			this.x = x;
			this.y = y;
			this.color = c; 
		}
	}
}
