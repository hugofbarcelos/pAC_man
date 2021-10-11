package org.academiadecodigo.altcatras.pacman.movables;

import org.academiadecodigo.altcatras.pacman.position.Field;
import org.academiadecodigo.altcatras.pacman.position.Position;
import org.academiadecodigo.altcatras.pacman.position.PositionObjectType;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

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

        fieldPositions[currentCol][currentRow].getRectangle().setColor(type.getColor());
        fieldPositions[currentCol][currentRow].getRectangle().fill();
    }

    public void moveLeft() {

        if(fieldPositions[currentCol-1][currentRow].getType() == PositionObjectType.WALL) return;
        fieldPositions[currentCol][currentRow].setType(PositionObjectType.EMPTY);
        fieldPositions[currentCol][currentRow].getRectangle().delete();
        currentCol--;
        fieldPositions[currentCol][currentRow].setType(this.type);

    }

    public void moveRight() {

        if(fieldPositions[currentCol+1][currentRow].getType() == PositionObjectType.WALL) return;
        fieldPositions[currentCol][currentRow].setType(PositionObjectType.EMPTY);
        fieldPositions[currentCol][currentRow].getRectangle().delete();
        currentCol++;
        fieldPositions[currentCol][currentRow].setType(this.type);

    }

    public void moveDown() {

        if(fieldPositions[currentCol][currentRow+1].getType() == PositionObjectType.WALL){
            return;
        }

        fieldPositions[currentCol][currentRow].setType(PositionObjectType.EMPTY);
        fieldPositions[currentCol][currentRow].getRectangle().delete();
        currentRow++;
        fieldPositions[currentCol][currentRow].setType(this.type);

    }

    public void moveUp() {

        if(fieldPositions[currentCol][currentRow-1].getType() == PositionObjectType.WALL){
            return;
        }

        fieldPositions[currentCol][currentRow].setType(PositionObjectType.EMPTY);
        fieldPositions[currentCol][currentRow].getRectangle().delete();
        currentRow--;
        fieldPositions[currentCol][currentRow].setType(this.type);

    }

    public void placeInGrid(){
        this.fieldPositions[currentCol][currentRow].setType(this.type);
    }

    public Direction randomDir(){
        switch ((int) (Math.random()*4)){
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

    public Direction randomDir(Direction dir1, Direction dir2){
        switch ((int) (Math.random()*2)){
            case 0:
                return dir1;
            default:
                return dir2;
        }
    }

    public Direction randomDir(Direction dir1, Direction dir2, Direction dir3){
        switch ((int) (Math.random()*3)){
            case 0:
                return dir1;
            case 1:
                return dir2;
            default:
                return dir3;
        }
    }

    public Direction chooseDirectionIntersection(Direction direction){

        PositionObjectType up = fieldPositions[currentCol][currentRow-1].getType();
        PositionObjectType down = fieldPositions[currentCol][currentRow+1].getType();
        PositionObjectType left = fieldPositions[currentCol-1][currentRow].getType();
        PositionObjectType right = fieldPositions[currentCol+1][currentRow].getType();

        //covers all possible intersection options for each direction
        switch (direction) {
            case DOWN:
                if (left != PositionObjectType.WALL && right != PositionObjectType.WALL && down != PositionObjectType.WALL) {
                   return randomDir(Direction.LEFT, Direction.RIGHT, Direction.DOWN);
                } else if(left != PositionObjectType.WALL && right != PositionObjectType.WALL){
                    return randomDir(Direction.LEFT, Direction.RIGHT);
                } else if(left != PositionObjectType.WALL && down != PositionObjectType.WALL){
                    return randomDir(Direction.LEFT, Direction.DOWN);
                } else if(right != PositionObjectType.WALL && down != PositionObjectType.WALL){
                    return randomDir(Direction.RIGHT, Direction.DOWN);
                } else if(left != PositionObjectType.WALL){
                    return randomDir(Direction.LEFT, Direction.UP);
                } else if(right != PositionObjectType.WALL){
                    return randomDir(Direction.RIGHT, Direction.UP);
                } else if(down != PositionObjectType.WALL) {
                    return Direction.DOWN;
                } else {
                    return (Direction.UP);
                }

            case UP:
                if (left != PositionObjectType.WALL && right != PositionObjectType.WALL && up != PositionObjectType.WALL) {
                    return randomDir(Direction.LEFT, Direction.RIGHT, Direction.UP);
                } else if(left != PositionObjectType.WALL && right != PositionObjectType.WALL){
                    return randomDir(Direction.LEFT, Direction.RIGHT);
                } else if(left != PositionObjectType.WALL && up != PositionObjectType.WALL){
                    return randomDir(Direction.LEFT, Direction.UP);
                } else if(right != PositionObjectType.WALL && up != PositionObjectType.WALL){
                    return randomDir(Direction.RIGHT, Direction.UP);
                } else if(left != PositionObjectType.WALL){
                    return randomDir(Direction.LEFT, Direction.DOWN);
                } else if(right != PositionObjectType.WALL){
                    return randomDir(Direction.RIGHT, Direction.DOWN);
                } else if(up != PositionObjectType.WALL) {
                    return Direction.UP;
                } else {
                    return (Direction.DOWN);
                }

            case LEFT:
                if (left != PositionObjectType.WALL && down != PositionObjectType.WALL && up != PositionObjectType.WALL) {
                    return randomDir(Direction.LEFT, Direction.DOWN, Direction.UP);
                } else if(left != PositionObjectType.WALL && down != PositionObjectType.WALL){
                    return randomDir(Direction.LEFT, Direction.DOWN);
                } else if(left != PositionObjectType.WALL && up != PositionObjectType.WALL){
                    return randomDir(Direction.LEFT, Direction.UP);
                } else if(down != PositionObjectType.WALL && up != PositionObjectType.WALL){
                    return randomDir(Direction.DOWN, Direction.UP);
                } else if(up != PositionObjectType.WALL){
                    return randomDir(Direction.UP, Direction.RIGHT);
                } else if(down != PositionObjectType.WALL){
                    return randomDir(Direction.DOWN, Direction.RIGHT);
                } else if(left != PositionObjectType.WALL) {
                    return Direction.LEFT;
                } else {
                    return (Direction.RIGHT);
                }


            case RIGHT:
                if (right != PositionObjectType.WALL && down != PositionObjectType.WALL && up != PositionObjectType.WALL) {
                    return randomDir(Direction.RIGHT, Direction.DOWN, Direction.UP);
                } else if(right != PositionObjectType.WALL && down != PositionObjectType.WALL){
                    return randomDir(Direction.RIGHT, Direction.DOWN);
                } else if(right != PositionObjectType.WALL && up != PositionObjectType.WALL){
                    return randomDir(Direction.RIGHT, Direction.UP);
                } else if(down != PositionObjectType.WALL && up != PositionObjectType.WALL){
                    return randomDir(Direction.DOWN, Direction.UP);
                } else if(up != PositionObjectType.WALL){
                    return randomDir(Direction.UP, Direction.LEFT);
                } else if(down != PositionObjectType.WALL){
                    return randomDir(Direction.DOWN, Direction.LEFT);
                } else if(right != PositionObjectType.WALL) {
                    return Direction.RIGHT;
                } else {
                    return (Direction.LEFT);
                }

            default:
                System.out.println("Something went wrong on intersection method!");
                return Direction.UP;
        }
    }

    public boolean checkCollisions(MovableObject obj1, MovableObject obj2){
        if(obj1.currentCol == obj2.currentCol && obj2.currentRow == obj1.currentRow){
            System.out.println("GAME OVER, PLAYER WAS CAUGHT BY THE GHOSTS");
            Rectangle lose = new Rectangle(field.getWidth()/2 - 70, field.getHeight()/2 - 50, 200, 100);
            lose.setColor(Color.RED);
            lose.fill();
            Text text = new Text(field.getWidth()/2, field.getHeight()/2- 10, "YOU LOSE :( ");
            text.grow(40,10);
            text.setColor(Color.BLACK);
            text.draw();
            return true;
        }

        return false;
    }
}
