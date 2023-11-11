package org.lwjgl.input;

import org.teavm.jso.JSBody;
import org.teavm.jso.dom.events.EventListener;
import org.teavm.jso.dom.events.KeyboardEvent;

import java.util.LinkedList;

public class Keyboard {

    private static KeyboardEvent currentEventK = null;
    public static EventListener keypress = null;
    public static EventListener keydown = null;
	  public static EventListener keyup = null;
	  public static LinkedList<KeyboardEvent> keyEvents = new LinkedList();
    public static boolean[] keyStates = new boolean[256];
    public static boolean enableRepeatEvents = false;

    private static String[] keyNames = new String[] {"NONE", "ESCAPE", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "MINUS", "EQUALS", "BACK", "TAB", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "LBRACKET", "RBRACKET", "RETURN", "LCONTROL", "A", "S", "D", "F", "G", "H", "J", "K", "L", "SEMICOLON", "APOSTROPHE", "GRAVE", "LSHIFT", "BACKSLASH", "Z", "X", "C", "V", "B", "N", "M", "COMMA", "PERIOD", "SLASH", "RSHIFT", "MULTIPLY", "LMENU", "SPACE", "CAPITAL", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "F10", "NUMLOCK", "SCROLL", "NUMPAD7", "NUMPAD8", "NUMPAD9", "SUBTRACT", "NUMPAD4", "NUMPAD5", "NUMPAD6", "ADD", "NUMPAD1", "NUMPAD2", "NUMPAD3", "NUMPAD0", "DECIMAL", "null", "null", "null", "F11", "F12", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "F13", "F14", "F15", "F16", "F17", "F18", "null", "null", "null", "null", "null", "null", "KANA", "F19", "null", "null", "null", "null", "null", "null", "null", "CONVERT", "null", "NOCONVERT", "null", "YEN", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "NUMPADEQUALS", "null", "null", "CIRCUMFLEX", "AT", "COLON", "UNDERLINE", "KANJI", "STOP", "AX", "UNLABELED", "null", "null", "null", "null", "NUMPADENTER", "RCONTROL", "null", "null", "null", "null", "null", "null", "null", "null", "null", "SECTION", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "NUMPADCOMMA", "null", "DIVIDE", "null", "SYSRQ", "RMENU", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "FUNCTION", "PAUSE", "null", "HOME", "UP", "PRIOR", "null", "LEFT", "null", "RIGHT", "null", "END", "DOWN", "NEXT", "INSERT", "DELETE", "null", "null", "null", "null", "null", "null", "CLEAR", "LMETA", "RMETA", "APPS", "POWER", "SLEEP", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null"};
    private static int[] keyCodes = new int[] {-1, -1, -1, -1, -1, -1, -1, -1, 14, 15, -1, -1, -1, 28, -1, -1, 42, 29, 56, -1, -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, 57, 210, 201, 207, 199, 203, 200, 205, 208, 205, 208, -1, -1, 210, 211, 211, 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, -1, -1, -1, -1, -1, -1, -1, 30, 48, 46, 32, 18, 33, 34, 35, 23, 36, 37, 38, 50, 49, 24, 25, 16, 19, 31, 20, 22, 47, 17, 45, 21, 44, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 12, 52, 53, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 39, 13, 51, 12, 52, 53, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, 43, 27,40};

    @JSBody(params = { "e" }, script = "return e.which;")
	  public static native int getWhich(KeyboardEvent e);

    public static String getKeyName(int keyCode) {
        return (keyCode >= 0 && keyCode < 256) ? keyNames[keyCode] : "null";
    }

    public static int remapKey(int k) {
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
}