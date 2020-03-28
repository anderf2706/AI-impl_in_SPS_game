package com.game1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class textures {

	public Texture spritefront;
	public Texture spriteback;
	public Texture spriteleft;
	public Texture fightsprite;
	public Sprite spriteright;

	public Texture spriteprotfront;
	public Texture spriteprotback;
	public Texture spriteprotleft;
	public Texture spriteprotright;




	public textures() {

		spritefront = new Texture(Gdx.files.internal("sprites/Fighter-Front.gif"));
		spriteback = new Texture(Gdx.files.internal("sprites/Fighter-Back.gif"));
		spriteleft = new Texture(Gdx.files.internal("sprites/Fighter-Left.gif"));
		spriteright = new Sprite(spriteleft);
		spriteright.flip(true, false);
		fightsprite = new Texture(Gdx.files.internal("sprites/Fighter-Front.gif"));

		spriteprotfront = new Texture(Gdx.files.internal("sprites/front_man.gif"));
		spriteprotback = new Texture(Gdx.files.internal("sprites/back_man.gif"));
		spriteprotleft = new Texture(Gdx.files.internal("sprites/left_man.gif"));
		spriteprotright = new Texture(Gdx.files.internal("sprites/right_man.gif"));



	}
}
