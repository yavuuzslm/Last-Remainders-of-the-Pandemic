package com.lastremaindersofthepandemic.com.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.lastremaindersofthepandemic.com.utilities.Assets;
import com.lastremaindersofthepandemic.com.MainGame;

public class OptionsPanel implements Screen {
    //OptionsPanel includes help button music on/off button and volume slider
    //OptionsPanel also includes a back button
    // help button opens popup dialog box with instructions
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
        // add help button
        // add music on/off button
        // add volume slider
        // add back button
        addButton("Help");
        addButton("Music").addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
//                if (maingame.ismusicon()) {
//                    maingame.setmusicon(false);
//                } else {
//                    maingame.setmusicon(true);
//                }
                System.out.println("Music button clicked");
            }
        }
        );
        addSlider("Volume",0,100,45);
        addButton("Back").addListener(
                new ChangeListener() {
                    @Override
                    public void changed(ChangeEvent event, Actor actor) {
                        mainGame.setScreen(new HomePage(mainGame, assetManager));
                    }
                }
        )
        ;
    }

    private Slider addSlider(String volume, int start, int end, int initial) {
        final Slider volumeSlider = new Slider(start, end, 1, false, skin);
        volumeSlider.setValue(initial);
        homeScreenTable.add(volumeSlider).pad(10);
        homeScreenTable.row();
        return volumeSlider;

    }

    private TextButton addButton(String ButtonName) {
        final TextButton button = new TextButton(ButtonName, skin);
        homeScreenTable.add(button).width(200).height(50).pad(10);
        homeScreenTable.row();
        return button;
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

}





