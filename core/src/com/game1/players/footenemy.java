package com.game1.players;

import com.game1.Game1;
import com.game1.GameScreen;
import com.game1.Node;

public class footenemy extends AI{


	public footenemy(Node node, GameScreen gamescreen, Game1 game, int x, int y) {
		super(node, gamescreen, game, x, y, 1, 5);
        idle_spritefront = gamescreen.tex.warriorfrontidle;
        idle_spriteback = gamescreen.tex.warriorbackidle;
        idle_spriteright = gamescreen.tex.warriorrightidle;
        idle_spriteleft = gamescreen.tex.warriorleftidle;

        walk_spritefront = gamescreen.tex.warriorfrontwalk;
        walk_spriteback = gamescreen.tex.warriorbackwalk;
        walk_spriteright = gamescreen.tex.warriorrightwalk;
        walk_spriteleft = gamescreen.tex.warriorleftwalk;

        harvest_spritefront = gamescreen.tex.warriorfrontharvest;
        harvest_spriteback = gamescreen.tex.warriorbackharvest;
        harvest_spriteright = gamescreen.tex.warriorrightharvest;
        harvest_spriteleft = gamescreen.tex.warriorleftharvest;

		death_spritefront = gamescreen.tex.warriorfrontharvest;
		death_spriteback = gamescreen.tex.warriorbackharvest;
		death_spriteright = gamescreen.tex.warriorrightharvest;
		death_spriteleft = gamescreen.tex.warriorleftharvest;

        the_player.x = x - 15;
		the_player.y = y - 15;

		this.the_player.height = 30;
		this.the_player.width = 30;
		health = 100;
		attack = 10;
		defense = 1;
		this.timerlong = 1000;
	}
}
