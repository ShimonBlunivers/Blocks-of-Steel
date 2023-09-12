package com.blunivers.source.blocks;

import java.util.ArrayList;

public class BlockManager {
        // BLOCKS INIT
        public static ArrayList<Block> blockList = new ArrayList<>();

        public static Block GrassBlock;
        public static Block DirtBlock;
        public static Block BottomsoilBlock;
        public static Block StoneBlock;
        public static Block GlassBlock;
        public static Block DiamondBlockBlock;

        public static void init() {
                BlockManager.GrassBlock = new Block("grass");
                BlockManager.DirtBlock = new Block("dirt");
                BlockManager.BottomsoilBlock = new Block("bottomsoil");
                BlockManager.StoneBlock = new Block("stone");    
                BlockManager.GlassBlock = new Block("glass").setTransparent(true);
                BlockManager.DiamondBlockBlock = new Block("diamond-block");
        }
}


