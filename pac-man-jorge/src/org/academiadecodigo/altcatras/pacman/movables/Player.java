package org.academiadecodigo.altcatras.pacman.movables;

import org.academiadecodigo.altcatras.pacman.position.Field;
import org.academiadecodigo.altcatras.pacman.position.Position;
import org.academiadecodigo.altcatras.pacman.position.PositionObjectType;

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

    }

    @Override
    public void move() {

        //moves on direction set by keyboard

        switch (currentDir){
            case DOWN:

                if(fieldPositions[currentCol][currentRow+1].getType() == PositionObjectType.WALL){
                    return;
                }

                fieldPositions[currentCol][currentRow].setType(PositionObjectType.EMPTY);
                field.paintCell(fieldPositions, currentCol, currentRow);
                currentRow++;
                fieldPositions[currentCol][currentRow].setType(PositionObjectType.PLAYER);
                field.paintCell(fieldPositions, currentCol, currentRow);
                break;

            case UP:

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
                break;

            default: break;

        }

    }

    public void placeInGrid(){
        this.fieldPositions[currentCol][currentRow].setType(PositionObjectType.PLAYER);
    }

    public void setCurrentDir(Direction currentDir) {
        this.currentDir = currentDir;
    }
}
