package com.nathan.heindl;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
 
import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;
 
public class Main {
 
    
    private long window;
 
    public void run() {
        System.out.println("Hello LWJGL " + Version.getVersion() + "!");
 
        try {
            init();
            loop();
 
            
            glfwFreeCallbacks(window);
            glfwDestroyWindow(window);
        } finally {
            
            glfwTerminate();
            glfwSetErrorCallback(null).free();
        }
    }
 
    private void init() {
        
        GLFWErrorCallback.createPrint(System.err).set();
 
        
        if ( !glfwInit() )
            throw new IllegalStateException("Unable to initialize GLFW");
 
        
        glfwDefaultWindowHints(); 
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); 
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); 
 
        int WIDTH = 300;
        int HEIGHT = 300;
 
        
        window = glfwCreateWindow(WIDTH, HEIGHT, "Hello World!", NULL, NULL);
        if ( window == NULL )
            throw new RuntimeException("Failed to create the GLFW window");
 
      
        glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
            if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
                glfwSetWindowShouldClose(window, true); 
        });
 
       
        GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        
        glfwSetWindowPos(
            window,
            (vidmode.width() - WIDTH) / 2,
            (vidmode.height() - HEIGHT) / 2
        );
 
        glfwMakeContextCurrent(window);
       
        glfwSwapInterval(1);
 
        glfwShowWindow(window);
    }
 
    private void loop() {
        
        GL.createCapabilities();
 
       
        glClearColor(1.0f, 20.0f, 0.0f, 0.0f);
 
        while ( !glfwWindowShouldClose(window) ) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); 
 
            glfwSwapBuffers(window); 
 
          
            glfwPollEvents();
        }
    }
 
    public static void main(String[] args) {
        new Main().run();
    }
 
}