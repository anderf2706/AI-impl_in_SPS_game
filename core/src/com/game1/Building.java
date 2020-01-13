package com.game1;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.game1.huds.BuildingHud;

public class Building implements InputProcessor, Screen{

	public Node buildingnode;
	public Rectangle the_building;
	GameScreen gamescreen;
	Texture building;
	Texture green;

	
	boolean buildingChosen = false;
	
	BitmapFont font = new BitmapFont();
	
	ArrayList<Node> BNlist = new ArrayList<Node>();

	BuildingHud bhud;

	
	public Building(GameScreen gamescreen, int x, int y, int width, int height) {
		this.gamescreen = gamescreen;
		the_building = new Rectangle();
		the_building.height = height;
		the_building.width = width;
		the_building.x = x - the_building.width / 2;
		the_building.y= y - the_building.height / 2;
			for (Node node : gamescreen.allnodes){
				if(Intersector.overlaps(node.body, the_building)) {
					this.buildingnode = gamescreen.chosenNode;
					node.occupied = true;
				}
			}


		bhud = new BuildingHud(gamescreen.game.batch, gamescreen, this);

		building = new Texture(Gdx.files.internal("bucket.png"));
		green = new Texture(Gdx.files.internal("green.jpg"));
		
		
		this.gamescreen.buildings.add(this);

		
	}
	

	
	public void overlap(int button) {
		if((Intersector.overlaps(gamescreen.the_mouse, the_building))){
			buildingChosen = true;
			System.out.println("player_chosen");
		
		}
		if(!(Intersector.overlaps(gamescreen.the_mouse, the_building)) && (button == Input.Buttons.LEFT)) {
			buildingChosen = false;
			System.out.println("unchosen");
		}
	}
	
	public void destroyed() {
		gamescreen.makenodes();
			
	}

	public void batch(SpriteBatch batch) {
		
		batch.draw(building, the_building.x, the_building.y, the_building.width, the_building.height);
		
		if(buildingChosen) {
			batch.draw(green, the_building.x, the_building.y + 75, 50, 10);
		}
		batch.draw(green, buildingnode.x, buildingnode.y , 10, 10);



	}

	public void UI(float delta){
		if(this.buildingChosen){
			this.bhud.getStage().act(delta); //act the Hud
			this.bhud.getStage().draw(); //draw the Hud
			if(gamescreen.multiplexer.getProcessors().first() != this.bhud.stage) {
				gamescreen.multiplexer.addProcessor(0, this.bhud.stage);
			}


		}
		else{
			this.bhud.dispose();
			if (gamescreen.multiplexer.getProcessors().contains(this.bhud.stage, true)) {
				gamescreen.multiplexer.removeProcessor(gamescreen.multiplexer.getProcessors().indexOf(this
						.bhud.stage, true));
			}
		}
	}





	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void render(float delta) {

		UI(delta);

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



	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		this.overlap(button);
		return false;
	}



	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}



}