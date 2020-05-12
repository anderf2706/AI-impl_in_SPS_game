package com.game1.biomes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.game1.Biome;
import com.game1.GameScreen;
import com.game1.Naturepackage.Greenery;
import com.game1.Naturepackage.Lake;
import com.game1.Naturepackage.Stone;
import com.game1.Naturepackage.Tree;
import com.game1.Node;
import com.game1.players.animals.cow;

import java.util.Random;

public class Forest_temp extends Biome {


	public Forest_temp(GameScreen gamescreen){
		super(gamescreen);
		E = new Texture(Gdx.files.internal("Grassland/bg.png"));
		D = new Texture(Gdx.files.internal("landtextures/grass_darker.png"));
		C = new Texture(Gdx.files.internal("landtextures/tile_grass.png"));
		B = new Texture(Gdx.files.internal("landtextures/sand.jpg"));
		A = new Texture(Gdx.files.internal("landtextures/water.jpg"));


	}
	/////////////////Level C////////////////////////////////




	public void lake(Node node, int chance) {
		Random rand = new Random();
		int randomNum = rand.nextInt((chance - 1) + 1) + 1;
		if (randomNum == 1) {
			node.occupied = true;
			Texture texture = gamescreen.tex.grasslandlake;
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
			Texture texture = gamescreen.tex.grasslandtree1;
			switch (randomtextureNum){
				case 1:
					texture = gamescreen.tex.grasslandtree1;
					break;
				case 2:
					texture = gamescreen.tex.grasslandtree2;
					break;
				case 3:
					texture = gamescreen.tex.grasslandtree3;
					break;
				case 4:
					texture = gamescreen.tex.grasslandtree4;
					break;
				case 5:
					texture = gamescreen.tex.grasslandtree5;
					break;
				case 6:
					texture = gamescreen.tex.grasslandtree6;
					break;
				case 7:
					texture = gamescreen.tex.grasslandtree7;
					break;
				case 8:
					texture = gamescreen.tex.grasslandtree8;
					break;
				case 9:
					texture = gamescreen.tex.grasslandtree9;
					break;
				case 10:
					texture = gamescreen.tex.grasslandtree10;
					break;
				case 11:
					texture = gamescreen.tex.grasslandtree11;
					break;
				case 12:
					texture = gamescreen.tex.grasslandtree12;
					break;
				case 13:
					texture = gamescreen.tex.grasslandtree13;
					break;
				case 14:
					texture = gamescreen.tex.grasslandtree14;
					break;
				case 15:
					texture = gamescreen.tex.grasslandtree15;
					break;

			}
			new Tree(500, node, node.gamescreen, node.x, node.y - 16, 96, 64, texture);

		}
	}

	public void stone(Node node, int chance){
		Random rand = new Random();

		int randomNum = rand.nextInt((chance - 1) + 1) + 1;
		if(randomNum == 1){
			node.occupied = true;
			int randomtextureNum = rand.nextInt((9- 1) + 1) + 1;
			Texture texture = gamescreen.tex.grasslandstone2;
			switch (randomtextureNum){
				case 1:
					texture = gamescreen.tex.grasslandstone2;
					break;
				case 2:
					texture = gamescreen.tex.grasslandstone3;
					break;
				case 3:
					texture = gamescreen.tex.grasslandstone4;
					break;
				case 4:
					texture = gamescreen.tex.grasslandstone5;
					break;
				case 5:
					texture = gamescreen.tex.grasslandstone6;
					break;
				case 6:
					texture = gamescreen.tex.grasslandstone7;
					break;

			}
			new Stone(200, node, node.gamescreen, node.x, node.y - 16, 32, 32, texture);

		}
	}

	public void greenery(Node node, int chance) {
		Random rand = new Random();

		int randomNum = rand.nextInt((chance - 1) + 1) + 1;
		if (randomNum == 1) {
			node.occupied = true;
			int randomtextureNum = rand.nextInt((9- 1) + 1) + 1;
			Texture texture = gamescreen.tex.grasslandgreenery1;
			switch (randomtextureNum){
				case 1:
					texture = gamescreen.tex.grasslandgreenery1;
					break;
				case 2:
					texture = gamescreen.tex.grasslandgreenery2;
					break;
				case 3:
					texture = gamescreen.tex.grasslandgreenery3;
					break;
				case 4:
					texture = gamescreen.tex.grasslandgreenery4;
					break;
				case 5:
					texture = gamescreen.tex.grasslandgreenery5;
					break;
				case 6:
					texture = gamescreen.tex.grasslandgreenery6;
					break;
				case 7:
					texture = gamescreen.tex.grasslandgreenery7;
					break;
				case 8:
					texture = gamescreen.tex.grasslandgreenery8;
					break;
				case 9:
					texture = gamescreen.tex.grasslandgreenery9;
					break;
				case 10:
					texture = gamescreen.tex.grasslandgreenery10;
					break;

			}

			new Greenery(200, node, node.gamescreen, node.x, node.y - 16, 32, 32, texture);

		}
	}


	////////////////////////////////////////////////////////////////////////////


	/////////////////Level E//////////////////////////////////////////////////////

	public void mountain(Node node, int chance) {
		Random rand = new Random();

		int randomNum = rand.nextInt((chance - 1) + 1) + 1;
		if (randomNum == 1) {
			node.occupied = true;
			for (Node nodes : node.adjecent) {
				if (nodes.y <= node.y + 32) {
					nodes.occupied = true;
				}
			}
			Texture texture = gamescreen.tex.grasslandstone1;
			new Stone(2000, node, node.gamescreen, node.x, node.y - 16, 96, 96, texture);

		}
	}

	public void animal_1(Node node, int chance) {
		Random rand = new Random();

		int randomNum = rand.nextInt((chance - 1) + 1) + 1;
		if (randomNum == 1) {
			if (!node.occupied){
				new cow(node, gamescreen, gamescreen.game, node.x, node.y);
			}

		}
	}


}
