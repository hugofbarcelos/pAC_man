package org.academiadecodigo.altcatras.pacman.position;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Garden {

    private final int PADDING = 10;
    private Rectangle field;
    private final int CELLSIZE = 60;
    private final int COLS = 13; // includes borders
    private final int ROWS = 13;
    private int width;
    private int height;
    Position[][] positions;

    public Garden(){

        width = COLS * CELLSIZE;
        height = ROWS * CELLSIZE;
        this.positions = new Position[COLS][ROWS];

    }

    public void createWalls() {

        //works for 13 x 13, including walls
        for (int i = 0; i < ROWS; i++) {

            if (i == 0 || i == ROWS - 1) {
                for (int j = 0; j < COLS; j++) {
                    positions[j][i] = new Position();
                    positions[j][i].setType(PositionObjectType.WALL);
                }
                continue;
            }

            if (i == 1 || i == ROWS - 2) {
                for (int j = 0; j < COLS; j++) {
                    switch (j) {
                        case 0, 12:
                            positions[j][i] = new Position();
                            positions[j][i].setType(PositionObjectType.WALL);
                            break;
                        default:
                            positions[j][i] = new Position();
                            positions[j][i].setType(PositionObjectType.EMPTY);
                            break;
                    }
                }
                continue;
            }

            if (i == 2 || i == ROWS - 3) {
                for (int j = 0; j < COLS; j++) {
                    switch (j) {
                        case 1, 3, 4, 6, 8, 9, 11:
                            positions[j][i] = new Position();
                            positions[j][i].setType(PositionObjectType.EMPTY);
                            break;
                        default:
                            positions[j][i] = new Position();
                            positions[j][i].setType(PositionObjectType.WALL);
                            break;
                    }
                }
                continue;
            }

            if (i == 3 || i == ROWS - 4) {
                for (int j = 0; j < COLS; j++) {
                    switch (j) {
                        case 0, 4, 8, 12:
                            positions[j][i] = new Position();
                            positions[j][i].setType(PositionObjectType.WALL);
                            break;
                        default:
                            positions[j][i] = new Position();
                            positions[j][i].setType(PositionObjectType.EMPTY);
                            break;
                    }
                }
                continue;
            }

            if (i == 4 || i == ROWS - 5) {
                for (int j = 0; j < COLS; j++) {
                    switch (j) {
                        case 0, 1, 3, 6, 9, 11, 12:
                            positions[j][i] = new Position();
                            positions[j][i].setType(PositionObjectType.WALL);
                            break;
                        default:
                            positions[j][i] = new Position();
                            positions[j][i].setType(PositionObjectType.EMPTY);
                            break;
                    }
                }
                continue;
            }

            if (i == 5 || i == ROWS - 6) {
                for (int j = 0; j < COLS; j++) {
                    switch (j) {
                        case 1,2,3,4, 8, 9, 10,11:
                            positions[j][i] = new Position();
                            positions[j][i].setType(PositionObjectType.EMPTY);
                            break;
                        default:
                            positions[j][i] = new Position();
                            positions[j][i].setType(PositionObjectType.WALL);
                            break;
                    }
                }
                continue;
            }

            if (i == 6 || i == ROWS - 7) {
                for (int j = 0; j < COLS; j++) {
                    switch (j) {
                        case 0, 2,3,4,5, 6, 7,8,9,10,12:
                            positions[j][i] = new Position();
                            positions[j][i].setType(PositionObjectType.WALL);
                            break;
                        default:
                            positions[j][i] = new Position();
                            positions[j][i].setType(PositionObjectType.EMPTY);
                            break;
                    }
                }
                continue;
            }


        }

    }

    public void paintField() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                paintCell(positions, i, j);
            }
        }
    }

    public void paintCell(Position[][] position, int col, int row) {

    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int colsToX(int cols) {
        return cols * CELLSIZE + PADDING;
    }

    public int rowsToY(int rows) {
        return rows * CELLSIZE + PADDING;
    }

    public int getCOLS() {
        return COLS;
    }

    public int getROWS() {
        return ROWS;
    }

    public Position[][] getPositions() {
        return positions;
    }
}

