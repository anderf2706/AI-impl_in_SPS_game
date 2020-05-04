package com.game1.huds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.game1.GameScreen;

class Hud extends InputAdapter implements Screen{

	public Stage stage;
	public FitViewport stageViewport;
	 Texture greybutton;
	 Texture empty;
     Drawable drawable;
     Drawable drawablebackground;
     Drawable drawable_invisible;
     Texture background;
     Texture background_top;
     public GameScreen gamescreen;
     public Table maintable;
     public Table buildertable;
     public Table buildingtable;
     public Table playertable;
     public Table playstattable;
     public Table itemtable;
	public Table inventorytable;
	public Table icontable;

	Image backgrounds;
	 Image topbackgrounds;
	 Image inventorybackground;
	 Label Gold;
	 ImageButton inventorybackgroundbutton;
	 ImageButton topbackgroundbutton;
	 ImageButton backgroundbutton;
	Drawable backbutton;

	Skin skin;

	public Hud(SpriteBatch spriteBatch, final GameScreen gamescreen) {
		stageViewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		stage = new Stage(stageViewport, spriteBatch); //create stage with the stageViewport and the SpriteBatch given in Constructor
		greybutton = new Texture(Gdx.files.internal("ui/upd_separeted_png/119.png"));
		empty = new Texture(Gdx.files.internal("Empty.png"));
		background = new Texture(Gdx.files.internal("ui/upd_separeted_png/75.png"));
		background_top = new Texture(Gdx.files.internal("ui/upd_separeted_png/120.png"));

		drawablebackground = new TextureRegionDrawable((new TextureRegion(background)));
		Drawable drawablebackground_top = new TextureRegionDrawable((new TextureRegion(background_top)));
		drawable = new TextureRegionDrawable((new TextureRegion(greybutton)));
		drawable_invisible = new TextureRegionDrawable((new TextureRegion(empty)));
		backbutton = new TextureRegionDrawable((new TextureRegion(new Texture(Gdx.files.internal("ui/upd_separeted_png/34.png")))));

		skin = new Skin(Gdx.files.internal("ui\\skin\\plain-james-ui.json"));
		this.gamescreen = gamescreen;

		maintable = new Table();
		maintable.setVisible(true);

		inventorytable = new Table();
		inventorytable.setVisible(true);

		itemtable = new Table();
		itemtable.setVisible(true);


		buildertable = new Table();
		buildertable.setVisible(true);


		buildingtable = new Table();
		buildingtable.setVisible(true);

		icontable = new Table();
		icontable.setVisible(true);



		playertable = new Table();
		playertable.setVisible(true);


		playstattable = new Table();
		playstattable.setVisible(true);


		backgrounds = new Image(drawablebackground_top);
		backgrounds.setPosition(0, 0);
		backgrounds.setWidth(Gdx.graphics.getWidth());
		backgrounds.setHeight(100);
		backgrounds.toBack();

		backgroundbutton = new ImageButton(drawable_invisible);
		backgroundbutton.setPosition(0, 0);
		backgroundbutton.setWidth(Gdx.graphics.getWidth());
		backgroundbutton.setHeight(100);
		backgroundbutton.toBack();
		backgroundbutton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
			}
		});

		topbackgrounds = new Image(drawablebackground_top);
		topbackgrounds.setPosition(0, 980);
		topbackgrounds.setWidth(Gdx.graphics.getWidth());
		topbackgrounds.setHeight(100);
		topbackgrounds.toBack();

		topbackgroundbutton = new ImageButton(drawable_invisible);
		topbackgroundbutton.setPosition(0, 980);
		topbackgroundbutton.setWidth(Gdx.graphics.getWidth());
		topbackgroundbutton.setHeight(100);
		topbackgroundbutton.toBack();
		topbackgroundbutton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
			}
		});

		/*
		Gold = new Label("Gold: " + gamescreen.gold, skin);
		Gold.setPosition(1700, 1030);

		 */

		inventorybackground = new Image(drawablebackground);
		inventorybackground.setPosition(100, 200);
		inventorybackground.setWidth(Gdx.graphics.getWidth() - 200);
		inventorybackground.setHeight(980 -300);
		inventorybackground.toBack();

		inventorybackgroundbutton = new ImageButton(drawable_invisible);
		inventorybackgroundbutton.setPosition(100, 200);
		inventorybackgroundbutton.setWidth(Gdx.graphics.getWidth() - 200);
		inventorybackgroundbutton.setHeight(980 -300);
		inventorybackgroundbutton.toBack();
		inventorybackgroundbutton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
			}
		});







		stage.addActor(backgrounds);
		stage.addActor(backgroundbutton);
		stage.addActor(topbackgrounds);
		stage.addActor(topbackgroundbutton);


	}

	public Stage getStage() { return stage; }

	public void dispose(){
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		//Gdx.input.setInputProcessor(this);


		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
}