package com.game1.buildings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.game1.Building;
import com.game1.GameScreen;
import com.game1.huds.BuildingHud;

public class Palicade_H extends Building {

	public Palicade_H( GameScreen gamescreen, int x, int y, int team) {
		super(gamescreen, x - 16, y - 16, 20, 20, x - 16, y - 16 ,32, 64, team );
			building = new Texture(Gdx.files.internal("Grassland/decor_15.png"));

		// TODO Auto-generated constructor stub

	}

}
