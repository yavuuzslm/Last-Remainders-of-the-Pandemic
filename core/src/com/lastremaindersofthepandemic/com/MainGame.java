package com.lastremaindersofthepandemic.com;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;


public class MainGame extends Game {


	@Override
	public void create () {
		Assets assets = new Assets();
		assets.loadAll();
		assets.getAssetManager().finishLoading();
		setScreen(new HomePage(assets.getAssetManager()));

	}

}


