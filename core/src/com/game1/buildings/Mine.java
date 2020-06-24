package com.game1.buildings;

import com.game1.Building;
import com.game1.GameScreen;

public class Mine extends Building {
    public Mine(GameScreen gamescreen, int x, int y, int team) {
        super(gamescreen, x, y, 32*2, 32*2, 64, 64, team);
        building = gamescreen.tex.mine;
    }
}
