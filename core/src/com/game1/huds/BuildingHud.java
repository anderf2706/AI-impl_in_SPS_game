package com.game1.huds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.game1.GameScreen;

public class BuildingHud extends Hud {

	GameScreen gamescreen;

	public BuildingHud(SpriteBatch spriteBatch, final GameScreen gamescreen) {
		super(spriteBatch, gamescreen);
		this.gamescreen = gamescreen;
		Button textbutton = new TextButton("hallabygg", super.skin);
		textbutton.setPosition(200, 50);
		textbutton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				gamescreen.makeHouse = false;
				gamescreen.makeWall = false;
				gamescreen.makeCastle = false;
				//gamescreen.makeBarracks = !gamescreen.makeBarracks;
			};
		});

		ImageButton imageButton2 = new ImageButton(drawable);
		imageButton2.setPosition(300, 50);
		imageButton2.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				gamescreen.makeBarracks = false;
				gamescreen.makeWall = false;
				gamescreen.makeCastle = false;
				gamescreen.makeHouse = !gamescreen.makeHouse;
			};
		});

		ImageButton imageButton3 = new ImageButton(drawable);
		imageButton3.setPosition(400, 50);
		imageButton3.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				gamescreen.makeHouse = false;
				gamescreen.makeBarracks = false;
				gamescreen.makeCastle = false;
				gamescreen.makeWall = !gamescreen.makeWall;
			};
		});

		ImageButton imageButton4 = new ImageButton(drawable);
		imageButton4.setPosition(500, 50);
		imageButton4.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				gamescreen.makeHouse = false;
				gamescreen.makeWall = false;
				gamescreen.makeBarracks = false;
				gamescreen.makeCastle = !gamescreen.makeCastle;
			};
		});

		ImageButton imageButton5 = new ImageButton(drawable);
		imageButton5.setPosition(600, 50);
		imageButton5.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("dd");
			};
		});

		Image background = new Image(drawablebackground);
		background.setPosition(0, 0);
		background.setWidth(Gdx.graphics.getWidth());
		background.setHeight(100);
		background.toBack();



		//stage.addActor(imageButton);
		table.addActor(textbutton);
		table.addActor(imageButton2);
		table.addActor(imageButton3);
		table.addActor(imageButton4);
		table.addActor(imageButton5);
		stage.addActor(background);

		stage.addActor(table);
		//stage.addActor(imageButton2);
	}



}
