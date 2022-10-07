
class SundownField {

	public static void main(String[] args) {
	
		FrameGenerator frameGenerator = new FrameGenerator();
		frameGenerator.setDimensions(750, 750);

		Background background = new Background();
		background.addPart(new NoisyStars());
		background.addPart(new BushModel(0.65));
		background.addPart(new Grass());

		frameGenerator.addPart(background);

		frameGenerator.savePic();
	}

}
