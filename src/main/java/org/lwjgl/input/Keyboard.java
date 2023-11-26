package org.lwjgl.input;

import org.teavm.jso.JSBody;
import org.teavm.jso.dom.events.EventListener;
import org.teavm.jso.dom.events.KeyboardEvent;

import org.lwjgl.Main;

import java.util.LinkedList;

import org.lwjgl.LWJGLException;

public class Keyboard {

    /**
	 * The special character meaning that no
	 * character was translated for the event.
	 */
	public static final int CHAR_NONE = '\0';

	/**
	 * The special keycode meaning that only the
	 * translated character is valid.
	 */
	public static final int KEY_NONE = 0x00;

	public static final int KEY_ESCAPE = 0x01;
	public static final int KEY_1 = 0x02;
	public static final int KEY_2 = 0x03;
	public static final int KEY_3 = 0x04;
	public static final int KEY_4 = 0x05;
	public static final int KEY_5 = 0x06;
	public static final int KEY_6 = 0x07;
	public static final int KEY_7 = 0x08;
	public static final int KEY_8 = 0x09;
	public static final int KEY_9 = 0x0A;
	public static final int KEY_0 = 0x0B;
	public static final int KEY_MINUS = 0x0C;
	public static final int KEY_EQUALS = 0x0D;
	public static final int KEY_BACK = 0x0E;
	public static final int KEY_TAB = 0x0F;
	public static final int KEY_Q = 0x10;
	public static final int KEY_W = 0x11;
	public static final int KEY_E = 0x12;
	public static final int KEY_R = 0x13;
	public static final int KEY_T = 0x14;
	public static final int KEY_Y = 0x15;
	public static final int KEY_U = 0x16;
	public static final int KEY_I = 0x17;
	public static final int KEY_O = 0x18;
	public static final int KEY_P = 0x19;
	public static final int KEY_LBRACKET = 0x1A;
	public static final int KEY_RBRACKET = 0x1B;
	public static final int KEY_RETURN = 0x1C;
	public static final int KEY_LCONTROL = 0x1D;
	public static final int KEY_A = 0x1E;
	public static final int KEY_S = 0x1F;
	public static final int KEY_D = 0x20;
	public static final int KEY_F = 0x21;
	public static final int KEY_G = 0x22;
	public static final int KEY_H = 0x23;
	public static final int KEY_J = 0x24;
	public static final int KEY_K = 0x25;
	public static final int KEY_L = 0x26;
	public static final int KEY_SEMICOLON = 0x27;
	public static final int KEY_APOSTROPHE = 0x28;
	public static final int KEY_GRAVE = 0x29;
	public static final int KEY_LSHIFT = 0x2A;
	public static final int KEY_BACKSLASH = 0x2B;
	public static final int KEY_Z = 0x2C;
	public static final int KEY_X = 0x2D;
	public static final int KEY_C = 0x2E;
	public static final int KEY_V = 0x2F;
	public static final int KEY_B = 0x30;
	public static final int KEY_N = 0x31;
	public static final int KEY_M = 0x32;
	public static final int KEY_COMMA = 0x33;
	public static final int KEY_PERIOD = 0x34;
	public static final int KEY_SLASH = 0x35;
	public static final int KEY_RSHIFT = 0x36;
	public static final int KEY_MULTIPLY = 0x37;
	public static final int KEY_LMENU = 0x38;
	public static final int KEY_SPACE = 0x39;
	public static final int KEY_CAPITAL = 0x3A;
	public static final int KEY_NUMPAD7 = 0x47;
	public static final int KEY_NUMPAD8 = 0x48;
	public static final int KEY_NUMPAD9 = 0x49;
	public static final int KEY_SUBTRACT = 0x4A;
	public static final int KEY_NUMPAD4 = 0x4B;
	public static final int KEY_NUMPAD5 = 0x4C;
	public static final int KEY_NUMPAD6 = 0x4D;
	public static final int KEY_ADD = 0x4E;
	public static final int KEY_NUMPAD1 = 0x4F;
	public static final int KEY_NUMPAD2 = 0x50;
	public static final int KEY_NUMPAD3 = 0x51;
	public static final int KEY_NUMPAD0 = 0x52;
	public static final int KEY_DECIMAL = 0x53;
	public static final int KEY_NUMPADEQUALS = 0x8D;
	public static final int KEY_AT = 0x91;
	public static final int KEY_COLON = 0x92;
	public static final int KEY_UNDERLINE = 0x93;
	public static final int KEY_STOP = 0x95;
	public static final int KEY_UNLABELED = 0x97;
	public static final int KEY_NUMPADENTER = 0x9C;
	public static final int KEY_RCONTROL = 0x9D;
	public static final int KEY_SECTION = 0xA7;
	public static final int KEY_NUMPADCOMMA = 0xB3;
	public static final int KEY_DIVIDE = 0xB5;
	public static final int KEY_SYSRQ = 0xB7;
	public static final int KEY_RMENU = 0xB8;
	public static final int KEY_PAUSE = 0xC5;
	public static final int KEY_HOME = 0xC7;
	public static final int KEY_UP = 0xC8;
	public static final int KEY_PRIOR = 0xC9;
	public static final int KEY_LEFT = 0xCB;
	public static final int KEY_RIGHT = 0xCD;
	public static final int KEY_END = 0xCF;
	public static final int KEY_DOWN = 0xD0;
	public static final int KEY_NEXT = 0xD1;
	public static final int KEY_INSERT = 0xD2;
	public static final int KEY_DELETE = 0xD3;
	public static final int KEY_CLEAR = 0xDA;

