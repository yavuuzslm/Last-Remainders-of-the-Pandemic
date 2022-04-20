package com.lastremaindersofthepandemic.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Player extends Entity{
    public Player(Vector3 pos){
        this.pos.x = pos.x;
        this.pos.y = pos.y;
        this.pos3.x = pos.x;
        this.pos3.y = pos.y;
        texture = new Texture(Gdx.files.internal("char.png"));
        speed = 3;
        width = texture.getWidth();
        height = texture.getHeight();
    }

}
