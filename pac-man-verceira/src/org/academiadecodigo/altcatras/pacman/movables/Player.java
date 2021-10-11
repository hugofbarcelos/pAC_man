package org.academiadecodigo.altcatras.pacman.movables;

import org.academiadecodigo.altcatras.pacman.position.Field;
import org.academiadecodigo.altcatras.pacman.position.Position;
import org.academiadecodigo.altcatras.pacman.position.PositionObjectType;

<<<<<<< HEAD
public class Player implements IsMovable {

    int currentCol;
    int currentRow;
    Field field;
    Direction previousDir;
    Direction currentDir;
    PlayerKeyboardHandler pkh;
    Position[][] fieldPositions;

    public Player(Field field){

        this.field = field;
        this.fieldPositions = field.getPositions();
        this.currentCol = 6;
        this.currentRow = 11;
        this.previousDir = Direction.UP;
        this.currentDir = Direction.DOWN;
        pkh = new PlayerKeyboardHandler(this);

=======
public class Player extends MovableObject implements IsMovable {

    PlayerKeyboardHandler pkh;

    public Player(Field field){

        super(field);

        this.currentCol = 6;
        this.currentRow = 11;
        this.type = PositionObjectType.PLAYER;
        pkh = new PlayerKeyboardHandler(this);

<<<<<<< HEAD

>>>>>>> 0c0e784d4083c285bcf02e45443ac0d80f65ea8b
=======
>>>>>>> 3be4dbf95cfe03403a99a3122cbcee531fd32c91
    }

    @Override
    public void move() {

        //moves on direction set by keyboard

<<<<<<< HEAD
        switch (currentDir){
            case DOWN:

<<<<<<< HEAD
                if(fieldPositions[currentCol][currentRow+1].getType() == PositionObjectType.WALL){
                    return;
                }

                fieldPositions[currentCol][currentRow].setType(PositionObjectType.EMPTY);
                field.paintCell(fieldPositions, currentCol, currentRow);
                currentRow++;
                fieldPositions[currentCol][currentRow].setType(PositionObjectType.PLAYER);
                field.paintCell(fieldPositions, currentCol, currentRow);
=======
                moveDown();
>>>>>>> 0c0e784d4083c285bcf02e45443ac0d80f65ea8b
                break;

            case UP:

<<<<<<< HEAD
                if(fieldPositions[currentCol][currentRow-1].getType() == PositionObjectType.WALL) {
                    return;
                }
                fieldPositions[currentCol][currentRow].setType(PositionObjectType.EMPTY);
                field.paintCell(fieldPositions, currentCol, currentRow);
                currentRow--;
                fieldPositions[currentCol][currentRow].setType(PositionObjectType.PLAYER);
                field.paintCell(fieldPositions, currentCol, currentRow);
                break;

            case LEFT:
                if(fieldPositions[currentCol-1][currentRow].getType() == PositionObjectType.WALL) return;
                fieldPositions[currentCol][currentRow].setType(PositionObjectType.EMPTY);
                field.paintCell(fieldPositions, currentCol, currentRow);
                currentCol--;
                fieldPositions[currentCol][currentRow].setType(PositionObjectType.PLAYER);
                field.paintCell(fieldPositions, currentCol, currentRow);
                break;

            case RIGHT:
                if(fieldPositions[currentCol+1][currentRow].getType() == PositionObjectType.WALL) return;
                fieldPositions[currentCol][currentRow].setType(PositionObjectType.EMPTY);
                field.paintCell(fieldPositions, currentCol, currentRow);
                currentCol++;
                fieldPositions[currentCol][currentRow].setType(PositionObjectType.PLAYER);
                field.paintCell(fieldPositions, currentCol, currentRow);
=======
                moveUp();
                break;

            case LEFT:
                moveLeft();
                break;

            case RIGHT:
                moveRight();
>>>>>>> 0c0e784d4083c285bcf02e45443ac0d80f65ea8b
                break;

            default: break;

        }

<<<<<<< HEAD
    }

    public void placeInGrid(){
        this.fieldPositions[currentCol][currentRow].setType(PositionObjectType.PLAYER);
    }

=======
        field.paintCell(fieldPositions, currentCol, currentRow);

    }



>>>>>>> 0c0e784d4083c285bcf02e45443ac0d80f65ea8b
=======
        super.move();

    }

>>>>>>> 3be4dbf95cfe03403a99a3122cbcee531fd32c91
    public void setCurrentDir(Direction currentDir) {
        this.currentDir = currentDir;
    }

}
