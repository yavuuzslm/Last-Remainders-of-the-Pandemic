package com.lastremaindersofthepandemic.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class HomePage extends ScreenAdapter {
    private Stage stage;
    private Viewport viewport;
    private AssetManager assetManager;
    private Skin skin;
    private Table homeScreenTable;



    public HomePage(AssetManager assetManager) {
        this.assetManager = assetManager;
        skin = new Skin(Gdx.files.internal("skin/ui-skin.json"));
    }

    @Override
    public void show() {
        viewport = new ExtendViewport(1280, 720);
        stage = new Stage(viewport);
        homeScreenTable = new Table();
        homeScreenTable.setFillParent(true);
        stage.addActor(homeScreenTable);
        addButton("Play", 100, 100);
        addButton("Options", 100, 200);
        addButton("About", 100, 300);
        addButton("Quit", 100, 300);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    private TextButton addButton(String text, float x, float y) {
        TextButton button = new TextButton(text, Assets.skin);
        button.setPosition(x, y);
        homeScreenTable.add(button);
        return button;
    }
    // getters and setters
    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public void setAssetManager(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public Skin getSkin() {
        return skin;
    }

    public void setSkin(Skin skin) {
        this.skin = skin;
    }

    public Table getHomeScreenTable() {
        return homeScreenTable;
    }

    public void setHomeScreenTable(Table homeScreenTable) {
        this.homeScreenTable = homeScreenTable;
    }
}




