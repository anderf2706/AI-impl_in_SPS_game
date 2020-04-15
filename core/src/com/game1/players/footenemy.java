package com.game1.players;

import com.game1.Game1;
import com.game1.GameScreen;

public class footenemy extends AI{


	public footenemy(GameScreen gamescreen, Game1 game, int x, int y, int team) {
		super(gamescreen, game, x, y, team);
		spritefront = gamescreen.tex.spritefront;
		spritefront2 = gamescreen.tex.spritefront2;
		spriteback = gamescreen.tex.spriteback;
		spriteback2 = gamescreen.tex.spriteback2;
		spriteleft = gamescreen.tex.spriteleft;
		spriteleft2 = gamescreen.tex.spriteleft2;
		spriteright = gamescreen.tex.spriteright;
		spriteright2 = gamescreen.tex.spriteright2;
		the_player.x = x - 15;
		the_player.y = y - 15;

		this.the_player.height = 30;
		this.the_player.width = 30;
		health = 100;
		attack = 10;
		defense = 1;
		this.speed = 5;
		this.timerlong = 1000;
	}
}
