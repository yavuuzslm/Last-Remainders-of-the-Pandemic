package com.lastremaindersofthepandemic.com;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class GameWorld implements Screen {
    SpriteBatch batch;
    Texture img;
    OrthographicCamera camera;
    Control control;
    TiledMap tiledMap;
    TiledMapRenderer tiledMapRenderer;

    //Display size
    private int displayW;
    private int displayH;


    //Temp x and y co-ords
    int x, y;

    //For movement
    int direction_x, direction_y;
    int speed = 3;

    //constructor
    public GameWorld() {
        create();
    }


    public void create() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.update();
        batch = new SpriteBatch();
        tiledMap = new TmxMapLoader().load("lab.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        control = new Control(displayW, displayH, camera);
        Gdx.input.setInputProcessor(control);

    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,1,1);
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
        batch.begin();
        batch.setProjectionMatrix(camera.combined);
        batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

        //new
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();

        //ScreenUtils.clear(1, 0, 0, 1);

        //batch.draw(img, 0, 0);
        batch.end();

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
    public void hide() {

    }

    @Override
    public void dispose () {
        batch.dispose();
        img.dispose();
    }


    public void show() {
        Gdx.input.setInputProcessor(control);
    }
}
