package com.game1.biomes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.game1.Biome;
import com.game1.GameScreen;
import com.game1.Naturepackage.*;
import com.game1.Node;

import java.util.Random;

public class Rainforest extends Biome {


	public Rainforest(GameScreen gamescreen){
		super(gamescreen);
		E = new Texture(Gdx.files.internal("landtextures/tile_dirt.png"));
		D = new Texture(Gdx.files.internal("landtextures/rainforestgrass.jpg"));
		C = new Texture(Gdx.files.internal("landtextures/rainforestgrass.jpg"));
		B = new Texture(Gdx.files.internal("landtextures/sand.jpg"));
		A = new Texture(Gdx.files.internal("landtextures/water.jpg"));


	}

	/////////////////Level C////////////////////////////////

	public void act_C1(Node node){
		Random rand = new Random();

		int randomNum = rand.nextInt((10 - 1) + 1) + 1;
		if(randomNum == 1){
			node.occupied = true;
			for (Node nodes : node.adjecent) {
				if (nodes.id == node.id + 1){
					nodes.occupied = true;
				}
				if (nodes.id == node.id + 1 + gamescreen.nodewidth){
					nodes.occupied = true;
				}
				if (nodes.id == node.id + 1 + 2*gamescreen.nodewidth){
					nodes.occupied = true;
				}
			}
			new Tree3(node, node.gamescreen, node.x, node.y - 16, 96, 64);

		}
	}

	public void act_C2(Node node){
		Random rand = new Random();

		int randomNum = rand.nextInt((10 - 1) + 1) + 1;
		if(randomNum == 1){
			node.occupied = true;
			for (Node nodes : node.adjecent) {
				if (nodes.id == node.id + 1){
					nodes.occupied = true;
				}
				if (nodes.id == node.id + 1 + gamescreen.nodewidth){
					nodes.occupied = true;
				}
				if (nodes.id == node.id + 1 + 2*gamescreen.nodewidth){
					nodes.occupied = true;
				}
			}
			new Tree4(node, node.gamescreen, node.x, node.y - 16, 96, 64);

		}
	}
	/*
	public void act_C3(Node node){
		Random rand = new Random();

		int randomNum = rand.nextInt((30 - 1) + 1) + 1;
		if(randomNum == 1){
			node.occupied = true;
			for (Node nodes : node.adjecent) {
				if (nodes.id == node.id + 1){
					nodes.occupied = true;
				}
			}
			new Palm1(node, node.gamescreen, node.x, node.y - 16, 162, 64);

		}
	}

	public void act_C4(Node node){
		Random rand = new Random();

		int randomNum = rand.nextInt((30 - 1) + 1) + 1;
		if(randomNum == 1){
			node.occupied = true;
			for (Node nodes : node.adjecent) {
				if (nodes.id == node.id + 1){
					nodes.occupied = true;
				}
			}
			new Palm2(node, node.gamescreen, node.x, node.y - 16, 128, 64);

		}
	}

	 */

	////////////////////////////////////////////////////////////////////////////


	/////////////////Level D//////////////////////////////////////////////////////


	//////////////////////////////////////////////////////////////////////////////////

	public void act_E1(Node node){
		Random rand = new Random();

		int randomNum = rand.nextInt((10 - 1) + 1) + 1;
		if(randomNum == 1){
			node.occupied = true;
			for (Node nodes : node.adjecent) {
				if (nodes.id == node.id + 1){
					nodes.occupied = true;
				}
				if (nodes.id == node.id + 1 + gamescreen.nodewidth){
					nodes.occupied = true;
				}
				if (nodes.id == node.id + 1 + 2*gamescreen.nodewidth){
					nodes.occupied = true;
				}
				if (nodes.id == node.id + 1 + 3*gamescreen.nodewidth){
					nodes.occupied = true;
				}
			}
			new Jungletree(node, node.gamescreen, node.x, node.y - 16, 250, 128);

		}
	}

}