package org.cohenrose.imageprocessing;

public class LargeColour {
	public static LargeColour PURPLE = new LargeColour(0xFF37358F);
	public static LargeColour RED = new LargeColour(0xFFA80938);

	public float a;
	public float r;
	public float g;
	public float b;
	
	public LargeColour() {
	}
	
	public LargeColour(float a, float r, float g, float b) {
		this.a = a;
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public LargeColour(int ARGB) {
		addColour(ARGB);
	}
	
	public void addColour(int ARGB) {
		a += (ARGB & 0xff000000) >> 24;
		r += (ARGB & 0xff0000) >> 16;
		g += (ARGB & 0xff00) >> 8;
		b += ARGB & 0xff;
	}
	
	public void divideBy(int factor) {
		a /= factor;
		r /= factor;
		g /= factor;
		b /= factor;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof LargeColour) {
			return closeTo((LargeColour) obj, 0.01f);
		}
		return false;
	}

	public boolean closeTo(LargeColour other, float difference) {
		return differenceFrom(other) < difference;
	}
	
	public double differenceFrom(LargeColour other) {
		return Math.sqrt((other.a - a)*(other.a - a) +
						 (other.r - r)*(other.r - r) +
						 (other.b - b)*(other.b - b) + 
						 (other.g - g)*(other.g - g));
	}
	
	public String toString() {
		return "Color[" + a + "," + r + "," + g + "," + b + "]";
	}
}