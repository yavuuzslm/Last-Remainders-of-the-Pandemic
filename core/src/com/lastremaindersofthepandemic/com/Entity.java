package com.lastremaindersofthepandemic.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Entity {
    public Vector2 pos;
    public Vector3 pos3;
    public Texture texture;
    public float width;
    public float height;
    public float speed;

    float dirX = 0;
    float dirY = 0;

    public Entity() {
        pos = new Vector2();
        pos3 = new Vector3();
    }

    public void draw(SpriteBatch batch, Sprite sprite) {
        //batch.draw(texture, pos.x, pos.y, width, height);
        sprite.draw(batch);
    }

}
