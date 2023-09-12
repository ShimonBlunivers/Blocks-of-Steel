package com.blunivers.source.shapes;

public class Cube extends Rect{
    protected int z, length;
    
    public Cube(int x, int y, int z, int width, int height, int length) {
        super(x, y, width, height);
        this.x = x;
        this.y = y;
        this.z = z;
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public int front(){
        return z;
    }

    public int back(){
        return z + length;
    }

    public int Z(){
        return z;
    }

    public void setZ(int z){
        this.z = z;
    }

    public void setSize(int width, int height, int length){
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public void setLength(int length){
        this.length = length;
    }

}
