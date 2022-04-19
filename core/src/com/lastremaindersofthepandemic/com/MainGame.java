package com.lastremaindersofthepandemic.com;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MainGame extends Game {


	SpriteBatch batch;
	BitmapFont font;


	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		Assets assets = new Assets();
		assets.loadAll();
		assets.getAssetManager().finishLoading();
		setScreen(new HomePage(this,assets.getAssetManager()));
	}

	public void switchScreen(Screen screen){
		Gdx.input.setInputProcessor(null);
		setScreen(screen);
	}

	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
	}

}


