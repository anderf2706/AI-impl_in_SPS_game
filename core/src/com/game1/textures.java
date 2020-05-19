package com.game1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.bullet.softbody.SWIGTYPE_p_btAlignedObjectArrayT_btSparseSdfT_3_t__Cell_p_t;
import com.badlogic.gdx.utils.Array;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class textures {

	public Texture spritefront;
	public Texture spritefront2;
	public Texture spriteback;
	public Texture spriteback2;
	public Texture spriteleft;
	public Texture spriteleft2;
	public Texture spriteright;
	public Texture spriteright2;


	public Texture spriteprotfront;
	public Texture spriteprotfront2;
	public Texture spriteprotback;
	public Texture spriteprotback2;
	public Texture spriteprotleft;
	public Texture spriteprotleft2;
	public Texture spriteprotright;
	public Texture spriteprotright2;

	public Texture spritecowfront;
	public Texture spritecowfront2;
	public Texture spritecowback;
	public Texture spritecowback2;
	public Texture spritecowleft;
	public Texture spritecowleft2;
	public Texture spritecowright;
	public Texture spritecowright2;

	public Animation<TextureRegion> wizardfrontidle;
	public Animation<TextureRegion> wizardbackidle;
	public Animation<TextureRegion> wizardrightidle;
	public Animation<TextureRegion> wizardleftidle;

	public Animation<TextureRegion> wizardfrontwalk;
	public Animation<TextureRegion> wizardbackwalk;
	public Animation<TextureRegion> wizardrightwalk;
	public Animation<TextureRegion> wizardleftwalk;


	////////////////desert//////////////////////

	public Texture deserttree1;
	public Texture deserttree2;
	public Texture deserttree3;
	public Texture deserttree4;
	public Texture deserttree5;
	public Texture deserttree6;
	public Texture deserttree7;
	public Texture deserttree8;
	public Texture deserttree9;
	public Texture deserttree10;
	public Texture deserttree11;
	public Texture deserttree12;

	public Texture desertstone1;
	public Texture desertstone2;
	public Texture desertstone3;
	public Texture desertstone4;
	public Texture desertstone5;
	public Texture desertstone6;
	public Texture desertstone7;
	public Texture desertstone8;
	public Texture desertstone9;
	public Texture desertstone10;
	public Texture desertstone11;
	public Texture desertstone12;

	public Texture desertgreenery1;
	public Texture desertgreenery2;
	public Texture desertgreenery3;
	public Texture desertgreenery4;
	public 	Texture desertgreenery5;
	public Texture desertgreenery6;
	public Texture desertgreenery7;
	public Texture desertgreenery8;
	public Texture desertgreenery9;
	public Texture desertgreenery10;

	public Texture desertlake;

	////////////////////////////////////////////

	/////////////////Grassland/////////////////

	public Texture grasslandtree1;
	public Texture grasslandtree2;
	public Texture grasslandtree3;
	public Texture grasslandtree4;
	public Texture grasslandtree5;
	public Texture grasslandtree6;
	public Texture grasslandtree7;
	public Texture grasslandtree8;
	public Texture grasslandtree9;
	public Texture grasslandtree10;
	public Texture grasslandtree11;
	public Texture grasslandtree12;
	public Texture grasslandtree13;
	public Texture grasslandtree14;
	public Texture grasslandtree15;

	public Texture grasslandstone1;
	public Texture grasslandstone2;
	public Texture grasslandstone3;
	public Texture grasslandstone4;
	public Texture grasslandstone5;
	public Texture grasslandstone6;
	public Texture grasslandstone7;

	public Texture grasslandgreenery1;
	public Texture grasslandgreenery2;
	public Texture grasslandgreenery3;
	public Texture grasslandgreenery4;
	public 	Texture grasslandgreenery5;
	public Texture grasslandgreenery6;
	public Texture grasslandgreenery7;
	public Texture grasslandgreenery8;
	public Texture grasslandgreenery9;
	public Texture grasslandgreenery10;

	public Texture grasslandlake;
	//////////////////////////////////////////

	///////////////winter////////////////////
	public Texture wintertree1;
	public Texture wintertree2;
	public Texture wintertree3;
	public Texture wintertree4;
	public Texture wintertree5;
	public Texture wintertree6;
	public Texture wintertree7;
	public Texture wintertree8;
	public Texture wintertree9;
	public Texture wintertree10;
	public Texture wintertree11;
	public Texture wintertree12;
	public Texture wintertree13;
	public Texture wintertree14;
	public Texture wintertree15;

	public Texture winterstone1;
	public Texture winterstone2;
	public Texture winterstone3;
	public Texture winterstone4;
	public Texture winterstone5;
	public Texture winterstone6;
	public Texture winterstone7;


	public Texture wintergreenery1;
	public Texture wintergreenery2;
	public Texture wintergreenery3;
	public Texture wintergreenery4;
	public Texture wintergreenery5;
	public Texture wintergreenery6;
	public Texture wintergreenery7;
	public Texture wintergreenery8;
	public Texture wintergreenery9;


	public Texture winterlake;


	////////////////////////////////////////

	////////////////tropical////////////////

	public Texture tropicaltree1;
	public Texture tropicaltree2;
	public Texture tropicaltree3;
	public Texture tropicaltree4;
	public Texture tropicaltree5;
	public Texture tropicaltree6;
	public Texture tropicaltree7;
	public Texture tropicaltree8;
	public Texture tropicaltree9;
	public Texture tropicaltree10;
	public Texture tropicaltree11;
	public Texture tropicaltree12;
	public Texture tropicaltree13;


	public Texture tropicalstone1;
	public Texture tropicalstone2;
	public Texture tropicalstone3;
	public Texture tropicalstone4;
	public Texture tropicalstone5;
	public Texture tropicalstone6;
	public Texture tropicalstone7;
	public Texture tropicalstone8;
	public Texture tropicalstone9;
	public Texture tropicalstone10;
	public Texture tropicalstone11;


	public Texture tropicalgreenery1;
	public Texture tropicalgreenery2;
	public Texture tropicalgreenery3;
	public Texture tropicalgreenery4;
	public Texture tropicalgreenery5;
	public Texture tropicalgreenery6;
	public Texture tropicalgreenery7;
	public Texture tropicalgreenery8;
	public Texture tropicalgreenery9;
	public Texture tropicalgreenery10;
	public Texture tropicalgreenery11;
	public Texture tropicalgreenery12;

	public Texture tropicallake;

	///////////////////////////////////////



	public Texture green;
	public Texture blue;
	public Texture grey;
	public Texture white;
	public Texture beige;
	public Texture tree_normal;
	public Texture normal_stone;
	public Texture water;
	public Texture grass;
	public Texture dirt;
	public Texture tree_small;
	public Texture rock;
	public Texture snow;
	public Texture sand;
	public Texture barrentree;
	public Texture desertstone;
	public Texture cactus;
	public Texture snowbush;
	public Texture snowtree;
	public Texture jungle_tree;
	public Texture palm1;
	public Texture palm2;
	public Texture tree3;
	public Texture tree4;


	public Texture house;
	public Texture barracks;
	public Texture towncenter;
	public Texture wall;
	public Texture gate;
	public Texture crate;
	public Texture barrel;
	public Texture road;
	public Texture castle;
	public Texture pavement;





	public textures() throws IOException {

		sprites();
		landtextures();
		buildingtextures();
		desert();
		grassland();
		winter();
		tropical();
		misctextures();


	}

	public Array getAllImages(String path) throws IOException {
		Array<Texture> resultList = new Array<Texture>();
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println(listOfFiles[i].getName());
                resultList.add(new Texture(Gdx.files.internal(path + listOfFiles[i].getName())));
            }
        }
		return resultList;
	}

	public void sprites() throws IOException {
		spritefront = new Texture(Gdx.files.internal("sprites/knt1/knt1_fr1.gif"));
		spritefront2 = new Texture(Gdx.files.internal("sprites/knt1/knt1_fr2.gif"));
		spriteback = new Texture(Gdx.files.internal("sprites/knt1/knt1_bk1.gif"));
		spriteback2 = new Texture(Gdx.files.internal("sprites/knt1/knt1_bk2.gif"));
		spriteleft = new Texture(Gdx.files.internal("sprites/knt1/knt1_lf1.gif"));
		spriteleft2 = new Texture(Gdx.files.internal("sprites/knt1/knt1_lf2.gif"));
		spriteright = new Texture(Gdx.files.internal("sprites/knt1/knt1_rt1.gif"));
		spriteright2 = new Texture(Gdx.files.internal("sprites/knt1/knt1_rt2.gif"));


		spriteprotfront = new Texture(Gdx.files.internal("sprites/man1/man1_fr1.gif"));
		spriteprotfront2 = new Texture(Gdx.files.internal("sprites/man1/man1_fr2.gif"));
		spriteprotback = new Texture(Gdx.files.internal("sprites/man1/man1_bk1.gif"));
		spriteprotback2 = new Texture(Gdx.files.internal("sprites/man1/man1_bk2.gif"));
		spriteprotleft = new Texture(Gdx.files.internal("sprites/man1/man1_lf1.gif"));
		spriteprotleft2 = new Texture(Gdx.files.internal("sprites/man1/man1_lf2.gif"));
		spriteprotright = new Texture(Gdx.files.internal("sprites/man1/man1_rt1.gif"));
		spriteprotright2 = new Texture(Gdx.files.internal("sprites/man1/man1_rt2.gif"));

		spritecowfront = new Texture(Gdx.files.internal("sprites/cow/cowfront1.png"));
		spritecowfront2 = new Texture(Gdx.files.internal("sprites/cow/cowfront1.png"));
		spritecowback = new Texture(Gdx.files.internal("sprites/cow/cowback1.png"));
		spritecowback2 = new Texture(Gdx.files.internal("sprites/cow/cowback2.png"));
		spritecowleft = new Texture(Gdx.files.internal("sprites/cow/cowleft1.png"));
		spritecowleft2 = new Texture(Gdx.files.internal("sprites/cow/cowleft2.png"));
		spritecowright = new Texture(Gdx.files.internal("sprites/cow/cowright1.png"));
		spritecowright2 = new Texture(Gdx.files.internal("sprites/cow/cowright2.png"));

		////////////////////////////////wizard/////////////////////////////////////////
        String wizard_front = "sprites/wizard/Wizard_animations/Front/PNG Sequences/Wizard_clothes_1/";
		String wizard_back = "sprites/wizard/Wizard_animations/Back/PNG Sequences/Wizard_clothes_1/";
		String wizard_right = "sprites/wizard/Wizard_animations/Right_Side/PNG Sequences/Wizard_clothes_1/";
		String wizard_left = "sprites/wizard/Wizard_animations/Left_Side/PNG Sequences/Wizard_clothes_1/";
		wizardfrontidle = new Animation<TextureRegion>((float) 0.05, this.getAllImages(wizard_front + "Idle Blinking/"));
		wizardbackidle = new Animation<TextureRegion>((float) 0.05, this.getAllImages(wizard_back + "Idle/"));
		wizardrightidle = new Animation<TextureRegion>((float) 0.05, this.getAllImages(wizard_right + "Idle Blinking/"));
		wizardleftidle = new Animation<TextureRegion>((float) 0.05, this.getAllImages(wizard_left + "Idle Blinking/"));

		wizardfrontwalk = new Animation<TextureRegion>((float) 0.05, this.getAllImages(wizard_front + "Run/"));
		wizardbackwalk = new Animation<TextureRegion>((float) 0.05, this.getAllImages(wizard_back + "Run/"));
		wizardrightwalk = new Animation<TextureRegion>((float) 0.05, this.getAllImages(wizard_right + "Run/"));
		wizardleftwalk = new Animation<TextureRegion>((float) 0.05, this.getAllImages(wizard_left + "Run/"));










	}

	public void landtextures(){
		green = new Texture(Gdx.files.internal("landtextures/green.jpg"));
		blue = new Texture(Gdx.files.internal("landtextures/blue.png"));
		grey = new Texture(Gdx.files.internal("landtextures/grey.jpg"));
		white = new Texture(Gdx.files.internal("landtextures/white.jpg"));
		beige = new Texture(Gdx.files.internal("landtextures/beige.jpg"));
		normal_stone =new Texture(Gdx.files.internal("landtextures/normalstone.png"));
		tree_normal = new Texture(Gdx.files.internal("landtextures/tree.png"));
		tree_small = new Texture(Gdx.files.internal("landtextures/tree2.png"));
		water = new Texture(Gdx.files.internal("landtextures/water.jpg"));
		grass = new Texture(Gdx.files.internal("landtextures/tile_grass.png"));
		dirt = new Texture(Gdx.files.internal("landtextures/tile_dirt.png"));
		rock = new Texture(Gdx.files.internal("landtextures/stone.jpg"));
		sand = new Texture(Gdx.files.internal("landtextures/sand.jpg"));
		snow = new Texture(Gdx.files.internal("landtextures/snow.jpg"));
		barrentree = new Texture(Gdx.files.internal("landtextures/dead_tree.png"));
		desertstone = new Texture(Gdx.files.internal("landtextures/desertrock.png"));
		cactus = new Texture(Gdx.files.internal("landtextures/cactus.png"));
		snowbush = new Texture(Gdx.files.internal("landtextures/snowbush.png"));
		snowtree = new Texture(Gdx.files.internal("landtextures/snow_tree.png"));

		//jungle_tree = new Texture(Gdx.files.internal("landtextures/jungle_tree.jpg"));
		palm1 = new Texture(Gdx.files.internal("landtextures/palm1.png"));
		palm2 = new Texture(Gdx.files.internal("landtextures/palm2.png"));
		tree3 = new Texture(Gdx.files.internal("landtextures/tree3.png"));
		tree4 = new Texture(Gdx.files.internal("landtextures/tree4.png"));

	}

	public void desert(){
		desertgreenery1 = new Texture(Gdx.files.internal("Desert/greenery_1.png"));
		desertgreenery2 = new Texture(Gdx.files.internal("Desert/greenery_2.png"));
		desertgreenery3 = new Texture(Gdx.files.internal("Desert/greenery_3.png"));
		desertgreenery4 = new Texture(Gdx.files.internal("Desert/greenery_4.png"));
		desertgreenery5 = new Texture(Gdx.files.internal("Desert/greenery_5.png"));
		desertgreenery6 = new Texture(Gdx.files.internal("Desert/greenery_6.png"));
		desertgreenery7 = new Texture(Gdx.files.internal("Desert/greenery_7.png"));
		desertgreenery8 = new Texture(Gdx.files.internal("Desert/greenery_8.png"));
		desertgreenery9 = new Texture(Gdx.files.internal("Desert/greenery_9.png"));
		desertgreenery10 = new Texture(Gdx.files.internal("Desert/greenery_10.png"));

		deserttree1 = new Texture(Gdx.files.internal("Desert/tree_1.png"));
		deserttree2 = new Texture(Gdx.files.internal("Desert/tree_2.png"));
		deserttree3 = new Texture(Gdx.files.internal("Desert/tree_3.png"));
		deserttree4 = new Texture(Gdx.files.internal("Desert/tree_4.png"));
		deserttree5 = new Texture(Gdx.files.internal("Desert/tree_5.png"));
		deserttree6 = new Texture(Gdx.files.internal("Desert/tree_6.png"));
		deserttree7 = new Texture(Gdx.files.internal("Desert/tree_7.png"));
		deserttree8 = new Texture(Gdx.files.internal("Desert/tree_8.png"));
		deserttree9 = new Texture(Gdx.files.internal("Desert/tree_9.png"));
		deserttree10 = new Texture(Gdx.files.internal("Desert/tree_10.png"));
		deserttree11 = new Texture(Gdx.files.internal("Desert/tree_11.png"));
		deserttree12 = new Texture(Gdx.files.internal("Desert/tree_12.png"));

		desertstone1 = new Texture(Gdx.files.internal("Desert/stones_1.png"));
		desertstone2 = new Texture(Gdx.files.internal("Desert/stones_2.png"));
		desertstone3 = new Texture(Gdx.files.internal("Desert/stones_3.png"));
		desertstone4 = new Texture(Gdx.files.internal("Desert/stones_4.png"));
		desertstone5 = new Texture(Gdx.files.internal("Desert/stones_5.png"));
		desertstone6 = new Texture(Gdx.files.internal("Desert/stones_6.png"));
		desertstone7 = new Texture(Gdx.files.internal("Desert/stones_7.png"));
		desertstone8 = new Texture(Gdx.files.internal("Desert/stones_8.png"));
		desertstone9 = new Texture(Gdx.files.internal("Desert/stones_9.png"));
		desertstone10 = new Texture(Gdx.files.internal("Desert/stones_10.png"));
		desertstone11 = new Texture(Gdx.files.internal("Desert/stones_11.png"));
		desertstone12 = new Texture(Gdx.files.internal("Desert/stones_12.png"));

		desertlake = new Texture(Gdx.files.internal("Desert/lake.png"));



	}

	public void grassland(){

		grasslandgreenery1 = new Texture(Gdx.files.internal("Grassland/greenery_1.png"));
		grasslandgreenery2 = new Texture(Gdx.files.internal("Grassland/greenery_2.png"));
		grasslandgreenery3 = new Texture(Gdx.files.internal("Grassland/greenery_3.png"));
		grasslandgreenery4 = new Texture(Gdx.files.internal("Grassland/greenery_4.png"));
		grasslandgreenery5 = new Texture(Gdx.files.internal("Grassland/greenery_5.png"));
		grasslandgreenery6 = new Texture(Gdx.files.internal("Grassland/greenery_6.png"));
		grasslandgreenery7 = new Texture(Gdx.files.internal("Grassland/greenery_7.png"));
		grasslandgreenery8 = new Texture(Gdx.files.internal("Grassland/greenery_8.png"));
		grasslandgreenery9 = new Texture(Gdx.files.internal("Grassland/greenery_9.png"));
		grasslandgreenery10 = new Texture(Gdx.files.internal("Grassland/greenery_10.png"));

		grasslandtree1 = new Texture(Gdx.files.internal("Grassland/tree_1.png"));
		grasslandtree2 = new Texture(Gdx.files.internal("Grassland/tree_2.png"));
		grasslandtree3 = new Texture(Gdx.files.internal("Grassland/tree_3.png"));
		grasslandtree4 = new Texture(Gdx.files.internal("Grassland/tree_4.png"));
		grasslandtree5 = new Texture(Gdx.files.internal("Grassland/tree_5.png"));
		grasslandtree6 = new Texture(Gdx.files.internal("Grassland/tree_6.png"));
		grasslandtree7 = new Texture(Gdx.files.internal("Grassland/tree_7.png"));
		grasslandtree8 = new Texture(Gdx.files.internal("Grassland/tree_8.png"));
		grasslandtree9 = new Texture(Gdx.files.internal("Grassland/tree_9.png"));
		grasslandtree10 = new Texture(Gdx.files.internal("Grassland/tree_10.png"));
		grasslandtree11 = new Texture(Gdx.files.internal("Grassland/tree_11.png"));
		grasslandtree12 = new Texture(Gdx.files.internal("Grassland/tree_12.png"));
		grasslandtree13 = new Texture(Gdx.files.internal("Grassland/tree_13.png"));
		grasslandtree14 = new Texture(Gdx.files.internal("Grassland/tree_14.png"));
		grasslandtree15 = new Texture(Gdx.files.internal("Grassland/tree_15.png"));

		grasslandstone1 = new Texture(Gdx.files.internal("Grassland/stones_1.png"));
		grasslandstone2 = new Texture(Gdx.files.internal("Grassland/stones_2.png"));
		grasslandstone3 = new Texture(Gdx.files.internal("Grassland/stones_3.png"));
		grasslandstone4 = new Texture(Gdx.files.internal("Grassland/stones_4.png"));
		grasslandstone5 = new Texture(Gdx.files.internal("Grassland/stones_5.png"));
		grasslandstone6 = new Texture(Gdx.files.internal("Grassland/stones_6.png"));
		grasslandstone7 = new Texture(Gdx.files.internal("Grassland/stones_7.png"));

		grasslandlake = new Texture(Gdx.files.internal("Grassland/river.png"));

	}

	public void winter(){
		wintergreenery1 = new Texture(Gdx.files.internal("Winter/greenery_1.png"));
		wintergreenery2 = new Texture(Gdx.files.internal("Winter/greenery_2.png"));
		wintergreenery3 = new Texture(Gdx.files.internal("Winter/greenery_3.png"));
		wintergreenery4 = new Texture(Gdx.files.internal("Winter/greenery_4.png"));
		wintergreenery5 = new Texture(Gdx.files.internal("Winter/greenery_5.png"));
		wintergreenery6 = new Texture(Gdx.files.internal("Winter/greenery_6.png"));
		wintergreenery7 = new Texture(Gdx.files.internal("Winter/greenery_7.png"));
		wintergreenery8 = new Texture(Gdx.files.internal("Winter/greenery_8.png"));
		wintergreenery9 = new Texture(Gdx.files.internal("Winter/greenery_9.png"));

		wintertree1 = new Texture(Gdx.files.internal("Winter/tree_1.png"));
		wintertree2 = new Texture(Gdx.files.internal("Winter/tree_2.png"));
		wintertree3 = new Texture(Gdx.files.internal("Winter/tree_3.png"));
		wintertree4 = new Texture(Gdx.files.internal("Winter/tree_4.png"));
		wintertree5 = new Texture(Gdx.files.internal("Winter/tree_5.png"));
		wintertree6 = new Texture(Gdx.files.internal("Winter/tree_6.png"));
		wintertree7 = new Texture(Gdx.files.internal("Winter/tree_7.png"));
		wintertree8 = new Texture(Gdx.files.internal("Winter/tree_8.png"));
		wintertree9 = new Texture(Gdx.files.internal("Winter/tree_9.png"));
		wintertree10 = new Texture(Gdx.files.internal("Winter/tree_10.png"));
		wintertree11 = new Texture(Gdx.files.internal("Winter/tree_11.png"));
		wintertree12 = new Texture(Gdx.files.internal("Winter/tree_12.png"));
		wintertree13 = new Texture(Gdx.files.internal("Winter/tree_13.png"));
		wintertree14 = new Texture(Gdx.files.internal("Winter/tree_14.png"));
		wintertree15 = new Texture(Gdx.files.internal("Winter/tree_15.png"));


		winterstone1 = new Texture(Gdx.files.internal("Winter/stones_1.png"));
		winterstone2 = new Texture(Gdx.files.internal("Winter/stones_2.png"));
		winterstone3 = new Texture(Gdx.files.internal("Winter/stones_3.png"));
		winterstone4 = new Texture(Gdx.files.internal("Winter/stones_4.png"));
		winterstone5 = new Texture(Gdx.files.internal("Winter/stones_5.png"));
		winterstone6 = new Texture(Gdx.files.internal("Winter/stones_6.png"));
		winterstone7 = new Texture(Gdx.files.internal("Winter/stones_7.png"));

		winterlake = new Texture(Gdx.files.internal("Desert/lake.png"));
	}

	public void tropical(){
		tropicalgreenery1 = new Texture(Gdx.files.internal("Tropical/greenery_1.png"));
		tropicalgreenery2 = new Texture(Gdx.files.internal("Tropical/greenery_2.png"));
		tropicalgreenery3 = new Texture(Gdx.files.internal("Tropical/greenery_3.png"));
		tropicalgreenery4 = new Texture(Gdx.files.internal("Tropical/greenery_4.png"));
		tropicalgreenery5 = new Texture(Gdx.files.internal("Tropical/greenery_5.png"));
		tropicalgreenery6 = new Texture(Gdx.files.internal("Tropical/greenery_6.png"));
		tropicalgreenery7 = new Texture(Gdx.files.internal("Tropical/greenery_7.png"));
		tropicalgreenery8 = new Texture(Gdx.files.internal("Tropical/greenery_8.png"));
		tropicalgreenery9 = new Texture(Gdx.files.internal("Tropical/greenery_9.png"));
		tropicalgreenery10 = new Texture(Gdx.files.internal("tropical/greenery_10.png"));
		tropicalgreenery11 = new Texture(Gdx.files.internal("Tropical/tree_11.png"));
		tropicalgreenery12 = new Texture(Gdx.files.internal("tropical/tree_13.png"));

		tropicaltree1 = new Texture(Gdx.files.internal("Tropical/tree_1.png"));
		tropicaltree2 = new Texture(Gdx.files.internal("Tropical/tree_2.png"));
		tropicaltree3 = new Texture(Gdx.files.internal("Tropical/tree_3.png"));
		tropicaltree4 = new Texture(Gdx.files.internal("Tropical/tree_4.png"));
		tropicaltree5 = new Texture(Gdx.files.internal("Tropical/tree_5.png"));
		tropicaltree6 = new Texture(Gdx.files.internal("Tropical/tree_6.png"));
		tropicaltree7 = new Texture(Gdx.files.internal("Tropical/tree_7.png"));
		tropicaltree8 = new Texture(Gdx.files.internal("Tropical/tree_8.png"));
		tropicaltree9 = new Texture(Gdx.files.internal("Tropical/tree_9.png"));
		tropicaltree10 = new Texture(Gdx.files.internal("Tropical/tree_10.png"));
		tropicaltree11 = new Texture(Gdx.files.internal("Tropical/tree_12.png"));

		tropicalstone1 = new Texture(Gdx.files.internal("Tropical/stones_1.png"));
		tropicalstone2 = new Texture(Gdx.files.internal("Tropical/stones_2.png"));
		tropicalstone3 = new Texture(Gdx.files.internal("Tropical/stones_3.png"));
		tropicalstone4 = new Texture(Gdx.files.internal("Tropical/stones_4.png"));
		tropicalstone5 = new Texture(Gdx.files.internal("Tropical/stones_5.png"));
		tropicalstone6 = new Texture(Gdx.files.internal("Tropical/stones_6.png"));
		tropicalstone7 = new Texture(Gdx.files.internal("Tropical/stones_7.png"));
		tropicalstone8 = new Texture(Gdx.files.internal("Tropical/stones_8.png"));
		tropicalstone9 = new Texture(Gdx.files.internal("Tropical/stones_9.png"));
		tropicalstone10 = new Texture(Gdx.files.internal("Tropical/stones_10.png"));
		tropicalstone11 = new Texture(Gdx.files.internal("Tropical/stones_11.png"));

		tropicallake = new Texture(Gdx.files.internal("Tropical/lake.png"));
	}

	public void buildingtextures(){
		house = new Texture(Gdx.files.internal("buildingtextures/house2.png"));
		barracks = new Texture(Gdx.files.internal("buildingtextures/house3.png"));
		towncenter = new Texture(Gdx.files.internal("buildingtextures/house.png"));
		road =  new Texture(Gdx.files.internal("buildingtextures/tile_pavement.png"));
		wall = new Texture(Gdx.files.internal("buildingtextures/wall.png"));
		gate = new Texture(Gdx.files.internal("buildingtextures/gate.png"));
		pavement = new Texture(Gdx.files.internal("buildingtextures/tile_pavement.png"));
	}

	public void misctextures(){
		barrel = new Texture(Gdx.files.internal("buildingtextures/barel.png"));
		crate = new Texture(Gdx.files.internal("buildingtextures/crate.png"));
	}
}
