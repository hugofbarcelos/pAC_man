package org.academiadecodigo.altcatras.pacman.position;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class SuperField {

    private static final int PADDING = 10;
    private static final int CELLSIZE = 60;
    private static final int COLS = 13; // includes borders
    private static final int getROWS = 13;
    private int targetPoints;
    private int width = COLS * CELLSIZE;
    private int height = getROWS * CELLSIZE;
    public Position[][] positions;

    public SuperField(int targetPoints) {
        this.positions = new Position[COLS][getROWS];
        this.targetPoints = targetPoints;
    }

    public void createWalls() {

    }

    ;

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
        Picture background = new Picture(colsToX(0), rowsToY(0), "resources/backgroup.png");
        background.draw();
        for (int i = 0; i < getROWS(); i++) {
            for (int j = 0; j < getCOLS(); j++) {
                paintCell(positions, i, j);
            }
        }
    }

    public void paintCell(Position[][] position, int col, int row) {

        if (position[col][row].getType() != PositionObjectType.WALL) {
            position[col][row].setPicture(new Picture(colsToX(col), rowsToY(row), "resources/ground.png"));
            position[col][row].getPicture().draw();
            return;
        } else if (position[col][row].getType() == PositionObjectType.WALL) {
            position[col][row].setPicture(new Picture(colsToX(col), rowsToY(row), "resources/wall.png"));
            position[col][row].getPicture().draw();
            return;
        }

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
        return targetPoints;
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
