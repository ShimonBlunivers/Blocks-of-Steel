package com.blunivers.source.world;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.blunivers.source.blocks.Block;
import com.blunivers.source.config.Settings;
import com.blunivers.source.input.InputHandler;
import com.blunivers.source.shapes.Cube;
import com.blunivers.source.shapes.Rect;
import com.blunivers.source.tools.Dimensions;

public class Tile extends Cube {


    private Block block;
    public Boolean empty = true;
    public int renderedX, renderedY;

    public float opacity;

    public int fixedWidth = width / Settings.horizontalShift; 
    public int fixedHeight = height / Settings.verticalShift;

    public Rect hitbox = new Rect(x, y, width, height);

    public Tile(int x, int y, int z, Block block) {
        super(x, y, z, Settings.screenHeight/Settings.scale, Settings.screenHeight/Settings.scale, Settings.screenHeight/Settings.scale);
        this.block = block;
        this.empty = false;
    }
    public Tile(int x, int y, int z) {
        super(x, y, z, Settings.screenHeight/Settings.scale, Settings.screenHeight/Settings.scale, Settings.screenHeight/Settings.scale);
    }

    public void setBlock(Block block){
        this.block = block;
        this.empty = false;
    }

    public void setBlock(){
        this.block = null;
        this.empty = true;
    }

    public void draw(SpriteBatch batch) {
        if (this.empty) return;
        int fixedX = (Dimensions.calculateX(this, x, z));
        int fixedY = (Dimensions.calculateY(this, x, y, z) );

        this.renderedX = fixedX - World.x;
        this.renderedY = fixedY - World.z;

        this.hitbox.setX(this.renderedX);
        this.hitbox.setY(this.renderedY);
        this.hitbox.setSize(width, height);

        if (renderedX + width < 0 || renderedX > Gdx.graphics.getWidth() || renderedY + height < 0 || renderedY > Gdx.graphics.getHeight()) return;


        // if (InputHandler.MOUSE_LEFT && hitbox.collision((int)InputHandler.mouseX, (int)InputHandler.mouseY)){
        //     this.setBlock();
        // }
        batch.draw(block.texture, renderedX, renderedY, width, height);
    }
}
