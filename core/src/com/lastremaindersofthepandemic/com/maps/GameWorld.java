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

        /*
        sb = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("shelby.png"));
        sprite = new Sprite(texture);
         */

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

        /*
        float oldX = camera.position.x;
        float oldY = camera.position.y;
         */

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

        batch.begin();
        player.draw(batch);
        batch.end();
        //game draw


        /*
        batch.begin();
        batch.setProjectionMatrix(camera.combined);
        batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

         */


        /*
        TiledMapTileLayer layer = (TiledMapTileLayer) tiledMap.getLayers().get(1);
        Cell cell = layer.getCell((int) (camera.position.y / 32), (int) (camera.position.x / 32));
        TiledMapTile tile = tiledMap.getTileSets().getTileSet(1).getTile(1030);

        if (cell != null && cell.equals(tile)) {
            camera.position.x = oldX;
            camera.position.y = oldY;
        }
         */

        player.getCamera().update();





        //new


        //ScreenUtils.clear(1, 0, 0, 1);

        /*
        sb.begin();
        sprite.setCenter(player.camera.position.x/2, player.camera.position.y/2);
        sprite.draw(sb);
        sb.end();
        //batch.draw(img, 0, 0);
        //batch.end();

         */

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
