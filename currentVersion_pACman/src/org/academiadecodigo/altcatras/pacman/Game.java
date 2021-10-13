package org.academiadecodigo.altcatras.pacman;

import org.academiadecodigo.altcatras.pacman.movables.Ghost;
import org.academiadecodigo.altcatras.pacman.movables.Player;
import org.academiadecodigo.altcatras.pacman.position.Menu;
import org.academiadecodigo.altcatras.pacman.position.SuperField;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.util.LinkedList;

public class Game {

    SuperField field;
    Player player;
    LinkedList<Ghost> ghosts = new LinkedList<>();
    Menu menu;

    public Game(int numberOfGhosts, SuperField gameGround) {

        this.field = gameGround;
        this.player = new Player(field);
        for (int i = 0; i < numberOfGhosts; i++) {
            ghosts.add(new Ghost(field));
        }
        menu = new Menu(this.field.getWidth(), this.field.getHeight());
        Text text = new Text(field.getWidth() / 2, field.getHeight() / 2 - 10, "START");
        text.grow(100,50);
        text.setColor(Color.BLACK);
        text.draw();

    }


    public void start() throws InterruptedException {


       while (!menu.isStart()) {
           System.out.println("waiting");
        }

        field.createWalls();
        field.paintField();
        field.paintInteractiveObject();
        player.placeInGrid();

        // desenha os ghosts e o player depois do background
        player.draw();
        for (Ghost ghost : ghosts) {
            ghost.draw();
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
        menu.changeFlag();
        this.start();
    }
}




