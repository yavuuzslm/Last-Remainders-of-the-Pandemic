package com.lastremaindersofthepandemic.com;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	OrthographicCamera camera;
	Control control;

	//Display size
	private int displayW;
	private int displayH;

	//Temp x and y co-ords
	int x, y;

	//For movement
	int direction_x, direction_y;
	int speed = 3;


	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		displayW = Gdx.graphics.getWidth();
		displayH = Gdx.graphics.getHeight();

		int h = (int) (displayH/Math.floor(displayH / 160));
		int w = (int) (displayW/(displayH / (displayH / Math.floor(displayW / 160))));

		camera = new OrthographicCamera(w, h);
		camera.zoom = .4f;

		control = new Control(displayW, displayH, camera);
		Gdx.input.setInputProcessor(control);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//reset the direction values

		direction_x = 0;
		direction_y = 0;

		if (control.down) {
			direction_y = -1;
		}
		if (control.up) {
			direction_y = 1;
		}
		if (control.right) {
			direction_x = 1;
		}
		if (control.left) {
			direction_x = -1;
		}

		camera.position.x += direction_x*speed;
		camera.position.y += direction_y*speed;
		camera.update();

		//game draw
		batch.setProjectionMatrix(camera.combined);
		batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);


		//ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
