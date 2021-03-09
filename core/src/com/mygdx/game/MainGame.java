package com.mygdx.game;


//INSTANTIATION CLASS
//SETS THINGS IN MOTION
//CORE APP IS IN GameScreen.java

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainGame extends com.badlogic.gdx.Game {

	GameScreen gameScreen;


	@Override
	public void create() {
		gameScreen = new GameScreen();
		setScreen(gameScreen); //display gameScreen when app starts
	}

	/*
	Clean resources after exit
	 */
	@Override
	public void dispose() {
		gameScreen.dispose();
	}

	/*
	Draws stuff on screen
	 */
	@Override
	public void render() {
		super.render();
	}

	/*
	Resizes the app - usually on desktop
	 */
	@Override
	public void resize(int width, int height) {
		gameScreen.resize(width, height);
	}

//	SpriteBatch batch;
//	Texture img;
//
//	@Override
//	public void create () {
//		batch = new SpriteBatch();
//		img = new Texture("badlogic.jpg");
//	}
//
//	@Override
//	public void render () {
//		Gdx.gl.glClearColor(1, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();
//	}
//
//	@Override
//	public void dispose () {
//		batch.dispose();
//		img.dispose();
//	}
}
