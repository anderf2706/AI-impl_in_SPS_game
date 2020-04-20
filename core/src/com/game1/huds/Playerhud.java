package com.game1.huds;


import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.game1.GameScreen;
import com.game1.Item;
import com.game1.Player;

import java.util.Set;

public class Playerhud extends Hud {

	public boolean builder = false;
	public boolean playstat = false;
	public Image background;
	public Player player;

	////
	public Item item1_object;
	public int item1_object_count = 0;
	////

	////
	public Item item2_object;
	public int item2_object_count = 0;
	////

	////
	public Item item3_object;

	public int item3_object_count = 0;
	////

	////
	public Item item4_object;

	public int item4_object_count = 0;
	////

	////
	public Item item5_object;

	public int item5_object_count = 0;
	////

	////
	public Item item6_object;

	public int item6_object_count = 0;
	////






	public Playerhud(SpriteBatch spriteBatch, final GameScreen gamescreen, final Player player) {
		super(spriteBatch, gamescreen);
		background = super.backgrounds;
		this.item1_object = gamescreen.wood;


		this.gamescreen = gamescreen;





////////////////////////////mainhud/////////////////////////////////////////

		Button builderbutton = new TextButton("Builder", super.skin);
		builderbutton.setPosition(100, 25);
		builderbutton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				stage.clear();
				stage.addActor(background);
				stage.addActor(buildertable);
				stage.addActor(topbackgrounds);
				stage.addActor(itemtable);
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
				stage.addActor(topbackgrounds);
				stage.addActor(itemtable);
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
				stage.addActor(topbackgrounds);
				stage.addActor(itemtable);
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
				stage.addActor(topbackgrounds);
				stage.addActor(itemtable);

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
		Button item1 = new TextButton("1", super.skin);
			item1.setPosition(100, 990);
			item1.addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					int num = 1;
					if (player.Inventory.size() >= num) {

						player.setitem(num);


					}

				}
			});


		Button item2 = new TextButton("2", super.skin);
			item2.setPosition(item1.getX() + item1.getWidth() + 50, 990);
			item2.addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					int num = 2;
					if (player.Inventory.size() >= num) {

						player.setitem(num);
					}

				}
			});


		Button item3 = new TextButton("3", super.skin);
			item3.setPosition(item2.getX() + item2.getWidth() + 50, 990);
			item3.addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					int num = 3;
					if (player.Inventory.size() >= num) {
						player.setitem(num);
					}

				}
			});


		Button item4 = new TextButton("4", super.skin);
			item4.setPosition(item3.getX() + item3.getWidth() + 50, 990);
			item4.addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					int num = 4;
					if (player.Inventory.size() >= num) {

						player.setitem(num);
					}

				}
			});


		Button item5 = new TextButton("5", super.skin);
			item5.setPosition(item4.getX() + item4.getWidth() + 50, 990);
			item5.addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					int num = 5;
					if (player.Inventory.size() >= num) {

						player.setitem(num);
					}

				}
			});


		Button item6 = new TextButton("6", super.skin);
			item6.setPosition(item5.getX() + item5.getWidth() + 50, 990);
			item6.addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					int num = 6;
					if (player.Inventory.size() >= 6) {

						player.setitem(num);
					}
				}
			});



		//TextField gold = new TextField();

		itemtable.addActor(item1);
		itemtable.addActor(item2);
		itemtable.addActor(item3);
		itemtable.addActor(item4);
		itemtable.addActor(item5);
		itemtable.addActor(item6);


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
	public void render(Drawable drawable1, Drawable drawable2, Drawable drawable3, Drawable drawable4,
					   Drawable drawable5, Drawable drawable6, Player player){
		/////////////////icon1/////////////////////////

		if (player.Inventory.size() > 0) {
			ImageButton icon1 = new ImageButton(drawable1);
			icon1.setPosition(100, 1055);
			icon1.setSize(50, 50);
			icontable.removeActor(icon1);
			icontable.addActor(icon1);
			stage.addActor(icontable);
			//////////////////////////////////////////////
		}
		/////////////////icon2/////////////////////////
		if (player.Inventory.size() > 1) {
			ImageButton icon2 = new ImageButton(drawable2);
			icon2.setPosition(200, 1055);
			icon2.setSize(50, 50);
			icontable.removeActor(icon2);
			icontable.addActor(icon2);
			stage.addActor(icontable);
			//////////////////////////////////////////////
		}
		/////////////////icon1/////////////////////////
		if (player.Inventory.size() > 2) {
			ImageButton icon3 = new ImageButton(drawable3);
			icon3.setPosition(300, 1055);
			icon3.setSize(50, 50);
			icontable.removeActor(icon3);
			icontable.addActor(icon3);
			stage.addActor(icontable);
			//////////////////////////////////////////////
		}
		/////////////////icon1/////////////////////////
		if (player.Inventory.size() > 3) {
			ImageButton icon4 = new ImageButton(drawable4);
			icon4.setPosition(400, 1055);
			icon4.setSize(50, 50);
			icontable.removeActor(icon4);
			icontable.addActor(icon4);
			stage.addActor(icontable);
			//////////////////////////////////////////////
		}
		/////////////////icon1/////////////////////////
		if (player.Inventory.size() > 4) {
			ImageButton icon5 = new ImageButton(drawable5);
			icon5.setPosition(500, 1055);
			icon5.setSize(50, 50);
			icontable.removeActor(icon5);
			icontable.addActor(icon5);
			stage.addActor(icontable);
			//////////////////////////////////////////////
		}
		/////////////////icon1/////////////////////////
		if (player.Inventory.size() > 5) {
			ImageButton icon6 = new ImageButton(drawable6);
			icon6.setPosition(600, 1055);
			icontable.removeActor(icon6);
			icontable.addActor(icon6);
			stage.addActor(icontable);
			//////////////////////////////////////////////
		}


	}



}
