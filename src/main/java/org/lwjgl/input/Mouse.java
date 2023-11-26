package org.lwjgl.input;

import org.teavm.jso.JSBody;
import org.teavm.jso.dom.events.EventListener;
import org.teavm.jso.dom.events.MouseEvent;
import org.teavm.jso.dom.events.WheelEvent;

import org.lwjgl.Main;
import org.lwjgl.LWJGLException;

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
			y = Main.canvas.getClientHeight() - getOffsetY(evt);
			DX += evt.getMovementX();
			DY += -evt.getMovementY();
			evt.preventDefault();
			evt.stopPropagation();
		}
	};

    private static int x, y;
    private static double DX, DY;

    @JSBody(params = { "m" }, script = "return m.offsetX;")
	private static native int getOffsetX(MouseEvent m);
	
	@JSBody(params = { "m" }, script = "return m.offsetY;")
	private static native int getOffsetY(MouseEvent m);

    public static int getDX() {
        double dx = DX;
        DX = 0.0D;
        return (int)dx;
    }

    public static int getDY() {
        double dy = DY;
        DY = 0.0D;
        return (int)dy;
    }

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }

    public static boolean next() {
        currentEvent = null;
		return !mouseEvents.isEmpty() && (currentEvent = mouseEvents.remove(0)) != null;
    }

    public static void setGrabbed(boolean b) {
        if(b) {
            Main.canvas.requestPointerLock();
        } else {
            Main.doc.exitPointerLock();
        }
    }

    public static boolean getEventButtonState() {
        return currentEvent == null ? false : currentEvent.getType().equals(MouseEvent.MOUSEDOWN);
    }

    public static int getEventX() {
        return currentEvent == null ? -1 : currentEvent.getClientX();
    }

    public static int getEventY() {
        return currentEvent == null ? -1 : Main.canvas.getClientHeight() - currentEvent.getClientY();
    }

    public static int getEventButton() {
        if(currentEvent == null) { 
            return -1;
        }
		int button = currentEvent.getButton();
		return button == 1 ? 2 : (button == 2 ? 1 : button);
    }

    public static boolean isButtonDown(int i) {
        return buttonStates[i];
    }

    public static int getEventDWheel() {
        return ("wheel".equals(currentEvent.getType())) ? (((WheelEvent)currentEvent).getDeltaY() == 0.0D ? 0 : (((WheelEvent)currentEvent).getDeltaY() > 0.0D ? -1 : 1)) : 0;
    }

    public static void create() throws LWJGLException {
        Main.win.addEventListener("contextmenu", contextmenu);
		Main.canvas.addEventListener("mousedown", mousedown);
		Main.canvas.addEventListener("mouseup", mouseup);
		Main.canvas.addEventListener("mousemove", mousemove);
		Main.canvas.addEventListener("wheel", wheel);
        mouseEvents.clear();
    }

    public static void destroy() throws LWJGLException {
        Main.win.removeEventListener("contextmenu", contextmenu);
		Main.canvas.removeEventListener("mousedown", mousedown);
		Main.canvas.removeEventListener("mouseup", mouseup);
		Main.canvas.removeEventListener("mousemove", mousemove);
		Main.canvas.removeEventListener("wheel", wheel);
        mouseEvents.clear();
    }

    public static void setNativeCursor(Object o) throws LWJGLException {
	}

    public static void setCursorPosition(int x, int y) {
    }
}