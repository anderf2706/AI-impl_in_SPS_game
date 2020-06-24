package com.game1.buildings;

import com.game1.Building;
import com.game1.GameScreen;

public class Tower extends Building {



    public Tower(GameScreen gamescreen, int x, int y, int team) {
        super(gamescreen, x - 20, y - 20, 32, 32, x - 64, y - 64, 84, 32*8, team);
        building = gamescreen.tex.tower;
    }
}
