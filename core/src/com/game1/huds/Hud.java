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
	 Texture texture;
     Drawable drawable;
     Drawable drawablebackground;
     Texture background;
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

	Skin skin;

	public Hud(SpriteBatch spriteBatch, final GameScreen gamescreen) {
		stageViewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		stage = new Stage(stageViewport, spriteBatch); //create stage with the stageViewport and the SpriteBatch given in Constructor
		texture = new Texture(Gdx.files.internal("sprites/man1/man1_fr1.gif"));
		background = new Texture(Gdx.files.internal("brown rectangle.jfif"));
		drawablebackground = new TextureRegionDrawable((new TextureRegion(background)));
		drawable = new TextureRegionDrawable((new TextureRegion(texture)));
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


		backgrounds = new Image(drawablebackground);
		backgrounds.setPosition(0, 0);
		backgrounds.setWidth(Gdx.graphics.getWidth());
		backgrounds.setHeight(100);
		backgrounds.toBack();

		topbackgrounds = new Image(drawablebackground);
		topbackgrounds.setPosition(0, 980);
		topbackgrounds.setWidth(Gdx.graphics.getWidth());
		topbackgrounds.setHeight(100);
		topbackgrounds.toBack();

		/*
		Gold = new Label("Gold: " + gamescreen.gold, skin);
		Gold.setPosition(1700, 1030);

		 */

		inventorybackground = new Image(drawablebackground);
		inventorybackground.setPosition(100, 200);
		inventorybackground.setWidth(Gdx.graphics.getWidth() - 200);
		inventorybackground.setHeight(980 -300);
		inventorybackground.toBack();

		inventorybackgroundbutton = new ImageButton(drawable);
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
		stage.addActor(topbackgrounds);


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