package com.lastremaindersofthepandemic.com.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.lastremaindersofthepandemic.com.entities.Entity;

public class Player extends Entity {
    OrthographicCamera camera;
    public Player(Vector2 position) {
        super();
        pos.x = position.x;
        pos.y = position.y;

        pos3.x = position.x;
        pos3.y = position.y;

        texture = new Texture(Gdx.files.internal("shelby.png"));
        width = texture.getWidth();
        height = texture.getHeight();
        speed = 2;

        camera = new OrthographicCamera(pos.x, pos.y);
        camera.update();

    }

    //get camera

    public OrthographicCamera getCamera() {
        return camera;
    }


}
