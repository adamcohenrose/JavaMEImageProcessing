package org.cohenrose.imageprocessing;

import junit.framework.Assert;

import org.jmock.integration.junit3.MockObjectTestCase;

public class ImageAveragerTest extends MockObjectTestCase {
	public void testGetAverageColourFromEmptyRgbaArray() {
		checkAverage(null, new int[0]);
	}
	
	public void testGetAverageColourFromTwoPixelRgbaArray() {
		checkAverage(new LargeColour(0xFF333333), new int[] {
			0xFF222222, 0xFF444444,	
		});
	}
	
	public void testColours() {
		assertEquals(30f, LargeColour.PURPLE.differenceFrom(LargeColour.RED));
	}

	private void checkAverage(LargeColour expectedResult, int[] imageArray) {
		LargeColour result = new ImageAverager().getAverageColourFrom(imageArray);
		if (expectedResult == null) {
			assertNull("Average should be null", result);
		} else if (!expectedResult.equals(result)) {
			Assert.fail("Incorrect average, expected: " + expectedResult
					+ " but was: " + result);
		}
	}
}
