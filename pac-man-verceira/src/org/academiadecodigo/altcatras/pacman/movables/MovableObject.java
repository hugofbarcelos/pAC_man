package org.academiadecodigo.altcatras.pacman.movables;

import org.academiadecodigo.altcatras.pacman.position.Field;
import org.academiadecodigo.altcatras.pacman.position.Position;
import org.academiadecodigo.altcatras.pacman.position.PositionObjectType;

abstract public class MovableObject implements  IsMovable {

    int currentCol;
    int currentRow;
    Field field;
    Direction currentDir;
    PositionObjectType type;
    Position[][] fieldPositions;

    public MovableObject(Field field){

        this.field = field;
        this.fieldPositions = field.getPositions();
        this.currentDir = Direction.DOWN;

    }

    @Override
    public void move() {

    }

    public void moveLeft() {

        if(fieldPositions[currentCol-1][currentRow].getType() == PositionObjectType.WALL) return;
        fieldPositions[currentCol][currentRow].setType(PositionObjectType.EMPTY);
        field.paintCell(fieldPositions, currentCol, currentRow);
        currentCol--;
        fieldPositions[currentCol][currentRow].setType(this.type);

    }

    public void moveRight() {

        if(fieldPositions[currentCol+1][currentRow].getType() == PositionObjectType.WALL) return;
        fieldPositions[currentCol][currentRow].setType(PositionObjectType.EMPTY);
        field.paintCell(fieldPositions, currentCol, currentRow);
        currentCol++;
        fieldPositions[currentCol][currentRow].setType(this.type);

    }

    public void moveDown() {

        if(fieldPositions[currentCol][currentRow+1].getType() == PositionObjectType.WALL){
            return;
        }

        fieldPositions[currentCol][currentRow].setType(PositionObjectType.EMPTY);
        field.paintCell(fieldPositions, currentCol, currentRow);
        currentRow++;
        fieldPositions[currentCol][currentRow].setType(this.type);

    }

    public void moveUp() {

        if(fieldPositions[currentCol][currentRow-1].getType() == PositionObjectType.WALL){
            return;
        }

        fieldPositions[currentCol][currentRow].setType(PositionObjectType.EMPTY);
        field.paintCell(fieldPositions, currentCol, currentRow);
        currentRow--;
        fieldPositions[currentCol][currentRow].setType(this.type);

    }

    public void placeInGrid(){
        this.fieldPositions[currentCol][currentRow].setType(this.type);
    }

    public Direction randomDir(){
        switch ((int) Math.random()*3){
            case 0:
                return Direction.LEFT;
            case 1:
                return Direction.RIGHT;
            case 2:
                return Direction.UP;
            case 3:
                return Direction.DOWN;
            default:
                return Direction.DOWN;
        }


    }
}
