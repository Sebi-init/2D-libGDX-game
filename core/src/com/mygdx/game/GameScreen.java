package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {

    /* Sections - legend & meanings
      screen
      graphics
      timing - for movement
     */

    //screen
    private Camera camera;
    private Viewport viewport;

    //graphics
    private SpriteBatch batch; // list of instructions
                               // for all of the sprites to draw (and fill in the batch to do so)
    private Texture background;// bg image

    //will be used for scrolling
    private int backgroundOffset; // bg updates while moving

    //world parameters - screen size
    private final int WORLD_WIDTH = 72; //meters
    private final int WORLD_HEIGHT = 128; //meters




    public GameScreen(){

        //Camera class is abstract => we choose subclass - 2D camera
        camera = new OrthographicCamera();

        //The screen the User sees - Stretching View
        viewport = new StretchViewport (WORLD_WIDTH, WORLD_WIDTH, camera);

        background = new Texture ("sky.jpg");
        backgroundOffset = 0; //timer

        batch = new SpriteBatch(); // collect all individual changes to the graphics and display all at once


    }


    @Override
    public void show() {

    }

    /*
    deltaTime = how much time has passed since prev time cycle
    > I ignore that since i use my time stamp : backgroundOffset
     */
    @Override
    public void render(float deltaTime) {
        batch.begin(); //start the sprite batch

        /*
          -----------------
          Starting the game
          -----------------
         */

        //scrolling background

        backgroundOffset ++; //each time the render method is called

        //if bigger than the resolution => set it back to 0
        if(backgroundOffset % WORLD_HEIGHT == 0) { //exactly 128
            backgroundOffset = 0;
        }




        // 0,0 = bottom left
        // y = -backgroundOffset => it scrolls down basically
        // If we only used the first batch.draw => no fluent transitioning
        batch.draw(background,0,-backgroundOffset,WORLD_WIDTH,WORLD_HEIGHT);
        batch.draw(background,0,WORLD_HEIGHT-backgroundOffset,WORLD_WIDTH,WORLD_HEIGHT);
        // ^ Putting them edge to edge, top to bottom and fit


        batch.end();

    }

    @Override
    public void resize(int width, int height) {
        //stretch view
        //last arg - centred or not
        viewport.update(width, height, true);
        batch.setProjectionMatrix(camera.combined);

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
