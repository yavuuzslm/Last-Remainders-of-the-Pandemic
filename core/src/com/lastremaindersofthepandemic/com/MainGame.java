package com.lastremaindersofthepandemic.com;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lastremaindersofthepandemic.com.maps.GameWorld;
import com.lastremaindersofthepandemic.com.screens.HomePage;
import com.lastremaindersofthepandemic.com.screens.OptionsPanel;
import com.lastremaindersofthepandemic.com.utilities.Assets;


public class MainGame extends Game {
	SpriteBatch batch;
	BitmapFont font;
	Assets assets;
	AssetManager manager;


	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		Assets assets = new Assets();
		assets.loadAll();
		assets.getAssetManager().finishLoading();
		manager = assets.getAssetManager();
		setScreen(new HomePage(this,manager));
	}

	public void switchScreen(String screen_name) {
		Gdx.input.setInputProcessor(null);

		switch (screen_name) {
			case "gameplay":
				setScreen(new GameWorld());
				break;
			case "options":
				setScreen(new OptionsPanel(this,manager));
				break;
			default:
				setScreen(new HomePage(this,manager));
				break;
		}
	}

	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
	}

	//assets getter
	public Assets getAssets() {
		return assets;
	}
}


