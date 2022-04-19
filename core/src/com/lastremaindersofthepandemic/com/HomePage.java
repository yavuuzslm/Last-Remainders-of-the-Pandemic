package com.lastremaindersofthepandemic.com;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class HomePage implements Screen {
    private Stage stage;
    private Viewport viewport;
    private AssetManager assetManager;
    final private Skin skin;
    private Table homeScreenTable;
    final private MainGame mainGame;


    public HomePage(MainGame game,AssetManager assetManager) {
        this.assetManager = assetManager;
        skin = assetManager.get(Assets.skinDescriptor);
        this.mainGame = game;
    }

    @Override
    public void show() {
        viewport = new ExtendViewport(1280, 720);
        stage = new Stage(viewport);
        homeScreenTable = new Table();
        homeScreenTable.setFillParent(true);
        stage.addActor(homeScreenTable);
        Gdx.input.setInputProcessor(stage);
        addButton("Play").addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                mainGame.setScreen(new GameWorld());
                dispose();
            }
        }
        );
        addButton("Options");
        addButton("About");
        addButton("Quit").addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        }
        );

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
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
    public void dispose() {
        stage.dispose();
    }

    private TextButton addButton(String text) {
        TextButton button = new TextButton(text, skin);
        homeScreenTable.add(button).width(200).height(50);
        homeScreenTable.row();
        return button;
    }
}




