package com.game1;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.game1.buildings.*;

public class MakingBuildings{

    GameScreen gamescreen;

    public MakingBuildings(GameScreen gamsecreen){
        this.gamescreen = gamsecreen;
    }

        public void makeBarracks() {

            for (int i = 0; i < this.gamescreen.buildings.size(); i++) {

                if((Intersector.overlaps(new Rectangle(gamescreen.chosenNode.x - 64, gamescreen.chosenNode.y - 64, 32*4, 32*3), gamescreen.buildings.get(i).the_building))){

                    return;
                }
            }
            for (int i = 0; i < this.gamescreen.nature.size(); i++) {

                if((Intersector.overlaps(new Rectangle(gamescreen.chosenNode.x - 64, gamescreen.chosenNode.y - 64, 32*4, 32*3), gamescreen.nature.get(i).the_nature))){

                    return;
                }
            }


            for (Node node : gamescreen.chosenNode.adjecent) {
                if(node == null) {
                    return;
                }

            }
            new Barracks(gamescreen, gamescreen.chosenNode.x, gamescreen.chosenNode.y, gamescreen.team);


        }

        public void makeHouse() {

            for (int i = 0; i < this.gamescreen.buildings.size(); i++) {

                if((Intersector.overlaps(new Rectangle(gamescreen.chosenNode.x - 96/2, gamescreen.chosenNode.y - 96/2, 96, 64), gamescreen.buildings.get(i).the_building))){

                    return;
                }
            }
            for (int i = 0; i < this.gamescreen.nature.size(); i++) {

                if((Intersector.overlaps(new Rectangle(gamescreen.chosenNode.x - 96/2, gamescreen.chosenNode.y - 96/2, 96, 64), gamescreen.nature.get(i).the_nature))){

                    return;
                }
            }


            if(gamescreen.chosenNode == null && gamescreen.chosenNode.adjecent.contains(null)) {
                return;
            }


            new House(gamescreen, gamescreen.chosenNode.x, gamescreen.chosenNode.y, gamescreen.team);

        }

        public void makePalicade_H() {
            /*
            for (int i = 0; i < this.gamescreen.buildings.size(); i++) {

                if((Intersector.overlaps(new Rectangle(gamescreen.chosenNode.x - 16, gamescreen.chosenNode.y - 16, 32, 32), gamescreen.buildings.get(i).the_building))){

                    return;
                }
            }
            for (int i = 0; i < this.gamescreen.nature.size(); i++) {

                if((Intersector.overlaps(new Rectangle(gamescreen.chosenNode.x - 16, gamescreen.chosenNode.y - 16, 32, 32), gamescreen.nature.get(i).the_nature))){

                    return;
                }
            }

             */


            if(gamescreen.chosenNode == null && gamescreen.chosenNode.adjecent.contains(null)) {
                return;
            }
            else{
                if (gamescreen.chosenNode.occupied){
                    return;
                }
            }


            new Palicade_H(gamescreen, gamescreen.chosenNode.x, gamescreen.chosenNode.y, gamescreen.team);

        }

    public void makePalicade_V() {
        /*

        for (int i = 0; i < this.gamescreen.buildings.size(); i++) {

            if((Intersector.overlaps(new Rectangle(gamescreen.chosenNode.x - 16, gamescreen.chosenNode.y - 16, 32, 32), gamescreen.buildings.get(i).the_building))){

                return;
            }
        }
        for (int i = 0; i < this.gamescreen.nature.size(); i++) {

            if((Intersector.overlaps(new Rectangle(gamescreen.chosenNode.x - 16, gamescreen.chosenNode.y - 16, 32, 32), gamescreen.nature.get(i).the_nature))){

                return;
            }
        }

         */

        if(gamescreen.chosenNode == null && gamescreen.chosenNode.adjecent.contains(null)) {
            return;
        }
        else{
            if (gamescreen.chosenNode.occupied){
                return;
            }
        }


        new Palicade_V(gamescreen, gamescreen.chosenNode.x, gamescreen.chosenNode.y, gamescreen.team);

    }

    public void makeWall_H() {
        /*

        for (int i = 0; i < this.gamescreen.buildings.size(); i++) {

            if((Intersector.overlaps(new Rectangle(gamescreen.chosenNode.x - 16, gamescreen.chosenNode.y - 16, 32, 32), gamescreen.buildings.get(i).the_building))){

                return;
            }
        }
        for (int i = 0; i < this.gamescreen.nature.size(); i++) {

            if((Intersector.overlaps(new Rectangle(gamescreen.chosenNode.x - 16, gamescreen.chosenNode.y - 16, 32, 32), gamescreen.nature.get(i).the_nature))){

                return;
            }
        }

         */

        if(gamescreen.chosenNode == null && gamescreen.chosenNode.adjecent.contains(null)) {
            return;
        }
        else{
            if (gamescreen.chosenNode.occupied){
                return;
            }
        }


        new Wall_H(gamescreen, gamescreen.chosenNode.x, gamescreen.chosenNode.y, gamescreen.team);

    }


