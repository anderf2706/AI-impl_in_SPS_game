package com.game1.huds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.game1.GameScreen;


public class Maingamehud extends Hud {

	public boolean builder = false;
	public boolean playstat = false;
	public Image background;

	public Maingamehud(SpriteBatch spriteBatch, final GameScreen gamescreen) {
		super(spriteBatch, gamescreen);
		background = super.backgrounds;

		this.gamescreen = gamescreen;

////////////////////////////mainhud/////////////////////////////////////////

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


/////////////////////////////////////////////////////////////////////////////

/////////////////////////////tables/////////////////////////////////

		buildertable.addActor(buildbackbutton);

		playstattable.addActor(playstatbackbutton);

		stage.addActor(background);
		stage.addActor(maintable);

////////////////////////////////////////////////////////////////////



	}
}
