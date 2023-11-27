package org.lwjgl.input;

import org.teavm.jso.JSBody;
import org.teavm.jso.dom.events.EventListener;
import org.teavm.jso.dom.events.MouseEvent;
import org.teavm.jso.dom.events.WheelEvent;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;

import java.util.LinkedList;

public class Mouse {

    private static LinkedList<MouseEvent> mouseEvents = new LinkedList();
    private static boolean[] buttonStates = new boolean[8];
    private static MouseEvent currentEvent = null;
    private static EventListener<MouseEvent> contextmenu = new EventListener<MouseEvent>() {
		@Override
		public void handleEvent(MouseEvent evt) {
			evt.preventDefault();
			evt.stopPropagation();
		}
	};

    private static EventListener wheel = new EventListener<WheelEvent>() {
		@Override
		public void handleEvent(WheelEvent evt) {
			mouseEvents.add(evt);
			evt.preventDefault();
			evt.stopPropagation();
		}
	};

    private static EventListener mousedown = new EventListener<MouseEvent>() {
		@Override
		public void handleEvent(MouseEvent evt) {
			int b = evt.getButton();
			buttonStates[b == 1 ? 2 : (b == 2 ? 1 : b)] = true;
			mouseEvents.add(evt);
			evt.preventDefault();
			evt.stopPropagation();
			setGrabbed(true);
		}
	};

	private static EventListener mouseup = new EventListener<MouseEvent>() {
		@Override
		public void handleEvent(MouseEvent evt) {
			int b = evt.getButton();
			buttonStates[b == 1 ? 2 : (b == 2 ? 1 : b)] = false;
			mouseEvents.add(evt);
			evt.preventDefault();
			evt.stopPropagation();
		}
	};

	private static EventListener mousemove = new EventListener<MouseEvent>() {
		@Override
		public void handleEvent(MouseEvent evt) {
			x = getOffsetX(evt);
			y = Display.getDisplayMode().getCanvas().getClientHeight() - getOffsetY(evt);
			DX += evt.getMovementX();
			DY += -evt.getMovementY();
			evt.preventDefault();
			evt.stopPropagation();
		}
	};

    private static int x, y;
    private static double DX, DY;
    
    private static boolean init = false;

    @JSBody(params = { "m" }, script = "return m.offsetX;")
	private static native int getOffsetX(MouseEvent m);
	
	@JSBody(params = { "m" }, script = "return m.offsetY;")
	private static native int getOffsetY(MouseEvent m);

    public static int getDX() {
        checkHasInitialized(true);
        double dx = DX;
        DX = 0.0D;
        return (int)dx;
    }

    public static int getDY() {
        checkHasInitialized(true);
        double dy = DY;
        DY = 0.0D;
        return (int)dy;
    }

    public static int getX() {
        checkHasInitialized(true);
        return x;
    }

    public static int getY() {
        checkHasInitialized(true);
        return y;
    }

    public static boolean next() {
        checkHasInitialized(true);
        currentEvent = null;
		return !mouseEvents.isEmpty() && (currentEvent = mouseEvents.remove(0)) != null;
    }

    public static void setGrabbed(boolean b) {
        checkHasInitialized(true);
        if(b) {
            Display.getDisplayMode().getCanvas().requestPointerLock();
        } else {
            Display.getDisplayMode().getDocument().exitPointerLock();
        }
    }

    public static boolean getEventButtonState() {
        checkHasInitialized(true);
        return currentEvent == null ? false : currentEvent.getType().equals(MouseEvent.MOUSEDOWN);
    }

    public static int getEventX() {
        checkHasInitialized(true);
        return currentEvent == null ? -1 : currentEvent.getClientX();
    }

    public static int getEventY() {
        checkHasInitialized(true);
        return currentEvent == null ? -1 : Display.getDisplayMode().getCanvas().getClientHeight() - currentEvent.getClientY();
    }

    public static int getEventButton() {
        checkHasInitialized(true);
        if(currentEvent == null) { 
            return -1;
        }
		int button = currentEvent.getButton();
		return button == 1 ? 2 : (button == 2 ? 1 : button);
    }

    public static boolean isButtonDown(int i) {
        checkHasInitialized(true);
        return buttonStates[i];
    }

    public static int getEventDWheel() {
        checkHasInitialized(true);
        return ("wheel".equals(currentEvent.getType())) ? (((WheelEvent)currentEvent).getDeltaY() == 0.0D ? 0 : (((WheelEvent)currentEvent).getDeltaY() > 0.0D ? -1 : 1)) : 0;
    }

    private static boolean checkHasInitialized(boolean shouldThrowError) {
        if(shouldThrowError && !init) {
            throw new IllegalArgumentException("Cannot access Mouse class before initialization!");
        }
        return init;
    }

    public static void create() throws LWJGLException {
        Display.getDisplayMode().getWindow().addEventListener("contextmenu", contextmenu);
		Display.getDisplayMode().getCanvas().addEventListener("mousedown", mousedown);
		Display.getDisplayMode().getCanvas().addEventListener("mouseup", mouseup);
		Display.getDisplayMode().getCanvas().addEventListener("mousemove", mousemove);
		Display.getDisplayMode().getCanvas().addEventListener("wheel", wheel);
        mouseEvents.clear();
        init = true;
    }

    public static void destroy() {
        checkHasInitialized(true);
        Display.getDisplayMode().getWindow().removeEventListener("contextmenu", contextmenu);
		Display.getDisplayMode().getCanvas().removeEventListener("mousedown", mousedown);
		Display.getDisplayMode().getCanvas().removeEventListener("mouseup", mouseup);
		Display.getDisplayMode().getCanvas().removeEventListener("mousemove", mousemove);
		Display.getDisplayMode().getCanvas().removeEventListener("wheel", wheel);
        mouseEvents.clear();
        init = false;
    }

    public static void setNativeCursor(Object o) throws LWJGLException {
        checkHasInitialized(true);
	}

    public static void setCursorPosition(int x, int y) {
        checkHasInitialized(true);
    }
}