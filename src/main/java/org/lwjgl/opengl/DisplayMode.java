package org.lwjgl.opengl;

import org.teavm.interop.Async;
import org.teavm.interop.AsyncCallback;
import org.teavm.jso.JSBody;
import org.teavm.jso.dom.events.Event;
import org.teavm.jso.dom.events.EventListener;
import org.teavm.jso.canvas.ImageData;
import org.teavm.interop.Async;
import org.teavm.interop.AsyncCallback;
import org.teavm.jso.canvas.CanvasRenderingContext2D;
import org.teavm.jso.dom.html.HTMLBodyElement;
import org.teavm.jso.dom.html.HTMLCanvasElement;
import org.teavm.jso.dom.html.HTMLDocument;
import org.teavm.jso.dom.html.HTMLElement;
import org.teavm.jso.browser.Window;
import org.teavm.jso.dom.html.HTMLImageElement;
import org.teavm.jso.typedarrays.ArrayBuffer;
import org.teavm.jso.typedarrays.Float32Array;
import org.teavm.jso.typedarrays.Int32Array;
import org.teavm.jso.typedarrays.Uint8Array;
import org.teavm.jso.typedarrays.Uint8ClampedArray;

public class DisplayMode {

    private static HTMLCanvasElement canvas = (HTMLCanvasElement)Window.current().getDocument().createElement("canvas");
    private static HTMLCanvasElement canvasBack = (HTMLCanvasElement)Window.current().getDocument().createElement("canvas");
    private static DisplayMode dm;
    private Window win = Window.current();
    private static HTMLDocument doc = Window.current().getDocument();
	private static HTMLBodyElement parent = Window.current().getDocument().getBody();

    private static HTMLCanvasElement imageLoadCanvas = (HTMLCanvasElement) doc.createElement("canvas");
	private static CanvasRenderingContext2D imageLoadContext = (CanvasRenderingContext2D) imageLoadCanvas.getContext("2d");

    public Window getWindow() {
        return win;
    }

    public HTMLDocument getDocument() {
        return doc;
    }

    public HTMLBodyElement getParent() {
        return parent;
    }

    public HTMLCanvasElement getCanvas() {
        return canvas;
    }

    public HTMLCanvasElement getBackCanvas() {
        return canvasBack;
    }
 
    public static DisplayMode getDisplayMode() {
        if(dm == null) {
            dm = new DisplayMode();
        }
        return dm;
    }

    public static final BufferedImage loadPNG(byte[] data) {
		ArrayBuffer arr = ArrayBuffer.create(data.length);
		Uint8Array.create(arr).set(data);
		return loadPNG0(arr);
	}

	@Async
	private static native BufferedImage loadPNG0(ArrayBuffer data);

	private static void loadPNG0(ArrayBuffer data, final AsyncCallback<BufferedImage> ret) {
		final HTMLImageElement toLoad = (HTMLImageElement) doc.createElement("img");
		toLoad.addEventListener("load", new EventListener<Event>() {
			@Override
			public void handleEvent(Event evt) {
				if(imageLoadCanvas.getWidth() < toLoad.getWidth()) {
					imageLoadCanvas.setWidth(toLoad.getWidth());
				}
				if(imageLoadCanvas.getHeight() < toLoad.getHeight()) {
					imageLoadCanvas.setHeight(toLoad.getHeight());
				}
				imageLoadContext.clearRect(0, 0, toLoad.getWidth(), toLoad.getHeight());
				imageLoadContext.drawImage(toLoad, 0, 0, toLoad.getWidth(), toLoad.getHeight());
				ImageData pxlsDat = imageLoadContext.getImageData(0, 0, toLoad.getWidth(), toLoad.getHeight());
				Uint8ClampedArray pxls = pxlsDat.getData();
				int totalPixels = pxlsDat.getWidth() * pxlsDat.getHeight();
				freeDataURL(toLoad.getSrc());
				if(pxls.getByteLength() < totalPixels * 4) {
					ret.complete(null);
					return;
				}
				int[] pixels = new int[totalPixels];
				for(int i = 0; i < pixels.length; ++i) {
					pixels[i] = (pxls.get(i * 4) << 16) | (pxls.get(i * 4 + 1) << 8) | pxls.get(i * 4 + 2) | (pxls.get(i * 4 + 3) << 24);
				}
				ret.complete(new BufferedImage(pixels, pxlsDat.getWidth(), pxlsDat.getHeight(), true));
			}
		});
		toLoad.addEventListener("error", new EventListener<Event>() {
			@Override
			public void handleEvent(Event evt) {
				freeDataURL(toLoad.getSrc());
				ret.complete(null);
			}
		});
		String src = getDataURL(data, "image/png");
		if(src == null) {
			ret.complete(null);
		}else {
			toLoad.setSrc(src);
		}
	}

    @JSBody(params = { "buf", "mime" }, script = "return URL.createObjectURL(new Blob([buf], {type: mime}));")
	private static native String getDataURL(ArrayBuffer buf, String mime);

	@JSBody(params = { "url" }, script = "URL.revokeObjectURL(url);")
	private static native void freeDataURL(String url);
}