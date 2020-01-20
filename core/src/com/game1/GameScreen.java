package com.game1;

import java.util.*;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import com.game1.huds.Maingamehud;


public class GameScreen extends ApplicationAdapter implements Screen, InputProcessor {

	Rectangle the_mouse;
	Vector2 mouseInWorld2D;
	Vector3 mouseInWorld3D;
	Vector2 start;
	Vector2 end;
	public Node chosenNode;
	float touchX;
	float touchY;

	public int team;

	Rectangle mousedrag;

	boolean makeP = false;
	boolean makeB = false;
	boolean rendersqaureformouse = false;
	boolean A = true;
	boolean W = true;
	boolean S = true;
	boolean D = true;


	float touchdownmouseX;
	float touchdownmouseY;

	Maingamehud MGhud;


	public boolean makeBarracks = false;
	public boolean makeHouse = false;
	public boolean makeWall = false;
	public boolean makeCastle = false;
	boolean menu = false;
	boolean rotate1 = false;
	boolean rotate2 = false;
	boolean nothud = false;

	BitmapFont font;


	public Game1 game;
	OrthographicCamera camera;
	OrthogonalTiledMapRenderer renderer;
	SpriteBatch batch;

	TiledMap map;
	TiledMapTileLayer tilelayer;
	int tileSize;
	int mapWidth;
	int mapHeight;
	AssetManager manager;

	ArrayList<Player> players = new ArrayList<Player>();
	ArrayList<Building> buildings = new ArrayList<Building>();
	ArrayList<Node> allnodes2 = new ArrayList<Node>();

	ShapeRenderer sr;
	ArrayList<ArrayList> dalist;

	float up;
	float down;
	float right;
	float left;
	float viewX;
	float viewY;

	Texture green;
	Texture blue;


	public InputMultiplexer multiplexer;

	ShapeRenderer ss;

	ArrayList<Node> allnodes;
	ArrayList<Node> nodes;
	Map<Integer, Node> nodedict = new HashMap<Integer, Node>();


	int nodewidth;



	public GameScreen(Game1 game) {









		nodewidth = 500;

		mapWidth = 100 * 32;
		mapHeight = 100*32;

		this.game = game;
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		green = new Texture(Gdx.files.internal("green.jpg"));
		blue = new Texture(Gdx.files.internal("blue.png"));

		camera = new OrthographicCamera();
		camera.setToOrtho(false, w, h);
		camera.update();

		nodes = new ArrayList<Node>();

		allnodes = new ArrayList<Node>();
		sr = new ShapeRenderer();
		makenodes();
		font = new BitmapFont();

		MGhud = new Maingamehud(game.batch, this);
		chosenNode = new Node(500, 500, this);

		multiplexer = new InputMultiplexer();
		multiplexer.addProcessor(this);


		ss = new ShapeRenderer();
		/*
		world = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 10000; i++) {
			for (int j = 0; j < 10000; j++) {

			}
		}

		 */


		the_mouse = new Rectangle();
		the_mouse.height = 2;
		the_mouse.width = 2;

		Vector2 mouseInWorld2D = new Vector2();
		Vector3 mouseInWorld3D = new Vector3();
		this.mouseInWorld2D = mouseInWorld2D;
		this.mouseInWorld3D = mouseInWorld3D;

        camera.translate((500*32)/2, (500*32)/2);
        camera.update();



	}







	public Node findavailablenode(Node playerNode){
		ArrayList<ArrayList> available_nodes = new ArrayList<ArrayList>();
		for(Node node : playerNode.closest){
			if(!node.occupied && node.players.size() == 0){
				double key = Math.sqrt(Math.pow((node.x - playerNode.x), 2) + Math.pow((node.y - playerNode.y), 2));
				available_nodes.add(new ArrayList<Object>(Arrays.asList(key, node)));
			}
			if (node.occupied){
				double key = 10000000;
				available_nodes.add(new ArrayList<Object>(Arrays.asList(key, node)));

			}
		}


		System.out.println(available_nodes.size());
		Collections.sort(available_nodes, new Doublecomparator());

		return (Node)available_nodes.get(0).get(1);
	}
	
