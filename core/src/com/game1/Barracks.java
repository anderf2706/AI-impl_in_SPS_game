package com.game1;


import com.game1.huds.BuildingHud;

import java.util.Timer;
import java.util.TimerTask;


public class Barracks extends Building{

	GameScreen gamescreen;
	Timer timer;


	public Barracks(GameScreen gamescreen, int x, int y, int team) {
		super(gamescreen, x, y, 32*3-2, 32*3-2, team);
		this.gamescreen = gamescreen;


		// TODO Auto-generated constructor stub


	}

	@Override
	protected void generate() {
		super.generate();
		System.out.println("yessss");
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

			new Player(gamescreen, gamescreen.game, node.x
					, node.y, 1);

		}
	}



}

	