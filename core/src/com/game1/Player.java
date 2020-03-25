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
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.game1.huds.Playerhud;


public class Player implements Screen, InputProcessor{
	
	GameScreen gamescreen;
	Game1 game;

	Timer timer;
	
	Rectangle the_player;
	Rectangle future_the_player;	
	Rectangle future_the_player2;

	Building buildingtarget;
	
	Node endnode;

	public double disttogoal;
	
	int dush = 0;
	int rightnum;
	int leftnum ;
	int upnum;
	int downnum;
	
	int health;
	int attack;
	int defense;

	boolean alive = true;
	
	Vector2 nodeFin;

	boolean executed = false;
	boolean colliding = false;
	boolean attacking = false;


	int objectLayerId = 2;
	
	Vector3 playerlocation;
	
    
    ArrayList<Node> finalpath = new ArrayList<Node>();
    
    Node roadsplit;
    Node finalnode;
	
	float speed = 200;
	Vector2 direction;
	Vector2 new_direction;
	//Vector2 new_direction2;
	
	float distance;
	
	Timer t;
	
	int i;
	boolean isAttacking = false;
	
	boolean playerChosen = false;
	boolean moving = false;
	boolean following = false;

	A_star astar;

	Node playerNode;
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
		

		future_the_player = new Rectangle();

		astar = new A_star(gamescreen);

		the_player.x = x - 15;
		the_player.y = y - 15;
		the_player.height = 30;
		the_player.width = 30;
		//future_the_player2 = new Rectangle();
		
		playerlocation = new Vector3(0,0,0);
		
		health = 100;
		attack = 10;
		defense = 1;
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

		if (team==1){
			monitor();
		}
		
	}
	
	public void collision() {
		for (Player player : gamescreen.players){
			if (this.playerNode.adjecent.contains(player.playerNode) && player.team != this.team && !isAttacking && !moving && !following){
				attack(player, 500);
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
			}, 0, 500);
			
		}
	}
		
	public void move_t(int b) {

		this.the_player.x = finalpath.get(b).x - the_player.width/2;
		this.the_player.y = finalpath.get(b).y - the_player.height/2;

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
			}, 0, 500);
			

	}
	
	public void follow_t(Player player) throws InterruptedException {
		if (!this.playerNode.adjecent.contains(player.playerNode)) {
			finalpath = astar.pathfinder(this.playerNode, player.playerNode, player);

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
						player.health = player.health - attack;
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

                    if (!executed) {
                        if (t != null) {
                            t.cancel();
                        }
                        following = false;
                        attacking = false;


                        moving = true;

                    }


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
		
		batch.draw(gamescreen.playersprite, this.the_player.x, this.the_player.y, this.the_player.width, this.the_player.height);
		
		if(playerChosen) {
			batch.draw(gamescreen.green, the_player.x, the_player.y + 75, 50, 10);
			gamescreen.font.draw(batch, "" + health, this.the_player.x + 20, this.the_player.y + 70);
			
			
		}
		
		if(gamescreen.chosenNode != null) {
			batch.draw(gamescreen.green, gamescreen.chosenNode.x, gamescreen.chosenNode.y, 5, 5);
		
		}
		if(playerNode != null) {
			batch.draw(gamescreen.green, playerNode.x, playerNode.y, 5, 5);
		
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
		
		
		
	}

	public void monitorwalk(){
		Node menode = gamescreen.me.playerNode;
		ArrayList<Node> openList = new ArrayList<Node>();
		for (Node node: this.playerNode.adjecent
			 ) {
			if (!node.occupied) {
				openList.add(node);
				if (node.x != this.playerNode.x && node.y != this.playerNode.y) {
					node.cost = Math.sqrt(2);
				} else {
					node.cost = 1;
				}
				node.h = Math.max(Math.abs(node.x - menode.x), Math.abs(node.y - menode.y));
				node.f = node.h + node.cost;

			}
		}
		Collections.sort(openList, new Comparator<Node>() {
			@Override
			public int compare(Node n1, Node n2) {
				return Double.compare(n1.f, n2.f);
			}
		});
		System.out.println(openList.size());
		this.playerNode.occupied = false;
		this.playerNode = openList.get(0);
		this.the_player.x = this.playerNode.x - 16;
		this.the_player.y = this.playerNode.y - 16;
		this.playerNode.occupied = true;
		System.out.println("fff");
	}

	class monitortimer extends TimerTask {
		public void run() {
			monitorwalk();
		}
	}

	public void monitor(){
		if (timer == null) {
			timer = new Timer();
			timer.schedule(new monitortimer(), 0, 1000);

		}

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

