package com.game1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.physics.bullet.softbody.SWIGTYPE_p_btAlignedObjectArrayT_btSparseSdfT_3_t__Cell_p_t;


public class textures {

	public Texture spritefront;
	public Texture spritefront2;
	public Texture spriteback;
	public Texture spriteback2;
	public Texture spriteleft;
	public Texture spriteleft2;
	public Texture spriteright;
	public Texture spriteright2;


	public Texture spriteprotfront;
	public Texture spriteprotfront2;
	public Texture spriteprotback;
	public Texture spriteprotback2;
	public Texture spriteprotleft;
	public Texture spriteprotleft2;
	public Texture spriteprotright;
	public Texture spriteprotright2;

	public Texture green;
	public Texture blue;
	public Texture grey;
	public Texture white;
	public Texture beige;
	public Texture tree_normal;
	public Texture normal_stone;
	public Texture water;
	public Texture grass;
	public Texture dirt;
	public Texture tree_small;
	public Texture rock;
	public Texture snow;
	public Texture sand;
	public Texture barrentree;
	public Texture desertstone;
	public Texture cactus;
	public Texture snowbush;
	public Texture snowtree;
	public Texture jungle_tree;
	public Texture palm1;
	public Texture palm2;
	public Texture tree3;
	public Texture tree4;


	public Texture house;
	public Texture barracks;
	public Texture towncenter;
	public Texture wall;
	public Texture gate;
	public Texture crate;
	public Texture barrel;
	public Texture road;
	public Texture castle;
	public Texture pavement;





	public textures() {

		sprites();
		landtextures();
		buildingtextures();
		misctextures();


	}

	public void sprites(){
		spritefront = new Texture(Gdx.files.internal("sprites/knt1/knt1_fr1.gif"));
		spritefront2 = new Texture(Gdx.files.internal("sprites/knt1/knt1_fr2.gif"));
		spriteback = new Texture(Gdx.files.internal("sprites/knt1/knt1_bk1.gif"));
		spriteback2 = new Texture(Gdx.files.internal("sprites/knt1/knt1_bk2.gif"));
		spriteleft = new Texture(Gdx.files.internal("sprites/knt1/knt1_lf1.gif"));
		spriteleft2 = new Texture(Gdx.files.internal("sprites/knt1/knt1_lf2.gif"));
		spriteright = new Texture(Gdx.files.internal("sprites/knt1/knt1_rt1.gif"));
		spriteright2 = new Texture(Gdx.files.internal("sprites/knt1/knt1_rt2.gif"));


		spriteprotfront = new Texture(Gdx.files.internal("sprites/man1/man1_fr1.gif"));
		spriteprotfront2 = new Texture(Gdx.files.internal("sprites/man1/man1_fr2.gif"));
		spriteprotback = new Texture(Gdx.files.internal("sprites/man1/man1_bk1.gif"));
		spriteprotback2 = new Texture(Gdx.files.internal("sprites/man1/man1_bk2.gif"));
		spriteprotleft = new Texture(Gdx.files.internal("sprites/man1/man1_lf1.gif"));
		spriteprotleft2 = new Texture(Gdx.files.internal("sprites/man1/man1_lf2.gif"));
		spriteprotright = new Texture(Gdx.files.internal("sprites/man1/man1_rt1.gif"));
		spriteprotright2 = new Texture(Gdx.files.internal("sprites/man1/man1_rt2.gif"));



	}

	public void landtextures(){
		green = new Texture(Gdx.files.internal("landtextures/green.jpg"));
		blue = new Texture(Gdx.files.internal("landtextures/blue.png"));
		grey = new Texture(Gdx.files.internal("landtextures/grey.jpg"));
		white = new Texture(Gdx.files.internal("landtextures/white.jpg"));
		beige = new Texture(Gdx.files.internal("landtextures/beige.jpg"));
		normal_stone =new Texture(Gdx.files.internal("landtextures/normalstone.png"));
		tree_normal = new Texture(Gdx.files.internal("landtextures/tree.png"));
		tree_small = new Texture(Gdx.files.internal("landtextures/tree2.png"));
		water = new Texture(Gdx.files.internal("landtextures/water.jpg"));
		grass = new Texture(Gdx.files.internal("landtextures/tile_grass.png"));
		dirt = new Texture(Gdx.files.internal("landtextures/tile_dirt.png"));
		rock = new Texture(Gdx.files.internal("landtextures/stone.jpg"));
		sand = new Texture(Gdx.files.internal("landtextures/sand.jpg"));
		snow = new Texture(Gdx.files.internal("landtextures/snow.jpg"));
		barrentree = new Texture(Gdx.files.internal("landtextures/dead_tree.png"));
		desertstone = new Texture(Gdx.files.internal("landtextures/desertrock.png"));
		cactus = new Texture(Gdx.files.internal("landtextures/cactus.png"));
		snowbush = new Texture(Gdx.files.internal("landtextures/snowbush.png"));
		snowtree = new Texture(Gdx.files.internal("landtextures/snow_tree.png"));

		//jungle_tree = new Texture(Gdx.files.internal("landtextures/jungle_tree.jpg"));
		palm1 = new Texture(Gdx.files.internal("landtextures/palm1.png"));
		palm2 = new Texture(Gdx.files.internal("landtextures/palm2.png"));
		tree3 = new Texture(Gdx.files.internal("landtextures/tree3.png"));
		tree4 = new Texture(Gdx.files.internal("landtextures/tree4.png"));

	}

	public void buildingtextures(){
		house = new Texture(Gdx.files.internal("buildingtextures/house2.png"));
		barracks = new Texture(Gdx.files.internal("buildingtextures/house3.png"));
		towncenter = new Texture(Gdx.files.internal("buildingtextures/house.png"));
		road =  new Texture(Gdx.files.internal("buildingtextures/tile_pavement.png"));
		wall = new Texture(Gdx.files.internal("buildingtextures/wall.png"));
		gate = new Texture(Gdx.files.internal("buildingtextures/gate.png"));
		pavement = new Texture(Gdx.files.internal("buildingtextures/tile_pavement.png"));
	}

	public void misctextures(){
		barrel = new Texture(Gdx.files.internal("buildingtextures/barel.png"));
		crate = new Texture(Gdx.files.internal("buildingtextures/crate.png"));
	}
}
