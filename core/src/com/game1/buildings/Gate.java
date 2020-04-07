package com.game1.buildings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.game1.Building;
import com.game1.GameScreen;
import com.game1.huds.BuildingHud;

public class Gate extends Building {

	public Gate(GameScreen gamescreen, int x, int y, int team) {
		super(gamescreen, x, y, 32, 32, team );
		building = new Texture(Gdx.files.internal("buildingtextures/gate.png"));
		// TODO Auto-generated constructor stub

	}

}
