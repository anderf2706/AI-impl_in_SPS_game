package com.game1.biomes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.game1.Biome;
import com.game1.GameScreen;
import com.game1.Naturepackage.*;
import com.game1.Node;

import java.util.Random;

public class Tundra extends Biome {


	public Tundra(GameScreen gamescreen){
		super(gamescreen);
		E = new Texture(Gdx.files.internal("Winter/bg.png"));
		D = new Texture(Gdx.files.internal("landtextures/snow.jpg"));
		C = new Texture(Gdx.files.internal("landtextures/snow.jpg"));
		B = new Texture(Gdx.files.internal("landtextures/sand.jpg"));
		A = new Texture(Gdx.files.internal("landtextures/ice.jpg"));


	}
	/////////////////Level C////////////////////////////////

	public void act_C1(Node node) {
		Random rand = new Random();
		int randomNum = rand.nextInt((200 - 1) + 1) + 1;
		if (randomNum == 1) {
			node.occupied = true;
			Texture texture = gamescreen.tex.desertlake;
			for (Node nodes : node.adjecent) {
				if ((node.y <= nodes.y)) {
					nodes.occupied = true;
				}
			}

			new Lake(node, node.gamescreen, node.x, node.y - 16, 64, 96, texture);

		}
	}

	public void act_C2(Node node){
		Random rand = new Random();

		int randomNum = rand.nextInt((20 - 1) + 1) + 1;
		if(randomNum == 1){
			node.occupied = true;

			int randomtextureNum = rand.nextInt((12 - 1) + 1) + 1;
			Texture texture = gamescreen.tex.wintertree1;
			switch (randomtextureNum){
				case 1:
					texture = gamescreen.tex.wintertree1;
					break;
				case 2:
					texture = gamescreen.tex.wintertree2;
					break;
				case 3:
					texture = gamescreen.tex.wintertree3;
					break;
				case 4:
					texture = gamescreen.tex.wintertree4;
					break;
				case 5:
					texture = gamescreen.tex.wintertree5;
					break;
				case 6:
					texture = gamescreen.tex.wintertree6;
					break;
				case 7:
					texture = gamescreen.tex.wintertree7;
					break;
				case 8:
					texture = gamescreen.tex.wintertree8;
					break;
				case 9:
					texture = gamescreen.tex.wintertree9;
					break;
				case 10:
					texture = gamescreen.tex.wintertree10;
					break;
				case 11:
					texture = gamescreen.tex.wintertree11;
					break;
				case 12:
					texture = gamescreen.tex.wintertree12;
					break;
				case 13:
					texture = gamescreen.tex.wintertree13;
					break;
				case 14:
					texture = gamescreen.tex.wintertree14;
					break;
				case 15:
					texture = gamescreen.tex.wintertree15;
					break;

			}
			new Tree(node, node.gamescreen, node.x, node.y - 16, 96, 64, texture);

		}
	}

	public void act_C3(Node node){
		Random rand = new Random();

		int randomNum = rand.nextInt((20 - 1) + 1) + 1;
		if(randomNum == 1){
			node.occupied = true;
			int randomtextureNum = rand.nextInt((9- 1) + 1) + 1;
			Texture texture = gamescreen.tex.winterstone2;
			switch (randomtextureNum){
				case 1:
					texture = gamescreen.tex.winterstone2;
					break;
				case 2:
					texture = gamescreen.tex.winterstone3;
					break;
				case 3:
					texture = gamescreen.tex.winterstone4;
					break;
				case 4:
					texture = gamescreen.tex.winterstone5;
					break;
				case 5:
					texture = gamescreen.tex.winterstone6;
					break;
				case 6:
					texture = gamescreen.tex.winterstone7;
					break;

			}
			new Stone(node, node.gamescreen, node.x, node.y - 16, 32, 32, texture);

		}
	}

	public void act_C4(Node node) {
		Random rand = new Random();

		int randomNum = rand.nextInt((15 - 1) + 1) + 1;
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

			}

			new Greenery(node, node.gamescreen, node.x, node.y - 16, 32, 32, texture);

		}
	}


	////////////////////////////////////////////////////////////////////////////


	/////////////////Level E//////////////////////////////////////////////////////

	public void act_E1(Node node) {
		Random rand = new Random();

		int randomNum = rand.nextInt((10 - 1) + 1) + 1;
		if (randomNum == 1) {
			node.occupied = true;
			for (Node nodes : node.adjecent) {
				if (node.y <= nodes.y) {
					nodes.occupied = true;
				}
			}
			Texture texture = gamescreen.tex.winterstone1;


			new Stone(node, node.gamescreen, node.x, node.y - 16, 96, 96, texture);

		}
	}
}