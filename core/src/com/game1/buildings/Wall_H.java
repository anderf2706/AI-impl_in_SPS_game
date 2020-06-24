package com.game1.buildings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.game1.Building;
import com.game1.GameScreen;
import com.game1.huds.BuildingHud;

public class Wall_H extends Building {

    public Wall_H( GameScreen gamescreen, int x, int y, int team) {
        super(gamescreen, x, y, 32, 32, 32, 64, team );
            building = new Texture(Gdx.files.internal("Grassland/City/buildings/building_1/building_7.png"));

        // TODO Auto-generated constructor stub

    }

}
