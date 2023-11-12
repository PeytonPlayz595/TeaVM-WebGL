package org.lwjgl.opengl.webgl.util;

public class BufferedImage {

	public final int[] data;
	public final int w;
	public final int h;
	public final boolean alpha;

	public BufferedImage(int pw, int ph, boolean palpha) {
		this.w = pw;
		this.h = ph;
		this.alpha = palpha;
		this.data = new int[pw * ph];
	}

	public BufferedImage(int[] pdata, int pw, int ph, boolean palpha) {
		if (pdata.length != pw * ph) {
			throw new IllegalArgumentException("array size does not equal image size");
		}
		this.w = pw;
		this.h = ph;
		this.alpha = palpha;
		if (!palpha) {
			for (int i = 0; i < pdata.length; ++i) {
				pdata[i] = pdata[i] | 0xFF000000;
			}
		}
		this.data = pdata;
	}

	public BufferedImage getSubImage(int x, int y, int pw, int ph) {
		int[] img = new int[pw * ph];
		for (int i = 0; i < ph; ++i) {
			System.arraycopy(data, (i + y) * this.w + x, img, i * pw, pw);
		}
		return new BufferedImage(img, pw, ph, alpha);
	}

}