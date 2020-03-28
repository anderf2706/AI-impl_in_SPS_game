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
     Table table;
     Skin skin;

	public Hud(SpriteBatch spriteBatch, final GameScreen gamescreen) {
		stageViewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		stage = new Stage(stageViewport, spriteBatch); //create stage with the stageViewport and the SpriteBatch given in Constructor
		texture = new Texture(Gdx.files.internal("Fighter-Front.gif"));
		background = new Texture(Gdx.files.internal("brown rectangle.jfif"));
		drawablebackground = new TextureRegionDrawable((new TextureRegion(background)));
		drawable = new TextureRegionDrawable((new TextureRegion(texture)));
		skin = new Skin(Gdx.files.internal("star-solider-ui.json"));
		this.gamescreen = gamescreen;

		table = new Table();
		table.setVisible(true);

		Image background = new Image(drawablebackground);
		background.setPosition(0, 0);
		background.setWidth(Gdx.graphics.getWidth());
		background.setHeight(100);
		background.toBack();

		ImageButton backgroundbutton = new ImageButton(drawablebackground);
		backgroundbutton.setPosition(0, 0);
		backgroundbutton.setSize(1920, 100);
		backgroundbutton.toBack();
		backgroundbutton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {

			}
		});



		stage.addActor(background);
		stage.addActor(backgroundbutton);



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