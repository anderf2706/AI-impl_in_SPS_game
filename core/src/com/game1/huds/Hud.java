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

	Image backgrounds;
	 Image topbackgrounds;
	 Label Gold;

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

		itemtable = new Table();
		itemtable.setVisible(true);


		buildertable = new Table();
		buildertable.setVisible(true);


		buildingtable = new Table();
		buildingtable.setVisible(true);


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
		topbackgrounds.setPosition(0, 1030);
		topbackgrounds.setWidth(Gdx.graphics.getWidth());
		topbackgrounds.setHeight(50);
		topbackgrounds.toBack();

		/*
		Gold = new Label("Gold: " + gamescreen.gold, skin);
		Gold.setPosition(1700, 1030);

		 */




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


		stage.addActor(backgrounds);
		stage.addActor(topbackgrounds);
		stage.addActor(backgroundbutton);
		stage.addActor(itemtable);


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