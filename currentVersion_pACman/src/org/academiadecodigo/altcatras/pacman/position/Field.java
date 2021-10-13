package org.academiadecodigo.altcatras.pacman.position;

import org.academiadecodigo.simplegraphics.pictures.Picture;

<<<<<<< HEAD
public class Field {

    public final int PADDING = 10;
    public final int CELLSIZE = 60;
    private final int COLS = 13; // includes borders
    private final int ROWS = 13;
    public final int TARGETPOINTS = 81;
    private int width;
    private int height;
    Position[][] positions;



    public Field() {


        width = COLS * CELLSIZE;
        height = ROWS * CELLSIZE;
        this.positions = new Position[COLS][ROWS];
=======
public class Field extends SuperField {
>>>>>>> dc0c12b8e689849c423849d46297e3f1a4359136

    public Field(){
        super(81);
    }

    //Create the walls for the map
    @Override
    public void createWalls() {

        //works for 13 x 13, including walls
        for (int i = 0; i < getROWS(); i++) {
            if (i == 0 || i == getROWS() - 1) {
                for (int j = 0; j < getROWS(); j++) {
                    positions[j][i] = new Position();
                    positions[j][i].setType(PositionObjectType.WALL);
                }
                continue;
            }

            if (i == 1 || i == (getROWS() / 2) || i == getROWS() - 2) {
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
                        case 1, 4, 8, 11:
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
                for (int j = 0; j < getROWS(); j++) {
                    switch (j) {
                        case 0, 2, 6, 10, 12:
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
                        case 0, 4, 6, 8, 12:
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
                        case 1, 5, 7, 11:
                            positions[j][i] = new Position();
                            positions[j][i].setType(PositionObjectType.EMPTY);
                            break;
                        default:
                            positions[j][i] = new Position();
                            positions[j][i].setType(PositionObjectType.WALL);
                            break;
                    }
                }
            }


        }

    }


    @Override
    public void paintField() {
        Picture background = new Picture(colsToX(0), rowsToY(0), "resources/backgroup.png"); //defines the background image for this field
        background.draw();
        super.paintField();
    }

    @Override
    public void paintCell(Position[][] position, int col, int row) {
        if (position[col][row].getType() == PositionObjectType.WALL) {
            position[col][row].setPicture(new Picture(colsToX(col), rowsToY(row), "resources/wall.png")); //defines the wall image for this field
            position[col][row].getPicture().draw();
            return;
        }
    }


<<<<<<< HEAD
    public void paintInteractiveObject() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
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
=======
>>>>>>> dc0c12b8e689849c423849d46297e3f1a4359136
}
