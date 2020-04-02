package com.game1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;


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




	public textures() {

		sprites();
		landtextures();


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
		tree_normal = new Texture(Gdx.files.internal("landtextures/sprite_0.png"));
	}
}
