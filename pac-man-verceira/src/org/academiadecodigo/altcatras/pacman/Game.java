package org.academiadecodigo.altcatras.pacman;

<<<<<<< HEAD
=======
import org.academiadecodigo.altcatras.pacman.movables.Ghost;
>>>>>>> 0c0e784d4083c285bcf02e45443ac0d80f65ea8b
import org.academiadecodigo.altcatras.pacman.movables.Player;
import org.academiadecodigo.altcatras.pacman.position.Field;
import org.academiadecodigo.altcatras.pacman.position.Position;

public class Game {

    Field field;
    Player player;
<<<<<<< HEAD
=======
    Ghost ghost;
>>>>>>> 0c0e784d4083c285bcf02e45443ac0d80f65ea8b

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
        field.paintField();
<<<<<<< HEAD
=======
        field.paintInteractiveObject();
>>>>>>> 0c0e784d4083c285bcf02e45443ac0d80f65ea8b


        while(true){
            Thread.sleep(200);
            player.move();
<<<<<<< HEAD
=======
            field.beerCounter();

            //ghost.move();
>>>>>>> 0c0e784d4083c285bcf02e45443ac0d80f65ea8b
        }
    }

}
