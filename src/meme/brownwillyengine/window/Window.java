package meme.brownwillyengine.window;

import meme.brownwillyengine.update.UpdateThread;
import org.lwjgl.system.MemoryUtil;

import static org.lwjgl.glfw.GLFW.*;

/**
 * Created by Tyler on 3/2/2017.
 */
public class Window {

    UpdateThread update;

    private long glfwID = MemoryUtil.NULL;

    public Window(CharSequence title, int xPos, int yPos, int width, int height){

        glfwID = glfwCreateWindow(width, height, title, MemoryUtil.NULL, MemoryUtil.NULL);

        if(glfwID == MemoryUtil.NULL){
            glfwTerminate();
            throw new IllegalStateException("Failed to initialize GLFW window");
        }

        update = new UpdateThread(glfwID);

    }

    public void show(){
        glfwShowWindow(glfwID);
    }

    public void hide(){
        glfwHideWindow(glfwID);
    }

}
