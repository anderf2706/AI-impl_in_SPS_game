package com.game1.huds;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
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

    int actorWidth = Gdx.graphics.getWidth() / 10;
    int actorHeight = Gdx.graphics.getHeight() /  10;
    Actor[] actors = new Actor[6 * 6];


	public Playerhud(SpriteBatch spriteBatch, final GameScreen gamescreen, final Player player) {
		super(spriteBatch, gamescreen);
		background = super.backgrounds;


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

		final Button inventorybutton = new TextButton("Inventory", super.skin);
		inventorybutton.setPosition(playstatbutton.getX() + playstatbutton.getWidth(), 25);
		inventorybutton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				stage.clear();
				stage.addActor(background);
				stage.addActor(inventorybackground);
				stage.addActor(topbackgrounds);
				stage.addActor(itemtable);
				for (int i = 0; i < 6; i++){
					for (int j = 0; j < 6; j++){
						//  Actor actor = actors[(i * 10) + j];
						// inventorytable.add(actor).width(actorWidth).height(actorHeight);
                        Drawable drawable_object;
						int count;
                        try {
                            Item item1 = (Item) player.keys.toArray()[(i * 6) + j];
                            drawable_object = new TextureRegionDrawable((new TextureRegion(item1.icon)));
                            count = player.Inventory.get(item1);
                        }
                        catch (ArrayIndexOutOfBoundsException e){
                            drawable_object = drawable;
                            count = 0;
                        }
						inventorytable.addActor(maketestbutton(drawable_object, i, j));
						Label countlabel = new Label(count + "", skin);
						countlabel.setBounds(300 + i*75, 340 + j*75, 40, 10);
						inventorytable.addActor(countlabel);
                        //gamescreen.font.draw(gamescreen.game.batch, "" + count, 250 + x*75, 340 + y*75);
					}

				}
				stage.addActor(inventorytable);

			}
		});


///////////////////////////////////////////////////////////////////////////

		Button inventorybackbutton = new ImageButton(backbutton);
		inventorybackbutton.setPosition(100, 980 - 140);
		inventorybackbutton.setSize(50,50);
		inventorybackbutton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				stage.clear();
				stage.addActor(background);
				stage.addActor(maintable);
				stage.addActor(topbackgrounds);
				stage.addActor(itemtable);

			}
		});


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


		inventorytable.addActor(inventorybackgroundbutton);
		inventorytable.addActor(inventorybackbutton);
		/*
        for (int i = 0; i < 10*10; i++) {
            actors[i] = test;
        }

		 */



		//TextField gold = new TextField();


///////////////////////////////////////////////////////////////////

///////////////////////////Health, stamina etc/////////////////////



///////////////////////////////////////////////////////////////////

/////////////////////////////tables/////////////////////////////////

		maintable.addActor(builderbutton);
		maintable.addActor(playstatbutton);
		maintable.addActor(inventorybutton);




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

	public ImageButton maketestbutton(Drawable drawable, final int x_pos, final int y_pos){
        ImageButton test = new ImageButton(drawable);
        test.setBounds(300 + x_pos*75, 300 + y_pos*75, 50, 50);
        test.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
            	try {
					System.out.println("heio1");
					player.setitem((5 * x_pos + y_pos));
				}
            	catch (NullPointerException e){
            		System.out.println("no item");
				}

            }
        });
        return test;

    }



	public void render(Drawable drawable1, Drawable drawable2, Drawable drawable3, Drawable drawable4,
					   Drawable drawable5, Drawable drawable6, final Player player){
		/////////////////icon1/////////////////////////

		if (player.Inventory.size() > 0) {

			ImageButton icon1 = new ImageButton(drawable);
			icon1.setPosition(100, 1000);
			icon1.setSize(50, 50);
			icon1.addListener(new ClickListener() {
			  @Override
			  public void clicked(InputEvent event, float x, float y) {
				  System.out.println("heio1");
				  player.setitem(0);




			  }
			});
			Image icon = new Image(drawable1);
			icon.setPosition(105, 1005);
			icon.setSize(40,40);
			icontable.removeActor(icon1);
			icontable.addActor(icon1);
			icontable.removeActor(icon);
			icontable.addActor(icon);
			//////////////////////////////////////////////
		}
		/////////////////icon2/////////////////////////

		if (player.Inventory.size() > 1) {

			ImageButton icon2 = new ImageButton(drawable2);
			icon2.setPosition(200, 1000);
			icon2.setSize(50, 50);
			icon2.addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					System.out.println("heio2");
					player.setitem(1);




				}
			});
			Image icon = new Image(drawable2);
			icon.setPosition(205, 1005);
			icon.setSize(40,40);
			icontable.removeActor(icon2);
			icontable.addActor(icon2);
			icontable.removeActor(icon);
			icontable.addActor(icon);

			//////////////////////////////////////////////
		}
		/////////////////icon1/////////////////////////
		if (player.Inventory.size() > 2) {

			ImageButton icon3 = new ImageButton(drawable3);
            icon3.setPosition(300, 1000);
			icon3.setSize(50, 50);
			icon3.addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					System.out.println("heio3");
					player.setitem(2);




				}
			});
			Image icon = new Image(drawable3);
			icon.setPosition(305, 1005);
			icon.setSize(40,40);
			icontable.removeActor(icon3);
			icontable.addActor(icon3);
			icontable.removeActor(icon);
			icontable.addActor(icon);

			//////////////////////////////////////////////
		}
		/////////////////icon1/////////////////////////
		if (player.Inventory.size() > 3) {

			ImageButton icon4 = new ImageButton(drawable4);
			icon4.setPosition(400, 1000);
			icon4.setSize(50, 50);
			icon4.addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					System.out.println("heio4");
					player.setitem(3);




				}
			});
			Image icon = new Image(drawable4);
			icon.setPosition(405, 1005);
			icon.setSize(40,40);
			icontable.removeActor(icon4);
			icontable.addActor(icon4);
			icontable.removeActor(icon);
			icontable.addActor(icon);

			//////////////////////////////////////////////
		}
		/////////////////icon1/////////////////////////
		if (player.Inventory.size() > 4) {

			ImageButton icon5 = new ImageButton(drawable5);
			icon5.setPosition(500, 1000);
			icon5.setSize(50, 50);
			icon5.addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					System.out.println("heio5");
					player.setitem(4);




				}
			});
			Image icon = new Image(drawable5);
			icon.setPosition(505, 1005);
			icon.setSize(40,40);
			icontable.removeActor(icon5);
			icontable.addActor(icon5);
			icontable.removeActor(icon);
			icontable.addActor(icon);

			//////////////////////////////////////////////
		}
		/////////////////icon1/////////////////////////
		if (player.Inventory.size() > 5) {
			
			ImageButton icon6 = new ImageButton(drawable6);
			icon6.setPosition(600, 1000);
			icon6.addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					System.out.println("heio6");
					player.setitem(5);




				}
			});
			Image icon = new Image(drawable6);
			icon.setPosition(605, 1005);
			icon.setSize(40,40);
			icontable.removeActor(icon6);
			icontable.addActor(icon6);
			icontable.removeActor(icon);
			icontable.addActor(icon);

			//////////////////////////////////////////////
		}
		stage.addActor(icontable);


	}



}