	public void makenodes() {
		for (int i = 0; i < nodewidth; i += 1) {
			for (int j = 0; j < nodewidth; j += 1) {
				Node node = new Node(i*32, j*32, this);
				allnodes.add(node);
				nodedict.put(node.id, node);


			}
		}

		System.out.println(nodedict.size());
		System.out.println(nodedict.keySet());



		for (Node node : allnodes){
			node.makeClosest(node.id, node.adjecent, false);
			node.makeClosest(node.id, node.closest, true);
			node.makeClosest(node.id + (nodewidth*3), node.closest, true);
			node.makeClosest(node.id - (nodewidth*3), node.closest, true);
			node.makeClosest(node.id + (3), node.closest, true);
			node.makeClosest(node.id - (3), node.closest, true);
			node.makeClosest((node.id + 3) + (nodewidth*3), node.closest, true);
			node.makeClosest((node.id + 3) - (nodewidth*3), node.closest, true);
			node.makeClosest((node.id - 3) + (nodewidth*3), node.closest, true);
			node.makeClosest((node.id - 3) - (nodewidth*3), node.closest, true);






		}
		/*
		outerloop:
		for (Node node : allnodes){

			for (Node node2 : allnodes2) {
				if (node2.x == node.x && node2.y == node.y) {
					continue outerloop;
				}
			}


			allnodes2.add(node);
		}
		allnodes = allnodes2;


		 */




	}
	
	
	
	@Override
	public void show() {
		Gdx.input.setInputProcessor(multiplexer);


		
	}

	@Override
	public void render(float delta) {

		nothud = false;

		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
      
       
        mouseInWorld3D.x = Gdx.input.getX();
		mouseInWorld3D.y = Gdx.input.getY();
		mouseInWorld3D.z = 0;
		camera.unproject(mouseInWorld3D);
		mouseInWorld2D.x = mouseInWorld3D.x;
		mouseInWorld2D.y = mouseInWorld3D.y;
		  
		the_mouse.x = mouseInWorld2D.x;
		the_mouse.y = mouseInWorld2D.y;

		
        viewX = right * 32 + left * 32;
        viewY = up * 32 + down * 32;
        game.batch.setProjectionMatrix(camera.combined);
        camera.translate(viewX, viewY);
        camera.update();
        up = 0;
        down = 0;
        right = 0;
        left = 0;
        camera.translate(viewX, viewY);
        //renderer.setView(camera);
        //renderer.render();
        if(rotate1) {
        	rotate(40);
        }
        if(rotate2) {
        	rotate(-40);
        }

        game.batch.begin();




		for (Node node : allnodes){
			game.batch.draw(blue, node.x, node.y, 32,32);
		}

       
        if(chosenNode != null) {
        	game.batch.draw(green, chosenNode.x - 8, chosenNode.y - 8, 16, 16);


		}

		for(Player player : players) {
		    if(player != null) {
                player.batch(game.batch);

            }
		}

		for(Building building : buildings) {
			building.batch(game.batch);
		}

		if (team != 0){
			Vector3 midscreen = new Vector3(500,500,0);
			font.draw(game.batch, "" + this.team, camera.project(midscreen).x, camera.project(midscreen).y);

		}



		game.batch.end();

		/*

        for (Player player : players){
        	if (player.endnode != null) {
				if (player.endnode.players.size() > 1) {

					int i = 0;
					for (Player innerplayer : player.endnode.players) {
						if (i > 0){
							innerplayer.stopmove();
							innerplayer.endnode = findavailablenode(innerplayer.endnode);
							/*
							try {
								innerplayer.finalpath = innerplayer.astar.pathfinder(innerplayer.playerNode, innerplayer.endnode, null);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}


							innerplayer.move(null);

							innerplayer.playerNode = innerplayer.endnode;
							innerplayer.playerNode.occupied = true;
						}
					}
				}
				player.endnode.players.clear();

			}


		}

		 */

		for(Building building : buildings) {
			building.render(delta);
			if(building.buildingChosen){
				nothud = true;
			}

		}

		for(Player player : players) {
			if (player.health <= 0){
				player = null;
			}
			if (player != null) {
				player.render(delta);
				if (player.playerChosen) {
					nothud = true;
				}
			}

		}
		if (!nothud){
			MGhud.getStage().act(delta); //act the Hud
			MGhud.getStage().draw(); //draw the Hud
			if(multiplexer.getProcessors().first() != MGhud.stage) {
				multiplexer.addProcessor(0, MGhud.stage);
			}

		}
		else{
			MGhud.dispose();
			if (multiplexer.getProcessors().contains(MGhud, true)) {
				multiplexer.removeProcessor(multiplexer.getProcessors().indexOf(MGhud, true));
			}
		}


		// game.batch.setProjectionMatrix(hud.getStage().getCamera().combined); //set the spriteBatch to draw what our stageViewport sees


		if (rendersqaureformouse && Gdx.input.getX() != 0){
			ss.begin(ShapeRenderer.ShapeType.Line);

			ss.rect(touchdownmouseX, 1080 - touchdownmouseY,-(touchdownmouseX - Gdx.input.getX()),((touchdownmouseY) - Gdx.input.getY()));
			ss.end();
		}
		
	  
        
        
        
        
        
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

		 //dispose our hud
	}
	
