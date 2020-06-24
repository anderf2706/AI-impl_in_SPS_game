package com.game1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.game1.buildings.Gate;
import com.game1.huds.BuildingHud;


public class Building implements InputProcessor, Screen, DistanceObjects{

	public Node buildingnode;
	public Rectangle the_building;
	GameScreen gamescreen;
	public Texture building;
	Texture green;
	public boolean render = false;

	
	boolean buildingChosen = false;
	int team;
	
	BitmapFont font = new BitmapFont();
	
	ArrayList<Node> BNlist = new ArrayList<Node>();

	BuildingHud bhud;
	boolean notrun = false;

	int texturewidth;
	int textureheight;
	int texture_x;
	int texture_y;
	
	public Building(GameScreen gamescreen, int x, int y, int width, int height,int texture_x, int texture_y, int texturewidth, int textureheight, int team) {

		this.gamescreen = gamescreen;
		this.team = team;
		the_building = new Rectangle();
		the_building.height = height;
		the_building.width = width;
		this.texturewidth = texturewidth;
		this.textureheight = textureheight;
		this.texture_x = texture_x;
		this.texture_y = texture_y;
		the_building.x = x ;
		the_building.y= y ;
			for (Node node : gamescreen.allnodes){
				if(Intersector.overlaps(node.body, the_building)) {
					this.buildingnode = gamescreen.chosenNode;
						node.occupied = true;
				}
			}
		if (this.team == 0){
			gamescreen.team_0.add(this);
		}
		bhud = new BuildingHud(gamescreen.game.batch, gamescreen, this);
		green = gamescreen.tex.green;
		
		
		this.gamescreen.buildings.add(this);

		if(gamescreen.buildings.size() > 1) {
			Collections.sort(gamescreen.buildings, new INTComparatorBuilding());
		}

		
	}

	public void checkrender(){
		for (DistanceObjects object : gamescreen.team_0){
			double ac = Math.abs(object.getY() - this.buildingnode.y);
			double cb = Math.abs(object.getX() - this.buildingnode.x);

			double h = Math.hypot(ac, cb);
			if (h < 200){
				render = true;
				return;
			}
		}
		render = false;
	}



	public void overlap(int button) {
		if((Intersector.overlaps(gamescreen.the_mouse, the_building))){
			buildingChosen = true;

		}
		if(!(Intersector.overlaps(gamescreen.the_mouse, the_building)) && (button == Input.Buttons.LEFT)) {
			buildingChosen = false;
		}
	}
	
	public void destroyed() throws IOException {
		gamescreen.makenodes();
			
	}

	public Integer gety(){
		return this.buildingnode.y;
	}

	public void batch(SpriteBatch batch) {
		
		batch.draw(building, texture_x, texture_y, texturewidth, textureheight);
		
		if(buildingChosen) {
			batch.draw(green, the_building.x, the_building.y + 75, 50, 10);
		}



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

	public void activate(){
		notrun = true;
	}





	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	protected void generate(){

	}



	@Override
	public void render(float delta) {
		if (this.team == 0){
			UI(delta);
		}
		else {
			checkrender();
		}
		if (notrun){
			generate();
			notrun = false;
		}

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


	@Override
	public int getX() {
		return this.buildingnode.x;
	}

	@Override
	public int getY() {
		return this.buildingnode.y;
	}
}