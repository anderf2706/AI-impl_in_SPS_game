package com.game1;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import java.util.Collections;
import java.util.Comparator;

public class Nature implements InputProcessor, Screen {

	public Node naturenode;
	public Rectangle the_nature;
	GameScreen gamescreen;
	public Texture texture;
	public int health;
	public Item material;

	public Nature(Node node, GameScreen gamescreen,int x, int y, int height, int width){
		this.gamescreen = gamescreen;

		the_nature = new Rectangle();
		the_nature.height = height;
		the_nature.width = width;
		the_nature.x = x - the_nature.width / 2;
		the_nature.y= y;
		this.naturenode = node;
		node.occupied = true;
		this.gamescreen.nature.add(this);

	}

	public void batch(SpriteBatch batch){
		batch.draw(texture, the_nature.x, the_nature.y, the_nature.width, the_nature.height);

	}

	public Integer gety(){
		return this.naturenode.y;
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

}
