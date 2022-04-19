package com.lastremaindersofthepandemic.com;

import com.badlogic.gdx.ScreenAdapter;

public class GameScreen extends ScreenAdapter {
    final private GameWorld world;

    public GameScreen() {
        world = new GameWorld();
    }



    @Override
    public void render(float delta) {
        world.update(delta);
    }

    @Override
    public void resize(int width, int height) {
        world.resize(width, height);
    }
    @Override
    public void show() {
        world.show();
    }
}
