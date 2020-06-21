package com.game1;

import java.io.Serializable;
import java.util.*;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;


public class Node implements Serializable, DistanceObjects {
	public ArrayList<Node> adjecent = new ArrayList<Node>();
	public ArrayList<Node> closest = new ArrayList<Node>();
	ArrayList<Player> players = new ArrayList<Player>();
	Set<Node> adjecent2 = new HashSet<Node>();
	int reuse_index;
	public int x;
	public int y;
	public int id;
	static int count = 1;
	Rectangle body;
	float simplexnoise;
	float humidity;
	Node parent;
	boolean ACNode = false;
	boolean BN = false;
	boolean PN = false;
	public boolean occupied = false;
	public double f;
	public double g;
	public double h;
	public double cost;

	Texture[][] textures;

	public GameScreen gamescreen;

	Texture nodetexture;

	Biome myBiome;

	public Nature mynature;

	public boolean render = false;


	public Node(int x, int y, GameScreen gamescreen, float simplexnoise, float humidity) {

		this.x = x;
		this.y = y;
		this.gamescreen = gamescreen;
		this.simplexnoise = simplexnoise;
		this.humidity = humidity;
		this.id = count++;
		body = new Rectangle(x - 16, y - 16, 32, 32);

		if (this.humidity > 0.8) {
			this.myBiome = gamescreen.rainforest;
		}
		if (this.humidity <= 0.8 && this.humidity > 0.6) {
			this.myBiome = gamescreen.tundra;

		}
		if (this.humidity <= 0.60 && this.humidity > 0.40) {
			this.myBiome = gamescreen.forest_temp;
		}
		if (this.humidity <= 0.4 && this.humidity > 0.2) {
			this.myBiome = gamescreen.desert;
		}
		if (this.humidity <= 0.2) {
			this.myBiome = gamescreen.desert;
		}




	}

	public void checkrender(){
		for (DistanceObjects object : gamescreen.team_0){
			double ac = Math.abs(object.getY() - this.y);
			double cb = Math.abs(object.getX() - this.x);

			double h = Math.hypot(ac, cb);
			if (h < 200){
				render = true;
				return;
			}
		}
		render = false;
	}

	public void makeClosest(int id, ArrayList<Node> list, boolean center) {
		if (gamescreen.nodedict.containsKey(id) && center) {
			list.add(gamescreen.nodedict.get(id));
		}
		if (gamescreen.nodedict.containsKey(id + 1)) {
			list.add(gamescreen.nodedict.get(id + 1));
		}
		if (gamescreen.nodedict.containsKey(id - 1)) {
			list.add(gamescreen.nodedict.get(id - 1));
		}
		if (gamescreen.nodedict.containsKey(id + gamescreen.nodewidth)) {
			list.add(gamescreen.nodedict.get(id + gamescreen.nodewidth));
		}
		if (gamescreen.nodedict.containsKey(id - gamescreen.nodewidth)) {
			list.add(gamescreen.nodedict.get(id - gamescreen.nodewidth));
		}
		if (gamescreen.nodedict.containsKey(id + (gamescreen.nodewidth + 1))) {
			list.add(gamescreen.nodedict.get(id + (gamescreen.nodewidth + 1)));
		}
		if (gamescreen.nodedict.containsKey(id + (gamescreen.nodewidth - 1))) {
			list.add(gamescreen.nodedict.get(id + (gamescreen.nodewidth - 1)));
		}
		if (gamescreen.nodedict.containsKey(id - (gamescreen.nodewidth + 1))) {
			list.add(gamescreen.nodedict.get(id - (gamescreen.nodewidth + 1)));
		}
		if (gamescreen.nodedict.containsKey(id - (gamescreen.nodewidth - 1))) {
			list.add(gamescreen.nodedict.get(id - (gamescreen.nodewidth - 1)));
		}
	}




	public void addmeaning() {

		if (this.simplexnoise > 0.8) {
			this.nodetexture = myBiome.E;
			if (myBiome == gamescreen.rainforest){
				if (!occupied){
					myBiome.tree(this, 10);
				}
				if (!occupied){
					myBiome.greenery(this, 10);
				}
			}
			else{
				int i = 0;
				for (Node node : closest) {
					if (node.y >= this.y && this.y + 96 >= node.y &&
							node.x >= this.x - 96 && this.x + 96 > node.x )
					if (node.occupied){
						i += 1;
					}
				}
				if (i == 0){
					myBiome.mountain(this, 50);
				}

				if (!occupied) {
					myBiome.stone(this, 25);
				}
			}

			return;
		}

		if (this.simplexnoise <= 0.8 && this.simplexnoise > 0.20) {
			this.nodetexture = myBiome.E;
			if (myBiome == gamescreen.rainforest){
				int i = 0;
				for (Node nodes : adjecent){
					if (this.y <= nodes.y){
						if (nodes.occupied){
							i += 1;
						}
					}
				}
				if (i == 0){
					myBiome.lake(this, 200);
				}
				if (!this.occupied) {
					myBiome.tree(this, 15);
				}
				if (!this.occupied) {
					myBiome.stone(this, 25);
				}
				if (!this.occupied) {
					myBiome.greenery(this, 15);
				}
				int j = 0;
				for (Node node : closest) {
					if (node.y >= this.y && this.y + 96 >= node.y &&
							node.x >= this.x - 96 && this.x + 96 > node.x )
						if (node.occupied){
							j += 1;
						}
				}
				if (j== 0){
					myBiome.mountain(this, 50);
				}
			}
			else {
				int i = 0;
				for (Node nodes : adjecent) {
					if (this.y <= nodes.y) {
						if (nodes.occupied) {
							i += 1;
						}
					}
				}
				if (i == 0) {
					myBiome.lake(this, 200);
				}
				if (!this.occupied) {
					myBiome.tree(this, 20);
				}
				if (!this.occupied) {
					myBiome.stone(this, 30);
				}
				if (!this.occupied) {
					myBiome.greenery(this, 15);
				}
				int j = 0;
				for (Node node : adjecent) {
					if (node.occupied) {
						j += 1;
					}
				}
				if (j == 0) {
					myBiome.mountain(this, 150);
				}
				/*
				if (!this.occupied) {
					myBiome.animal_1(this, 500);
				}

				 */

				return;
			}
		}
		if (this.simplexnoise <= 0.20 && this.simplexnoise >= 0) {
			this.nodetexture = myBiome.A;
			this.occupied = true;

		}


	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}
}
