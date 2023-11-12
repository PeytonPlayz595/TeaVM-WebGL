package org.lwjgl;

import java.nio.*;

public class BufferUtils {	
	public static ByteBuffer createByteBuffer(int i1) {
		return ByteBuffer.wrap(new byte[i1]).order(ByteOrder.nativeOrder());
	}

	public static ShortBuffer createShortBuffer(int size) {
		return createByteBuffer(size << 1).asShortBuffer();
	}

	public static CharBuffer createCharBuffer(int size) {
		return createByteBuffer(size << 1).asCharBuffer();
	}

	public static IntBuffer createIntBuffer(int size) {
		return createByteBuffer(size << 2).asIntBuffer();
	}

	public static LongBuffer createLongBuffer(int size) {
		return createByteBuffer(size << 3).asLongBuffer();
	}

	public static FloatBuffer createFloatBuffer(int size) {
		return createByteBuffer(size << 2).asFloatBuffer();
	}

	public static DoubleBuffer createDoubleBuffer(int size) {
		return createByteBuffer(size << 3).asDoubleBuffer();
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