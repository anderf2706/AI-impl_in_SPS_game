package com.game1.Naturepackage;

import com.game1.GameScreen;
import com.game1.Nature;
import com.game1.Node;

public class Stone extends Nature {
	public Stone(Node node, GameScreen gamescreen, int x, int y, int height, int width) {
		super(node, gamescreen, x, y, height, width);

		texture = gamescreen.tex.normal_stone;
	}
}
