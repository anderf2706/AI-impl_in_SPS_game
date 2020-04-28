package com.game1;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Nature implements InputProcessor, Screen, DistanceObjects {
	public Node naturenode;
	public Rectangle the_nature;
	GameScreen gamescreen;
	public Texture texture;
	public int health;
	public Item material;
	public boolean render = false;


	public Nature(int health, Node node, GameScreen gamescreen,int x, int y, int height, int width, Texture texture){
		this.gamescreen = gamescreen;
		this.texture= texture;
		the_nature = new Rectangle();
		the_nature.height = height;
		the_nature.width = width;
		the_nature.x = x - the_nature.width / 2;
		the_nature.y= y;
		naturenode = node;
		node.occupied = true;
		node.mynature = this;
		this.health = health;

		this.gamescreen.nature.add(this);



	}

	public void batch(SpriteBatch batch){
		batch.draw(texture, the_nature.x, the_nature.y, the_nature.width, the_nature.height);
		if (gamescreen.debug) {
			gamescreen.font.draw(gamescreen.game.batch, naturenode.x + " " + naturenode.y,
					naturenode.x, naturenode.y);
		}
	}

	public Integer gety(){
		return this.naturenode.y;
	}

	public void checkrender(){
		for (DistanceObjects object : gamescreen.team_0){
			double ac = Math.abs(object.getY() - this.naturenode.y);
			double cb = Math.abs(object.getX() - this.naturenode.x);

			double h = Math.hypot(ac, cb);
			if (h < 200){
				render = true;
				return;
			}
		}
		render = false;
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
		checkrender();

	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {

	}

	@Override
	public int getX() {
		return this.naturenode.x;
	}

	@Override
	public int getY() {
		return this.naturenode.y;
	}
}
