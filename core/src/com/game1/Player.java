package com.game1;

import java.util.*;
import java.util.concurrent.*;

import javax.management.openmbean.TabularData;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.game1.huds.Playerhud;


public class Player implements Screen, InputProcessor, DistanceObjects{
	
	public GameScreen gamescreen;
	Game1 game;

	public Timer timer;

    public Drawable drawable_object1;
	int item1_object_count;

	public Drawable drawable_object2;
	int item2_object_count;

	public Drawable drawable_object3;
	int item3_object_count;

	public Drawable drawable_object4;
	int item4_object_count;

	public Drawable drawable_object5;
	int item5_object_count;

	public Drawable drawable_object6;
	int item6_object_count;


	public Rectangle the_player;
	Rectangle future_the_player;	
	Rectangle future_the_player2;

	Building buildingtarget;
	
	Node endnode;

	public long timerlong;

	public double disttogoal;
	
	int dush = 0;
	int rightnum;
	int leftnum ;
	int upnum;
	int downnum;
	
	public int health;
	public int attack;
	public int defense;

	Timer itemtimer;

	boolean alive = true;

	public Texture spritefront;
	public Texture spritefront2;
	public Texture spriteback;
	public Texture spriteback2;
	public Texture spriteleft;
	public Texture spriteleft2;
	public Texture spriteright;
	public Texture spriteright2;
	public Texture fightsprite;
	
	Vector2 nodeFin;

	int harvestspeed;

	boolean executed = false;
	boolean colliding = false;
	boolean attacking = false;


	int objectLayerId = 2;
	
	Vector3 playerlocation;
	
    
    ArrayList<Node> finalpath = new ArrayList<Node>();
	Set<Item> keys;
    
    Node roadsplit;
    Node finalnode;
	
	public float speed;
	Vector2 direction;
	Vector2 new_direction;
	//Vector2 new_direction2;
	
	float distance;
	
	Timer t;


	public int spritedir;
	
	int i;
	boolean isAttacking = false;
	
	boolean playerChosen = false;
	boolean moving = false;
	boolean following = false;

	A_star astar;

	public Node playerNode;
	int k;

	public boolean render = false;
	
	int team;
	
	float oldX;
	float oldY;


	Playerhud playerhud;

	boolean natureattacking;

	public Item activeitem;

	Nature naturetarget;

	public Hashtable<Item, Integer>Inventory = new Hashtable<Item, Integer>();

	int gold;

	int stone;
	int food;
	int water;

	Actor[] actors;

	public Player(Node node, GameScreen gamescreen, Game1 game, int x, int y, int team) {
		this.gamescreen = gamescreen;
		this.game = game;
		this.team = team;


		
		the_player = new Rectangle();
		the_player.x = x;
		the_player.y = y;

		harvestspeed = 10;

		keys = this.Inventory.keySet();


		spritedir = 40;

		future_the_player = new Rectangle();

		astar = new A_star(gamescreen);

		//future_the_player2 = new Rectangle();
		
		playerlocation = new Vector3(0,0,0);
		

		if (team == 0) {
			playerhud = new Playerhud(game.batch, gamescreen, this);
			gamescreen.team_0.add(this);

		}


		for (Node playernode : gamescreen.allnodes) {
			if (Intersector.overlaps(playernode.body, the_player)) {
				this.playerNode = playernode;
				playernode.occupied = true;
				break;
			}
		}



		
		gamescreen.players.add(this);

		itemchecker();

		
	}

	public void checkrender(){
		for (DistanceObjects object : gamescreen.team_0){
			double ac = Math.abs(object.getY() - this.playerNode.y);
			double cb = Math.abs(object.getX() - this.playerNode.x);

			double h = Math.hypot(ac, cb);
			if (h < 200){
				render = true;
				return;
			}
		}
		render = false;
	}
	
	public void collision() {
		for (Player player : gamescreen.players){
			if (this.playerNode.adjecent.contains(player.playerNode) && player.team != this.team && !isAttacking && !moving && !following){
				attack(player, 2000);
				isAttacking = true;
			}

		}
	}

