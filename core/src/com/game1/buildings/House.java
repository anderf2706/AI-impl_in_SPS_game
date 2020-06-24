package com.game1.buildings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.game1.Building;
import com.game1.GameScreen;

import java.util.Random;

public class House extends Building {

	public House(GameScreen gamescreen, int x, int y, int team) {
		super(gamescreen, x , y + 30, 32*3 - 2, 44, 96, 96, team);
		Random random = new Random();
		int rand = random.nextInt(3 - 1 + 1) + 1;
		switch (rand){
			case 1:
				building = new Texture(Gdx.files.internal("Grassland/building_1.png"));
				break;
			case 2:
				building = new Texture(Gdx.files.internal("Grassland/building_2.png"));
				break;
			case 3:
				building = new Texture(Gdx.files.internal("Grassland/building_6.png"));
		}
		// TODO Auto-generated constructor stub
	}

}
