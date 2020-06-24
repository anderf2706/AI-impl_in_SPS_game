package com.game1.buildings;

import com.game1.Building;
import com.game1.GameScreen;

public class Mine extends Building {
    public Mine(GameScreen gamescreen, int x, int y, int team) {
        super(gamescreen, x- 40, y , 40, 40, x - 48 , y - 20, 64, 64, team);
        building = gamescreen.tex.mine;
    }
}
