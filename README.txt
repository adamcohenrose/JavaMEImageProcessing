Here's some sample code for using the LargeColour class:

LargeColour avgColour = getAverageColourFrom(image);
String choice = getChosenColour(avgColour);

private LargeColour getAverageColourFrom(Image image) {
	int width = image.getWidth();
	int height = image.getHeight();
	int rgbaArray[] = new int[width * height];
	image.getRGB(rgbaArray, 0, width, 0, 0, width, height);
	return imageAverager.getAverageColourFrom(rgbaArray);
}

private String getChosenColour(LargeColour averageColour) {
	String choice = "hackday";
	if (LargeColour.PURPLE.differenceFrom(averageColour) < 60f) {
		choice = "yahoo";
	} else if (LargeColour.RED.differenceFrom(averageColour) < 60f) {
		choice = "kizoom";
	}
	return choice;
}
