package com.game1.Naturepackage;

import com.badlogic.gdx.graphics.Texture;
import com.game1.GameScreen;
import com.game1.Nature;
import com.game1.Node;

public class Lake extends Nature {
	public Lake(int health, Node node, GameScreen gamescreen, int x, int y, int height, int width, Texture texture) {
		super(health, node, gamescreen, x, y, height, width, texture);
		material = gamescreen.water;
	}
}
