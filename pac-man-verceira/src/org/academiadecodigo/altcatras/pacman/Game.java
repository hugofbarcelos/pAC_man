package org.academiadecodigo.altcatras.pacman;

import org.academiadecodigo.altcatras.pacman.movables.Ghost;
import org.academiadecodigo.altcatras.pacman.movables.MovableObject;
import org.academiadecodigo.altcatras.pacman.movables.Player;
import org.academiadecodigo.altcatras.pacman.position.Field;

public class Game {

    Field field;
    Player player;
    Ghost ghost;
    Boolean isOver = false;

    public Game() {

        this.field = new Field();
        this.player = new Player(field);
        this.ghost = new Ghost(field);

    }

    public void start() throws InterruptedException {
        field.createWalls();
        player.placeInGrid();
        ghost.placeInGrid();
        field.paintField();


        while(true){
            Thread.sleep(200);
            player.move();
            if(MovableObject.checkColisions(player, ghost)) break;
            ghost.move();
        }
    }

}