	public void makeP() {
		try {
			new Player(this, game, findavailablenode(chosenNode).x, findavailablenode(chosenNode).y, team);
			
		}
		catch(Exception e) {
			
		}
				
		
	}
	
	public void makeBarracks() {
		
				for (int i = 0; i < this.buildings.size(); i++) {
					
					if((Intersector.overlaps(new Rectangle(chosenNode.x - 32, chosenNode.y - 32, 64, 64), buildings.get(i).the_building))){
						
						return;
					}
				}
				
				for (Node node : chosenNode.adjecent) {
					if(node == null) {
						return;
					}
					
				}
				new Barracks(this, chosenNode.x, chosenNode.y, team);
		
	}
	
	public void makeHouse() {
		
		for (int i = 0; i < this.buildings.size(); i++) {
			
			if((Intersector.overlaps(new Rectangle(chosenNode.x - 16, chosenNode.y - 16, 32, 32), buildings.get(i).the_building))){
				
				return;
			}
		}
		
		
		if(chosenNode == null) {
			return;
		}
			
		
		new House(this, chosenNode.x, chosenNode.y, team);

	}
	
		public void makeWall() {
			
			for (int i = 0; i < this.buildings.size(); i++) {
				
				if((Intersector.overlaps(new Rectangle(chosenNode.x - 16, chosenNode.y - 16, 32, 32), buildings.get(i).the_building))){
					
					return;
				}
			}
			
			if(chosenNode == null) {
				return;
			}
				
			
			new Wall(this, chosenNode.x, chosenNode.y, team);
	
	}
		
public void makeCastle() {
			
			for (int i = 0; i < this.buildings.size(); i++) {
				
				if((Intersector.overlaps(new Rectangle(chosenNode.x - 64, chosenNode.y - 64, 128, 128), buildings.get(i).the_building))){
					
					return;
				}
			}
			
			if(chosenNode == null && chosenNode.adjecent.contains(null)) {
				return;
			}
				
			
			new Castle(this, chosenNode.x, chosenNode.y, team);
	
	}
		
	
		
		
	public void rotate(int b) {
		camera.rotate(b * Gdx.graphics.getDeltaTime());
	}



	@Override
	public boolean keyDown(int keycode) {

		if(keycode == Input.Keys.M) {
			menu= !menu;
		}

		if(keycode == Input.Keys.D) {
			if(D) {
				right = 1;

				D = false;
				}

		}
		if(keycode == Input.Keys.A) {
			if(A) {
				left = -1;
				A = false;
			}
		}
		if(keycode == Input.Keys.W) {
			if(W) {
				up = 1;
				W = false;
			}
		}
		if(keycode == Input.Keys.S) {
			if(S) {
				down = -1;
				S = false;
			}
		}




		if(keycode == Input.Keys.Q) {
			rotate1 = true;
		}
		if(keycode == Input.Keys.E) {
			rotate2 = true;
		}
		
		if(keycode == Input.Keys.P) {
			
			makeP = !makeP;
		}
		if(keycode == Input.Keys.B) {
			
			makeB = !makeB;

		}
		/*if(makeB) {
			switch(keycode) {
			case 1: keycode = Input.Keys.NUM_1;
			makeBarracks = !makeBarracks;
			break;
			case 2: keycode = Input.Keys.NUM_2;
			makeHouse = !makeHouse;
			break;
			case 3:keycode = Input.Keys.NUM_3;
			makeWall = !makeWall;
			break;
			case 4:keycode = Input.Keys.NUM_4;
			makeCastle = !makeCastle;
			break;
			}
		}*/
		
		for(Player player : players) {
			player.keyDown(keycode);
		}
		for(Building building : buildings) {
			building.keyDown(keycode);
		}      
		return false;
	}


