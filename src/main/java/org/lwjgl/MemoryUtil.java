package org.lwjgl;

import java.nio.Buffer; 
import java.nio.ByteBuffer; 

public class MemoryUtil { 
    public static long getAddress0(Buffer buffer) { 
        return getAddress(buffer); 
    }
    
    public static long getAddress(Buffer buffer) { 
        if (buffer.hasArray()) { 
            return buffer.arrayOffset() + buffer.position(); 
        } else { 
            return buffer.position(); 
        } 
    } 
} 