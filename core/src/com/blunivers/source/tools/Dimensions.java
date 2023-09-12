package com.blunivers.source.tools;

import com.blunivers.source.world.Tile;

public class Dimensions {
    
    public static int calculateX(int x, int z){
        return x + z;
    }

    public static int calculateY(int x, int y, int z){
        return (x + 2 * y - z);
    }

    public static int calculateX(Tile tile, int x, int z){
        return (x + z) * tile.fixedWidth;
    }

    public static int calculateY(Tile tile, int x, int y, int z){
        return (x + 2 * y - z) * tile.fixedHeight;
    }
}
