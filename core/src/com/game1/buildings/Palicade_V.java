package com.game1.buildings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.game1.Building;
import com.game1.GameScreen;
import com.game1.huds.BuildingHud;

public class Palicade_V extends Building {

    public Palicade_V(GameScreen gamescreen, int x, int y, int team) {
        super(gamescreen, x + 8, y, 16, 32, 32, 32, team );
            building = new Texture(Gdx.files.internal("Tropical/decor_3.png"));

        // TODO Auto-generated constructor stub

    }

}
