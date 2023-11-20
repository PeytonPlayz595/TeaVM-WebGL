package org.lwjgl;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;

import org.teavm.interop.Async;
import org.teavm.interop.AsyncCallback;
import org.teavm.jso.JSBody;
import org.teavm.jso.JSFunctor;
import org.teavm.jso.JSObject;
import org.teavm.jso.dom.events.Event;
import org.teavm.jso.dom.events.EventListener;
import org.teavm.jso.dom.events.KeyboardEvent;
import org.teavm.jso.dom.events.MessageEvent;
import org.teavm.jso.dom.events.MouseEvent;
import org.teavm.jso.dom.events.WheelEvent;
import org.teavm.jso.dom.html.HTMLCanvasElement;
import org.teavm.jso.dom.html.HTMLDocument;
import org.teavm.jso.dom.html.HTMLElement;
import org.teavm.jso.dom.html.HTMLImageElement;
import org.teavm.jso.typedarrays.ArrayBuffer;
import org.teavm.jso.typedarrays.Float32Array;
import org.teavm.jso.typedarrays.Int32Array;
import org.teavm.jso.typedarrays.Uint8Array;
import org.teavm.jso.typedarrays.Uint8ClampedArray;
import org.teavm.jso.browser.Window;
import org.teavm.jso.webgl.WebGLRenderingContext;
import org.teavm.jso.canvas.CanvasRenderingContext2D;
import com.jcraft.jzlib.InflaterInputStream;
import org.teavm.jso.ajax.XMLHttpRequest;
import org.teavm.jso.ajax.ReadyStateChangeHandler;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import org.lwjgl.util.*;

public class Main {

	public static boolean anisotropicFilteringSupported = false;

    public static HTMLDocument doc = null;
	public static HTMLElement parent = null;
	public static HTMLCanvasElement canvas = null;
	public static HTMLCanvasElement imageLoadCanvas = null;
	public static CanvasRenderingContext2D imageLoadContext = null;
	public static CanvasRenderingContext2D canvasContext = null;
	public static HTMLCanvasElement canvasBack = null;
	public static WebGL webgl = null;
	public static Window win = null;

	private static byte[] loadedPackage = null;

    public static void main(String args[]) {
        /*
		 * You can remove this function...
		 */
    }

