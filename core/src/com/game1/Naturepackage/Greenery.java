package com.game1.Naturepackage;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.game1.GameScreen;
import com.game1.Nature;
import com.game1.Node;

public class Greenery extends Nature {


	public Greenery(Node node, GameScreen gamescreen, int x, int y, int height, int width, Texture texture) {
		super(node, gamescreen, x, y, height, width, texture);

		health = 200;
		material = gamescreen.stick;
	}
}
