
package com.blunivers.source;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.blunivers.source.blocks.Block;
import com.blunivers.source.blocks.BlockManager;
import com.blunivers.source.config.Settings;
import com.blunivers.source.input.InputHandler;
import com.blunivers.source.world.World;


public class GamePanel extends ApplicationAdapter {

    public long window;

    InputHandler inputHandler = new InputHandler();

    public static World world;

    private SpriteBatch batch;
    public static OrthographicCamera camera;


	@Override
	public void create () {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Settings.screenWidth, Settings.screenHeight);
		batch = new SpriteBatch();

        Gdx.input.setInputProcessor(inputHandler);
        BlockManager.init();

        GamePanel.world = new World();
	}

    public void update(){
        moveCamera();
    }

    private void moveCamera(){

        double cameraSpeed = 16;
        if (InputHandler.UP) World.z += cameraSpeed;
        if (InputHandler.DOWN) World.z -= cameraSpeed;
        if (InputHandler.LEFT) World.x -= cameraSpeed;
        if (InputHandler.RIGHT) World.x += cameraSpeed;
        
    }

    private void processInput(){
        camera.update();
        try {   if (InputHandler.MOUSE_LEFT) world.getClosestTile(0, 0).setBlock();    }    catch(NullPointerException e){}
        System.out.println((InputHandler.mouseX - World.x) + ", " + (InputHandler.mouseY + World.z));
    }


    @Override
    public void render(){
        
        ScreenUtils.clear((float)Settings.backgroundColor.getRed()/255, (float)Settings.backgroundColor.getGreen()/255, (float)Settings.backgroundColor.getBlue()/255, 0.0f);
        update();

        batch.setProjectionMatrix(camera.combined);


        batch.begin(); 
        world.render(batch);
        
        batch.draw(BlockManager.DiamondBlockBlock.texture, InputHandler.mouseX, InputHandler.mouseY, 20, 20);
        batch.end();
        
        


        // INPUT
        processInput();

    }

    @Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		for (Block block : BlockManager.blockList){
            block.texture.dispose();
        }
	}

}
