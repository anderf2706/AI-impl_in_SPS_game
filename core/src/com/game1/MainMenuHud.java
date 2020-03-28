package com.game1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.io.IOException;


public class MainMenuHud extends InputAdapter implements Screen{
	
	
	public static Stage stage;
	public FitViewport stageViewport;
	 Texture texture;
     Drawable drawable;
     Drawable drawablebackground;
     Texture background;
     Game1 game;
     GameScreen gamescreen;
     Table table;
     MainMenu mainmenu;
	 Skin skin;


	public MainMenuHud(SpriteBatch spriteBatch, final Game1 game, final MainMenu mainmenu) {
		stageViewport = new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
	    stage = new Stage(stageViewport, spriteBatch); //create stage with the stageViewport and the SpriteBatch given in Constructor
		skin = new Skin(Gdx.files.internal("ssu.json"));
	    background = new Texture(Gdx.files.internal("Hjm8sUt.png"));
	    drawablebackground = new TextureRegionDrawable((new TextureRegion(background)));
	    this.game = game;
	    //this.gamescreen = new GameScreen(game);
	   // this.MPSS = new MultiplayerStartScreen(game);
	    this.mainmenu = mainmenu;
	    

	    table = new Table();
	    table.setVisible(true);


		Button textbutton = new TextButton("singelplayer", skin);
		textbutton.setPosition(Gdx.graphics.getWidth() / 2, 900);
		textbutton.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				try {
					gamescreen = new GameScreen(game);
				} catch (IOException e) {
					e.printStackTrace();
				}

				game.setScreen(gamescreen);
				mainmenu.dispose();
			};
		});


		Button textbutton2 = new TextButton("multiplayer", skin);
		textbutton2.setPosition(Gdx.graphics.getWidth() / 2 + 5, 800);
		textbutton2.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {

			};
		});

		Button textbutton3 = new TextButton("settings", skin);
		textbutton3.setPosition(Gdx.graphics.getWidth() / 2 + 15, 700);
		textbutton3.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {

			};
		});

		Button textbutton4 = new TextButton("exit", skin);
		textbutton4.setPosition(Gdx.graphics.getWidth() / 2 + 25, 600);
		textbutton4.addListener( new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.dispose();
			};
		});

		Image background = new Image(drawablebackground);
		background.setPosition(0, 0);
		background.setWidth(Gdx.graphics.getWidth());
		background.setHeight(Gdx.graphics.getHeight());
		background.toBack();


       
              	
        table.addActor(textbutton);
        table.addActor(textbutton2);
        table.addActor(textbutton3);
        table.addActor(textbutton4);
		stage.addActor(background);
        stage.addActor(table);
        //stage.addActor(imageButton2);
	}
	
	public Stage getStage() { return stage; }
	


	

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
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

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
		
	}
	
	
	
	

}
