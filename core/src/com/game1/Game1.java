package com.game1;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class Game1 extends Game {
	public SpriteBatch batch;
	Texture img;
	BitmapFont font;
	Texture frontimg;
	GameScreen[][]games;
	float[][] humiditymap;
	int nodewidth;
	
	@Override
	public void create () {
		nodewidth = 200;
		games = new GameScreen[10][10];
		batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		font = new BitmapFont();
		font.setColor(Color.BLACK);
		font.getData().setScale(2);
		humiditymap = generateSimplexNoise((float) 0.5, nodewidth*10, nodewidth*10, 1.5, 1.5);

		frontimg = new Texture(Gdx.files.internal("libgdx.png"));
		this.setScreen(new StartScreen(this, nodewidth));
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

	public float[][] generateSimplexNoise(float hairyfactor, int width, int height, double min, double max){
		SimplexNoise sn = new SimplexNoise();
		float[][]simplexnoise=new float[width][height];
		Random r = new Random();
		double randomfreq = min + r.nextDouble() * (max - min);
		System.out.println(randomfreq);
		float frequency=(float)randomfreq/(float)width;
		double random = (Math.random() * (10000) + 1);
		for(int x=0;x<width; x++){
			for(int y=0;y<height; y++){
				simplexnoise[x][y]=(float) sn.noise( hairyfactor, (x+random)*frequency,(y+random)*frequency);
				simplexnoise[x][y]=(simplexnoise[x][y]+1)/2;   //generate values between 0 and 1
			}
		}


		return simplexnoise;
	}
}
