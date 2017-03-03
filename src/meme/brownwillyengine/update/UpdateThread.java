package meme.brownwillyengine.update;

import static org.lwjgl.glfw.GLFW.*;

/**
 * Created by Tyler on 3/2/2017.
 */
public class UpdateThread extends Thread implements Runnable{

    private long glfwID;

    public UpdateThread(long glfwID){
        start();
    }

    @Override
    public void run() {



    }
}
