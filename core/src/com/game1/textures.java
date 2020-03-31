package com.game1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;


public class textures {

	public Texture spritefront;
	public Texture spriteback;
	public Texture spriteleft;
	public Texture spriteright;

	public Texture spriteprotfront;
	public Texture spriteprotback;
	public Texture spriteprotleft;
	public Texture spriteprotright;

	public Texture green;
	public Texture blue;
	public Texture grey;
	public Texture white;
	public Texture beige;
	public Texture tree_normal;




	public textures() {

		sprites();
		landtextures();


	}

	public void sprites(){
		spritefront = new Texture(Gdx.files.internal("sprites/knt1_fr1.gif"));
		spriteback = new Texture(Gdx.files.internal("sprites/knt1_bk1.gif"));
		spriteleft = new Texture(Gdx.files.internal("sprites/knt1_lf1.gif"));
		spriteright = new Texture(Gdx.files.internal("sprites/knt1_rt1.gif"));


		spriteprotfront = new Texture(Gdx.files.internal("sprites/man1_fr1.gif"));
		spriteprotback = new Texture(Gdx.files.internal("sprites/man1_bk1.gif"));
		spriteprotleft = new Texture(Gdx.files.internal("sprites/man1_lf1.gif"));
		spriteprotright = new Texture(Gdx.files.internal("sprites/man1_rt1.gif"));


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
