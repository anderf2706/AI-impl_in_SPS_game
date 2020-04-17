package com.game1;

import java.io.Serializable;
import java.util.*;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;


public class Node implements Serializable {
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


	public Node(int x, int y, GameScreen gamescreen, float simplexnoise, float humidity) {

		this.x = x;
		this.y = y;
		this.gamescreen = gamescreen;
		this.simplexnoise = simplexnoise;
		this.humidity = humidity;
		this.id = count++;
		body = new Rectangle(x - 16, y - 16, 32, 32);

		if (this.humidity > 0.90) {
			this.myBiome = gamescreen.rainforest;
		}
		if (this.humidity <= 0.90 && this.humidity > 0.6) {
			this.myBiome = gamescreen.tundra;

		}
		if (this.humidity <= 0.60 && this.humidity > 0.40) {
			this.myBiome = gamescreen.forest_temp;
		}
		if (this.humidity <= 0.4) {
			this.myBiome = gamescreen.desert;
		}
		if (this.humidity <= 0.2) {
			this.myBiome = gamescreen.desert;
		}


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
			if (!this.occupied) {
				myBiome.act_E1(this);
			}
			if (!this.occupied) {
				myBiome.act_E2(this);
			}
			return;
		}

		if (this.simplexnoise <= 0.8 && this.simplexnoise > 0.20) {
			this.nodetexture = myBiome.E;
			if (!this.occupied) {
				myBiome.act_C1(this);
			}
			if (!this.occupied) {
				myBiome.act_C2(this);
			}
			if (!this.occupied) {
				myBiome.act_C3(this);
			}
			if (!this.occupied) {
				myBiome.act_C4(this);
			}
			if (!this.occupied) {
				myBiome.act_C5(this);
			}
			if (!this.occupied) {
				myBiome.act_C6(this);
			}
			if (!this.occupied) {
				myBiome.act_C7(this);
			}

			return;
		}
		if (this.simplexnoise <= 0.20 && this.simplexnoise >= 0) {
			this.nodetexture = myBiome.A;
			this.occupied = true;

		}


	}

}
