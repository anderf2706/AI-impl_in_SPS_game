package com.game1;

import java.io.IOException;
import java.util.*;
import java.util.List;


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
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;


import com.game1.buildings.Barracks;
import com.game1.buildings.Castle;
import com.game1.buildings.House;
import com.game1.buildings.Wall;
import com.game1.huds.Maingamehud;
import com.game1.players.protagonist;


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

	public Player me;


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
	ArrayList<Nature> nature = new ArrayList<Nature>();
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
	Texture grey;
	Texture white;
	Texture beige;



	public InputMultiplexer multiplexer;

	ShapeRenderer ss;

	ArrayList<Node> allnodes;
	ArrayList<Node> nodes;
	Map<Integer, Node> nodedict = new HashMap<Integer, Node>();



	public int nodewidth;
    List<List<Node>> listOfLists;

	public textures tex;

	float[][] noisemap;
	Texture[][] textureoverworld;

	float w;
	float h;
	float zoom;


	public GameScreen(Game1 game) throws IOException {
        listOfLists = new ArrayList<List<Node>>();
        for(int i = 0; i < 64; i++)  {
            listOfLists.add(new ArrayList<Node>());
        }



		zoom = 1;
        nodewidth = 200;

		mapWidth = 100 * 32;
		mapHeight = 100*32;

		this.game = game;
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();



		camera = new OrthographicCamera();
		camera.setToOrtho(false, w/zoom, h/zoom);
		camera.update();

		nodes = new ArrayList<Node>();

		allnodes = new ArrayList<Node>();
		sr = new ShapeRenderer();
		noisemap = generateSimplexNoise(nodewidth, nodewidth);
		settextures();
		makenodes();
		font = new BitmapFont();

		MGhud = new Maingamehud(game.batch, this);


		multiplexer = new InputMultiplexer();
		multiplexer.addProcessor(this);



		ss = new ShapeRenderer();

		the_mouse = new Rectangle();
		the_mouse.height = 2;
		the_mouse.width = 2;

		Vector2 mouseInWorld2D = new Vector2();
		Vector3 mouseInWorld3D = new Vector3();
		this.mouseInWorld2D = mouseInWorld2D;
		this.mouseInWorld3D = mouseInWorld3D;

        camera.translate((nodewidth*32)/2, (nodewidth*32)/2);
        camera.update();


        for (int i = 0; i < 64; i++) {
            for (int j = 0; j < 36; j++) {
                listOfLists.get(i).add(j, nodedict.get(((((nodewidth/2 - 2) + i)*nodewidth)+((nodewidth/2 + 2) + j))));
            }

        }

        me = new protagonist(this, game ,(nodewidth*32)/2, (nodewidth*32)/2, 0);
		chosenNode = allnodes.get(10);


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


		Collections.sort(available_nodes, new Doublecomparator());

		return (Node)available_nodes.get(0).get(1);
	}

	public void settextures(){
		tex = new textures();
		green = tex.green;
		blue = tex.blue;
		grey = tex.grey;
		white = tex.white;
		beige = tex.beige;
	}
	
	public void makenodes() throws IOException {
		for (int i = 0; i < nodewidth; i += 1) {
			for (int j = 0; j < nodewidth; j += 1) {



				Node node = new Node(i*32, j*32, this, noisemap[i][j]);

				allnodes.add(node);
				nodedict.put(node.id, node);



			}
		}

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
		Collections.sort(this.nature, new INTComparatorNature());
		/*
		if(nature.size() > 1) {
			Collections.sort(nature, new Comparator<Nature>() {
				@Override
				public int compare(Nature n1, Nature n2) {
					return compare(n2.naturenode.y, n1.naturenode.y);
				}
			});
		}

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

		for (List<Node> list : listOfLists){
		    for(Node node : list){
					game.batch.draw(node.nodetexture, node.x - 16, node.y - 16, 32, 32);
		    }


        }


        if(chosenNode != null) {
        	game.batch.draw(green, chosenNode.x - 8, chosenNode.y - 8, 16, 16);
			font.draw(game.batch, "" + chosenNode.simplexnoise, chosenNode.x, chosenNode.y);



		}

		for(Player player : players) {
		    if(player != null) {
                player.batch(game.batch);

            }
		}

		for(Building building : buildings) {
			building.batch(game.batch);
		}

		for(Nature nature : nature) {
			nature.batch(game.batch);
		}



		if (team != 0){
			Vector3 midscreen = new Vector3(500,500,0);
			font.draw(game.batch, "" + this.team, camera.project(midscreen).x, camera.project(midscreen).y);

		}


		game.batch.end();

		for(Building building : buildings) {
			building.render(delta);
			if(building.buildingChosen){
				nothud = true;
			}

		}

		for(int i = 0; i<players.size(); i++ ) {
			if (players.get(i).health <= 0){
				players.get(i).playerNode.players.remove(players.get(i));
				players.get(i).playerNode.occupied = false;
				players.remove(players.get(i));
				i -= 1;
			}
		}
		for(Player player2 : players) {
			player2.render(delta);
			if (player2.playerChosen) {
				nothud = true;
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


		if (MGhud.builder){
			MGhud.stage.clear();
			MGhud.stage.addActor(MGhud.background);
			MGhud.stage.addActor(MGhud.buildertable);

		}
		if (MGhud.playstat){
			MGhud.stage.clear();
			MGhud.stage.addActor(MGhud.background);
			MGhud.stage.addActor(MGhud.playstattable);
		}


		// game.batch.setProjectionMatrix(hud.getStage().getCamera().combined); //set the spriteBatch to draw what our stageViewport sees


		if (rendersqaureformouse && Gdx.input.getX() != 0){
			ss.begin(ShapeRenderer.ShapeType.Line);

			ss.rect(touchdownmouseX, 1080 - touchdownmouseY,-(touchdownmouseX - Gdx.input.getX()),((touchdownmouseY) - Gdx.input.getY()));
			ss.end();
		}

	}


	public float[][] generateSimplexNoise(int width, int height){
		SimplexNoise sn = new SimplexNoise();
		float[][]simplexnoise=new float[width][height];
		Random r = new Random();
		double randomfreq = 2 + r.nextDouble() * (8 - 2);
		System.out.println(randomfreq);
		float frequency=(float)randomfreq/(float)width;
		double random = (Math.random() * (10000) + 1);
		for(int x=0;x<width; x++){
			for(int y=0;y<height; y++){
				simplexnoise[x][y]=(float) sn.noise((x+random)*frequency,(y+random)*frequency);
				simplexnoise[x][y]=(simplexnoise[x][y]+1)/2;   //generate values between 0 and 1
			}
		}


		return simplexnoise;
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
			new protagonist(this, game, findavailablenode(chosenNode).x, findavailablenode(chosenNode).y, team);

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

		if (keycode == Input.Keys.ESCAPE){
			this.dispose();
		}

		if(	keycode == Input.Keys.D && (listOfLists.get(listOfLists.size() - 1).get(36-1).id <= nodewidth*(nodewidth - 1))) {
			if(D) {

					right = 1;
					ArrayList<Node> templist = new ArrayList<Node>();
					for (Node node : listOfLists.get(listOfLists.size() - 1)) {

						templist.add(nodedict.get(node.id + 1 * nodewidth));

					}
					listOfLists.add(templist);

					ArrayList<Node> templist2 = new ArrayList<Node>();
					for (Node node : listOfLists.get(listOfLists.size() - 1)) {
						templist2.add(nodedict.get(node.id + 1 * nodewidth));
					}

					listOfLists.add(templist2);


					listOfLists.remove(1);
					listOfLists.remove(0);

					D = false;
				}
					return false;
		}



		if(keycode == Input.Keys.A && (listOfLists.get(1).get(0).id >= 0)) {
			if(A) {
				left = -1;

				ArrayList<Node> templist = new ArrayList<Node>();
				for (Node node : listOfLists.get(0)){
					templist.add(nodedict.get(node.id - nodewidth));
				}

				listOfLists.add(0, templist);

				ArrayList<Node> templist2 = new ArrayList<Node>();
				for (Node node : listOfLists.get(0)){
					templist2.add(nodedict.get(node.id - nodewidth));
				}

				listOfLists.add(0, templist2);



				listOfLists.remove(listOfLists.size() - 2);
				listOfLists.remove(listOfLists.size() - 1);


				A = false;
				return false;
			}
		}
		if(keycode == Input.Keys.W && (listOfLists.get(listOfLists.size() - 1).get(35).id)/
				(listOfLists.get(listOfLists.size() - 1).get(35).y) <= 35){
			if(W) {

				up = 1;
				Node node = nodedict.get(listOfLists.get(0).get(listOfLists.get(0).size() - 1).id + 1);
				Node node2 = nodedict.get(listOfLists.get(0).get(listOfLists.get(0).size() - 1).id + 2);
				for (int i = 0; i < 64; i++) {
					listOfLists.get(i).add(listOfLists.get(i).size(), nodedict.get(node.id + (i * nodewidth)));
					listOfLists.get(i).add(listOfLists.get(i).size(), nodedict.get(node2.id + (i * nodewidth)));
					listOfLists.get(i).remove(1);
					listOfLists.get(i).remove(0);
				}

				W = false;
				return false;
			}
		}
		if(keycode == Input.Keys.S && (listOfLists.get(0).get(0).id)/
				(listOfLists.get(0).get(0).y) >= 1) {
			if(S) {

				down = -1;
				Node node = nodedict.get(listOfLists.get(0).get(0).id - 1);
				Node node2 = nodedict.get(listOfLists.get(0).get(0).id - 2);
				for (int i = 0; i < 64; i++) {
					listOfLists.get(i).add(0, nodedict.get(node.id + (i * nodewidth)));
					listOfLists.get(i).add(0, nodedict.get(node2.id + (i * nodewidth)));
					listOfLists.get(i).remove(listOfLists.get(i).size() - 1);
					listOfLists.get(i).remove(listOfLists.get(i).size() - 1);
				}



				S = false;
				return false;
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





		if(keycode == Input.Keys.SPACE){
			listOfLists = new ArrayList<List<Node>>();
			for(int i = 0; i < 64; i++)  {
				listOfLists.add(new ArrayList<Node>());
			}

			for (int i = 0; i < 64; i++) {
				for (int j = 0; j < 36; j++) {
					listOfLists.get(i).add(j, nodedict.get((me.playerNode.id - ((32*nodewidth) + 18)) + ((i*nodewidth)+ j)));
				}

			}


			camera.position.x = me.the_player.x;
			camera.position.y = me.the_player.y;


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
					this.chosenNode = node;
				}
			}
			/*
		for (int i =0; i<players.size(); i++) {
			if (players.get(i).playerChosen) {
				if (button == Input.Buttons.RIGHT) {
					if (i != 0){
						players.get(i).endnode = findavailablenode(chosenNode);
						players.get(i).endnode.occupied = true;
					}
				}
			}

		}

			 */
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
			makeBarracks = !makeBarracks;
		}
		if(makeHouse && button == Input.Buttons.LEFT) {
			makeHouse();
			makeHouse = !makeHouse;
		}
		if(makeWall && button == Input.Buttons.LEFT) {
			makeWall();
			makeWall = !makeWall;
		}
		if(makeCastle && button == Input.Buttons.LEFT) {
			makeCastle();
			makeCastle = !makeCastle;
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
		/*
		if(keycode == Input.Keys.Z && zoom > 0.3){
			zoom -= 0.1;
			camera.zoom = zoom;

		 */
		if(amount == -1 && zoom > 0.3){
			zoom -= 0.1;
			camera.zoom = zoom;
		}
		if(amount == 1 && zoom < 1){
			zoom += 0.1;
			camera.zoom = zoom;
		}
		return false;



	}

}
