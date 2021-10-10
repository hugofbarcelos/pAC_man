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

        switch (currentDir){
            case DOWN:

                moveDown();
                break;

            case UP:

                moveUp();
                break;

            case LEFT:
                moveLeft();
                break;

            case RIGHT:
                moveRight();
                break;

            default: break;

        }

        field.paintCell(fieldPositions, currentCol, currentRow);

    }

    public void setCurrentDir(Direction currentDir) {
        this.currentDir = currentDir;
    }
}
