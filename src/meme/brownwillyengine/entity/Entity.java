package meme.brownwillyengine.entity;

/**
 * Created by Tyler on 3/2/2017.
 */
public class Entity implements EntityI {

    private float x, y, z;
    private float height, width, length;

    @Override
    public void draw() {



    }

    public void setX(float x){
        this.x = x;
    }

    public float getX(){
        return x;
    }

    public void setY(float y){
        this.y = y;
    }

    public float getY(){
        return y;
    }

    public void setZ(float z){
        this.z = z;
    }

    public float getZ(){
        return z;
    }

    public void setHeight(float height){
        this.height = height;
    }

    public float getHeight(){
        return height;
    }

    public void setWidth(float width){
        this.width = width;
    }

    public float getWidth(){
        return width;
    }

    public void setLength(float length){
        this.length = length;
    }

    public float getLength(){
        return length;
    }

}
