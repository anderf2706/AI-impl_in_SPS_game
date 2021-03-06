package com.game1.buildings;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.game1.Building;
import com.game1.GameScreen;
import com.game1.Node;
import com.game1.players.*;

import java.util.Timer;
import java.util.TimerTask;


public class Barracks extends Building {

	GameScreen gamescreen;
	Timer timer;


	public Barracks(GameScreen gamescreen, int x, int y, int team) {
		super(gamescreen, x -64, y -64, 32*4-2, 20*3, x - 76,y - 86, 32*4 + 20, 32*4 + 10, team);
		this.gamescreen = gamescreen;
		building = new Texture(Gdx.files.internal("Grassland/building_3.png"));

		// TODO Auto-generated constructor stub


	}

	@Override
	protected void generate() {
		super.generate();
		if (timer == null) {
			timer = new Timer();
			timer.schedule(new makemen(), 0, 5000);
			return;
		}
		timer.cancel();
		timer = null;


	}


	class makemen extends TimerTask {
		public void run() {
			Node node = gamescreen.findavailablenode(buildingnode);

			new footenemy(node, gamescreen, gamescreen.game, node.x
					, node.y);

		}
	}



}

	