	@Override
	public boolean keyUp(int keycode) {
		switch (keycode){
			case Input.Keys.NUM_1:
				System.out.println("switch");
				team = 1;
				break;
			case Input.Keys.NUM_2:
				team = 2;
				break;
			case Input.Keys.NUM_3:
				team = 3;
				break;
			case Input.Keys.NUM_4:
				team = 4;
				break;

		}


		if(keycode == Input.Keys.D) {
			right = 0;
			D = true;
		}
		if(keycode == Input.Keys.A) {
			left = 0;
			A = true;
		}
			
		if(keycode == Input.Keys.W) {
			up = 0;
			W = true;
		}
		if(keycode == Input.Keys.S) {
			down = 0;
			S = true;
		}
		if(keycode == Input.Keys.Q) {
			rotate1 = false;
		}
		if(keycode == Input.Keys.E) {
			rotate2 = false;
		}
		//player.keyUp(keycode);
		for(Player player : players) {
			player.keyUp(keycode);
		}
		for(Building building : buildings) {
			building.keyUp(keycode);
		}

		return false;
	}


	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub


		return false;
	}


	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {

		System.out.println(the_mouse.x + " " + the_mouse.y);

		if(button == Input.Buttons.LEFT){
			rendersqaureformouse = true;
			touchdownmouseX = Gdx.input.getX();
			touchdownmouseY = Gdx.input.getY();
		}
		
		if(button == Input.Buttons.RIGHT) {
				makeBarracks = false;
				makeHouse = false;
				makeWall = false;
				makeCastle = false;
		}

			
		Rectangle mouserec = new Rectangle(the_mouse.x, the_mouse.y, 1,1);
			for (Node node : allnodes){
				if (Intersector.overlaps(node.body, mouserec)) {
					System.out.println("inne");
					this.chosenNode = node;
				}
			}

			
		for (Player player : players) {
				player.touchDown(screenX, screenY, pointer, button);
		}
		for(Building building : buildings) {
				building.touchDown(screenX, screenY, pointer, button);
		}
			
		if(makeP && button == Input.Buttons.LEFT) {
			makeP();
		}
			
		if(makeBarracks && button == Input.Buttons.LEFT) {
			makeBarracks();
		}
		if(makeHouse && button == Input.Buttons.LEFT) {
			makeHouse();
		}
		if(makeWall && button == Input.Buttons.LEFT) {
			makeWall();
		}
		if(makeCastle && button == Input.Buttons.LEFT) {
			makeCastle();
		}
		for (Player player : players) {
			if (player.playerChosen) {
				if (button == Input.Buttons.RIGHT) {
					if (player.endnode.players.size() > 1){

						player.endnode = findavailablenode(player.endnode);


					}
				}
			}
		}
		return false;
			
	}


	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		rendersqaureformouse = false;

		if(chosenNode != null) {
			if (the_mouse.x > chosenNode.x && the_mouse.y > chosenNode.y) {
				mousedrag = new Rectangle(chosenNode.x, chosenNode.y, the_mouse.x - chosenNode.x,
						the_mouse.y - chosenNode.y);
			}
			if (the_mouse.x < chosenNode.x && the_mouse.y > chosenNode.y) {
				mousedrag = new Rectangle(the_mouse.x, chosenNode.y, chosenNode.x - the_mouse.x,
						the_mouse.y - chosenNode.y);
			}
			if (the_mouse.x < chosenNode.x && the_mouse.y < chosenNode.y) {
				mousedrag = new Rectangle(the_mouse.x, the_mouse.y, chosenNode.x - the_mouse.x,
						chosenNode.y - the_mouse.y);
			}
			if (the_mouse.x > chosenNode.x && the_mouse.y < chosenNode.y) {
				mousedrag = new Rectangle(chosenNode.x, the_mouse.y, the_mouse.x - chosenNode.x,
						chosenNode.y - the_mouse.y);
			}
		}

		// TODO Auto-generated method stub
		for (Player player : players) {
			player.touchUp(screenX, screenY, pointer, button);
			
		}	
		
		for(Building building : buildings) {
			building.touchUp(screenX, screenY, pointer, button);
		}      
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
