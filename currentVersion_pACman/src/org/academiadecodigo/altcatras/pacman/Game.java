package org.academiadecodigo.altcatras.pacman;

import org.academiadecodigo.altcatras.pacman.movables.Ghost;
import org.academiadecodigo.altcatras.pacman.movables.Player;
import org.academiadecodigo.altcatras.pacman.position.Field;
import org.academiadecodigo.altcatras.pacman.position.SuperField;

import java.awt.*;
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

    public void init() {
        new Rectangle();
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
