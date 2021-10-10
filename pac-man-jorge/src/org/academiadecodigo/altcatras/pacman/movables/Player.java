package org.academiadecodigo.altcatras.pacman.movables;

import org.academiadecodigo.altcatras.pacman.position.Field;
import org.academiadecodigo.altcatras.pacman.position.Position;
import org.academiadecodigo.altcatras.pacman.position.PositionObjectType;

public class Player extends MovableObject implements IsMovable {

    PlayerKeyboardHandler pkh;

    public Player(Field field){

        super(field);

        this.currentCol = 6;
        this.currentRow = 11;
        this.type = PositionObjectType.PLAYER;
        pkh = new PlayerKeyboardHandler(this);

    }

    @Override
    public void move() {

        //moves on direction set by keyboard

        super.move();

    }

    public void setCurrentDir(Direction currentDir) {
        this.currentDir = currentDir;
    }

}
