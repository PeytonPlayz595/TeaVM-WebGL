package org.lwjgl.opengl;

import org.teavm.jso.JSBody;
import org.teavm.jso.JSObject;
import org.teavm.jso.dom.events.Event;
import org.teavm.jso.dom.events.EventListener;
import org.teavm.jso.dom.events.WheelEvent;
import org.teavm.jso.dom.html.HTMLCanvasElement;
import org.teavm.jso.dom.html.HTMLDocument;
import org.teavm.jso.dom.html.HTMLElement;
import org.teavm.jso.dom.html.HTMLImageElement;
import org.teavm.jso.dom.html.HTMLBodyElement;
import org.teavm.jso.browser.Window;
import org.teavm.jso.webgl.WebGLRenderingContext;
import org.teavm.jso.canvas.CanvasRenderingContext2D;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.webgl.WebGL;

public class Display {

    private static int width = 0;
	private static int height = 0;
    private static boolean isWindowFocused;
	private static JSObject fullscreenQuery = null;
	private static boolean init = false;

    @JSBody(params = { "obj" }, script = "if(obj.commit) obj.commit();")
	private static native int commitContext(JSObject obj);

    public static boolean isActive() {
        return isWindowFocused;
    }

    public static void update() {
        commitContext(WebGL.webgl);
		CanvasRenderingContext2D canvasContext = (CanvasRenderingContext2D) getDisplayMode().getCanvas().getContext("2d");
		canvasContext.drawImage(getDisplayMode().getBackCanvas(), 0d, 0d, getDisplayMode().getCanvas().getWidth(), getDisplayMode().getCanvas().getHeight());
		
		int ww = getDisplayMode().getCanvas().getClientWidth();
		int hh = getDisplayMode().getCanvas().getClientHeight();
		if(ww != width || hh != height) {
			width = ww;
			height = hh;
			getDisplayMode().getBackCanvas().setWidth(ww);
			getDisplayMode().getBackCanvas().setHeight(hh);
		}
		
		try {
			Thread.sleep(1l);
		} catch (InterruptedException e) {
			;
		}
    }

    public static int getWidth() {
        int w = getDisplayMode().getParent().getClientWidth();
		if(w != width) {
			getDisplayMode().getCanvas().setWidth(w);
			getDisplayMode().getBackCanvas().setWidth(w);
			width = w;
		}
		return w;
    }

    public static int getHeight() {
        int h = getDisplayMode().getParent().getClientHeight();
		if(h != height) {
			getDisplayMode().getCanvas().setHeight(h);
			getDisplayMode().getBackCanvas().setHeight(h);
			height = h;
		}
		return h;
    }

	public static void setFullscreen(boolean b) {
		if(b & !isFullscreen()) {
			requestFullscreen(getDisplayMode().getCanvas());
		}
		if(!b & isFullscreen()) {
			exitFullscreen();
		}
	}

	public static boolean isFullscreen() {
		return mediaQueryMatches(fullscreenQuery);
	}

	public static boolean isCreated() {
		return init;
	}

	public static DisplayMode getDisplayMode() {
		return DisplayMode.getDisplayMode();
	}

    public static void create() throws LWJGLException {
		init = true;

		String s = getDisplayMode().getParent().getAttribute("style");
		getDisplayMode().getParent().setAttribute("style", (s == null ? "" : s)+"overflow-x:hidden;overflow-y:hidden;");
		width = getDisplayMode().getParent().getClientWidth();
		height = getDisplayMode().getParent().getClientHeight();
		getDisplayMode().getCanvas().setWidth(width);
		getDisplayMode().getCanvas().setHeight(height);
		getDisplayMode().getCanvas().setAttribute("id", "webglCanvas");
		getDisplayMode().getParent().appendChild(getDisplayMode().getCanvas());
		getDisplayMode().getBackCanvas().setWidth(width);
		getDisplayMode().getBackCanvas().setHeight(height);
		WebGL.webgl = (WebGL.WEBGL) getDisplayMode().getBackCanvas().getContext("webgl2", getContext());
		if(WebGL.webgl == null) {
			throw new RuntimeException("WebGL 2.0 not supported!");
		}
		setContext(WebGL.webgl);
		
		WebGL.anisotropicFilteringSupported = WebGL.webgl.getExtension("EXT_texture_filter_anisotropic") != null;
		org.lwjgl.opengl.webgl.WebGL.hasDebugRenderInfoExt = WebGL.webgl.getExtension("WEBGL_debug_renderer_info") != null;
		
		getDisplayMode().getWindow().addEventListener("blur", new EventListener<WheelEvent>() {
			@Override
			public void handleEvent(WheelEvent evt) {
				isWindowFocused = false;
			}
		});
		getDisplayMode().getWindow().addEventListener("focus", new EventListener<WheelEvent>() {
			@Override
			public void handleEvent(WheelEvent evt) {
				isWindowFocused = true;
				Mouse.setGrabbed(true);
			}
		});

		fullscreenQuery = fullscreenMediaQuery();
    }

	public static void destroy() {
		System.err.println("Not implimented! WebGL Context will NOT be terminated!");
    }

	@JSBody(params = { }, script = "document.exitFullscreen();")
	private static native void exitFullscreen();

	@JSBody(params = { "element" }, script = "element.requestFullscreen();")
	private static native void requestFullscreen(HTMLElement element);

	@JSBody(params = { "mediaQuery" }, script = "return mediaQuery.matches;")
	private static native boolean mediaQueryMatches(JSObject mediaQuery);

	@JSBody(params = {}, script = "return window.matchMedia('(display-mode: fullscreen)');")
	private static native JSObject fullscreenMediaQuery();

	@JSBody(params = { }, script = "return {antialias: false, depth: true, powerPreference: \"high-performance\", desynchronized: false, preserveDrawingBuffer: false, premultipliedAlpha: false, alpha: false};")
	private static native JSObject getContext();

	@JSBody(params = { "obj" }, script = "window.currentContext = obj;")
	private static native int setContext(JSObject obj);
}