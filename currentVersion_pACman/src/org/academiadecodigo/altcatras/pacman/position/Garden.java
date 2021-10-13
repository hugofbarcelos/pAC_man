package org.academiadecodigo.altcatras.pacman.position;


import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Garden extends SuperField {


    public Garden() {
        super(84);

    }

    //Create the walls for the map
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
                        case 1, 2, 3, 4, 8, 9, 10, 11:
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
                        case 0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12:
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
}

