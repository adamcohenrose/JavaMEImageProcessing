package org.cohenrose.imageprocessing;

public class ImageAverager {
	public LargeColour getAverageColourFrom(int[] rgbaArray) {
		if (rgbaArray.length == 0)
			return null;
		
		LargeColour total = new LargeColour();
		for (int i = 0; i < rgbaArray.length; i++) {
			total.addColour(rgbaArray[i]);
		}
		total.divideBy(rgbaArray.length);
		return total;
	}
}
