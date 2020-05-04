package com.game1.players;

import com.game1.Game1;
import com.game1.GameScreen;
import com.game1.Node;
import com.game1.Player;

public class protagonist extends Player {

	public protagonist(Player player, Node node, GameScreen gamescreen, Game1 game, int x, int y) {
		super(player, node, gamescreen, game, x, y, 0);

		spritefront = gamescreen.tex.spriteprotfront;
		spritefront2 = gamescreen.tex.spriteprotfront2;
		spriteback = gamescreen.tex.spriteprotback;
		spriteback2 = gamescreen.tex.spriteprotback2;
		spriteleft = gamescreen.tex.spriteprotleft;
		spriteleft2 = gamescreen.tex.spriteprotleft2;
		spriteright = gamescreen.tex.spriteprotright;
		spriteright2 = gamescreen.tex.spriteprotright2;


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
