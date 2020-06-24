package com.game1.buildings;

import com.game1.Building;
import com.game1.GameScreen;

public class Towncenter extends Building {



    public Towncenter(GameScreen gamescreen, int x, int y, int team) {
        super(gamescreen,x , y, 32*5 - 2, 32*3 - 2, 32*5, 32*5, team);
        building = gamescreen.tex.towncenter;
    }
}
