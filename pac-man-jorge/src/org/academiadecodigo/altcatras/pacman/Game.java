package org.academiadecodigo.altcatras.pacman;

import org.academiadecodigo.altcatras.pacman.movables.Player;
import org.academiadecodigo.altcatras.pacman.position.Field;
import org.academiadecodigo.altcatras.pacman.position.Position;

public class Game {

    Field field;
    Player player;

    public Game() {

        this.field = new Field();
        this.player = new Player(field);

    }

    public void start() throws InterruptedException {
        field.createWalls();
        player.placeInGrid();
        field.paintField();


        while(true){
            Thread.sleep(200);
            player.move();
        }
    }

}
