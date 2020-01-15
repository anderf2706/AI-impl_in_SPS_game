package com.game1.huds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.game1.*;

import java.util.ArrayList;
import java.util.TreeMap;

public class BuildingHud extends Hud {

	GameScreen gamescreen;

	public BuildingHud(SpriteBatch spriteBatch, final GameScreen gamescreen, final Building building) {
		super(spriteBatch, gamescreen);
		this.gamescreen = gamescreen;

		Button textbutton = new TextButton("solider", super.skin);
		textbutton.setPosition(200, 50);
		textbutton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Node node = gamescreen.findavailablenode(building.buildingnode);

				new Player(gamescreen, gamescreen.game, node.x
						, node.y, gamescreen.team);



			}
		});

		ImageButton imageButton2 = new ImageButton(drawable);
		imageButton2.setPosition(300, 50);
		imageButton2.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Node node = gamescreen.findavailablenode(building.buildingnode);
				new Wall(gamescreen, node.x, node.y, gamescreen.team);


			};
		});

		ImageButton imageButton3 = new ImageButton(drawable);
		imageButton3.setPosition(400, 50);
		imageButton3.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {

			};
		});

		ImageButton imageButton4 = new ImageButton(drawable);
		imageButton4.setPosition(500, 50);
		imageButton4.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {

			};
		});

		ImageButton imageButton5 = new ImageButton(drawable);
		imageButton5.setPosition(600, 50);
		imageButton5.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
			};
		});

		Button textbutton2 = new TextButton("solider", super.skin);
		textbutton2.setPosition(200, 50);
		textbutton2.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Node node = gamescreen.findavailablenode(building.buildingnode);

				new Wall(gamescreen, node.x, node.y, gamescreen.team);



			}
		});


		if(building.getClass() == Barracks.class){
			table.addActor(textbutton);
			table.addActor(imageButton2);
			table.addActor(imageButton3);
			table.addActor(imageButton4);
			table.addActor(imageButton5);
		}

		if(building.getClass() == Wall.class){
			table.addActor(textbutton2);
			table.addActor(imageButton2);

		}


		stage.addActor(table);

	}



}
