package com.game1.buildings;

import com.game1.Building;
import com.game1.GameScreen;

public class Towncenter extends Building {



    public Towncenter(GameScreen gamescreen, int x, int y, int team) {
        super(gamescreen, x - 50, y - 80, 32*4, 32*3 - 2, x - 100, y - 80, 32*5 + 40, 32*5, team);
        building = gamescreen.tex.towncenter;
    }
}