    /*
     *For the parameter "id" use the ID set for the 
     *<body></body> tags in your index.html 
     */
    public static void initWebGLContext(String id) {
		HTMLElement rootElement = Window.current().getDocument().getElementById(id);
        parent = rootElement;
		String s = parent.getAttribute("style");
		parent.setAttribute("style", (s == null ? "" : s)+"overflow-x:hidden;overflow-y:hidden;");
		win = Window.current();
		doc = win.getDocument();
		canvas = (HTMLCanvasElement)doc.createElement("canvas");
		Display.width = rootElement.getClientWidth();
		Display.height = rootElement.getClientHeight();
		canvas.setWidth(Display.width);
		canvas.setHeight(Display.height);
		canvasContext = (CanvasRenderingContext2D) canvas.getContext("2d");
		canvas.setAttribute("id", "webglCanvas");
		rootElement.appendChild(canvas);
		canvasBack = (HTMLCanvasElement)doc.createElement("canvas");
		canvasBack.setWidth(Display.width);
		canvasBack.setHeight(Display.height);
		webgl = (WebGL) canvasBack.getContext("webgl2", getContext());
		if(webgl == null) {
			throw new RuntimeException("WebGL 2.0 not supported!");
		}
		setContext(webgl);
		
		anisotropicFilteringSupported = webgl.getExtension("EXT_texture_filter_anisotropic") != null;
		org.lwjgl.opengl.webgl.WebGL.hasDebugRenderInfoExt = webgl.getExtension("WEBGL_debug_renderer_info") != null;

		org.lwjgl.opengl.webgl.WebGL.webgl = webgl;
		
		win.addEventListener("contextmenu", Mouse.contextmenu = new EventListener<MouseEvent>() {
			@Override
			public void handleEvent(MouseEvent evt) {
				evt.preventDefault();
				evt.stopPropagation();
			}
		});
		canvas.addEventListener("mousedown", Mouse.mousedown = new EventListener<MouseEvent>() {
			@Override
			public void handleEvent(MouseEvent evt) {
				int b = evt.getButton();
				Mouse.buttonStates[b == 1 ? 2 : (b == 2 ? 1 : b)] = true;
				Mouse.mouseEvents.add(evt);
				evt.preventDefault();
				evt.stopPropagation();
				Mouse.setGrabbed(true);
			}
		});
		canvas.addEventListener("mouseup", Mouse.mouseup = new EventListener<MouseEvent>() {
			@Override
			public void handleEvent(MouseEvent evt) {
				int b = evt.getButton();
				Mouse.buttonStates[b == 1 ? 2 : (b == 2 ? 1 : b)] = false;
				Mouse.mouseEvents.add(evt);
				evt.preventDefault();
				evt.stopPropagation();
			}
		});
		canvas.addEventListener("mousemove", Mouse.mousemove = new EventListener<MouseEvent>() {
			@Override
			public void handleEvent(MouseEvent evt) {
				Mouse.x = Mouse.getOffsetX(evt);
				Mouse.y = canvas.getClientHeight() - Mouse.getOffsetY(evt);
				Mouse.DX += evt.getMovementX();
				Mouse.DY += -evt.getMovementY();
				evt.preventDefault();
				evt.stopPropagation();
			}
		});
		win.addEventListener("keydown", Keyboard.keydown = new EventListener<KeyboardEvent>() {
			@Override
			public void handleEvent(KeyboardEvent evt) {
				Keyboard.keyStates[Keyboard.remapKey(Keyboard.getWhich(evt))] = true;
				Keyboard.keyEvents.add(evt);
				evt.preventDefault();
				evt.stopPropagation();
				Mouse.setGrabbed(true);
			}
		});
		win.addEventListener("keyup", Keyboard.keyup = new EventListener<KeyboardEvent>() {
			@Override
			public void handleEvent(KeyboardEvent evt) {
				Keyboard.keyStates[Keyboard.remapKey(Keyboard.getWhich(evt))] = false;
				Keyboard.keyEvents.add(evt);
				evt.preventDefault();
				evt.stopPropagation();
			}
		});
		win.addEventListener("keypress", Keyboard.keypress = new EventListener<KeyboardEvent>() {
			@Override
			public void handleEvent(KeyboardEvent evt) {
				if(Keyboard.enableRepeatEvents && evt.isRepeat()) Keyboard.keyEvents.add(evt);
				evt.preventDefault();
				evt.stopPropagation();
			}
		});
		canvas.addEventListener("wheel", Mouse.wheel = new EventListener<WheelEvent>() {
			@Override
			public void handleEvent(WheelEvent evt) {
				Mouse.mouseEvents.add(evt);
				evt.preventDefault();
				evt.stopPropagation();
			}
		});
		win.addEventListener("blur", new EventListener<WheelEvent>() {
			@Override
			public void handleEvent(WheelEvent evt) {
				Display.isWindowFocused = false;
			}
		});
		win.addEventListener("focus", new EventListener<WheelEvent>() {
			@Override
			public void handleEvent(WheelEvent evt) {
				Display.isWindowFocused = true;
				Mouse.setGrabbed(true);
			}
		});
		
		Mouse.mouseEvents.clear();
		Keyboard.keyEvents.clear();
    }

	/*
	* Downloads the assets for the program by file name
	* FILE HAS TO BE COMPILED USING LAX1DUDE'S EPK COMPILER!
	*/
	@Async
	public static native String downloadAssetPack(String filename);

