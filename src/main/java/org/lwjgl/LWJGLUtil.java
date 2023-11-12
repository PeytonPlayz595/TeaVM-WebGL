package org.lwjgl;

import java.util.*;

public class LWJGLUtil {

    public static void log(CharSequence msg) {
		System.err.println("[OpenGL Emulator] " + msg);
	}

    public static String toHexString(final int value) {
		return "0x" + Integer.toHexString(value).toUpperCase();
	}
}