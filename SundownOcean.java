
class SundownOcean {

	public static void main(String[] args) {
	
		FrameGenerator frameGenerator = new FrameGenerator();
		frameGenerator.setDimensions(750, 750);

		Background background = new Background();
		background.addPart(new Noise());
		background.addPart(new NoisyStars());
		

		frameGenerator.addPart(background);
		frameGenerator.addPart(new SealikeMirror(0.7));
		frameGenerator.addPart(new SeaFade(0.7));
		frameGenerator.addPart(new Waves(0.7));
		

		frameGenerator.savePic("Ocean");
	}

}
