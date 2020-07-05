package com.game1.players;

import com.badlogic.gdx.Gdx;
import com.game1.*;

import java.util.*;

public class AI extends Player {

	public GameScreen gamescreen;
	Random rand;
	int speed;
	Node lastnode;

	public AI(Node node, GameScreen gamescreen, Game1 game, int x, int y, int team, int speed) {
		super(null, node, gamescreen, game, x, y, team);
		this.gamescreen = gamescreen;
		this.speed = speed;
		rand = new Random();
		if (team==1){
			monitor();
		}
		if (team == 10){
			walkaround();
		}



	}

	public void monitorwalk(Node lastnode) {
		Node menode = gamescreen.me.playerNode;
		ArrayList<Node> openList = new ArrayList<Node>();

		for (Node node : playerNode.adjecent
		) {

			if (!node.occupied) {
				if (node.x != this.playerNode.x && node.y != this.playerNode.y) {
					node.cost = Math.sqrt(2);
				} else {
					node.cost = 1;
				}
				node.h = Math.max(Math.abs(node.x - menode.x), Math.abs(node.y - menode.y));
				node.f = node.h + node.cost;
				if (node.f < 100) {
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



			UP = false;
			DOWN = false;
			RIGHT = false;
			LEFT = false;
			UPRIGHT = false;
			UPLEFT = false;
			DOWNRIGHT = false;
			DOWNLEFT = false;

		if (this.playerNode.adjecent.contains(gamescreen.me.playerNode) || openList.size() == 0) {
			this.moving = false;
			return;
		}

			if (lastnode == null) {

			} else {
				this.the_player.x = lastnode.x - 16;
				this.the_player.y = lastnode.y - 16;
				this.playerNode = lastnode;
			}


			if (openList.size() > 0) {
				System.out.println("1");
				this.lastnode = openList.get(0);

				this.moving = true;
				chosedir(openList.get(0));

				//this.the_player.y < openList.get(0).y
				if (this.playerNode.id + 1 == openList.get(0).id) {
					System.out.println("inne");
					UP = true;

				}
				if (this.playerNode.id + (1 + gamescreen.nodewidth) == openList.get(0).id) {
					System.out.println("inne");
					UP = true;
					RIGHT = true;
					System.out.println("topright");

				}
				if (this.playerNode.id + (1 - gamescreen.nodewidth) == openList.get(0).id) {
					System.out.println("inne");
					UP = true;
					LEFT = true;

				}
				if (this.playerNode.id - 1 == openList.get(0).id) {
					System.out.println("inne");
					DOWN = true;

				}
				if (this.playerNode.id + ((-1) + gamescreen.nodewidth) == openList.get(0).id) {
					System.out.println("inne");
					DOWN = true;
					RIGHT = true;

				}
				if (openList.get(0).id == this.playerNode.id + ((-1) - gamescreen.nodewidth)) {
					System.out.println("inne");
					DOWN = true;
					LEFT = true;
					System.out.println("downleft");

				}
				if (this.playerNode.id + gamescreen.nodewidth == openList.get(0).id) {
					System.out.println("inne");
					RIGHT = true;
				}
				if (this.playerNode.id - gamescreen.nodewidth == openList.get(0).id) {
					System.out.println("inne");
					LEFT = true;

				}


			}

			if (health <= 0) {
				this.dispose();
			}


	}


	class monitortimer extends TimerTask {
		public void run() {
			monitorwalk(lastnode);
		}
	}

	public void monitor(){
		if (timer == null) {
			timer = new Timer();

			timer.scheduleAtFixedRate(new monitortimer(), 0, 5000/speed);

		}

	}

	@Override
	protected void movesmooth() {
		super.movesmooth();
		if (UP) {
			this.the_player.y += 1 * 16 * 2 * Gdx.graphics.getDeltaTime();
		}
		if (DOWN) {
			this.the_player.y -= 1 * 16 * 2 * Gdx.graphics.getDeltaTime();
		}
		if (RIGHT) {
			this.the_player.x += 1 * 16 * 2 * Gdx.graphics.getDeltaTime();
		}
		if (LEFT) {
			this.the_player.x -= 1 * 16 * 2* Gdx.graphics.getDeltaTime();
		}

	}

	public void walkaroundwalk(){
		Node startnode = this.playerNode;
		ArrayList<Node> openList = new ArrayList<Node>();
		int count = -1;
		for (Node node: startnode.adjecent) {
			float distancetostart = Math.max(Math.abs(node.x - startnode.x), Math.abs(node.y - startnode.y));
			if (!node.occupied && distancetostart < 150) {
				count += 1;
				openList.add(node);
			}
		}
		if (openList.size() > 0) {

			int randomNum = rand.nextInt((count - 1) + 1) + 1;
			chosedir(openList.get(randomNum));
			this.playerNode.occupied = false;
			this.playerNode = openList.get(randomNum);
			this.the_player.x = this.playerNode.x - the_player.width/2;
			this.the_player.y = this.playerNode.y - the_player.height/2;
			this.playerNode.occupied = true;
		}

	}



	class walkaroundtimer extends TimerTask {
		public void run() {
			walkaroundwalk();
		}
	}

	public void walkaround(){
		if (timer == null) {
			timer = new Timer();
			int randomtimer = rand.nextInt((4000 - 1000) + 1) + 1000;

			timer.scheduleAtFixedRate(new walkaroundtimer(), 0, randomtimer);

		}

	}

	public void chosedir(Node node){
		if (this.playerNode.id == node.id + 1 || this.playerNode.id == node.id + (1+gamescreen.nodewidth)
				|| this.playerNode.id == node.id + (1-gamescreen.nodewidth)){
				spritedir = 4;

		}
		else if (this.playerNode.id == node.id - 1 || this.playerNode.id == node.id + ((-1) + gamescreen.nodewidth)
				|| node.id == this.playerNode.id + ((-1) - gamescreen.nodewidth)){

				spritedir = 1;

		}
		else if (this.playerNode.id == node.id + gamescreen.nodewidth){
				spritedir = 3;

		}
		else if(this.playerNode.id == node.id - gamescreen.nodewidth){
				spritedir = 2;

		}
	}
}
