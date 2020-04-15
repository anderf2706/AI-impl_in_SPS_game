package com.game1.players.animals;

import com.game1.*;
import com.game1.players.AI;

public class cow extends AI {
	public cow(GameScreen gamescreen, Game1 game, int x, int y, int team) {
		super(gamescreen, game, x, y, team);
		this.gamescreen = gamescreen;

		the_player.x = x - the_player.width/2 - 1;
		the_player.y = y - the_player.height/2 - 1;

		this.the_player.height = 30;
		this.the_player.width = 30;
		health = 100;
		attack = 0;
		defense = 1;
		this.speed = 10;
		this.timerlong = 1000;

		monitor();
	}


}
