package com.blunivers.source.tools;

public class Colors {
    
    int red, green, blue, alpha;

    public Colors(int r, int g, int b){
        this.red = r;
        this.green = g;
        this.blue = b;
        this.alpha = 0;
    }

    public Colors(int r, int g, int b, int a){
        this.red = r;
        this.green = g;
        this.blue = b;
        this.alpha = a;
    }

    public Colors(float r, float g, float b){
        this.red = (int)(r * 255);
        this.green = (int)(g * 255);
        this.blue = (int)(b * 255);
        this.alpha = 0;
    }

    public Colors(float r, float g, float b, float a){
        this.red = (int)(r * 255);
        this.green = (int)(g * 255);
        this.blue = (int)(b * 255);
        this.alpha = (int)(a * 255);
    }

    public int getR(){
        return red;
    }
    
    public int getG(){
        return green;
    }

    public int getB(){
        return blue;
    }

    public int getA(){
        return alpha;
    }

    public float getRf(){
        return red/255;
    }
    
    public float getGf(){
        return green/255;
    }

    public float getBf(){
        return blue/255;
    }

    public float getAf(){
        return alpha/255;
    }
}
