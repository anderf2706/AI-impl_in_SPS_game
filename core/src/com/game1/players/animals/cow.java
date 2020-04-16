package com.game1.players.animals;

import com.game1.*;
import com.game1.players.AI;

public class cow extends AI {
	public cow(Node node, GameScreen gamescreen, Game1 game, int x, int y) {
		super(node, gamescreen, game, x, y, 10, 10);
		this.gamescreen = gamescreen;

		spritefront = gamescreen.tex.spritecowfront;
		spritefront2 = gamescreen.tex.spritecowfront2;
		spriteback = gamescreen.tex.spritecowback;
		spriteback2 = gamescreen.tex.spritecowback2;
		spriteleft = gamescreen.tex.spritecowleft;
		spriteleft2 = gamescreen.tex.spritecowleft2;
		spriteright = gamescreen.tex.spritecowright;
		spriteright2 = gamescreen.tex.spritecowright2;

		the_player.x = x - the_player.width/2 - 1;
		the_player.y = y - the_player.height/2 - 1;

		this.the_player.height = 32;
		this.the_player.width = 32;
		health = 200;
		attack = 0;
		defense = 1;
		this.timerlong = 1000;
	}


}