	public static void downloadAssetPack(String filename, final AsyncCallback<String> cb) {
		final XMLHttpRequest request = XMLHttpRequest.create();
		request.setResponseType("arraybuffer");
		request.open("GET", filename, true);
		request.setOnReadyStateChange(new ReadyStateChangeHandler() {
			@Override
			public void stateChanged() {
				if(request.getReadyState() == XMLHttpRequest.DONE) {
					Uint8Array bl = Uint8Array.create((ArrayBuffer)request.getResponse());
					loadedPackage = new byte[bl.getByteLength()];
					for(int i = 0; i < loadedPackage.length; ++i) {
						loadedPackage[i] = (byte) bl.get(i);
					}
					cb.complete("yee");
				}
			}
		});
		request.send();

		try {
			install(loadedPackage);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static final HashMap<String, byte[]> filePool = new HashMap();

	public static final void install(byte[] pkg) throws LWJGLException, IOException {
		ByteArrayInputStream in2 = new ByteArrayInputStream(pkg);
		DataInputStream in = new DataInputStream(in2);
		byte[] header = new byte[8];
		in.read(header);
		if (!"EAGPKG!!".equals(new String(header, Charset.forName("UTF-8")))) {
			throw new LWJGLException("invalid file! FILE HAS TO BE COMPILED WITH LAX1DUDE'S EPK COMPILER!");
		}
		in.readUTF();
		in = new DataInputStream(new InflaterInputStream(in2));
		String s = null;
		SHA1Digest dg = new SHA1Digest();
		while ("<file>".equals(s = in.readUTF())) {
			String path = in.readUTF();
			byte[] digest = new byte[20];
			byte[] digest2 = new byte[20];
			in.read(digest);
			int len = in.readInt();
			byte[] file = new byte[len];
			in.read(file);
			if (filePool.containsKey(path)) {
				continue;
			}
			dg.update(file, 0, len);
			dg.doFinal(digest2, 0);
			if (!Arrays.equals(digest, digest2)) {
				throw new LWJGLException("invalid file hash for " + path);
			}
			filePool.put(path, file);
			if (!"</file>".equals(in.readUTF())) {
				throw new LWJGLException("invalid file! FILE HAS TO BE COMPILED WITH LAX1DUDE'S EPK COMPILER!");
			}
		}
		if (in.available() > 0 || !" end".equals(s)) {
			throw new LWJGLException("invalid file! FILE HAS TO BE COMPILED WITH LAX1DUDE'S EPK COMPILER!");
		}
	}

	public static final byte[] getResource(String path) {
		if (path.startsWith("/")) {
			path = path.substring(1);
		}
		return filePool.get(path);
	}

	public static final String fileContents(String path) {
		byte[] contents = getResource(path);
		if(contents == null) {
			return null;
		}else {
			return new String(contents, Charset.forName("UTF-8"));
		}
	}

    @JSBody(params = { }, script = "return {antialias: false, depth: true, powerPreference: \"high-performance\", desynchronized: false, preserveDrawingBuffer: false, premultipliedAlpha: false, alpha: false};")
	public static native JSObject getContext();

	@JSBody(params = { "obj" }, script = "window.currentContext = obj;")
	private static native int setContext(JSObject obj);

	public interface WebGL extends WebGLRenderingContext {
		int TEXTURE_MAX_LEVEL = 0x0000813D;
		int TEXTURE_MAX_ANISOTROPY_EXT = 0x000084FE;
		int UNSIGNED_INT_24_8 = 0x000084FA;
		int ANY_SAMPLES_PASSED = 0x00008D6A; 
		int QUERY_RESULT = 0x00008866;
		int QUERY_RESULT_AVAILABLE = 0x00008867;
		int DEPTH24_STENCIL8 = 0x000088F0;
		int DEPTH_COMPONENT32F = 0x00008CAC;
		int READ_FRAMEBUFFER = 0x00008CA8;
		int DRAW_FRAMEBUFFER = 0x00008CA9;
		int RGB8 = 0x00008051;
		int RGBA8 = 0x00008058;
		
		WebGLQuery createQuery();
	
		void beginQuery(int p1, WebGLQuery obj);
	
		void endQuery(int p1);
	
		void deleteQuery(WebGLQuery obj);
	
		int getQueryParameter(WebGLQuery obj, int p2);
	
		WebGLVertexArray createVertexArray();
	
		void deleteVertexArray(WebGLVertexArray obj);  
	
		void bindVertexArray(WebGLVertexArray obj); 
		
		void renderbufferStorageMultisample(int p1, int p2, int p3, int p4, int p5);
		
		void blitFramebuffer(int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8, int p9, int p10);
		
		void drawBuffers(int[] p1);
	}

	public interface WebGLQuery extends JSObject {
	}

	public interface WebGLVertexArray extends JSObject {
	}
}