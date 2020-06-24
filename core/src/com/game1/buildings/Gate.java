package com.game1.buildings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.game1.Building;
import com.game1.GameScreen;
import com.game1.huds.BuildingHud;

public class Gate extends Building {

	public Gate(GameScreen gamescreen, int x, int y, int team) {
		super(gamescreen, x - 32, y - 32, 40, 32, x- 48, y -48, 64, 64, team );
		building = new Texture(Gdx.files.internal("Grassland/City/buildings/building_3/building_5.png"));
		// TODO Auto-generated constructor stub

	}

}
