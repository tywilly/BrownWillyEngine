package meme.brownwillyengine;

import meme.brownwillyengine.opengl.OpenGLUtils;
import org.lwjgl.opengl.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class BrownWillyEngine {

    double rotatex = 0;

    double rotatey = 0;

    protected boolean revUp(){
        // Rev up that Willy Engine!

        OpenGLUtils.initOpenGL(0);

        loop();

        return false;
    }

    private void loop(){
        // This line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current thread,
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use.
        GL.createCapabilities();

        // Set the clear color
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

        // Run the rendering loop until the user has attempted to close
        // the window or has pressed the ESCAPE key.
        while ( !glfwWindowShouldClose(OpenGLUtils.getWindow(0)) ) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer


            glBegin(GL_TRIANGLES);
            glColor3f(1,0,0);
            glVertex2d(0, 1.0);
            glVertex2d(-1.0,-1.0);
            glVertex2d(1.0,-1.0);
            glEnd();

            glRotated(rotatex,1,0,0);
            glRotated(rotatey,0,0,1);

            rotatex+=0.001;
            rotatey+=0.0005;

            glfwSwapBuffers(OpenGLUtils.getWindow(0)); // swap the color buffers

            // Poll for window events. The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }

    }

}
