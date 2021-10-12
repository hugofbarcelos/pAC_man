package org.academiadecodigo.altcatras.pacman;

import org.academiadecodigo.altcatras.pacman.movables.Ghost;
import org.academiadecodigo.altcatras.pacman.movables.Player;
import org.academiadecodigo.altcatras.pacman.position.Field;

import java.util.LinkedList;

public class Game {

    Field field;
    Player player;
    LinkedList<Ghost> ghosts = new LinkedList<>();
    Ghost ghost1, ghost2;


    public Game(int numberOfGhosts) {

        this.field = new Field();
        this.player = new Player(field);
        for (int i = 0; i < numberOfGhosts; i++) {
            ghosts.add(new Ghost(field));
        }

    }

    public void start() throws InterruptedException {
        field.createWalls();
        player.placeInGrid();
        for (Ghost ghost : ghosts) {
            ghost.placeInGrid();
        }
        field.paintField();
        field.paintInteractiveObject();


        while (true) {
            Thread.sleep(200);
            player.move();

            if (player.checkWin()) break;
            for (Ghost ghost : ghosts) {
                ghost.move();
                if (player.checkCollisions(player, ghost)) return;
            }



        }
    }

}
