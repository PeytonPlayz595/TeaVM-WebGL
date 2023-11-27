# TeaVM-WebGL
This project is designed to replicate OpenGL 1.3 in TeaVM

# Initializing
To use any WebGL functions or use the `Keyboard` and `Mouse` classes you first must initialize the WebGL context

Usage:
```java
package net.PeytonPlayz585.test;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class TestClass {

  public static void main(String[] args) {
    try {
      //Initializes WebGL context and canvas, must be called to use any OpenGL/WebGL functions including the mouse and keyboard
      Display.create();

      //Initializes the Keyboard and Mouse classes, needed to interact with Keyboard and Mouse
      Keyboard.create();
      Mouse.create();
    } catch(LWJGLException e) {
      e.printStackTrace();
    }
  }

}
```

# Using external files and textures

To use or load external files or textures using this project you first have to compile all of the assets you want to use in the program with Lax1dude's EPK compiler, the compiler and the instructions can be found [here]()

Once you have compiled the assets place the epk file in the same folder with your index.html and classes.js, next you have to load and install the assets in the OpenGL Emulator
Here's an example of how you can do that:
```java
package net.PeytonPlayz585.test;

public class TestClass {

  public static void main(String[] args) {
    try {
      //Downloads the assets from the EPK file
      //Make sure to replace "assets.epk" with the actual name of the EPK file
      WebGL.downloadAssetPack("assets.epk");

      //Installs the files from the downloaded EPK file into the project
      WebGL.install();
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
  
}
```
Once you download and install the resources from the EPK file you are able to render images and get file contents.

# Loading and Rendering images

# Loading GLSL Shaders

# Projects created with this OpenGL Emulator
