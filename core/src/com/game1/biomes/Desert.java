package com.game1.biomes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.game1.Biome;
import com.game1.GameScreen;
import com.game1.Naturepackage.*;
import com.game1.Node;

import java.util.Random;
public class Desert extends Biome{

	public Desert(GameScreen gamescreen) {
		super(gamescreen);
		E = new Texture(Gdx.files.internal("Desert/bg.png"));
		D = new Texture(Gdx.files.internal("landtextures/desert.jpg"));
		C = new Texture(Gdx.files.internal("landtextures/desert.jpg"));
		B = new Texture(Gdx.files.internal("landtextures/desert red.jpg"));
		A = new Texture(Gdx.files.internal("landtextures/water.jpg"));
		}

		/////////////////Level C////////////////////////////////

		public void lake(Node node) {
			Random rand = new Random();
			int randomNum = rand.nextInt((300 - 1) + 1) + 1;
			if (randomNum == 1) {
				node.occupied = true;
				Texture texture = gamescreen.tex.desertlake;
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
				Texture texture = gamescreen.tex.deserttree1;
				switch (randomtextureNum){
					case 1:
						texture = gamescreen.tex.deserttree1;
						break;
					case 2:
						texture = gamescreen.tex.deserttree2;
						break;
					case 3:
						texture = gamescreen.tex.deserttree3;
						break;
					case 4:
						texture = gamescreen.tex.deserttree4;
						break;
					case 5:
						texture = gamescreen.tex.deserttree5;
						break;
					case 6:
						texture = gamescreen.tex.deserttree6;
						break;
					case 7:
						texture = gamescreen.tex.deserttree7;
						break;
					case 8:
						texture = gamescreen.tex.deserttree8;
						break;
					case 9:
						texture = gamescreen.tex.deserttree9;
						break;
					case 10:
						texture = gamescreen.tex.deserttree10;
						break;
					case 11:
						texture = gamescreen.tex.deserttree11;
						break;
					case 12:
						texture = gamescreen.tex.deserttree12;
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
				Texture texture = gamescreen.tex.desertstone1;
				switch (randomtextureNum){
					case 1:
						texture = gamescreen.tex.desertstone1;
						break;
					case 2:
						texture = gamescreen.tex.desertstone2;
						break;
					case 3:
						texture = gamescreen.tex.desertstone3;
						break;
					case 4:
						texture = gamescreen.tex.desertstone4;
						break;
					case 5:
						texture = gamescreen.tex.desertstone5;
						break;
					case 6:
						texture = gamescreen.tex.desertstone6;
						break;
					case 7:
						texture = gamescreen.tex.desertstone7;
						break;
					case 8:
						texture = gamescreen.tex.desertstone8;
						break;
					case 9:
						texture = gamescreen.tex.desertstone9;
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
				Texture texture = gamescreen.tex.desertgreenery1;
				switch (randomtextureNum){
					case 1:
						texture = gamescreen.tex.desertgreenery1;
						break;
					case 2:
						texture = gamescreen.tex.desertgreenery2;
						break;
					case 3:
						texture = gamescreen.tex.desertgreenery3;
						break;
					case 4:
						texture = gamescreen.tex.desertgreenery4;
						break;
					case 5:
						texture = gamescreen.tex.desertgreenery5;
						break;
					case 6:
						texture = gamescreen.tex.desertgreenery6;
						break;
					case 7:
						texture = gamescreen.tex.desertgreenery7;
						break;
					case 8:
						texture = gamescreen.tex.desertgreenery8;
						break;
					case 9:
						texture = gamescreen.tex.desertgreenery9;
						break;
					case 10:
						texture = gamescreen.tex.desertgreenery10;
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
			int randomtextureNum = rand.nextInt((3 - 1) + 1) + 1;
			Texture texture = gamescreen.tex.desertgreenery1;
			switch (randomtextureNum) {
				case 1:
					texture = gamescreen.tex.desertstone10;
					break;
				case 2:
					texture = gamescreen.tex.desertstone11;
					break;
				case 3:
					texture = gamescreen.tex.desertstone12;
					break;


			}

			new Stone(2000, node, node.gamescreen, node.x, node.y - 16, 96, 96, texture);


		}
	}

		/////////////////////////////////////////////////////////////////////////////////


}