        public void makeCastle() {

        for (int i = 0; i < this.gamescreen.buildings.size(); i++) {

            if((Intersector.overlaps(new Rectangle(gamescreen.chosenNode.x - 76, gamescreen.chosenNode.y - 76, 32*6, 34), gamescreen.buildings.get(i).the_building))){

                return;
            }
        }
        for (int i = 0; i < this.gamescreen.nature.size(); i++) {

            if((Intersector.overlaps(new Rectangle(gamescreen.chosenNode.x - 76, gamescreen.chosenNode.y - 76, 32*6, 34), gamescreen.nature.get(i).the_nature))){

                return;
            }
        }

        if(gamescreen.chosenNode == null && gamescreen.chosenNode.adjecent.contains(null)) {
            return;
        }




        new Castle(gamescreen, gamescreen.chosenNode.x, gamescreen.chosenNode.y, gamescreen.team);

    }

    public void makeTower() {

        for (int i = 0; i < this.gamescreen.buildings.size(); i++) {

            if((Intersector.overlaps(new Rectangle(gamescreen.chosenNode.x - 32, gamescreen.chosenNode.y - 32, 32*2, 32*2), gamescreen.buildings.get(i).the_building))){

                return;
            }
        }
        for (int i = 0; i < this.gamescreen.nature.size(); i++) {

            if((Intersector.overlaps(new Rectangle(gamescreen.chosenNode.x - 32, gamescreen.chosenNode.y - 32, 32*2, 32*2), gamescreen.nature.get(i).the_nature))){

                return;
            }
        }

        if(gamescreen.chosenNode == null && gamescreen.chosenNode.adjecent.contains(null)) {
                return;
        }




        new Tower(gamescreen, gamescreen.chosenNode.x, gamescreen.chosenNode.y, gamescreen.team);

    }

        public void makeGate() {
            for (int i = 0; i < this.gamescreen.buildings.size(); i++) {

                if((Intersector.overlaps(new Rectangle(gamescreen.chosenNode.x - 32, gamescreen.chosenNode.y - 16, 64, 32), gamescreen.buildings.get(i).the_building))){

                    return;
                }
            }
            for (int i = 0; i < this.gamescreen.nature.size(); i++) {

                if((Intersector.overlaps(new Rectangle(gamescreen.chosenNode.x - 32, gamescreen.chosenNode.y - 16, 64, 32), gamescreen.nature.get(i).the_nature))){

                    return;
                }
            }


            new Gate(gamescreen, gamescreen.chosenNode.x, gamescreen.chosenNode.y, gamescreen.team);

        }

    public void makeTowncenter() {
        for (int i = 0; i < this.gamescreen.buildings.size(); i++) {

            if((Intersector.overlaps(new Rectangle(gamescreen.chosenNode.x - 32*5/2, gamescreen.chosenNode.y - 64, 32*5, 32*4), gamescreen.buildings.get(i).the_building))){

                return;
            }
        }
        for (int i = 0; i < this.gamescreen.nature.size(); i++) {

            if((Intersector.overlaps(new Rectangle(gamescreen.chosenNode.x - 32*5/2, gamescreen.chosenNode.y - 64, 32*5, 32*4), gamescreen.nature.get(i).the_nature))){

                return;
            }
        }


        new Towncenter(gamescreen, gamescreen.chosenNode.x, gamescreen.chosenNode.y, gamescreen.team);

    }

    public void makeMine() {
        for (int i = 0; i < this.gamescreen.buildings.size(); i++) {

            if((Intersector.overlaps(new Rectangle(gamescreen.chosenNode.x - 32, gamescreen.chosenNode.y - 32, 64, 64), gamescreen.buildings.get(i).the_building))){

                return;
            }
        }
        for (int i = 0; i < this.gamescreen.nature.size(); i++) {

            if((Intersector.overlaps(new Rectangle(gamescreen.chosenNode.x - 32, gamescreen.chosenNode.y - 32, 64, 64), gamescreen.nature.get(i).the_nature))){

                return;
            }
        }


        new Mine(gamescreen, gamescreen.chosenNode.x, gamescreen.chosenNode.y, gamescreen.team);

    }

}