    private static KeyboardEvent currentEventK = null;

    private static EventListener<KeyboardEvent> keypress = new EventListener<KeyboardEvent>() {
		@Override
		public void handleEvent(KeyboardEvent evt) {
			if(enableRepeatEvents && evt.isRepeat()) keyEvents.add(evt);
			evt.preventDefault();
			evt.stopPropagation();
		}
	};

    private static EventListener keydown = new EventListener<KeyboardEvent>() {
		@Override
		public void handleEvent(KeyboardEvent evt) {
			keyStates[remapKey(getWhich(evt))] = true;
			keyEvents.add(evt);
			evt.preventDefault();
			evt.stopPropagation();
			Mouse.setGrabbed(true);
		}
	};

	private static EventListener<KeyboardEvent> keyup = new EventListener<KeyboardEvent>() {
		@Override
		public void handleEvent(KeyboardEvent evt) {
			keyStates[remapKey(getWhich(evt))] = false;
			keyEvents.add(evt);
			evt.preventDefault();
			evt.stopPropagation();
		}
	};

	private static LinkedList<KeyboardEvent> keyEvents = new LinkedList();
    private static boolean[] keyStates = new boolean[256];
    private static boolean enableRepeatEvents = false;

    private static String[] keyNames = new String[] {"NONE", "ESCAPE", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "MINUS", "EQUALS", "BACK", "TAB", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "LBRACKET", "RBRACKET", "RETURN", "LCONTROL", "A", "S", "D", "F", "G", "H", "J", "K", "L", "SEMICOLON", "APOSTROPHE", "GRAVE", "LSHIFT", "BACKSLASH", "Z", "X", "C", "V", "B", "N", "M", "COMMA", "PERIOD", "SLASH", "RSHIFT", "MULTIPLY", "LMENU", "SPACE", "CAPITAL", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "F10", "NUMLOCK", "SCROLL", "NUMPAD7", "NUMPAD8", "NUMPAD9", "SUBTRACT", "NUMPAD4", "NUMPAD5", "NUMPAD6", "ADD", "NUMPAD1", "NUMPAD2", "NUMPAD3", "NUMPAD0", "DECIMAL", "null", "null", "null", "F11", "F12", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "F13", "F14", "F15", "F16", "F17", "F18", "null", "null", "null", "null", "null", "null", "KANA", "F19", "null", "null", "null", "null", "null", "null", "null", "CONVERT", "null", "NOCONVERT", "null", "YEN", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "NUMPADEQUALS", "null", "null", "CIRCUMFLEX", "AT", "COLON", "UNDERLINE", "KANJI", "STOP", "AX", "UNLABELED", "null", "null", "null", "null", "NUMPADENTER", "RCONTROL", "null", "null", "null", "null", "null", "null", "null", "null", "null", "SECTION", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "NUMPADCOMMA", "null", "DIVIDE", "null", "SYSRQ", "RMENU", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "FUNCTION", "PAUSE", "null", "HOME", "UP", "PRIOR", "null", "LEFT", "null", "RIGHT", "null", "END", "DOWN", "NEXT", "INSERT", "DELETE", "null", "null", "null", "null", "null", "null", "CLEAR", "LMETA", "RMETA", "APPS", "POWER", "SLEEP", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null"};
    private static int[] keyCodes = new int[] {-1, -1, -1, -1, -1, -1, -1, -1, 14, 15, -1, -1, -1, 28, -1, -1, 42, 29, 56, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, 57, 210, 201, 207, 199, 203, 200, 205, 208, 205, 208, -1, -1, 210, 211, 211, 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, -1, -1, -1, -1, -1, -1, -1, 30, 48, 46, 32, 18, 33, 34, 35, 23, 36, 37, 38, 50, 49, 24, 25, 16, 19, 31, 20, 22, 47, 17, 45, 21, 44, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 12, 52, 53, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 39, 13, 51, 12, 52, 53, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, 43, 27,40};

    @JSBody(params = { "e" }, script = "return e.which;")
	private static native int getWhich(KeyboardEvent e);

    public static String getKeyName(int keyCode) {
        return (keyCode >= 0 && keyCode < 256) ? keyNames[keyCode] : "null";
    }

    private static int remapKey(int k) {
		return (k > keyCodes.length || k < 0) ? -1 : keyCodes[k];
    }

    public static boolean next() {
		currentEventK = null;
		return !keyEvents.isEmpty() && (currentEventK = keyEvents.remove(0)) != null;
    }

    public static boolean getEventKeyState() {
        return currentEventK == null? false : !currentEventK.getType().equals("keyup");
    }

    public static final int getEventKey() {
        return currentEventK == null ? -1 : remapKey(getWhich(currentEventK));
    }

    public static char getEventCharacter() {
        if(currentEventK == null) {
            return '\0';
        }

        String s = currentEventK.getKey();
        return currentEventK == null ? ' ' : (char) (s.length() > 1 ? '\0' : s.charAt(0));
    }

    public static void enableRepeatEvents(boolean b) {
        enableRepeatEvents = b;
    }

    public static boolean isKeyDown(int i) {
        return keyStates[i];
    }

	public static void create() throws LWJGLException {
		Main.win.addEventListener("keydown", keydown);
		Main.win.addEventListener("keyup", keyup);
		Main.win.addEventListener("keypress", keypress);
		keyEvents.clear();
    }

    public static void destroy() throws LWJGLException {
		Main.win.removeEventListener("keydown", keydown);
		Main.win.removeEventListener("keyup", keyup);
		Main.win.removeEventListener("keypress", keypress);
		keyEvents.clear();
    }
}