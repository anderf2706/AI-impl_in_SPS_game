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
		E = new Texture(Gdx.files.internal("Tropical/bg.png"));
		D = new Texture(Gdx.files.internal("landtextures/rainforestgrass.jpg"));
		C = new Texture(Gdx.files.internal("landtextures/rainforestgrass.jpg"));
		B = new Texture(Gdx.files.internal("landtextures/sand.jpg"));
		A = new Texture(Gdx.files.internal("landtextures/water.jpg"));


	}
	/////////////////Level C////////////////////////////////
	public void mountain(Node node, int chance){
		Random rand = new Random();

		int randomNum = rand.nextInt((chance - 1) + 1) + 1;
		if(randomNum == 1){
			node.occupied = true;
			for (Node nodes : node.adjecent) {
				if (nodes.y >= node.y ) {
					nodes.occupied = true;
				}
			}
			/*
			if (nodes.y >= node.y && node.y + 96 >= nodes.y &&
						nodes.x >= node.x - 64 && node.x + 64 > nodes.x) {
					nodes.occupied = true;
				}
			 */

			int randomtextureNum = rand.nextInt((6- 1) + 1) + 1;
			Texture texture = gamescreen.tex.tropicalstone1;
			switch (randomtextureNum){
				case 1:
					texture = gamescreen.tex.tropicalstone1;
					break;
				case 2:
					texture = gamescreen.tex.tropicalstone2;
					break;
				case 3:
					texture = gamescreen.tex.tropicalstone3;
					break;
				case 4:
					texture = gamescreen.tex.tropicalstone4;
					break;
				case 5:
					texture = gamescreen.tex.tropicalstone5;
					break;
				case 6:
					texture = gamescreen.tex.tropicalstone6;
					break;

			}
			new Stone(2000, node, node.gamescreen, node.x, node.y - 16, 96, 96, texture);

		}
	}

	public void lake(Node node, int chance) {
		Random rand = new Random();
		int randomNum = rand.nextInt((chance - 1) + 1) + 1;
		if (randomNum == 1) {
			node.occupied = true;
			Texture texture = gamescreen.tex.tropicallake;
			for (Node nodes : node.adjecent) {
				if ((node.y <= nodes.y)) {
					nodes.occupied = true;
				}
			}

			new Lake(1000, node, node.gamescreen, node.x, node.y - 16, 64, 96, texture);

		}
	}



	public void tree(Node node, int chance){
		Random rand = new Random();

		int randomNum = rand.nextInt((chance - 1) + 1) + 1;
		if(randomNum == 1){
			node.occupied = true;

			int randomtextureNum = rand.nextInt((12 - 1) + 1) + 1;
			Texture texture = gamescreen.tex.tropicaltree1;
			switch (randomtextureNum){
				case 1:
					texture = gamescreen.tex.tropicaltree1;
					break;
				case 2:
					texture = gamescreen.tex.tropicaltree2;
					break;
				case 3:
					texture = gamescreen.tex.tropicaltree3;
					break;
				case 4:
					texture = gamescreen.tex.tropicaltree4;
					break;
				case 5:
					texture = gamescreen.tex.tropicaltree5;
					break;
				case 6:
					texture = gamescreen.tex.tropicaltree6;
					break;
				case 7:
					texture = gamescreen.tex.tropicaltree7;
					break;
				case 8:
					texture = gamescreen.tex.tropicaltree8;
					break;
				case 9:
					texture = gamescreen.tex.tropicaltree9;
					break;
				case 10:
					texture = gamescreen.tex.tropicaltree10;
					break;
				case 11:
					texture = gamescreen.tex.tropicaltree11;
					break;

			}
			if (texture != gamescreen.tex.tropicaltree11) {
				new Tree(500, node, node.gamescreen, node.x, node.y - 16, 96, 64, texture);
			}
			else{
				new Tree(500, node, node.gamescreen, node.x, node.y - 16, 32, 96, texture);
			}
		}
	}


	public void greenery(Node node, int chance) {
		Random rand = new Random();

		int randomNum = rand.nextInt((chance - 1) + 1) + 1;
		if (randomNum == 1) {
			node.occupied = true;
			int randomtextureNum = rand.nextInt((12- 1) + 1) + 1;
			Texture texture = gamescreen.tex.tropicalgreenery1;
			switch (randomtextureNum){
				case 1:
					texture = gamescreen.tex.tropicalgreenery1;
					break;
				case 2:
					texture = gamescreen.tex.tropicalgreenery2;
					break;
				case 3:
					texture = gamescreen.tex.tropicalgreenery3;
					break;
				case 4:
					texture = gamescreen.tex.tropicalgreenery4;
					break;
				case 5:
					texture = gamescreen.tex.tropicalgreenery5;
					break;
				case 6:
					texture = gamescreen.tex.tropicalgreenery6;
					break;
				case 7:
					texture = gamescreen.tex.tropicalgreenery7;
					break;
				case 8:
					texture = gamescreen.tex.tropicalgreenery8;
					break;
				case 9:
					texture = gamescreen.tex.tropicalgreenery9;
					break;
				case 10:
					texture = gamescreen.tex.tropicalgreenery10;
					break;
				case 11:
					texture = gamescreen.tex.tropicalgreenery11;
					break;                  
				case 12:                    
					texture = gamescreen.tex.tropicalgreenery12;
					break;

			}

			new Greenery(200, node, node.gamescreen, node.x, node.y - 16, 32, 32, texture);

		}
	}

	public void stone(Node node, int chance){
		Random rand = new Random();

		int randomNum = rand.nextInt((chance - 1) + 1) + 1;
		if(randomNum == 1){
			node.occupied = true;
			int randomtextureNum = rand.nextInt((5- 1) + 1) + 1;
			Texture texture = gamescreen.tex.tropicalstone7;
			switch (randomtextureNum){
				case 1:
					texture = gamescreen.tex.tropicalstone7;
					break;
				case 2:
					texture = gamescreen.tex.tropicalstone8;
					break;
				case 3:
					texture = gamescreen.tex.tropicalstone9;
					break;
				case 4:
					texture = gamescreen.tex.tropicalstone10;
					break;
				case 5:
					texture = gamescreen.tex.tropicalstone11;
					break;
			}
			new Stone(200, node, node.gamescreen, node.x, node.y - 16, 32, 32, texture);

		}
	}
	////////////////////////////////////////////////////////////////////////////


	/////////////////Level E//////////////////////////////////////////////////////

}