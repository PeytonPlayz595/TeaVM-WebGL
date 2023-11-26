package org.lwjgl;

import java.nio.*;

public class BufferUtils {	
	public static ByteBuffer createByteBuffer(int i1) {
		return ByteBuffer.wrap(new byte[i1]);
	}

	public static ShortBuffer createShortBuffer(int size) {
		return ShortBuffer.wrap(new short[size]);
	}

	public static CharBuffer createCharBuffer(int size) {
		return CharBuffer.wrap(new char[size]);
	}

	public static IntBuffer createIntBuffer(int size) {
		return IntBuffer.wrap(new int[size]);
	}

	public static LongBuffer createLongBuffer(int size) {
		return LongBuffer.wrap(new long[size]);
	}

	public static FloatBuffer createFloatBuffer(int size) {
		return FloatBuffer.wrap(new float[size]);
	}

	public static DoubleBuffer createDoubleBuffer(int size) {
		return DoubleBuffer.wrap(new double[size]);
	}

	public static int getElementSizeExponent(Buffer buf) {
		if (buf instanceof ByteBuffer)
			return 0;
		else if (buf instanceof ShortBuffer || buf instanceof CharBuffer)
			return 1;
		else if (buf instanceof FloatBuffer || buf instanceof IntBuffer)
			return 2;
		else if (buf instanceof LongBuffer || buf instanceof DoubleBuffer)
			return 3;
		else
			throw new IllegalStateException("Unsupported buffer type: " + buf);
	}

	public static int getOffset(Buffer buffer) {
		return buffer.position() << getElementSizeExponent(buffer);
	}
}