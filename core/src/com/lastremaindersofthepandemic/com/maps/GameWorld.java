package com.lastremaindersofthepandemic.com.maps;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.lastremaindersofthepandemic.com.utilities.Control;
import com.lastremaindersofthepandemic.com.entities.Player;

public class GameWorld implements Screen {
    SpriteBatch batch;
    Texture img;
    //OrthographicCamera camera;
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
    int speed = 2;

    SpriteBatch sb;
    Sprite sprite;
    Texture texture;
    Player player;

    //constructor
    public GameWorld() {
        create();
    }


    public void create() {

        Vector2 vector = new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        player = new Player(vector);
        batch = new SpriteBatch();
        tiledMap = new TmxMapLoader().load("lab.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);

        control = new Control(displayW, displayH, player.getCamera());
        Gdx.input.setInputProcessor(control);



    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        tiledMapRenderer.setView(player.getCamera());
        tiledMapRenderer.render();

        //reset the direction values
        direction_x = 0;
        direction_y = 0;

        float oldX = player.getCamera().position.x;
        float oldY = player.getCamera().position.y;


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

        player.getCamera().position.x += direction_x*speed;
        player.getCamera().position.y += direction_y*speed;

        if(!isValid()) {
            player.getCamera().position.x = oldX;
            player.getCamera().position.y = oldY;
        }

        batch.begin();
        player.draw(batch);
        batch.end();

        player.getCamera().update();
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

    public boolean isValid() {
        TiledMapTileLayer layer = (TiledMapTileLayer) tiledMap.getLayers().get(1);
        TiledMapTileLayer.Cell cell = layer.getCell((int) ((player.getCamera().position.x + direction_x*player.texture.getWidth()/2)
                / layer.getTileWidth()), (int) (player.getCamera().position.y + direction_y*player.texture.getHeight()/2)
                / layer.getTileHeight());
        TiledMapTile tile = tiledMap.getTileSets().getTileSet(1).getTile(1031);

        return cell == null;
    }

    public void show() {
        Gdx.input.setInputProcessor(control);
    }
}
