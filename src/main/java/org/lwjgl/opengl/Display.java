package org.lwjgl.opengl;

import org.lwjgl.Main;
import org.lwjgl.LWJGLException;
import org.teavm.jso.JSBody;
import org.teavm.jso.JSObject;

public class Display {

    public static int width = 0;
	public static int height = 0;
    public static boolean isWindowFocused;

    @JSBody(params = { "obj" }, script = "if(obj.commit) obj.commit();")
	private static native int commitContext(JSObject obj);

    public static boolean isActive() {
        return isWindowFocused;
    }

    public static void update() {
        commitContext(Main.webgl);
		Main.canvasContext.drawImage(Main.canvasBack, 0d, 0d, Main.canvas.getWidth(), Main.canvas.getHeight());
		
		int ww = Main.canvas.getClientWidth();
		int hh = Main.canvas.getClientHeight();
		if(ww != width || hh != height) {
			width = ww;
			height = hh;
			Main.canvasBack.setWidth(ww);
			Main.canvasBack.setHeight(hh);
		}
		
		try {
			Thread.sleep(1l);
		} catch (InterruptedException e) {
			;
		}
    }

    public static int getWidth() {
        int w = Main.parent.getClientWidth();
		if(w != width) {
			Main.canvas.setWidth(w);
			Main.canvasBack.setWidth(w);
			width = w;
		}
		return w;
    }

    public static int getHeight() {
        int h = Main.parent.getClientHeight();
		if(h != height) {
			Main.canvas.setHeight(h);
			Main.canvasBack.setHeight(h);
			height = h;
		}
		return h;
    }

    public static void create() throws LWJGLException {
    }
}