package com.game1.buildings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.game1.Building;
import com.game1.GameScreen;

public class Castle extends Building {

	public Castle(GameScreen gamescreen, int x, int y, int team) {
		super(gamescreen, x - 76 , y -76 , 32*6-2, 34, x - 96, y - 96, 32*6 + 40, 32*6 + 20, team);
		building = new Texture(Gdx.files.internal("Grassland/City/buildings/building_1/building_1.png"));
		// TODO Auto-generated constructor stub
	}
	
	
	

}
