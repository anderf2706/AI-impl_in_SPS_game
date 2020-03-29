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


public class Maingamehud extends Hud {

	public boolean builder = false;
	public boolean playstat = false;

	public Maingamehud(SpriteBatch spriteBatch, final GameScreen gamescreen) {
		super(spriteBatch, gamescreen);

		this.gamescreen = gamescreen;

////////////////////////////mainhud/////////////////////////////////////////

		Button builderbutton = new TextButton("Builder", super.skin);
		builderbutton.setPosition(200, 50);
		builderbutton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				stage.clear();
				stage.addActor(buildertable);
			};
		});

		Button playstatbutton = new TextButton("Playstat", super.skin);
		playstatbutton.setPosition(300, 50);
		playstatbutton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				stage.clear();
				stage.addActor(playstattable);
			};
		});


///////////////////////////////////////////////////////////////////////////


////////////////////////////builderhud//////////////////////////////////

		Button buildbackbutton = new TextButton("Back", super.skin);
		buildbackbutton.setPosition(200, 50);
		buildbackbutton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				stage.clear();
				stage.addActor(maintable);
			};
		});


		Button barracksbutton = new TextButton("Barracks", super.skin);
		barracksbutton.setPosition(300, 50);
		barracksbutton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				gamescreen.makeHouse = false;
				gamescreen.makeWall = false;
				gamescreen.makeCastle = false;
				gamescreen.makeBarracks = !gamescreen.makeBarracks;
			};
		});

		Button housebutton = new TextButton("House", super.skin);
		housebutton.setPosition(400, 50);
		housebutton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				gamescreen.makeBarracks = false;
				gamescreen.makeWall = false;
				gamescreen.makeCastle = false;
				gamescreen.makeHouse = !gamescreen.makeHouse;
			};
		});

		Button wallbutton = new TextButton("Wall", super.skin);
		wallbutton.setPosition(500, 50);
		wallbutton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				gamescreen.makeHouse = false;
				gamescreen.makeBarracks = false;
				gamescreen.makeCastle = false;
				gamescreen.makeWall = !gamescreen.makeWall;
			};
		});

		Button castlebutton = new TextButton("Castle", super.skin);
		castlebutton.setPosition(600, 50);
		castlebutton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				gamescreen.makeHouse = false;
				gamescreen.makeWall = false;
				gamescreen.makeBarracks = false;
				gamescreen.makeCastle = !gamescreen.makeCastle;
			};
		});

////////////////////////////////////////////////////////////////////////////

//////////////////////playstathud////////////////////////////////////////////

		Button playstatbackbutton = new TextButton("Back", super.skin);
		playstatbackbutton.setPosition(200, 50);
		playstatbackbutton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				stage.clear();
				stage.addActor(maintable);
			};
		});

		Button playerbutton = new TextButton("player", super.skin);
		castlebutton.setPosition(300, 50);
		castlebutton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {

			};
		});

/////////////////////////////////////////////////////////////////////////////

/////////////////////////////tables/////////////////////////////////

		maintable.addActor(builderbutton);
		maintable.addActor(playstatbutton);

		buildertable.addActor(buildbackbutton);
		buildertable.addActor(barracksbutton);
		buildertable.addActor(housebutton);
		buildertable.addActor(wallbutton);
		buildertable.addActor(castlebutton);

		playstattable.addActor(playerbutton);
		playstattable.addActor(playstatbackbutton);

		stage.addActor(maintable);

////////////////////////////////////////////////////////////////////



	}
}
