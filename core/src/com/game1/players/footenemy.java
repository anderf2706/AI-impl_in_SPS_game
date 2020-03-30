package com.game1.players;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.game1.Game1;
import com.game1.GameScreen;
import com.game1.Node;
import com.game1.Player;

import java.util.*;

public class footenemy extends Player {

	GameScreen gamescreen;

	public footenemy(GameScreen gamescreen, Game1 game, int x, int y, int team) {
		super(gamescreen, game, x, y, team);
		this.gamescreen = gamescreen;
		spritefront = gamescreen.tex.spritefront;
		spriteback = gamescreen.tex.spriteback;
		spriteleft = gamescreen.tex.spriteleft;
		spriteright = gamescreen.tex.spriteright;

		the_player.x = x - 15;
		the_player.y = y - 15;

		this.the_player.height = 30;
		this.the_player.width = 30;
		health = 100;
		attack = 10;
		defense = 1;
		this.speed = 5;
		this.timerlong = 1000;

		if (team==1){
			monitor();
		}



	}

	public void monitorwalk(){
		Node menode = gamescreen.me.playerNode;
		ArrayList<Node> openList = new ArrayList<Node>();
		for (Node node: playerNode.adjecent
		) {

			if (!node.occupied) {
				if (node.x != this.playerNode.x && node.y != this.playerNode.y) {
					node.cost = Math.sqrt(2);
				} else {
					node.cost = 1;
				}
				node.h = Math.max(Math.abs(node.x - menode.x), Math.abs(node.y - menode.y));
				node.f = node.h + node.cost;
				if(node.f < 200){
					openList.add(node);
				}
			}
		}
		Collections.sort(openList, new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				return Double.compare(n1.f, n2.f);
			}
		});


		if (openList.size() > 0){
			this.playerNode.occupied = false;
			this.playerNode = openList.get(0);
			this.the_player.x = this.playerNode.x - 16;
			this.the_player.y = this.playerNode.y - 16;
			this.playerNode.occupied = true;
		}
	}

	class monitortimer extends TimerTask {
		public void run() {
			monitorwalk();
		}
	}

	public void monitor(){
		if (timer == null) {
			timer = new Timer();
			timer.scheduleAtFixedRate(new monitortimer(), 0, 1000);

		}

	}
}
