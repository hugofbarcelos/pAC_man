package org.academiadecodigo.altcatras.pacman.position;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class SuperField {

    private static final int PADDING = 10;
    private static final int CELLSIZE = 60;
    private static final int COLS = 13; // includes borders
    private static final int getROWS = 13;
    private static final int TARGETPOINTS = 81;
    private int width = COLS * CELLSIZE;
    private int height = getROWS * CELLSIZE;
    public Position[][] positions;

    public SuperField(){
        this.positions = new Position[COLS][getROWS];
    }

    public void createWalls(){

    };

    public void paintInteractiveObject() {
        for (int i = 0; i < getROWS(); i++) {
            for (int j = 0; j < getROWS(); j++) {
                if (positions[i][j].getType() != PositionObjectType.WALL) {
                    positions[i][j].setInteractiveType(IsInteractiveObjectType.BEER);
                    paintBeer(positions, i, j);
                }
            }
        }
    }

    public void paintBeer(Position[][] position, int col, int row) {
        position[col][row].setPicture(new Picture(colsToX(col), rowsToY(row), "resources/super-bock.png"));
        position[col][row].getPicture().draw();

    }

    public void paintField() {
        Picture background = new Picture(colsToX(0),rowsToY(0), "resources/backgroup.png");
        background.draw();
        for (int i = 0; i < getROWS(); i++) {
            for (int j = 0; j < getCOLS(); j++) {
                paintCell(positions, i, j);
            }
        }
    }

    public void paintCell(Position[][] position, int col, int row) {
        /*if (position[col][row].getType() == PositionObjectType.EMPTY) {
            position[col][row].setPicture(new Picture(colsToX(col), rowsToY(row), "resources/ground.png"));
            position[col][row].getPicture().draw();
            return;
        } else*/



        if (position[col][row].getType() == PositionObjectType.WALL) {
            position[col][row].setPicture(new Picture(colsToX(col), rowsToY(row), "resources/wall.png"));
            position[col][row].getPicture().draw();
            return;
        }
        position[col][row].setRectangle(new Rectangle(colsToX(col), rowsToY(row), getCELLSIZE(), getCELLSIZE()));
        position[col][row].getRectangle().setColor(position[col][row].getType().color);
        position[col][row].getRectangle().fill();
    }

    public static int getCELLSIZE() {
        return CELLSIZE;
    }
    public static int getCOLS() {
        return COLS;
    }
    public static int getROWS() {
        return getROWS;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public int getTARGETPOINTS() {
        return TARGETPOINTS;
    }
    public Position[][] getPositions() {
        return positions;
    }
    public int colsToX(int cols) {
        return cols * CELLSIZE + PADDING;
    }
    public int rowsToY(int rows) {
        return rows * CELLSIZE + PADDING;
    }


}
