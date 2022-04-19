package com.lastremaindersofthepandemic.com;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Assets {
    private static final AssetManager manager = new AssetManager();
    public static TextButton.TextButtonStyle skin;

    public AssetManager getAssetManager() {
        return manager;
    }

    public void loadAll() {
        manager.load("skin/ui-skin.atlas", TextureAtlas.class);
        manager.load("skin/ui-skin.json", TextButton.TextButtonStyle.class);
    }
}
