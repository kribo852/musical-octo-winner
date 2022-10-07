import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


class FrameGenerator {

	int width=0, height=0;


	protected List<PicPart> parts = new ArrayList<>();

	public void savePic(final String filename) {
		BufferedImage bimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		parts.forEach(part -> part.paintRecursive(bimg));

		saveImage(bimg, filename);
	}

	public void setDimensions(final int width, final int height) {
		this.width = width;
		this.height = height;
	}

	public void addPart(final PicPart part) {
		parts.add(part);
	}

	private void saveImage(final BufferedImage bimg, final String filename) {
		try {
			File outputfile = new File(filename+".png");
			ImageIO.write(bimg, "png", outputfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 

}
