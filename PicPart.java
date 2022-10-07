import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.awt.image.BufferedImage;


abstract class PicPart {


	List<PicPart> parts;

	public PicPart() {
		parts = new ArrayList<>();
	}

	public void addPart(PicPart part) {
		parts.add(part);
	}

	public void paintRecursive(final BufferedImage bimg) {

		paint(bimg);

		parts.forEach(part -> part.paintRecursive(bimg));
	}

	abstract protected void paint(final BufferedImage bimg);

}