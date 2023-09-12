package com.blunivers.source.shapes;

import com.blunivers.source.tools.Colors;

public class Rect {
    public int x;
    public int y;
    public int width;
    public int height;
    protected Colors fillColor, outlineColor;
    
    public Rect(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.fillColor = new Colors(1.0f, 1.0f, 1.0f);
    }   
    
    public Rect(int x, int y, int width, int height, Colors fillColor) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
    }


    public int left(){
        return x;
    }

    public int right(){
        return x + width;
    }

    public int top(){
        return y + height;
    }

    public int bottom(){
        return y;
    }

    public int X(){
        return x;
    }

    public int Y(){
        return y;
    }

    public void setX(int x){
        this.x = x;
    }    
    
    public void setY(int y){
        this.y = y;
    }


    public void setSize(int width, int height){
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public boolean collision(int x, int y){
        return
        left() < x &&
        right() > x &&
        bottom() < y &&
        top() > y;
    }

    
    public boolean collision(int x, int y, int width, int height){
        return
        left() < x + width &&
        right() > x &&
        bottom() < y + height &&
        top() > y ;
    }

    public boolean collision(Rect rect){
        return
        left() < rect.right() &&
        right() > rect.left() &&
        bottom() < rect.top() &&
        top() > rect.bottom();
    }

    public static boolean collision(Rect rect1, Rect rect2){
        return
        rect1.left() < rect2.right() &&
        rect1.right() > rect2.left() &&
        rect1.bottom() < rect2.top() &&
        rect1.top() > rect2.bottom();
    }

    public static boolean collision(Rect rect1, int x2, int y2){
        return
        rect1.left() < x2 &&
        rect1.right() > x2 &&
        rect1.bottom() < y2 &&
        rect1.top() > y2;
    }

    public static boolean collision(int x1, int y1, int width1, int height1, int x2, int y2, int width2, int height2){
        return
        x1 < x2 + width2 &&
        x1 + width1 > x2 &&
        y1 < y2 + height2 &&
        y1 + height1 > y2;
    }
}
