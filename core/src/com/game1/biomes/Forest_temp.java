package com.game1.biomes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.game1.Biome;
import com.game1.GameScreen;
import com.game1.Naturepackage.Smalltree;
import com.game1.Naturepackage.Stone;
import com.game1.Naturepackage.Tree;
import com.game1.Node;

import java.util.Random;

public class Forest_temp extends Biome {


	public Forest_temp(GameScreen gamescreen){
		super(gamescreen);
		E = new Texture(Gdx.files.internal("landtextures/tile_dirt.png"));
		D = new Texture(Gdx.files.internal("landtextures/grass_darker.png"));
		C = new Texture(Gdx.files.internal("landtextures/tile_grass.png"));
		B = new Texture(Gdx.files.internal("landtextures/sand.jpg"));
		A = new Texture(Gdx.files.internal("landtextures/water.jpg"));


	}

	/////////////////Level C////////////////////////////////

	public void act_C1(Node node){
		Random rand = new Random();

		int randomNum = rand.nextInt((20 - 1) + 1) + 1;
		if(randomNum == 1){
			node.occupied = true;
			for (Node nodes : node.adjecent) {
				if (nodes.id == node.id + 1){
					nodes.occupied = true;
				}
			}
			new Tree(node, node.gamescreen, node.x, node.y - 16, 96, 64);

		}
	}

	public void act_C2(Node node){
		Random rand = new Random();

		int randomNum = rand.nextInt((20 - 1) + 1) + 1;
		if(randomNum == 1){
			node.occupied = true;
			new Smalltree(node, node.gamescreen, node.x, node.y - 16, 32, 32);

		}
	}
	////////////////////////////////////////////////////////////////////////////


	/////////////////Level D//////////////////////////////////////////////////////

	public void act_D1(Node node){
		Random rand = new Random();

		int randomNum = rand.nextInt((30 - 1) + 1) + 1;
		if(randomNum == 1){
			node.occupied = true;
			/*
			for (Node node : this.adjecent) {

				if (node.id == this.id + 1){
					node.occupied = true;
				}

			}

			 */
			new Stone(node, node.gamescreen, node.x, node.y - 16, 32, 32);

		}
	}

	//////////////////////////////////////////////////////////////////////////////////

	public void act_E1(Node node){
		Random rand = new Random();

		int randomNum = rand.nextInt((15 - 1) + 1) + 1;
		if(randomNum == 1){
			node.occupied = true;
			/*
			for (Node node : this.adjecent) {

				if (node.id == this.id + 1){
					node.occupied = true;
				}

			}

			 */
			new Stone(node, node.gamescreen, node.x, node.y - 16, 64, 64);

		}
	}
}
