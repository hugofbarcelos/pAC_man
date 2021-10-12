package org.academiadecodigo.altcatras.pacman.position;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Garden extends SuperField{




    public void createWalls() {

        //works for 13 x 13, including walls
        for (int i = 0; i < getROWS(); i++) {

            if (i == 0 || i == getROWS() - 1) {
                for (int j = 0; j < getCOLS(); j++) {
                    positions[j][i] = new Position();
                    positions[j][i].setType(PositionObjectType.WALL);
                }
                continue;
            }

            if (i == 1 || i == getROWS() - 2) {
                for (int j = 0; j < getCOLS(); j++) {
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

            if (i == 2 || i == getROWS() - 3) {
                for (int j = 0; j < getCOLS(); j++) {
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

            if (i == 3 || i == getROWS() - 4) {
                for (int j = 0; j < getCOLS(); j++) {
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

            if (i == 4 || i == getROWS() - 5) {
                for (int j = 0; j < getCOLS(); j++) {
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

            if (i == 5 || i == getROWS() - 6) {
                for (int j = 0; j < getCOLS(); j++) {
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

            if (i == 6 || i == getROWS() - 7) {
                for (int j = 0; j < getCOLS(); j++) {
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

<<<<<<< HEAD
=======
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
>>>>>>> e145953861150895db6c6be247c45f13f8e168dc

}

