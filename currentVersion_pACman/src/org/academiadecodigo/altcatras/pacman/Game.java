package org.academiadecodigo.altcatras.pacman;

import org.academiadecodigo.altcatras.pacman.movables.Ghost;
import org.academiadecodigo.altcatras.pacman.movables.Player;
import org.academiadecodigo.altcatras.pacman.position.SuperField;

import java.util.LinkedList;

public class Game {

    SuperField field;
    Player player;
    LinkedList<Ghost> ghosts = new LinkedList<>();


    public Game(int numberOfGhosts, SuperField gameGround) {
        this.field = gameGround;
        this.player = new Player(field);
        for (int i = 0; i < numberOfGhosts; i++) {
            ghosts.add(new Ghost(field));
        }
    }

    public void start() throws InterruptedException {
        field.createWalls();
        field.paintField();
        field.paintInteractiveObject();
        player.placeInGrid();
        for (Ghost ghost : ghosts) {
            ghost.placeInGrid();
        }


        while (true) {
            Thread.sleep(200);
            player.move();

            if (player.checkWin()) break;
            for (Ghost ghost : ghosts) {
                if (player.checkCollisions(player, ghost)) return;
                ghost.move();
                if (player.checkCollisions(player, ghost)) return;
            }
        }
    }

}
