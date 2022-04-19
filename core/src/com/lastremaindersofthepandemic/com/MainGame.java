package com.lastremaindersofthepandemic.com;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;


public class MainGame extends Game {

	@Override
	public void create () {
		Assets assets = new Assets();
		assets.loadAll();
		assets.getAssetManager().finishLoading();
		setScreen(new HomePage(this, assets.getAssetManager()));

	}

	public void switchScreen(Screen screen){
		setScreen(screen);
	}






}


