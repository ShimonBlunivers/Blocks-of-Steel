package com.blunivers.source.world;

// import java.util.Random;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.blunivers.source.blocks.BlockManager;
import com.blunivers.source.config.WorldGen;

public class World {


    public static int       x,          y,          z;
    public        int       width,      height,     length;

    
    public Tile data[] = {};

    private BufferedImage mapNoise;


    public World() {
        try {
                this.mapNoise = ImageIO.read(getClass().getResourceAsStream("/map/texture.png"));
            } catch(IOException e){ e.printStackTrace(); }

        generate();
        
    }

    public void generate() {
        this.width = WorldGen.worldWidth;
        this.height = WorldGen.heightLimit;
        this.length = WorldGen.worldLength;
        
        this.data = new Tile[width * height * length];

        World.x = width / 2;
        World.y = height / 2;
        World.z = length / 2;

        // Random rand = new Random();

        for (int i = 0; i < width * height * length ; i++) {

            int x = (height - 1) - i % width;
            int y = Math.floorDiv(i, width) % height;
            int z = Math.floorDiv(i, width * height);

            int currentPixelColorWeight;
            int maxY = 0;

            Tile newTile;
            if (y == 0) newTile = new Tile(x, y, z, BlockManager.BottomsoilBlock);
            else {
                currentPixelColorWeight = mapNoise.getRGB(Math.abs(x%mapNoise.getWidth(null)), Math.abs(z%mapNoise.getHeight(null))) & 0xff;
                maxY = currentPixelColorWeight/16 + 10;
                if (y == maxY) newTile = new Tile(x, y, z, BlockManager.GrassBlock);
                else if (y > maxY) newTile = new Tile(x, y, z);
                else if (y > maxY*3/4) newTile = new Tile(x, y, z, BlockManager.GrassBlock);
                else newTile = new Tile(x, y, z, BlockManager.StoneBlock);
            }

            this.data[i] = newTile;
        }

    }

    public Tile getClosestTile(int x, int y){
        Tile closestTile = null;

        for (Tile currentTile : this.data){
            if (!currentTile.empty && currentTile.X() == x && currentTile.Z() == y) closestTile = currentTile;
            
        }
        
        return closestTile;
    }


    
    public void render(SpriteBatch batch) {
        for (Tile tile : data) try { 
            tile.draw(batch);
        } catch(NullPointerException e) {}
    }
}