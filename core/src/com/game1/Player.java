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
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.game1.huds.Playerhud;


public class Player implements Screen, InputProcessor{
	
	public GameScreen gamescreen;
	Game1 game;

	public Timer timer;
	
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

	boolean executed = false;
	boolean colliding = false;
	boolean attacking = false;


	int objectLayerId = 2;
	
	Vector3 playerlocation;
	
    
    ArrayList<Node> finalpath = new ArrayList<Node>();
    
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
	
	int team;
	
	float oldX;
	float oldY;


	Playerhud playerhud;

	public Player(GameScreen gamescreen, Game1 game, int x, int y, int team) {
		this.gamescreen = gamescreen;
		this.game = game;
		this.team = team;

		
		the_player = new Rectangle();


		spritedir = 40;

		future_the_player = new Rectangle();

		astar = new A_star(gamescreen);

		//future_the_player2 = new Rectangle();
		
		playerlocation = new Vector3(0,0,0);
		

		if (team == 0) {
			playerhud = new Playerhud(game.batch, gamescreen, this);
		}



		for (Node node : gamescreen.allnodes){
			if(Intersector.overlaps(node.body, the_player)) {
				this.playerNode = node;
				node.occupied = true;
				break;
			}
		}

		
		gamescreen.players.add(this);

		
	}
	
	public void collision() {
		for (Player player : gamescreen.players){
			if (this.playerNode.adjecent.contains(player.playerNode) && player.team != this.team && !isAttacking && !moving && !following){
				attack(player, 2000);
				isAttacking = true;
			}

		}
	}
	
	
	public void move(final Building building) {
		dush = 0;
		if(dush < finalpath.size()) {
			t = new Timer();

			t.schedule(new TimerTask() {
				@Override
				public void run() {
					// TODO Auto-generated method stub

					move_t(dush);

			    }
			}, (long) (5000/speed), (long)(5000/speed));
			
		}
	}
		
	public void move_t(int b) {
		final Node nextnode = finalpath.get(b);
		t = new Timer();
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








	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub



		if (team == 0) {
			UI(delta);
		}
		  check_player();
		  collision();
		  if (!(moving || following) && endnode != null){

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




		 }
		 if(!Intersector.overlaps(the_player, playerNode.body)) {
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

	
}

