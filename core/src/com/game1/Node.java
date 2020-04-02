package com.game1;

import java.io.Serializable;
import java.util.*;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.game1.Naturepackage.Tree;


public class Node implements Serializable {
	public ArrayList<Node> adjecent = new ArrayList<Node>();
	ArrayList<Node> closest = new ArrayList<Node>();
	ArrayList<Player> players = new ArrayList<Player>();
	Set<Node> adjecent2 = new HashSet<Node>();
	int reuse_index;
	public int x;
	public int y;
	public int id;
	static int count = 1;
	Rectangle body;
	float simplexnoise;
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
	
	GameScreen gamescreen;

	Texture nodetexture;


	public Node(int x, int y, GameScreen gamescreen, float simplexnoise) {
		this.x = x;
		this.y = y;
		this.gamescreen = gamescreen;
		this.simplexnoise = simplexnoise;
		this.id = count++;
		body = new Rectangle(x - 16, y - 16 ,32,32);
		addmeaning();

	}

	public void makeClosest(int id, ArrayList<Node> list, boolean center){
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

	public void maketree(){
		Random rand = new Random();

		int randomNum = rand.nextInt((10 - 1) + 1) + 1;
		if(randomNum == 1){
		this.occupied = true;
		for (Node node : this.adjecent) {
			if (node.id == this.id + 1){
				node.occupied = true;
			}
		}
		gamescreen.nature.add(new Tree(this, gamescreen, this.x, this.y, 96, 64));

		}
	}


	public void addmeaning() {
		/*
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {

		 */
				if (this.simplexnoise > 0.85) {
					this.nodetexture = gamescreen.white;
				}
				if (this.simplexnoise <= 0.85 && this.simplexnoise > 0.70) {
					this.nodetexture = gamescreen.grey;
				}
				if (this.simplexnoise <= 0.70 && this.simplexnoise > 0.45) {
					this.nodetexture = gamescreen.green;
					this.maketree();
				}
				if (this.simplexnoise <= 0.45 && this.simplexnoise > 0.30) {
					this.nodetexture = gamescreen.beige;
				}
				if (this.simplexnoise <= 0.30 && this.simplexnoise >= 0) {
					this.nodetexture = gamescreen.blue;
					this.occupied = true;
				}
				/*
			}

		}

				 */


	}
}
