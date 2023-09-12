package com.blunivers.source.blocks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Block {
    
    public Texture texture;
    public String name;
    public int index;
    public boolean transparent = false;

    public Block(String name) {
        this.name = name;
        this.texture = new Texture(Gdx.files.internal("blocks/" + name + "/texture.png"));
        this.index = BlockManager.blockList.size();
        BlockManager.blockList.add(this);
    }
    public Block setTransparent(boolean t){
        this.transparent = t;
        return this;
    }
}
