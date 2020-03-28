package com.game1.players;

import com.game1.Game1;
import com.game1.GameScreen;
import com.game1.Player;

public class protagonist extends Player {

	public protagonist(GameScreen gamescreen, Game1 game, int x, int y, int team) {
		super(gamescreen, game, x, y, team);

		spritefront = gamescreen.tex.spriteprotfront;
		spriteback = gamescreen.tex.spriteprotback;
		spriteleft = gamescreen.tex.spriteprotleft;
		spriteright = gamescreen.tex.spriteprotright;

		the_player.x = x - 15;
		the_player.y = y - 15;

		this.the_player.height = 30;
		this.the_player.width = 30;
		this.health = 100;
		this.attack = 20;
		this.defense = 2;
		this.speed = 10;


	}
}
