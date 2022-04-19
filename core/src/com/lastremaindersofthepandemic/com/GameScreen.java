package com.lastremaindersofthepandemic.com;

import com.badlogic.gdx.ScreenAdapter;

public class GameScreen extends ScreenAdapter {
    private MainGame game;
    private GameWorld world;


    public GameScreen(MainGame game) {
        this.game = game;
        world = new GameWorld();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}






