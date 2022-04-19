package com.lastremaindersofthepandemic.com;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.SkinLoader;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Assets {
    private static final AssetManager manager = new AssetManager();
    public static final AssetDescriptor<Skin> skinDescriptor = new AssetDescriptor<>("uiskin.json", Skin.class, new SkinLoader.SkinParameter("uiskin.atlas"));



    public AssetManager getAssetManager() {
        return manager;
    }

    public void loadAll() {
        manager.load(skinDescriptor);
    }
}
