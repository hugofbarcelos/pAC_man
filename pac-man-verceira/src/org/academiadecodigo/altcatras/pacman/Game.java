package org.academiadecodigo.altcatras.pacman;

<<<<<<< HEAD
=======
import org.academiadecodigo.altcatras.pacman.movables.Ghost;
<<<<<<< HEAD
>>>>>>> 0c0e784d4083c285bcf02e45443ac0d80f65ea8b
=======
import org.academiadecodigo.altcatras.pacman.movables.MovableObject;
>>>>>>> 3be4dbf95cfe03403a99a3122cbcee531fd32c91
import org.academiadecodigo.altcatras.pacman.movables.Player;
import org.academiadecodigo.altcatras.pacman.position.Field;

public class Game {

    Field field;
    Player player;
<<<<<<< HEAD
=======
    Ghost ghost;
<<<<<<< HEAD
>>>>>>> 0c0e784d4083c285bcf02e45443ac0d80f65ea8b
=======
    Boolean isOver = false;
>>>>>>> 3be4dbf95cfe03403a99a3122cbcee531fd32c91

    public Game() {

        this.field = new Field();
        this.player = new Player(field);
<<<<<<< HEAD
=======
        this.ghost = new Ghost(field);
>>>>>>> 0c0e784d4083c285bcf02e45443ac0d80f65ea8b

    }

    public void start() throws InterruptedException {
        field.createWalls();
        player.placeInGrid();
        ghost.placeInGrid();
        field.paintField();
<<<<<<< HEAD
<<<<<<< HEAD
=======
        field.paintInteractiveObject();
>>>>>>> 0c0e784d4083c285bcf02e45443ac0d80f65ea8b
=======
>>>>>>> 3be4dbf95cfe03403a99a3122cbcee531fd32c91


        while(true){
            Thread.sleep(200);
            player.move();
<<<<<<< HEAD
<<<<<<< HEAD
=======
            field.beerCounter();

            //ghost.move();
>>>>>>> 0c0e784d4083c285bcf02e45443ac0d80f65ea8b
=======
            if(MovableObject.checkColisions(player, ghost)) break;
            ghost.move();
>>>>>>> 3be4dbf95cfe03403a99a3122cbcee531fd32c91
        }
    }

}
