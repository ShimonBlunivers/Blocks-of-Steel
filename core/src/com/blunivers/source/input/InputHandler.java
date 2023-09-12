package com.blunivers.source.input;


import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;
import com.blunivers.source.GamePanel;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;

public class InputHandler implements InputProcessor {
    public static boolean MOUSE_LEFT, MOUSE_RIGHT; 
    public static boolean W, S, A, D, SHIFT_LEFT, UP, DOWN, LEFT, RIGHT, Q, E;

    public static float mouseX, mouseY;

    @Override
    public boolean keyDown(int keycode) {

        if (keycode == Keys.W) W = true;
        if (keycode == Keys.S) S = true;
        if (keycode == Keys.A) A = true;
        if (keycode == Keys.D) D = true;
        if (keycode == Keys.SHIFT_LEFT) SHIFT_LEFT = true;
        if (keycode == Keys.UP) UP = true;
        if (keycode == Keys.DOWN) DOWN = true;
        if (keycode == Keys.LEFT) LEFT = true;
        if (keycode == Keys.RIGHT) RIGHT = true;
        if (keycode == Keys.Q) Q = true;
        if (keycode == Keys.E) E = true;
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {

        if (keycode == Keys.W) W = false;
        if (keycode == Keys.S) S = false;
        if (keycode == Keys.A) A = false;
        if (keycode == Keys.D) D = false;
        if (keycode == Keys.SHIFT_LEFT) SHIFT_LEFT = false;
        if (keycode == Keys.UP) UP = false;
        if (keycode == Keys.DOWN) DOWN = false;
        if (keycode == Keys.LEFT) LEFT = false;
        if (keycode == Keys.RIGHT) RIGHT = false;
        if (keycode == Keys.Q) Q = false;
        if (keycode == Keys.E) E = false;

        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        
        if (button == Buttons.LEFT) MOUSE_LEFT = true;        
        if (button == Buttons.RIGHT) MOUSE_RIGHT = true;

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        
        if (button == Buttons.LEFT) MOUSE_LEFT = false;        
        if (button == Buttons.RIGHT) MOUSE_RIGHT = false;

        return true;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        mouseX = convertToGraphicCoords(screenX, screenY).x;
        mouseY = convertToGraphicCoords(screenX, screenY).y;
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        mouseX = convertToGraphicCoords(screenX, screenY).x;
        mouseY = convertToGraphicCoords(screenX, screenY).y;
        return true;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
    
    private Vector3 convertToGraphicCoords(int x, int y){
        return GamePanel.camera.unproject(new Vector3(x, y, 0));
    }
}
