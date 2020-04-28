package com.game1;

import com.badlogic.gdx.graphics.Texture;

public class Item {

	int weight;
	public Texture icon;
	public GameScreen gamescreen;


	public Item(GameScreen gamescreen, Texture icon){
		this.gamescreen = gamescreen;
		this.icon = icon;
		this.weight = 1;

	}

}

