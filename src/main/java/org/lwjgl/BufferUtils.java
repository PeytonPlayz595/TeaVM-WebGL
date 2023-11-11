package org.lwjgl;

import java.nio.*;

public class BufferUtils {
	public static FloatBuffer createFloatBuffer(int i1) {
		return FloatBuffer.wrap(new float[i1]);
	}
	
	public static IntBuffer createIntBuffer(int i1) {
		return IntBuffer.wrap(new int[i1]);
	}
	
	public static ByteBuffer createByteBuffer(int i1) {
		return ByteBuffer.wrap(new byte[i1]).order(ByteOrder.nativeOrder());
	}
}