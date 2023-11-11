package org.lwjgl.input;

import org.teavm.jso.JSBody;
import org.teavm.jso.dom.events.EventListener;
import org.teavm.jso.dom.events.MouseEvent;
import org.teavm.jso.dom.events.WheelEvent;

import org.lwjgl.Main;
import org.lwjgl.LWJGLException;

import java.util.LinkedList;

public class Mouse {

    public static LinkedList<MouseEvent> mouseEvents = new LinkedList();
    public static boolean[] buttonStates = new boolean[8];
    private static MouseEvent currentEvent = null;

    public static EventListener contextmenu = null;
    public static EventListener wheel = null;
    public static EventListener mousedown = null;
	public static EventListener mouseup = null;
	public static EventListener mousemove = null;

    public static int x, y;
    public static double DX, DY;

    @JSBody(params = { "m" }, script = "return m.offsetX;")
	public static native int getOffsetX(MouseEvent m);
	
	@JSBody(params = { "m" }, script = "return m.offsetY;")
	public static native int getOffsetY(MouseEvent m);

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
    }

    public static void setNativeCursor(Object o) throws LWJGLException {
	}

    public static void setCursorPosition(int x, int y) {
    }
}