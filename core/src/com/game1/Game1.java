package com.game1;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game1 extends Game {
	public SpriteBatch batch;
	Texture img;
	BitmapFont font;
	Texture frontimg;
	GameScreen[][]games;
	
	float x = 0;
	float y = 0;
	
	@Override
	public void create () {
		games = new GameScreen[10][10];
		batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		font = new BitmapFont();
		font.setColor(Color.BLACK);
		font.getData().setScale(2);
		frontimg = new Texture(Gdx.files.internal("libgdx.png"));
		this.setScreen(new StartScreen(this));
	}

	@Override
	public void render () {
		super.render();

	}
	
	
	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
		
	}
}
