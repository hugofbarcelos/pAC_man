package org.academiadecodigo.altcatras.pacman;

import org.academiadecodigo.altcatras.pacman.movables.Ghost;
import org.academiadecodigo.altcatras.pacman.movables.Player;
import org.academiadecodigo.altcatras.pacman.position.Field;

public class Game {

    Field field;
    Player player;
    Ghost ghost1, ghost2;

    public Game() {

        this.field = new Field();
        this.player = new Player(field);
        this.ghost1 = new Ghost(field);
        this.ghost2 = new Ghost(field);

    }

    public void start() throws InterruptedException {
        field.createWalls();
        player.placeInGrid();
        ghost1.placeInGrid();
        ghost2.placeInGrid();
        field.paintField();
        field.paintInteractiveObject();


        while(true){
            Thread.sleep(200);
            player.move();
            if(player.checkWin()) break;
            ghost1.move();
            ghost2.move();
            if(player.checkCollisions(player, ghost1)) break;
            if(player.checkCollisions(player, ghost2)) break;
        }
    }

}
