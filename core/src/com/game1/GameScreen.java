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


import com.game1.biomes.Desert;
import com.game1.biomes.Forest_temp;
import com.game1.biomes.Rainforest;
import com.game1.biomes.Tundra;
import com.game1.buildings.*;
import com.game1.huds.Maingamehud;
import com.game1.players.animals.cow;
import com.game1.players.footenemy;
import com.game1.players.protagonist;

import javax.print.attribute.standard.Sides;


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
	public boolean renderboolean = true;


	float touchdownmouseX;
	float touchdownmouseY;

	public ArrayList<ArrayList<Node>> AIList = new ArrayList<ArrayList<Node>>();
	public ArrayList<Node> cows = new ArrayList<Node>();

	Maingamehud MGhud;

	public Player me;


	public boolean makeBarracks = false;
	public boolean makeHouse = false;
	public boolean makeWall = false;
	public boolean makeCastle = false;
	public boolean makeGate = false;
	boolean menu = false;
	boolean rotate1 = false;
	boolean rotate2 = false;
	boolean nothud = false;

	public BitmapFont font;


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
	ArrayList<DistanceObjects> team_0 = new ArrayList<DistanceObjects>();
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
	Texture grass;
	Texture rock;
	Texture dirt;
	Texture snow;
	Texture sand;
	Texture watertexture;

	int startposx;
	int startposy;



	public InputMultiplexer multiplexer;

	ShapeRenderer ss;

	ArrayList<Node> allnodes;
	ArrayList<Node> nodes;
	Map<Integer, Node> nodedict = new HashMap<Integer, Node>();

	public Item wood;
	public Item stone;
	public Item stick;
	public Item water;


	public int nodewidth;
    List<List<Node>> listOfLists;

	public textures tex;

	float[][] noisemap;

	Texture[][] textureoverworld;

	float w;
	float h;
	float zoom;
	int cmerasafe_x;

	public Forest_temp forest_temp;
	public Desert desert;
	public Tundra tundra;
	public Rainforest rainforest;

	int games_i;
	int games_j;
	boolean changescene = false;

	int cmerasafe_x_max;
	int cmerasafe_x_min;

	int memovement_x = 0;
	int memovement_y = 0;

	boolean debug = false;
	boolean cameraonplayer = false;

	public GameScreen(Game1 game, Player startme, int nodewidth, int startposx, int startposy, int games_i, int games_j) throws IOException {
		game.games[games_i][games_j] = this;
		this.games_i = games_i;
		this.games_j = games_j;
        listOfLists = new ArrayList<List<Node>>();
        for(int i = 0; i < 64; i++)  {
            listOfLists.add(new ArrayList<Node>());
        }
		settextures();

        this.nodewidth = nodewidth;

        this.startposx = startposx;
        this.startposy = startposy;

        makeItems();
		makebiomes();

		mapWidth = nodewidth * 32;
		mapHeight = nodewidth *32;



		this.game = game;
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();




		zoom = (float) 1.5;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, w/(zoom), h/(zoom));
		camera.update();

		nodes = new ArrayList<Node>();

		allnodes = new ArrayList<Node>();
		sr = new ShapeRenderer();
		noisemap = generateSimplexNoise((float) 0.5, nodewidth, nodewidth, 4, 4);

		font = new BitmapFont();

		MGhud = new Maingamehud(game.batch, this);


		multiplexer = new InputMultiplexer();
		multiplexer.addProcessor(this);



		ss = new ShapeRenderer();

		the_mouse = new Rectangle();
		the_mouse.height = 1;
		the_mouse.width = 1;


		makenodes();
		if (startme != null) {
			me = new protagonist(startme, null, this, game, startposx, startposy);
		}
		else {
			me = new protagonist(null, null, this, game, startposx, startposy);

		}


		Vector2 mouseInWorld2D = new Vector2();
		Vector3 mouseInWorld3D = new Vector3();
		this.mouseInWorld2D = mouseInWorld2D;
		this.mouseInWorld3D = mouseInWorld3D;


        camera.translate((nodewidth*32)/2, (nodewidth*32)/2);
        camera.update();

        chosenNode = allnodes.get(10);

		for (int i = 0; i < 64; i++) {
			for (int j = 0; j < 37; j++) {
				listOfLists.get(i).add(j, nodedict.get((me.playerNode.id - ((32*nodewidth) + 18)) + ((i*nodewidth)+ j)));


			}

		}
        System.out.println(nodedict.size());
		camera.position.x = me.the_player.x;
		camera.position.y = me.the_player.y;

		this.fixborder();
	}

	public void makebiomes(){
		forest_temp = new Forest_temp(this);
		desert = new Desert(this);
		tundra = new Tundra(this);
		rainforest = new Rainforest(this);
	}



	public void makeItems(){
		wood = new Item(this, this.tex.barrel);
		stone = new Item(this, this.tex.grasslandstone1);
		stick = new Item(this, this.tex.barrentree);
		water = new Item(this, this.tex.water);
	}



	public void fixborder(){
		if (listOfLists.get(0).get(0) != null) {
			cmerasafe_x = listOfLists.get(0).get(0).x;
			cmerasafe_x_max = nodewidth * 32 - 64 * 32;
			cmerasafe_x_min = 0;
		}
		else if(listOfLists.get(0).get(36) != null){
			cmerasafe_x = listOfLists.get(0).get(36).x;
			cmerasafe_x_max = nodewidth * 32 - 64 * 32;
			cmerasafe_x_min = 0;
		}
		else if(listOfLists.get(listOfLists.size()-1).get(0) != null){
			cmerasafe_x = listOfLists.get(listOfLists.size()-1).get(0).x;
			cmerasafe_x_max = nodewidth*32;
			cmerasafe_x_min = 32*64;
		}

		else{
			cmerasafe_x = listOfLists.get(listOfLists.size()-1).get(36).x;
			cmerasafe_x_max = nodewidth*32;
			cmerasafe_x_min = 32*64;
		}


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

	public void settextures() throws IOException {
		tex = new textures();
		green = tex.green;
		blue = tex.blue;
		grey = tex.grey;
		white = tex.white;
		beige = tex.beige;
		grass = tex.grass;
		watertexture = tex.water;
		rock = tex.rock;
		sand = tex.sand;
		snow = tex.snow;
		dirt = tex.dirt;
	}
	
	public void makenodes() throws IOException {
		for (int i = 0; i < nodewidth; i += 1) {
			for (int j = 0; j < nodewidth; j += 1) {



				Node node = new Node(i*32, j*32, this, noisemap[i][j],
						game.humiditymap[i*(this.games_i)][j*(this.games_j)]);

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

			node.addmeaning();
		}
		Collections.sort(this.nature, new INTComparatorNature());



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
		    	if (node != null) {
		    		node.checkrender();
		    		if (node.render || debug){
						game.batch.draw(node.nodetexture, node.x - 16, node.y - 16, 32, 32);

		    		}

		    	}

		    }


        }


		for (int j = 36; j >= 0; j--) {
			for (int i = 0; i < 64; i++) {
				if (listOfLists.get(i).get(j) != null && this.nature.contains(listOfLists.get(i).get(j).mynature)) {
					if (listOfLists.get(i).get(j).mynature != null && listOfLists.get(i).get(j).mynature.render || debug) {
						listOfLists.get(i).get(j).mynature.batch(game.batch);
					}
				}
				if (listOfLists.get(i).get(j) != null){
					for (Player player : this.players){
						if (player.playerNode == listOfLists.get(i).get(j)
								&& listOfLists.get(i).get(j).render || debug){
							if (player == me){
								if (memovement_y == 1){
									me.spritedir = 1;

								}
								else if(memovement_y == -1){
									me.spritedir = 4;

								}
								else if (memovement_x == 1){
									me.spritedir = 2;


								}
								else if(memovement_x == -1){
									me.spritedir = 3;

								}
							}
							player.batch(game.batch);
						}
					}
				}
				if (listOfLists.get(i).get(j) != null && listOfLists.get(i).get(j).mynature == null){
					for (Building building : this.buildings){
						if (building.buildingnode == listOfLists.get(i).get(j)
								&& listOfLists.get(i).get(j).render || debug){
							building.batch(game.batch);
						}
					}
				}
			}
		}

		for (List<Node> list : listOfLists){
			for(Node node : list){
				if (node != null) {
					if (node.occupied && debug){
						game.batch.draw(green, node.x -10, node.y - 10, 20, 20);

					}
				}

			}

		}


		if(chosenNode != null) {
        	game.batch.draw(green, chosenNode.x - 8, chosenNode.y - 8, 16, 16);
			font.draw(game.batch, chosenNode.x + " " + chosenNode.y + " " + chosenNode.humidity, chosenNode.x, chosenNode.y);




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

		for (Nature nature : this.nature){
			nature.render(delta);
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
		if (cameraonplayer) {

		    me.the_player.x += memovement_x * 16*3 * Gdx.graphics.getDeltaTime();
		    me.the_player.y += memovement_y * 16*3 * Gdx.graphics.getDeltaTime();

			listOfLists = new ArrayList<List<Node>>();
			for (int i = 0; i < 64; i++) {
				listOfLists.add(new ArrayList<Node>());
			}

			for (int i = 0; i < 64; i++) {
				for (int j = 0; j < 37; j++) {
					listOfLists.get(i).add(j, nodedict.get((me.playerNode.id - ((32 * nodewidth) + 18)) + ((i * nodewidth) + j)));
				}

			}

			fixborder();
			camera.position.x = me.the_player.x;
			camera.position.y = me.the_player.y;
		}



	}


	public float[][] generateSimplexNoise(float hairyfactor, int width, int height, double min, double max){
		SimplexNoise sn = new SimplexNoise();
		float[][]simplexnoise=new float[width][height];
		Random r = new Random();
		double randomfreq = min + r.nextDouble() * (max - min);
		System.out.println(randomfreq);
		float frequency=(float)randomfreq/(float)width;
		double random = (Math.random() * (10000) + 1);
		for(int x=0;x<width; x++){
			for(int y=0;y<height; y++){
				simplexnoise[x][y]=(float) sn.noise( hairyfactor, (x+random)*frequency,(y+random)*frequency);
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
			new protagonist(null, null, this, game, findavailablenode(chosenNode).x, findavailablenode(chosenNode).y);

		}
		catch(Exception e) {

		}


	}

	public void makeBarracks() {

				for (int i = 0; i < this.buildings.size(); i++) {

					if((Intersector.overlaps(new Rectangle(chosenNode.x - 48, chosenNode.y - 48, 96, 96), buildings.get(i).the_building))){

						return;
					}
				}
				for (int i = 0; i < this.nature.size(); i++) {

					if((Intersector.overlaps(new Rectangle(chosenNode.x - 48, chosenNode.y - 48, 96, 96), nature.get(i).the_nature))){

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
		for (int i = 0; i < this.nature.size(); i++) {

			if((Intersector.overlaps(new Rectangle(chosenNode.x - 32, chosenNode.y - 32, 64, 64), nature.get(i).the_nature))){

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
			for (int i = 0; i < this.nature.size(); i++) {

				if((Intersector.overlaps(new Rectangle(chosenNode.x - 16, chosenNode.y - 16, 32, 32), nature.get(i).the_nature))){

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
	for (int i = 0; i < this.nature.size(); i++) {

		if((Intersector.overlaps(new Rectangle(chosenNode.x - 64, chosenNode.y - 64, 128, 128), nature.get(i).the_nature))){

			return;
		}
	}

			if(chosenNode == null && chosenNode.adjecent.contains(null)) {
				return;
			}


			new Castle(this, chosenNode.x, chosenNode.y, team);

	}

	public void makeGate() {
		for (int i = 0; i < this.buildings.size(); i++) {

			if((Intersector.overlaps(new Rectangle(chosenNode.x - 16, chosenNode.y - 16, 32, 32), buildings.get(i).the_building))){

				return;
			}
		}
		for (int i = 0; i < this.nature.size(); i++) {

			if((Intersector.overlaps(new Rectangle(chosenNode.x - 16, chosenNode.y - 16, 32, 32), nature.get(i).the_nature))){

				return;
			}
		}


		new Gate(this, chosenNode.x, chosenNode.y, team);

	}




	public void rotate(int b) {
		camera.rotate(b * Gdx.graphics.getDeltaTime());
	}




	@Override
	public boolean keyDown(int keycode) {

		if (keycode == Input.Keys.ESCAPE){
			Gdx.app.exit();
		}
		if (keycode == Input.Keys.ENTER ) {
			/////////////////////right/////////////////////////////
			if (me.playerNode.x == 6368) {
				if (game.games[this.games_i + 1][this.games_j] == null) {
					try {
						game.setScreen(new GameScreen(game, me, nodewidth, 0, this.me.playerNode.y, this.games_i + 1, this.games_j));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else{
					game.games[this.games_i + 1][this.games_j].me.playerNode.x = 0;
					game.games[this.games_i + 1][this.games_j].me.playerNode.y = this.me.playerNode.y;
					game.setScreen(game.games[this.games_i + 1][this.games_j]);

				}
			}
			/////////////////////////////////////////////////////////

			//////////////////////left//////////////////////////
			if (me.playerNode.x == 0){
				if (game.games[this.games_i - 1][this.games_j] == null) {
					try {
						game.setScreen(new GameScreen(game, me, nodewidth, 6368, this.me.playerNode.y, this.games_i - 1, this.games_j));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else{
					game.games[this.games_i - 1][this.games_j].me.playerNode.x = 6368;
					game.games[this.games_i - 1][this.games_j].me.playerNode.y = this.me.playerNode.y;
					game.setScreen(game.games[this.games_i - 1][this.games_j]);

				}
			}
			///////////////////////////////////////////////////////


			////////////////////////////down////////////////////////////
			if (me.playerNode.y == 0){
				if (game.games[this.games_i][this.games_j - 1] == null) {
					try {
						game.setScreen(new GameScreen(game, me, nodewidth, this.me.playerNode.x, 6368, this.games_i, this.games_j - 1));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else{
					game.games[this.games_i][this.games_j - 1].me.playerNode.x = this.me.playerNode.x;
					game.games[this.games_i][this.games_j - 1].me.playerNode.y = 6368;
					game.setScreen(game.games[this.games_i][this.games_j - 1]);

				}
			}
			//////////////////////////////////////////////////////////////


			////////////////////////////up////////////////////////////
			if (me.playerNode.y == 6368){
				if (game.games[this.games_i][this.games_j + 1] == null) {
					try {
						game.setScreen(new GameScreen(game, me, nodewidth, this.me.playerNode.x, 0, this.games_i, this.games_j + 1));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else{
					game.games[this.games_i][this.games_j + 1].me.playerNode.x = this.me.playerNode.x;
					game.games[this.games_i][this.games_j + 1].me.playerNode.y = 0;
					game.setScreen(game.games[this.games_i][this.games_j + 1]);

				}
			}
			///////////////////////////////////////////////////////////

		}

		//&& listOfLists.get(listOfLists.size() - 1).get(37 - 1).id <= nodewidth*(nodewidth - 1)
		if(	keycode == Input.Keys.D) {
			if (cameraonplayer){
				for (Node node : me.playerNode.adjecent){
					if (node.id == me.playerNode.id + nodewidth){
						if (!node.occupied){
							memovement_x = 1;
							me.moving = true;
						}
					}
				}
			}
			else {
				if (D) {
					renderboolean = true;
					right = 1;
					cmerasafe_x += 64;

					ArrayList<Node> templist = new ArrayList<Node>();
					Node node1;
					System.out.println(cmerasafe_x);
					if (cmerasafe_x <= cmerasafe_x_max) {
						for (Node node : listOfLists.get(listOfLists.size() - 1)) {
							node1 = nodedict.get(node.id + nodewidth);
							templist.add(node1);
						}

					} else {
						for (int i = 0; i < 37; i++) {
							node1 = null;
							templist.add(node1);
						}
					}

					listOfLists.add(listOfLists.size(), templist);

					ArrayList<Node> templist2 = new ArrayList<Node>();
					Node node2;
					System.out.println(cmerasafe_x);
					if (cmerasafe_x <= cmerasafe_x_max) {
						for (Node node : listOfLists.get(listOfLists.size() - 1)) {
							node2 = nodedict.get(node.id + nodewidth);
							templist2.add(node2);
						}
					} else {
						for (int i = 0; i < 37; i++) {
							node2 = null;
							templist2.add(node2);
						}

					}

					listOfLists.add(templist2);


					listOfLists.remove(1);
					listOfLists.remove(0);

					D = false;

				}
			}



		}


		// && listOfLists.get(0).get(0).id >= nodewidth
		if(keycode == Input.Keys.A) { // 32
			if (cameraonplayer){
                memovement_x = -1;
                me.moving = true;
			}
			else {
				if (A) {
					left = -1;
					cmerasafe_x -= 64;
					System.out.println(cmerasafe_x);
					ArrayList<Node> templist = new ArrayList<Node>();
					Node node1;
					if (cmerasafe_x >= cmerasafe_x_min) {
						for (Node node : listOfLists.get(0)) {
							node1 = nodedict.get(node.id - nodewidth);
							templist.add(node1);

						}
					} else {
						for (int i = 0; i < 37; i++) {
							node1 = null;
							templist.add(node1);
						}
					}

					listOfLists.add(0, templist);

					ArrayList<Node> templist2 = new ArrayList<Node>();
					Node node2;
					if (cmerasafe_x >= cmerasafe_x_min) {
						for (Node node : listOfLists.get(0)) {
							node2 = nodedict.get(node.id - nodewidth);
							templist2.add(node2);

						}
					} else {
						for (int i = 0; i < 37; i++) {
							node2 = null;
							templist2.add(node2);
						}
					}

					listOfLists.add(0, templist2);


					listOfLists.remove(listOfLists.size() - 2);
					listOfLists.remove(listOfLists.size() - 1);


					A = false;
				}
			}


		}
		// && cmerasafe_y + 34 < nodewidth
		if(keycode == Input.Keys.W){//6368
			if (cameraonplayer){
				memovement_y = 1;
				me.moving = true;
			}
			else {
				if (W) {

					up = 1;
					Node node;
					Node node2;

					try {
						node = nodedict.get(listOfLists.get(0).get(listOfLists.get(0).size() - 1).id + 1);
						node2 = nodedict.get(listOfLists.get(0).get(listOfLists.get(0).size() - 1).id + 2);
						for (int i = 0; i < 64; i++) {
							listOfLists.get(i).add(listOfLists.get(i).size(), nodedict.get(node.id + (i * nodewidth)));
							listOfLists.get(i).add(listOfLists.get(i).size(), nodedict.get(node2.id + (i * nodewidth)));
							listOfLists.get(i).remove(1);
							listOfLists.get(i).remove(0);
						}
					} catch (NullPointerException e) {
						up = 0;
					}

					W = false;
				}
			}

		}
		// && cmerasafe_y - 1  > 1
		if(keycode == Input.Keys.S) { //32
			if (cameraonplayer){
                memovement_y = -1;
                me.moving= true;
			}
			else {
				if (S) {

					Node node;
					Node node2;
					down = -1;
					try {
						node = nodedict.get(listOfLists.get(0).get(0).id - 1);
						node2 = nodedict.get(listOfLists.get(0).get(0).id - 2);
						for (int i = 0; i < 64; i++) {
							listOfLists.get(i).add(0, nodedict.get(node.id + (i * nodewidth)));
							listOfLists.get(i).add(0, nodedict.get(node2.id + (i * nodewidth)));
							listOfLists.get(i).remove(listOfLists.get(i).size() - 1);
							listOfLists.get(i).remove(listOfLists.get(i).size() - 1);
						}
					} catch (NullPointerException e) {
						down = 0;
					}
					S = false;
				}
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
		if (keycode == Input.Keys.C){
			cameraonplayer = !cameraonplayer;
		}





		if(keycode == Input.Keys.SPACE){
			listOfLists = new ArrayList<List<Node>>();
			for(int i = 0; i < 64; i++)  {
				listOfLists.add(new ArrayList<Node>());
			}

			for (int i = 0; i < 64; i++) {
				for (int j = 0; j < 37; j++) {
					listOfLists.get(i).add(j, nodedict.get((me.playerNode.id - ((32*nodewidth) + 18)) + ((i*nodewidth)+ j)));
				}

			}



			fixborder();
			System.out.println("yee boy");


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
		    memovement_x = 0;
			right = 0;
			D = true;
			me.moving = false;
		}
		if(keycode == Input.Keys.A) {
		    memovement_x = 0;
			left = 0;
			A = true;
			me.moving = false;
		}
			
		if(keycode == Input.Keys.W) {
		    memovement_y = 0;
			up = 0;
			W = true;
			me.moving = false;
		}
		if(keycode == Input.Keys.S) {
		    memovement_y = 0;
			down = 0;
			S = true;
			me.moving = false;
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
				makeGate = false;
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
		}
		if(makeCastle && button == Input.Buttons.LEFT) {
			makeCastle();
			makeCastle = !makeCastle;
		}
		if (makeGate && button == Input.Buttons.LEFT){
			makeGate();
			makeGate = !makeGate;
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
			System.out.println(zoom);
		}
		if(amount == 1 && zoom < 1){
			zoom += 0.1;
			camera.zoom = zoom;
		}
		return false;



	}

}
