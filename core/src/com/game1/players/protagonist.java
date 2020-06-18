package com.game1.players;

import com.badlogic.gdx.Input;
import com.game1.*;

import java.util.concurrent.TimeUnit;

public class protagonist extends Player {

    boolean Attacking = false;
    private volatile long start;

	public protagonist(Player player, Node node, GameScreen gamescreen, Game1 game, int x, int y) {
		super(player, node, gamescreen, game, x, y, 0);

    idle_spritefront = gamescreen.tex.wizardfrontidle;
	idle_spriteback = gamescreen.tex.wizardbackidle;
	idle_spriteright = gamescreen.tex.wizardrightidle;
	idle_spriteleft = gamescreen.tex.wizardleftidle;

	walk_spritefront = gamescreen.tex.wizardfrontwalk;
	walk_spriteback = gamescreen.tex.wizardbackwalk;
	walk_spriteright = gamescreen.tex.wizardrightwalk;
	walk_spriteleft = gamescreen.tex.wizardleftwalk;

	harvest_spritefront = gamescreen.tex.wizardfrontharvest;
	harvest_spriteback = gamescreen.tex.wizardbackharvest;
	harvest_spriteright = gamescreen.tex.wizardrightharvest;
	harvest_spriteleft = gamescreen.tex.wizardleftharvest;

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

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if (button == Input.Buttons.LEFT) {
			if (super.gamescreen.cameraonplayer) {
			    if (System.nanoTime() - start < TimeUnit.SECONDS.toNanos(2)){
			        Attacking = false;
                }
				for (Player players : gamescreen.players){
                    if (players.playerNode == gamescreen.chosenNode && players.team != this.team && !Attacking){
                        start = System.nanoTime();
                        protagonist_attack_meele(players);
                        Attacking = true;
					}
				}
				for(Nature nature: gamescreen.nature){
					if (nature.naturenode == gamescreen.chosenNode && this.playerNode.adjecent.contains(nature.naturenode)){
						harvest(nature);
					}
				}

			}
		}
		return super.touchDown(screenX, screenY, pointer, button);
	}

	public void protagonist_attack_meele(Player player){
        if(player.health > 0 && playerNode.adjecent.contains(player.playerNode) && health> 0) {
            player.health -= (int)(attack/(player.defense*0.5));

        }
	}


    private boolean timedBoolean() {
	    start = System.nanoTime();
        return System.nanoTime()-start < TimeUnit.SECONDS.toNanos(2);
    }

}
