package org.academiadecodigo.altcatras.pacman;

import org.academiadecodigo.altcatras.pacman.position.Field;
import org.academiadecodigo.altcatras.pacman.position.Garden;
import org.academiadecodigo.altcatras.pacman.position.SuperField;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MainTests {

    public static void main(String[] args) throws InterruptedException {

        Field field = new Field();
        Garden garden = new Garden();

        Game game = new Game(3, garden);

        game.start();

        System.out.println("end");
    }
}
