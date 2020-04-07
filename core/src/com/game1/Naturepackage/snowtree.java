package com.game1.Naturepackage;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.game1.GameScreen;
import com.game1.Nature;
import com.game1.Node;

public class snowtree extends Nature {


	public snowtree(Node node, GameScreen gamescreen, int x, int y, int height, int width) {
		super(node, gamescreen, x, y, height, width);

		texture = gamescreen.tex.snowtree;
	}
}