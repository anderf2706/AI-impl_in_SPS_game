package com.game1;

import java.util.*;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public class Node {
	ArrayList<Node> adjecent = new ArrayList<Node>();
	ArrayList<Node> closest = new ArrayList<Node>();
	ArrayList<Player> players = new ArrayList<Player>();
	Set<Node> adjecent2 = new HashSet<Node>();
	int reuse_index;
	public int x;
	public int y;
	int id;
	static int count = 1;
	Rectangle body;
	/*
	Node right = null;
	Node left = null;
	Node up = null;
	Node down = null;
	Node upright = null;
	Node upleft = null;
	Node downright = null;
	Node downleft = null;
	*/
	Node parent;
	boolean ACNode = false;
	boolean BN = false;
	boolean PN = false;
	public boolean occupied = false;
	double f;
	double g;
	double h;
	double cost;
	
	GameScreen gamescreen;


	public Node(int x, int y, GameScreen gamescreen) {
		this.x = x;
		this.y = y;
		//gamescreen.camera.unproject(pos);
		this.gamescreen = gamescreen;


		this.id = count++;

		


		body = new Rectangle(x - 16, y - 16 ,32,32);
		/*for(Node node : gamescreen.allnodes) {
			if(Intersector.overlaps(node.body, new Rectangle(this.x - 32, this.y, 100,100))) {
				this.right = node;
			}*/

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


	public void addmeaning() {

		//TODO, occupied og color.

	}
}
