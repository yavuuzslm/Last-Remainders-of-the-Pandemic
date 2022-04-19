package com.lastremaindersofthepandemic.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class OptionsPanel implements Screen {
    //OptionsPanel includes help button music on/off button and volume slider
    //OptionsPanel also includes a back button
    // help button opens help screen
    // music on/off button toggles music on/off
    // volume slider adjusts volume
    // back button returns to main menu
    // OptionsPanel is a Screen

    private Stage stage;
    private Viewport viewport;
    private AssetManager assetManager;
    final private Skin skin;
    private Table homeScreenTable;
    final private MainGame mainGame;

    public OptionsPanel(MainGame mainGame, AssetManager assetManager) {
        this.assetManager = assetManager;
        skin = assetManager.get(Assets.skinDescriptor);
        this.mainGame = mainGame;
    }

    @Override
    public void show() {
        viewport = new ExtendViewport(1280, 720);
        stage = new Stage(viewport);
        homeScreenTable = new Table();
        homeScreenTable.setFillParent(true);
        stage.addActor(homeScreenTable);
        Gdx.input.setInputProcessor(stage);




    }

    @Override
    public void render(float delta) {
        // TODO Auto-generated method stub

    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub

    }

}





