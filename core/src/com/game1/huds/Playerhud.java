package com.game1.huds;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.game1.GameScreen;
import com.game1.Player;

public class Playerhud extends Hud {

	public boolean builder = false;
	public boolean playstat = false;
	public Image background;
	public Player player;

	public Playerhud(SpriteBatch spriteBatch, final GameScreen gamescreen, Player player) {
		super(spriteBatch, gamescreen);
		background = super.backgrounds;

		this.gamescreen = gamescreen;
		this.player = player;

////////////////////////////mainhud/////////////////////////////////////////

		Button builderbutton = new TextButton("Builder", super.skin);
		builderbutton.setPosition(100, 25);
		builderbutton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				stage.clear();
				stage.addActor(background);
				stage.addActor(buildertable);
			}
		});

		Button playstatbutton = new TextButton("Playstat", super.skin);
		playstatbutton.setPosition(builderbutton.getX() + builderbutton.getWidth(), 25);
		playstatbutton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				stage.clear();
				stage.addActor(background);
				stage.addActor(playstattable);
			}
		});


///////////////////////////////////////////////////////////////////////////


////////////////////////////builderhud//////////////////////////////////

		Button buildbackbutton = new TextButton("Back", super.skin);
		buildbackbutton.setPosition(100, 25);
		buildbackbutton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				stage.clear();
				stage.addActor(background);
				stage.addActor(maintable);
			}
		});


		Button barracksbutton = new TextButton("Barracks", super.skin);
		barracksbutton.setPosition(buildbackbutton.getX() + buildbackbutton.getWidth() + 50, 25);
		barracksbutton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				gamescreen.makeHouse = false;
				gamescreen.makeWall = false;
				gamescreen.makeCastle = false;
				gamescreen.makeGate = false;
				gamescreen.makeBarracks = !gamescreen.makeBarracks;
			}
		});

		Button housebutton = new TextButton("House", super.skin);
		housebutton.setPosition(barracksbutton.getX() + barracksbutton.getWidth(), 25);
		housebutton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				gamescreen.makeBarracks = false;
				gamescreen.makeWall = false;
				gamescreen.makeCastle = false;
				gamescreen.makeGate = false;

				gamescreen.makeHouse = !gamescreen.makeHouse;
			}
		});

		Button wallbutton = new TextButton("Wall", super.skin);
		wallbutton.setPosition(housebutton.getX() + housebutton.getWidth(), 25);
		wallbutton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				gamescreen.makeHouse = false;
				gamescreen.makeBarracks = false;
				gamescreen.makeCastle = false;
				gamescreen.makeGate = false;

				gamescreen.makeWall = !gamescreen.makeWall;
			}
		});

		Button gatebutton = new TextButton("Gate", super.skin);
		gatebutton.setPosition(wallbutton.getX() + wallbutton.getWidth(), 25);
		gatebutton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				gamescreen.makeHouse = false;
				gamescreen.makeBarracks = false;
				gamescreen.makeCastle = false;
				gamescreen.makeWall = false;
				gamescreen.makeGate = !gamescreen.makeGate;
			}
		});

		Button castlebutton = new TextButton("Castle", super.skin);
		castlebutton.setPosition(gatebutton.getX() + gatebutton.getWidth(), 25);
		castlebutton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				gamescreen.makeHouse = false;
				gamescreen.makeWall = false;
				gamescreen.makeBarracks = false;
				gamescreen.makeGate= false;

				gamescreen.makeCastle = !gamescreen.makeCastle;
			}
		});

////////////////////////////////////////////////////////////////////////////

//////////////////////playstathud////////////////////////////////////////////

		Button playstatbackbutton = new TextButton("Back", super.skin);
		playstatbackbutton.setPosition(100, 25);
		playstatbackbutton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				stage.clear();
				stage.addActor(background);
				stage.addActor(maintable);

			}
		});

		Button playerbutton = new TextButton("player", super.skin);
		playerbutton.setPosition(playstatbackbutton.getX() + playstatbackbutton.getWidth() + 50, 25);
		playerbutton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {

			}
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
		buildertable.addActor(gatebutton);

		playstattable.addActor(playerbutton);
		playstattable.addActor(playstatbackbutton);

		stage.addActor(background);
		stage.addActor(maintable);

////////////////////////////////////////////////////////////////////



	}
}
