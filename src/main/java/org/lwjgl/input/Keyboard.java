package org.lwjgl.input;

import org.teavm.jso.JSBody;
import org.teavm.jso.dom.events.EventListener;
import org.teavm.jso.dom.events.KeyboardEvent;

import java.util.LinkedList;

public class Keyboard {

    /**
	 * The special character meaning that no
	 * character was translated for the event.
	 */
	public static final int CHAR_NONE          = '\0';

	/**
	 * The special keycode meaning that only the
	 * translated character is valid.
	 */
	public static final int KEY_NONE            = 0x00;

	public static final int KEY_ESCAPE          = 0x01;
	public static final int KEY_1               = 0x02;
	public static final int KEY_2               = 0x03;
	public static final int KEY_3               = 0x04;
	public static final int KEY_4               = 0x05;
	public static final int KEY_5               = 0x06;
	public static final int KEY_6               = 0x07;
	public static final int KEY_7               = 0x08;
	public static final int KEY_8               = 0x09;
	public static final int KEY_9               = 0x0A;
	public static final int KEY_0               = 0x0B;
	public static final int KEY_MINUS           = 0x0C; /* - on main keyboard */
	public static final int KEY_EQUALS          = 0x0D;
	public static final int KEY_BACK            = 0x0E; /* backspace */
	public static final int KEY_TAB             = 0x0F;
	public static final int KEY_Q               = 0x10;
	public static final int KEY_W               = 0x11;
	public static final int KEY_E               = 0x12;
	public static final int KEY_R               = 0x13;
	public static final int KEY_T               = 0x14;
	public static final int KEY_Y               = 0x15;
	public static final int KEY_U               = 0x16;
	public static final int KEY_I               = 0x17;
	public static final int KEY_O               = 0x18;
	public static final int KEY_P               = 0x19;
	public static final int KEY_LBRACKET        = 0x1A;
	public static final int KEY_RBRACKET        = 0x1B;
	public static final int KEY_RETURN          = 0x1C; /* Enter on main keyboard */
	public static final int KEY_LCONTROL        = 0x1D;
	public static final int KEY_A               = 0x1E;
	public static final int KEY_S               = 0x1F;
	public static final int KEY_D               = 0x20;
	public static final int KEY_F               = 0x21;
	public static final int KEY_G               = 0x22;
	public static final int KEY_H               = 0x23;
	public static final int KEY_J               = 0x24;
	public static final int KEY_K               = 0x25;
	public static final int KEY_L               = 0x26;
	public static final int KEY_SEMICOLON       = 0x27;
	public static final int KEY_APOSTROPHE      = 0x28;
	public static final int KEY_GRAVE           = 0x29; /* accent grave */
	public static final int KEY_LSHIFT          = 0x2A;
	public static final int KEY_BACKSLASH       = 0x2B;
	public static final int KEY_Z               = 0x2C;
	public static final int KEY_X               = 0x2D;
	public static final int KEY_C               = 0x2E;
	public static final int KEY_V               = 0x2F;
	public static final int KEY_B               = 0x30;
	public static final int KEY_N               = 0x31;
	public static final int KEY_M               = 0x32;
	public static final int KEY_COMMA           = 0x33;
	public static final int KEY_PERIOD          = 0x34; /* . on main keyboard */
	public static final int KEY_SLASH           = 0x35; /* / on main keyboard */
	public static final int KEY_RSHIFT          = 0x36;
	public static final int KEY_MULTIPLY        = 0x37; /* * on numeric keypad */
	public static final int KEY_LMENU           = 0x38; /* left Alt */
	public static final int KEY_SPACE           = 0x39;
	public static final int KEY_CAPITAL         = 0x3A;
	public static final int KEY_F1              = 0x3B;
	public static final int KEY_F2              = 0x3C;
	public static final int KEY_F3              = 0x3D;
	public static final int KEY_F4              = 0x3E;
	public static final int KEY_F5              = 0x3F;
	public static final int KEY_F6              = 0x40;
	public static final int KEY_F7              = 0x41;
	public static final int KEY_F8              = 0x42;
	public static final int KEY_F9              = 0x43;
	public static final int KEY_F10             = 0x44;
	public static final int KEY_NUMLOCK         = 0x45;
	public static final int KEY_SCROLL          = 0x46; /* Scroll Lock */
	public static final int KEY_NUMPAD7         = 0x47;
	public static final int KEY_NUMPAD8         = 0x48;
	public static final int KEY_NUMPAD9         = 0x49;
	public static final int KEY_SUBTRACT        = 0x4A; /* - on numeric keypad */
	public static final int KEY_NUMPAD4         = 0x4B;
	public static final int KEY_NUMPAD5         = 0x4C;
	public static final int KEY_NUMPAD6         = 0x4D;
	public static final int KEY_ADD             = 0x4E; /* + on numeric keypad */
	public static final int KEY_NUMPAD1         = 0x4F;
	public static final int KEY_NUMPAD2         = 0x50;
	public static final int KEY_NUMPAD3         = 0x51;
	public static final int KEY_NUMPAD0         = 0x52;
	public static final int KEY_DECIMAL         = 0x53; /* . on numeric keypad */
	public static final int KEY_F11             = 0x57;
	public static final int KEY_F12             = 0x58;
	public static final int KEY_F13             = 0x64; /*                     (NEC PC98) */
	public static final int KEY_F14             = 0x65; /*                     (NEC PC98) */
	public static final int KEY_F15             = 0x66; /*                     (NEC PC98) */
	public static final int KEY_F16             = 0x67; /* Extended Function keys - (Mac) */
	public static final int KEY_F17             = 0x68;
	public static final int KEY_F18             = 0x69;
	public static final int KEY_KANA            = 0x70; /* (Japanese keyboard)            */
	public static final int KEY_F19             = 0x71; /* Extended Function keys - (Mac) */
	public static final int KEY_CONVERT         = 0x79; /* (Japanese keyboard)            */
	public static final int KEY_NOCONVERT       = 0x7B; /* (Japanese keyboard)            */
	public static final int KEY_YEN             = 0x7D; /* (Japanese keyboard)            */
	public static final int KEY_NUMPADEQUALS    = 0x8D; /* = on numeric keypad (NEC PC98) */
	public static final int KEY_CIRCUMFLEX      = 0x90; /* (Japanese keyboard)            */
	public static final int KEY_AT              = 0x91; /*                     (NEC PC98) */
	public static final int KEY_COLON           = 0x92; /*                     (NEC PC98) */
	public static final int KEY_UNDERLINE       = 0x93; /*                     (NEC PC98) */
	public static final int KEY_KANJI           = 0x94; /* (Japanese keyboard)            */
	public static final int KEY_STOP            = 0x95; /*                     (NEC PC98) */
	public static final int KEY_AX              = 0x96; /*                     (Japan AX) */
	public static final int KEY_UNLABELED       = 0x97; /*                        (J3100) */
	public static final int KEY_NUMPADENTER     = 0x9C; /* Enter on numeric keypad */
	public static final int KEY_RCONTROL        = 0x9D;
	public static final int KEY_SECTION         = 0xA7; /* Section symbol (Mac) */
	public static final int KEY_NUMPADCOMMA     = 0xB3; /* , on numeric keypad (NEC PC98) */
	public static final int KEY_DIVIDE          = 0xB5; /* / on numeric keypad */
	public static final int KEY_SYSRQ           = 0xB7;
	public static final int KEY_RMENU           = 0xB8; /* right Alt */
	public static final int KEY_FUNCTION        = 0xC4; /* Function (Mac) */
	public static final int KEY_PAUSE           = 0xC5; /* Pause */
	public static final int KEY_HOME            = 0xC7; /* Home on arrow keypad */
	public static final int KEY_UP              = 0xC8; /* UpArrow on arrow keypad */
	public static final int KEY_PRIOR           = 0xC9; /* PgUp on arrow keypad */
	public static final int KEY_LEFT            = 0xCB; /* LeftArrow on arrow keypad */
	public static final int KEY_RIGHT           = 0xCD; /* RightArrow on arrow keypad */
	public static final int KEY_END             = 0xCF; /* End on arrow keypad */
	public static final int KEY_DOWN            = 0xD0; /* DownArrow on arrow keypad */
	public static final int KEY_NEXT            = 0xD1; /* PgDn on arrow keypad */
	public static final int KEY_INSERT          = 0xD2; /* Insert on arrow keypad */
	public static final int KEY_DELETE          = 0xD3; /* Delete on arrow keypad */
	public static final int KEY_CLEAR           = 0xDA; /* Clear key (Mac) */
	public static final int KEY_LMETA           = 0xDB; /* Left Windows/Option key */
	/**
	 * The left windows key, mapped to KEY_LMETA
	 *
	 * @deprecated Use KEY_LMETA instead
	 */
	public static final int KEY_LWIN            = KEY_LMETA; /* Left Windows key */
	public static final int KEY_RMETA            = 0xDC; /* Right Windows/Option key */
	/**
	 * The right windows key, mapped to KEY_RMETA
	 *
	 * @deprecated Use KEY_RMETA instead
	 */
	public static final int KEY_RWIN            = KEY_RMETA; /* Right Windows key */
	public static final int KEY_APPS            = 0xDD; /* AppMenu key */
	public static final int KEY_POWER           = 0xDE;
	public static final int KEY_SLEEP           = 0xDF;

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