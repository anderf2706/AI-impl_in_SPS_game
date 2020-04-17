package com.game1.huds;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
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

/////////////////////////////itmes//////////////////////////////////

		ImageButton backgroundbutton = new ImageButton(drawablebackground);
		backgroundbutton.setPosition(0, 0);
		backgroundbutton.setSize(1920, 100);
		backgroundbutton.toBack();
		backgroundbutton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {

			}
		});

		ImageButton item1 = new ImageButton(drawable);
		item1.setPosition(100, 1035);
		item1.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
			}
		});
		ImageButton item2 = new ImageButton(drawable);
		item2.setPosition(item1.getX() + item1.getWidth() + 50, 1035);
		item2.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
			}
		});
		ImageButton item3 = new ImageButton(drawable);
		item3.setPosition(item2.getX() + item2.getWidth() + 50, 1035);
		item3.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
			}
		});
		ImageButton item4 = new ImageButton(drawable);
		item4.setPosition(item3.getX() + item3.getWidth() + 50, 1035);
		item4.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
			}
		});
		ImageButton item5 = new ImageButton(drawable);
		item5.setPosition(item4.getX() + item4.getWidth() + 50, 1035);
		item5.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
			}
		});
		ImageButton item6 = new ImageButton(drawable);
		item6.setPosition(item5.getX() + item5.getWidth() + 50, 1035);
		item6.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
			}
		});
		ImageButton item7 = new ImageButton(drawable);
		item7.setPosition(item6.getX() + item6.getWidth() + 50, 1035);
		item7.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
			}
		});
		//TextField gold = new TextField();

		itemtable.addActor(item1);
		itemtable.addActor(item2);
		itemtable.addActor(item3);
		itemtable.addActor(item4);
		itemtable.addActor(item5);
		itemtable.addActor(item6);
		itemtable.addActor(item7);

///////////////////////////////////////////////////////////////////

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
		stage.addActor(itemtable);

////////////////////////////////////////////////////////////////////



	}
}