	public void harvest(final Nature naturetarget){
		System.out.println(naturetarget.health);
		if(t != null){
			t.cancel();
		}
		t = new Timer();

		t.schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (naturetarget.health > 0 ) {
					System.out.println("har");
					harvest_t(naturetarget);
				}
				else{
					naturetarget.naturenode.occupied = false;
					naturetarget.naturenode = null;
					naturetarget.the_nature = null;
					gamescreen.nature.remove(naturetarget);
					naturetarget.dispose();


				}


			}
		}, 0, 5000/harvestspeed);
	}

	public void harvest_t(Nature naturetarget){
		if (!this.Inventory.containsKey(naturetarget.material)){
			this.Inventory.put(naturetarget.material, 1);
		}
		else {
			int mat_num = Inventory.get(naturetarget.material);
			this.Inventory.put(naturetarget.material, mat_num + 1);
		}

		naturetarget.health -= 10;
		System.out.println(naturetarget.health);
	}


	
	
	public void move(final Building building) {
		dush = 0;
		if(dush < finalpath.size() && !executed) {
			if(t != null){
				t.cancel();
			}
			t = new Timer();

			t.schedule(new TimerTask() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					if (dush < finalpath.size()) {
						move_t(dush);
					}
					else{
						t.cancel();
						return;
					}

			    }
			}, 0, (long)(5000/speed));
			
		}
	}
		
	public void move_t(int b) {
		final Node nextnode = finalpath.get(b);
		if (nextnode.id == this.playerNode.id + 1 || nextnode.id == this.playerNode.id + (1+gamescreen.nodewidth)
		|| nextnode.id == this.playerNode.id + (1-gamescreen.nodewidth)){
			if (spritedir == 1){
				spritedir = 10;
			}
			else{
				spritedir = 1;
			}

		}
		else if (nextnode.id == this.playerNode.id - 1 || nextnode.id == this.playerNode.id + ((-1) + gamescreen.nodewidth)
				|| nextnode.id == this.playerNode.id + ((-1) - gamescreen.nodewidth)){
			if (spritedir == 4){
				spritedir = 40;
			}
			else{
				spritedir = 4;
			}
		}
		else if (nextnode.id == this.playerNode.id + gamescreen.nodewidth){
			if (spritedir == 2){
				spritedir = 20;
			}
			else{
				spritedir = 2;
			}
		}
		else if(nextnode.id == this.playerNode.id - gamescreen.nodewidth){
			if (spritedir == 3){
				spritedir = 30;
			}
			else{
				spritedir = 3;
			}
		}


		this.the_player.x = nextnode.x - the_player.width/2;
		this.the_player.y = nextnode.y - the_player.height/2;

		if(colliding) {
				
		}
			
		dush++;
		
	}
	
	
	public void follow(final Player player) {
		dush = 0;
			t = new Timer();

			t.schedule(new TimerTask() {
	
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						follow_t(player);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}


				}
			}, 0, (long) (5000/speed));
			

	}
	
	public void follow_t(Player player) throws InterruptedException {
		if (!this.playerNode.adjecent.contains(player.playerNode)) {
			finalpath = astar.pathfinder(this.playerNode, player.playerNode, player);

			Node nextnode = finalpath.get(1);

			if (nextnode.id == this.playerNode.id + 1 || nextnode.id == this.playerNode.id + (1+gamescreen.nodewidth)
					|| nextnode.id == this.playerNode.id + (1-gamescreen.nodewidth)){
				if (spritedir == 1){
					spritedir = 10;
				}
				else{
					spritedir = 1;
				}

			}
			else if (nextnode.id == this.playerNode.id - 1 || nextnode.id == this.playerNode.id + ((-1) + gamescreen.nodewidth)
					|| nextnode.id == this.playerNode.id + ((-1) - gamescreen.nodewidth)){
				if (spritedir == 4){
					spritedir = 40;
				}
				else{
					spritedir = 4;
				}
			}
			else if (nextnode.id == this.playerNode.id + gamescreen.nodewidth){
				if (spritedir == 2){
					spritedir = 20;
				}
				else{
					spritedir = 2;
				}
			}
			else if(nextnode.id == this.playerNode.id - gamescreen.nodewidth){
				if (spritedir == 3){
					spritedir = 30;
				}
				else{
					spritedir = 3;
				}
			}

			this.the_player.x = finalpath.get(1).x - the_player.width / 2;
			this.the_player.y = finalpath.get(1).y - the_player.width / 2;
		}
		if (this.playerNode.adjecent.contains(player.playerNode) && player.team != this.team && !isAttacking && following){
			attack(player, 0);
			isAttacking = true;
		}
	}

		
		
		
	public void stopmove() {
		t.cancel();

	}





	public void attack(Building building){

	}

	public void attack(final Player player, int delay){
		final Timer tattack = new Timer();

			tattack.schedule(new TimerTask() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					if(player.health > 0 && playerNode.adjecent.contains(player.playerNode)) {
						player.health -= (int)(attack/(player.defense*0.5));
					}
					else {
						tattack.cancel();
						isAttacking = false;
					}

				}
			}, delay, 2000);




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
		// TODO Auto-generated method stub
		return false;
	}
	
	public void overlap(int button) {
		if((Intersector.overlaps(gamescreen.the_mouse, the_player) && button == Input.Buttons.LEFT)) {
			playerChosen = true;

		}

		if(!(Intersector.overlaps(gamescreen.the_mouse, the_player))  && button == Input.Buttons.LEFT) {
			playerChosen = false;
			/*JTextArea jTextArea = new JTextArea();
			jTextArea.append( "Player UnChosen" );

			gamescreen.frame.add( jTextArea );*/
		}
	}




	public boolean touchDown(int screenX, int screenY, int pointer, int button) {



			if(playerChosen) {
                if (button == Input.Buttons.RIGHT) {

                	if (endnode != null) {
					}
                    endnode = gamescreen.chosenNode;
					finalnode = gamescreen.chosenNode;
					isAttacking = false;


					if (executed) {
						t.cancel();
					}
					following = false;
					attacking = false;
 					moving = true;




                    for (Player player : gamescreen.players) {
                        if (Intersector.overlaps(gamescreen.the_mouse, player.the_player)) {
                            Player target = player;
                            following = true;
                            follow(target);

                        }

                    }
                    for (Building building : gamescreen.buildings) {
                        if (Intersector.overlaps(gamescreen.the_mouse, building.the_building)) {
                            this.buildingtarget = building;
                            attacking = true;


                        }


                    }


                    for (Nature nature : gamescreen.nature){
                    	if (Intersector.overlaps(gamescreen.the_mouse, nature.the_nature)) {
                    		this.naturetarget = nature;
                    		natureattacking = true;
                    		endnode = gamescreen.findavailablenode(naturetarget.naturenode);
                    	}
					}


                    if (!following) {


                        if (attacking) {
                            endnode = gamescreen.findavailablenode(buildingtarget.buildingnode);
                        }



                                int k = 0;
                                for (Node node2 : playerNode.adjecent) {
                                    if (!node2.occupied) {
                                        k += 1;
                                    }
                                }
                                if (k == 0){
									finalpath.clear();


								}

                                else{
                                	try {
										finalpath = astar.pathfinder(playerNode, endnode, null);
									}
                                	catch (IndexOutOfBoundsException ignored){
                                		finalpath = astar.pathfinder(playerNode, gamescreen.findavailablenode(endnode), null);

									}
								}



                        move(null);


                        executed = true;
                    }
                }
            }

		return false;
		
	}





	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		overlap(button);
		if((Intersector.overlaps(gamescreen.mousedrag, the_player) && button == Input.Buttons.LEFT)) {
			playerChosen = true;
		}

		executed = false;
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
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
	public void batch(SpriteBatch batch) {
		if (isAttacking){
			spritedir = 4;
		}
		switch (spritedir){
			case 4:
				batch.draw(this.spritefront, this.the_player.x, this.the_player.y, this.the_player.width, this.the_player.height);

				break;
			case 40:
				batch.draw(this.spritefront2, this.the_player.x, this.the_player.y, this.the_player.width, this.the_player.height);
				break;
			case 1:
				batch.draw(this.spriteback, this.the_player.x, this.the_player.y, this.the_player.width, this.the_player.height);

				break;
			case 10:
				batch.draw(this.spriteback2, this.the_player.x, this.the_player.y, this.the_player.width, this.the_player.height);

				break;
			case 2:
				batch.draw(this.spriteright, this.the_player.x, this.the_player.y, this.the_player.width, this.the_player.height);

				break;
			case 20:
				batch.draw(this.spriteright2, this.the_player.x, this.the_player.y, this.the_player.width, this.the_player.height);

				break;
			case 3:
				batch.draw(this.spriteleft, this.the_player.x, this.the_player.y, this.the_player.width, this.the_player.height);

				break;
			case 30:
				batch.draw(this.spriteleft2, this.the_player.x, this.the_player.y, this.the_player.width, this.the_player.height);

				break;
		}
		

		if(playerChosen) {
			batch.draw(gamescreen.green, the_player.x, the_player.y + 75, 50, 10);
			gamescreen.font.draw(batch, "" + health, this.the_player.x + 20, this.the_player.y + 70);
			
			
		}
		

		/*for(Node node : closedlist) {
			batch.draw(green, node.x, node.y, 5, 5);
		}*/
		/*if(gamescreen.chosenNode != playerNode && playerChosen) {	
			for(Node node : finalpath) {
				font.draw(batch, "" + finalpath.indexOf(node), node.x, node.y + 50);
				batch.draw(green, node.x, node.y, 5, 5);
			}
		}*/
			
			/*batch.draw(green, playerNode.right.x, playerNode.right.y, 5, 5);
			batch.draw(green, playerNode.left.x, playerNode.left.y, 5, 5);
			batch.draw(green, playerNode.up.x, playerNode.up.y, 5, 5);
			batch.draw(green, playerNode.down.x, playerNode.down.y, 5, 5);
			*/

		
		
	}

	public void setitem(int num){

		this.activeitem = (Item) this.keys.toArray()[num];
	}

	public void itemchecker(){
		itemtimer = new Timer();
		itemtimer.schedule(new TimerTask() {
			@Override
			public void run() {
				itemchecker_t();

			}
		}, 0, 1000);
	}

	public void itemchecker_t(){

		if (Inventory.size() > 0) {
		/////////////item1//////////////////////////
			Item item1 = (Item) keys.toArray()[0];
			drawable_object1 = new TextureRegionDrawable((new TextureRegion(item1.icon)));
			item1_object_count = this.Inventory.get(item1);
		}
		//////////////////////////////////////////

		if (Inventory.size() > 1) {
			/////////////item1//////////////////////////
			Item item2 = (Item) keys.toArray()[1];
			drawable_object2 = new TextureRegionDrawable((new TextureRegion(item2.icon)));
			item2_object_count = this.Inventory.get(item2);
		}

		if (Inventory.size() > 2) {
			/////////////item1//////////////////////////
			Item item3 = (Item) keys.toArray()[2];
			drawable_object3 = new TextureRegionDrawable((new TextureRegion(item3.icon)));
			item3_object_count = this.Inventory.get(item3);
		}

		if (Inventory.size() > 3) {
			/////////////item1//////////////////////////
			Item item4 = (Item) keys.toArray()[3];
			drawable_object4 = new TextureRegionDrawable((new TextureRegion(item4.icon)));
			item4_object_count = this.Inventory.get(item4);
		}

		if (Inventory.size() > 4) {
			/////////////item1//////////////////////////
			Item item5 = (Item) keys.toArray()[4];
			drawable_object5 = new TextureRegionDrawable((new TextureRegion(item5.icon)));
			item5_object_count = this.Inventory.get(item5);
		}

		if (Inventory.size() > 5) {
			/////////////item1//////////////////////////
			Item item6 = (Item) keys.toArray()[5];
			drawable_object6 = new TextureRegionDrawable((new TextureRegion(item6.icon)));
			item6_object_count = this.Inventory.get(item6);
		}


		this.playerhud.render(drawable_object1, drawable_object2, drawable_object3, drawable_object4,
				drawable_object5, drawable_object6, this);



	}








	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub



		if (team == 0) {
			UI(delta);

		}
		else{
			checkrender();
		}
		if (gamescreen.renderboolean) {
			check_player();
			collision();
		}
	}

	public void UI(float delta){
		if(this.playerChosen){
			this.playerhud.getStage().act(delta); //act the Hud
			this.playerhud.getStage().draw(); //draw the Hud
			if(gamescreen.multiplexer.getProcessors().first() != this.playerhud.stage) {
				gamescreen.multiplexer.addProcessor(0, this.playerhud.stage);
			}
		}
		else {

			this.playerhud.dispose();
			if (gamescreen.multiplexer.getProcessors().contains(this.playerhud.stage, true)) {
				gamescreen.multiplexer.removeProcessor(gamescreen.multiplexer.getProcessors().indexOf(this
				.playerhud.stage, true));
			}
		}
	}
	
	public void check_player() {
		 if (this.health <= 0){
		 	this.playerNode.occupied = false;
		 	this.playerNode = null;
		 	gamescreen.players.remove(this);
		 	return;

		 }


		 /////////////////////check_player///////////////////////////////

		if (natureattacking){
			if (playerNode.adjecent.contains(naturetarget.naturenode)){
				harvest(naturetarget);
				natureattacking = false;
			}
		}


		 //if (this.playerNode)

		 if(!Intersector.overlaps(the_player, this.playerNode.body)) {
		 	  playerNode.occupied = false;

				 for (Node node : gamescreen.allnodes) {

					 if (Intersector.overlaps(node.body, the_player)) {
						 this.playerNode = node;
						 playerNode.occupied = true;

						 break;
					 }
				 }

		  }
		 if (moving || following){
		 	disttogoal = Math.sqrt(Math.pow((endnode.x - playerNode.x), 2)
					 + Math.pow((endnode.y - playerNode.y), 2));
		 }
		 if(t != null && (Intersector.overlaps(endnode.body, this.the_player))) {
				stopmove();
				moving = false;
				executed = false;

			}

		for(Player player : gamescreen.players){
			if (player.playerNode == this.playerNode && !(this == player)){
				Node node;
				if(attacking && !moving){
					node = gamescreen.findavailablenode(buildingtarget.buildingnode);
				}
				else {
					node = gamescreen.findavailablenode(this.playerNode);

				}
				this.playerNode = node;
				this.the_player.x = this.playerNode.x - the_player.width / 2;
				this.the_player.y = this.playerNode.y - the_player.height / 2;
				this.playerNode.occupied = true;

			}

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
		
	}


	@Override
	public int getX() {
		return this.playerNode.x;
	}

	@Override
	public int getY() {
		return this.playerNode.y;
	}
}

