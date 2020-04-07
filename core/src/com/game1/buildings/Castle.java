package com.game1.buildings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.game1.Building;
import com.game1.GameScreen;

public class Castle extends Building {

	public Castle(GameScreen gamescreen, int x, int y, int team) {
		super(gamescreen, x, y, 32*4-2, 32*4-2, team);
		building = new Texture(Gdx.files.internal("buildingtextures/house.png"));
		
		// TODO Auto-generated constructor stub
	}
	
	
	

}
