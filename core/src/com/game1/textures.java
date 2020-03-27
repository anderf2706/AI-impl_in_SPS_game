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

	public textures() {

		spritefront = new Texture(Gdx.files.internal("Fighter-Front.gif"));
		spriteback = new Texture(Gdx.files.internal("Fighter-Back.gif"));
		spriteleft = new Texture(Gdx.files.internal("Fighter-Left.gif"));
		spriteright = new Sprite(spriteleft);
		spriteright.flip(true, false);


		fightsprite = new Texture(Gdx.files.internal("Fighter-Front.gif"));

	}
}
