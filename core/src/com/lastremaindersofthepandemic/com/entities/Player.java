package com.lastremaindersofthepandemic.com.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Player extends Entity {
    public enum PlayerNumber {
        PLAYER1,
        PLAYER2,
        PLAYER3,
        PLAYER4
    }
    OrthographicCamera camera;
    PlayerNumber playerNumber;
    public Player(Vector2 position, PlayerNumber playerNumber) {
        super();
        this.playerNumber = playerNumber;

        pos.x = position.x;
        pos.y = position.y;

        pos3.x = position.x;
        pos3.y = position.y;

        setTexture(0, 0);
        width = texture.getWidth();
        height = texture.getHeight();
        speed = 2;

        camera = new OrthographicCamera(pos.x, pos.y);
        //camera.zoom = .100f;
        camera.update();

    }

    //get camera

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void setTexture(int x, int y) {
        String face;
        if (x == -1) face = "left";
        else if (x == 1) face = "right";
        else if (y == 1) face = "back";
        else face = "front";

        String path = playerNumber.name() + "/" + face + ".png";
        texture = new Texture(Gdx.files.internal(path));
    }


}
