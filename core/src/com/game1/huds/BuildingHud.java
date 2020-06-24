package com.game1.huds;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.game1.*;
import com.game1.buildings.Barracks;
import com.game1.buildings.Palicade_H;
import com.game1.buildings.Palicade_V;
import com.game1.players.footenemy;

public class BuildingHud extends Hud {

	GameScreen gamescreen;

	public BuildingHud(SpriteBatch spriteBatch, final GameScreen gamescreen, final Building building) {
		super(spriteBatch, gamescreen);
		this.gamescreen = gamescreen;

		Button barracks_footenemy = new TextButton("solider", super.skin);
		barracks_footenemy.setPosition(100, 50);
		barracks_footenemy.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Node node = gamescreen.findavailablenode(building.buildingnode);

				new footenemy(node, gamescreen, gamescreen.game, node.x
						, node.y);



			}
		});

		Button barracks_activatefootenemy = new TextButton("activate", super.skin);
		barracks_activatefootenemy.setPosition(barracks_footenemy.getX() + barracks_footenemy.getWidth(), 50);
		barracks_activatefootenemy.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				building.activate();

			}
		});

		ImageButton imageButton3 = new ImageButton(drawable);
		imageButton3.setPosition(400, 50);
		imageButton3.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {

			}
		});

		ImageButton imageButton4 = new ImageButton(drawable);
		imageButton4.setPosition(500, 50);
		imageButton4.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {

			}
		});

		ImageButton imageButton5 = new ImageButton(drawable);
		imageButton5.setPosition(600, 50);
		imageButton5.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
			}
		});


		if(building.getClass() == Barracks.class){
			buildingtable.addActor(barracks_footenemy);
			buildingtable.addActor(barracks_activatefootenemy);
			buildingtable.addActor(imageButton3);
			buildingtable.addActor(imageButton4);
			buildingtable.addActor(imageButton5);
		}

		if(building.getClass() == Palicade_H.class || building.getClass() == Palicade_V.class){


		}


		stage.addActor(buildingtable);

	}



}
